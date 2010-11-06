package org.tonoplace.glmotes;

import java.util.Properties;
import javax.media.opengl.GLProfile;

/**
 * Main class for the GLMotes program, handles GL initialization, and
 * Constructs a JMotesMasterFrame for the Motes eye-candy GL toy.
 * 
 * @author Elijah C. Menifee
 * @date 2010NOV05 19:31
 */
public class Main
{
  /**
   * This variable holds the static final value for the property name used to
   * indicate if this program should assume that it is the 
   * firstUIActionOnProcess.  See the class static initialization block for
   * further details on what this value is used for.
   *
   * @see $cinit()
   * @see getFirstUIActionOnProcessPropertyValue()
   * @see setFirstUIActionOnProcessPropertyValue(boolean initializedValue)
   * @see FIRST_UI_ACTION_ON_PROCESS_DEFAULT_VALUE
   */
  public static final String FIRST_UI_ACTION_ON_PROCESS_PROPERTY_NAME =
    "org.tonoplace.glmotes.Main.properties.firstUIActionOnProcess";

  /**
   * This variable holds the static final default value for the property
   * FIRST_UI_ACTION_ON_PROCESS_PROPERTY_NAME, of true since if not supplied
   * by launcher, assume we are first UI call.
   *
   * @see FIRST_UI_ACTION_ON_PROCESS_PROPERTY_NAME
   * @see getFirstUIActionOnProcessPropertyValue()
   */
  public static final boolean FIRST_UI_ACTION_ON_PROCESS_DEFAULT_VALUE = true;

  /**
   * This variable holds the static final value for the property name used to
   * indicate if this program should perform the ASAP code for
   * GLProfile.initSingleton(firstUIActionOnProcess) method at startup. See the
   * class static initialization block for further details on what this value
   * is used for.
   *
   * @see $cinit()
   * @see shouldInitializeJOGL_GLProfile_initSingleton()
   * @see INITIALIZE_JOGL_GLPROFILE_DEFAULT_VALUE
   */
  public static final String INITIALIZE_JOGL_GLPROFILE_PROPERTY_NAME =
    "org.tonoplace.glmotes.Main.properties.call_GLProfile_initSingleton";

  /**
   * This variable holds the static final default value for the property
   * INITIALIZE_JOGL_GLPROFILE_PROPERTY_NAME, of true since if not overridden
   * by launcher, assume JOGL initialization falls to this class.
   *
   * @see INITIALIZE_JOGL_GLPROFILE_PROPERTY_NAME
   * @see shouldInitializeJOGL_GLProfile_initSingleton()
   */
  public static final boolean INITIALIZE_JOGL_GLPROFILE_DEFAULT_VALUE = true;

  /**
   * This variable holds the static final value for the property name used to
   * indicate if the GLProfile was ASAP initialized during the class static
   * initialization block.
   *
   * @see $cinit()
   * @see wasJOGL_GLProfile_initSingleton_called()
   * @see setJOGL_GLProfile_initSingleton_called(boolean wasInitialized)
   * @see JOGL_GLPROFILE_INITIALIZED_DEFAULT_VALUE
   */
  public static final String JOGL_GLPROFILE_INITIALIZED_PROPERTY_NAME =
    "org.tonoplace.glmotes.Main.properties.GLProfile_initSingleton_called";

  /**
   * This variable holds the static final default value for the property
   * JOGL_GLPROFILE_INITIALIZED_PROPERTY_NAME, of false since if this property
   * has not been set, the initialization has not yet happened.
   *
   * @see JOGL_GLPROFILE_INITIALIZED_PROPERTY_NAME
   * @see wasJOGL_GLProfile_initSingleton_called()
   */
  public static final boolean JOGL_GLPROFILE_INITIALIZED_DEFAULT_VALUE = false;

  /**
   * This is a class static initialization code block.  Class static
   * initialization will take place immediately after the class file is loaded
   * into the VM as part of the class initialization AND loading.  Since this
   * class is the entry point in the project to this program, the code in the
   * following block will execute before the call to main(String[] args).
   */
  static {
    // According to JOGL we should statically initialize the GLProfile singleton
    // instance at program startup, before any potential UI interface calls have
    // occurred.  Otherwise it will auto-initialize with the value false.
    // When initialized with false, depending on platform and implemenation
    // details, it may implement special GUI thread locking semantics that
    // could cause speed degradation in GL/GUI calls.  If initialized with
    // the value of true, the JOGL system will attempt to use faster native
    // threads.
    boolean firstUIActionOnProcess = true; // would like, gets set below
    
    // Under certain conditions that may be beyond our controll, such as this
    // JOGL demo being launched as an Eclipse, Netbeans, or Other RCP
    // (Rich Client Program), or in certain instances of Applet or WebStart or
    // other Launchers the first call to AWT/UI interface may have already
    // occured, so allow firstUIActionOnProcess to be over-ridden as false
    // before making the call, by looking for a property that could be
    // set by our invoker.
    firstUIActionOnProcess = getFirstUIActionOnProcessPropertyValue();

    // Should we ignore the GLProfile initialization step? If this class is
    // being loaded by another java process, it can set the property value to
    // false before loading the class to ensure that the call is not made again.
    boolean shouldInit = shouldInitializeJOGL_GLProfile_initSingleton();
    
    // we have not yet made the call to init.
    boolean initialized = false;

    // Actually call the ASAP initialization of the GLProfile with information
    // regarding if this is the 'firstUIActionOnProcess' based on property
    // checked above.
    if (shouldInit)
    {
      try
      {
        GLProfile.initSingleton( firstUIActionOnProcess );
        initialized = true;
      }
      catch (UnsatisfiedLinkError ule)
      {
        String libPath = "";
        try
        {
          libPath = System.getProperty("java.library.path");
        }
        catch(Throwable propT)
        {
          System.err.println("Error looking up 'java.library.path': " + propT);
        }
        System.err.println("JOGL native libraries appear to be missing...\n");
        ule.printStackTrace(System.err);
        System.exit(1);
      }
      catch (Throwable t)
      {
        System.err.println("Unknown error while initializing the JOGL system.");
        t.printStackTrace(System.err);
        System.exit(2);
      }
    }

    setFirstUIActionOnProcessPropertyValue( initialized &&
                                            firstUIActionOnProcess);
    setJOGL_GLProfile_initSingleton_called( initialized );
  }

  
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) throws Exception {
    Properties props = System.getProperties();
    props.list(System.out);
    System.out.println("\n\nFound the following GL Profiles:");
    for(String profile : GLProfile.GL_PROFILE_LIST_ALL)
      System.out.println("\t"+profile);
    System.exit(0);
  }


  /**
   * Obtain the System.Property boolean value for the firstUIActionOnProcess.
   * This method performs the lookup to determine if the static GLProfile
   * singleton initialization code should claim 'firstUIActionOnProcess=true'
   * in the static initialization block for this class.  After the static
   * initialization block has made the first call to GLProfile, the property
   * will be adjusted to what the static initialization block determined for
   * this value, if the GLProfile was initialized, otherwise false.
   * 
   * @see $cinit()
   * @see FIRST_UI_ACTION_ON_PROCESS_PROPERTY_NAME
   * @see FIRST_UI_ACTION_ON_PROCESS_DEFAULT_VALUE
   * @see setFirstUIActionOnProcessPropertyValue(boolean wasFirstUIAction)
   * @see getBooleanProperty( String propertyVarName,
   *                          String propertyName,
   *                          boolean defaultValue,
   *                          boolean errorValue)
   * 
   * @return <ul>
   *          <li>
   *            FIRST_UI_ACTION_ON_PROCESS_PROPERTY_NAME value as parsed by 
   *            Boolean.parse(String booleanString) if property exists.
   *          </li>
   *          <li>
   *            FIRST_UI_ACTION_ON_PROCESS_DEFAULT_VALUE if property not found.
   *          </li>
   *         </ul>
   */
  public static boolean getFirstUIActionOnProcessPropertyValue()
  {
    return  getBooleanProperty ( "FIRST_UI_ACTION_ON_PROCESS_PROPERTY_NAME",
                                 FIRST_UI_ACTION_ON_PROCESS_PROPERTY_NAME,
                                 FIRST_UI_ACTION_ON_PROCESS_DEFAULT_VALUE,
                                 false
                               );
  }


  /**
   * Obtains the System.Property boolean value for calling
   * GLProfile.initSingleton(boolean firstUIActionOnProcess).
   * This method performs the lookup to determine if the static GLProfile
   * singleton initialization should be called.
   *
   * @see $cinit()
   * @see INITIALIZE_JOGL_GLPROFILE_PROPERTY_NAME
   * @see INITIALIZE_JOGL_GLPROFILE_DEFAULT_VALUE
   * @see getBooleanProperty( String propertyVarName,
   *                          String propertyName,
   *                          boolean defaultValue,
   *                          boolean errorValue)
   *
   * @return <ul>
   *          <li>
   *            INITIALIZE_JOGL_GLPROFILE_PROPERTY_NAME value as parsed by
   *            Boolean.parse(String booleanString) if property exists.
   *          </li>
   *          <li>
   *            INITIALIZE_JOGL_GLPROFILE_DEFAULT_VALUE if property not found.
   *          </li>
   *         </ul>
   */
  public static boolean shouldInitializeJOGL_GLProfile_initSingleton()
  {
    return  getBooleanProperty ( "INITIALIZE_JOGL_GLPROFILE_PROPERTY_NAME",
                                 INITIALIZE_JOGL_GLPROFILE_PROPERTY_NAME,
                                 INITIALIZE_JOGL_GLPROFILE_DEFAULT_VALUE,
                                 false
                               );
  }
  
  
  /**
   * Obtains the System.Property boolean value to determine if
   * GLProfile.initSingleton(boolean firstUIActionOnProcess) was properly
   * called.
   *
   * @see $cinit()
   * @see JOGL_GLPROFILE_INITIALIZED_PROPERTY_NAME
   * @see JOGL_GLPROFILE_INITIALIZED_DEFAULT_VALUE
   * @see getBooleanProperty( String propertyVarName,
   *                          String propertyName,
   *                          boolean defaultValue,
   *                          boolean errorValue)
   *
   * @return <ul>
   *          <li>
   *            JOGL_GLPROFILE_INITIALIZED_PROPERTY_NAME value as parsed by
   *            Boolean.parse(String booleanString) if property exists.
   *          </li>
   *          <li>
   *            JOGL_GLPROFILE_INITIALIZED_DEFAULT_VALUE if property not found.
   *          </li>
   *         </ul>
   */
  public static boolean wasJOGL_GLProfile_initSingleton_called()
  {
    return  getBooleanProperty ( "JOGL_GLPROFILE_INITIALIZED_PROPERTY_NAME",
                                 JOGL_GLPROFILE_INITIALIZED_PROPERTY_NAME,
                                 JOGL_GLPROFILE_INITIALIZED_DEFAULT_VALUE,
                                 false
                               );
  }

  
  /**
   * Performs a boolean lookup for a given property.
   *
   * @param forProperty   Context of the propertyName for reporting errors.
   * @param propertyName  The name of the System.Property to lookup.
   * @param defaultValue  The value to return if the property does not exist
   * @param errorValue    The value to return if an exception occurs.
   *
   * @return A boolean value based on the property value.
   */
  private static boolean getBooleanProperty ( String forProperty,
                                              String propertyName,
                                              boolean defaultValue,
                                              boolean errorValue
  )
  {
    String defaultPropertyValue = Boolean.toString(defaultValue);
    try
    {
      // attempt to read the system property with default/assumed value if does
      // not exist, can throw SecurityException, NullPointerException, and
      // IllegalArgumentException.
      String propertyValue = System.getProperty( propertyName,
                                                 defaultPropertyValue );
      return Boolean.parseBoolean(propertyValue);
    }
    catch (SecurityException se)
    {
      System.err.println("The security manager declined READ access to the '" +
         forProperty+"' with a value of '" + propertyName+"', will assume "+
         errorValue + " instead of " + defaultValue);
      se.printStackTrace(System.err);
      return errorValue;
    }
    catch (NullPointerException npe)
    {
      System.err.println("The property name value for '" + forProperty+"' had" +
        " a NULL value, will assume " + errorValue + " instead of " +
        defaultValue);
      npe.printStackTrace(System.err);
      return errorValue;
    }
    catch (IllegalArgumentException iae)
    {
      System.err.println("The property name value for '" + forProperty + "'" +
        " was empty, will assume " + errorValue + " instead of " +
        defaultValue);
      iae.printStackTrace(System.err);
      return errorValue;
    }
  }


  /**
   * Stores a property value into the System.Properties.
   *
   * @param forProperty   Context of the propertyName for reporting errors.
   * @param propertyName  The name of the System.Property to store the value in.
   * @param propertyValue The value to store in the property as a String.
   */
  private static void setBooleanProperty( String forProperty,
                                          String propertyName,
                                          boolean propertyValue
  )
  {
    // convert boolean into a valid string for properties
    String newPropertyValue =  Boolean.toString( propertyValue );
    try
    {
      System.setProperty( propertyName, newPropertyValue );
    }
    catch (SecurityException se)
    {
      System.err.println("The security manager declined WRITE access to the '" +
        forProperty + "' property at '" + propertyName + "' to new value of " +
        newPropertyValue + ", property not set!");
      se.printStackTrace(System.err);
    }
    catch (NullPointerException npe)
    {
      System.err.println("Error setting '" + forProperty +
        "' property at '" + propertyName + "' to new value of " +
        newPropertyValue + ", a value was null so property not set!");
      npe.printStackTrace(System.err);
    }
    catch (IllegalArgumentException iae)
    {
      System.err.println("Error setting '" + forProperty +
        "' property at '" + propertyName + "' to new value of " +
        newPropertyValue + ", name was EMPTY so property not set!");
      iae.printStackTrace(System.err);
    }
  }


  /**
   * Method to allow the static initialization block set the value actually used
   * for the 'firstUIActionOnProcess' value.  This method is only called from
   * the static initialization block, with a value for false if GLProfile
   * initialization did not happen, otherwise with the value passed into the
   * GLProfile.initSingleton(boolean newValue) method.
   *
   * @see $cinit()
   * @see FIRST_UI_ACTION_ON_PROCESS_PROPERTY_NAME
   * @see getFirstUIActionOnProcessPropertyValue()
   * @see setBooleanProperty( String forProperty,
   *                          String propertyName,
   *                          boolean propertyValue )
   *
   * @param initializedValue The value to set the property to based on
   * initialization logic.
   */
  private static void setFirstUIActionOnProcessPropertyValue(
    boolean wasFirstUIAction
  )
  {
    setBooleanProperty ( "FIRST_UI_ACTION_ON_PROCESS_PROPERTY_NAME",
                         FIRST_UI_ACTION_ON_PROCESS_PROPERTY_NAME,
                         wasFirstUIAction
                       );
  }


  /**
   * Method to allow the static initialization block set the value actually used
   * for the 'firstUIActionOnProcess' value.  This method is only called from
   * the static initialization block, with a value of false if
   * GLProfile.initSingleton( isFirstUIAction ) threw an Exception or was not
   * called, or true if the singleton was initialized.
   *
   * @see $cinit()
   * @see JOGL_GLPROFILE_INITIALIZED_PROPERTY_NAME
   * @see wasJOGL_GLProfile_initSingleton_called()
   * @see setBooleanProperty( String forProperty,
   *                          String propertyName,
   *                          boolean propertyValue )
   */
  private static void setJOGL_GLProfile_initSingleton_called(
    boolean initialized
  )
  {
    setBooleanProperty ( "JOGL_GLPROFILE_INITIALIZED_PROPERTY_NAME",
                         JOGL_GLPROFILE_INITIALIZED_PROPERTY_NAME,
                         initialized
                       );
  }
}
