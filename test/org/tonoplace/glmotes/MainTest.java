/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.tonoplace.glmotes;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author eli
 */
public class MainTest {

    public MainTest() {
    }

  @BeforeClass
  public static void setUpClass() throws Exception {
  }

  @AfterClass
  public static void tearDownClass() throws Exception {
  }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

  /**
   * Test of getFirstUIActionOnProcessPropertyValue method, of class Main,
   * with default value expected.
   */
  @Test
  public void testGetFirstUIActionOnProcessPropertyValue_DefaultValue() {
    System.out.println("getFirstUIActionOnProcessPropertyValue_DefaultValue");
    // make sure the property is not set so that the default value will be
    // returned
    System.clearProperty(Main.FIRST_UI_ACTION_ON_PROCESS_PROPERTY_NAME);
    boolean expResult = Main.FIRST_UI_ACTION_ON_PROCESS_DEFAULT_VALUE;
    boolean result = Main.getFirstUIActionOnProcessPropertyValue();
    assertEquals(expResult, result);
  }

  /**
   * Test of return value based value found in property, with property set to true.
   */
  @Test
  public void testGetFirstUIActionOnProcessPropertyValue_PropertyValue_true() {
    System.out.println("getFirstUIActionOnProcessPropertyValue_PropertyValue_true");
    boolean expResult = true;
    System.setProperty(Main.FIRST_UI_ACTION_ON_PROCESS_PROPERTY_NAME,
                       Boolean.toString(expResult));
    boolean result = Main.getFirstUIActionOnProcessPropertyValue();
    assertEquals(expResult, result);
  }

  /**
   * Test of return value based value found in property, with property set to false.
   */
  @Test
  public void testGetFirstUIActionOnProcessPropertyValue_PropertyValue_false() {
    System.out.println("getFirstUIActionOnProcessPropertyValue_PropertyValue_false");
    boolean expResult = false;
    System.setProperty(Main.FIRST_UI_ACTION_ON_PROCESS_PROPERTY_NAME,
                       Boolean.toString(expResult));
    boolean result = Main.getFirstUIActionOnProcessPropertyValue();
    assertEquals(expResult, result);
  }

  /**
   * Test of return value based on interpretation of value found in property.
   * Default value already in property with no property value fiddling.
   */
  @Test
  public void testGetFirstUIActionOnProcessPropertyValue_PropertyValue1() {
    System.out.println("getFirstUIActionOnProcessPropertyValue_PropertyValue1");
    boolean expResult = propertyVal(Main.FIRST_UI_ACTION_ON_PROCESS_PROPERTY_NAME,
                                    Main.FIRST_UI_ACTION_ON_PROCESS_DEFAULT_VALUE);
    boolean result = Main.getFirstUIActionOnProcessPropertyValue();
    assertEquals(expResult, result);
  }

  /**
   * Test of return value based on interpretation of value found in property.
   * Default value already in property with no property / value cleared.
   */
  @Test
  public void testGetFirstUIActionOnProcessPropertyValue_PropertyValue2() {
    System.out.println("getFirstUIActionOnProcessPropertyValue_PropertyValue2");
    System.clearProperty(Main.FIRST_UI_ACTION_ON_PROCESS_PROPERTY_NAME);
    boolean expResult = propertyVal(Main.FIRST_UI_ACTION_ON_PROCESS_PROPERTY_NAME,
                                    Main.FIRST_UI_ACTION_ON_PROCESS_DEFAULT_VALUE);
    boolean result = Main.getFirstUIActionOnProcessPropertyValue();
    assertEquals(expResult, result);
    // on null/cleared property also expect result to equal default value
    assertEquals(Main.FIRST_UI_ACTION_ON_PROCESS_DEFAULT_VALUE, result);
  }

  /**
   * Test of return value based on interpretation of value found in property.
   * Default value already in property with property value as true.
   */
  @Test
  public void testGetFirstUIActionOnProcessPropertyValue_PropertyValue3() {
    System.out.println("getFirstUIActionOnProcessPropertyValue_PropertyValue3");
    System.setProperty(Main.FIRST_UI_ACTION_ON_PROCESS_PROPERTY_NAME,"tRuE");
    boolean expResult = propertyVal(Main.FIRST_UI_ACTION_ON_PROCESS_PROPERTY_NAME,
                                    Main.FIRST_UI_ACTION_ON_PROCESS_DEFAULT_VALUE);
    boolean expResult2 = true; // we set property to value manually
    boolean result = Main.getFirstUIActionOnProcessPropertyValue();
    assertEquals(expResult, result);
    assertEquals(expResult2, result);
  }

  /**
   * Test of return value based on interpretation of value found in property.
   * Default value already in property with  property value set false.
   */
  @Test
  public void testGetFirstUIActionOnProcessPropertyValue_PropertyValue4() {
    System.out.println("getFirstUIActionOnProcessPropertyValue_PropertyValue4");
    System.setProperty(Main.FIRST_UI_ACTION_ON_PROCESS_PROPERTY_NAME,"false");
    boolean expResult = propertyVal(Main.FIRST_UI_ACTION_ON_PROCESS_PROPERTY_NAME,
                                    Main.FIRST_UI_ACTION_ON_PROCESS_DEFAULT_VALUE);
    boolean expResult2 = false; // we set to false manually
    boolean result = Main.getFirstUIActionOnProcessPropertyValue();
    assertEquals(expResult, result);
    assertEquals(expResult2, result);
  }

  /**
   * Test of return value based on interpretation of value found in property.
   * Default value already in property with no property set empty string
   */
  @Test
  public void testGetFirstUIActionOnProcessPropertyValue_PropertyValue5() {
    System.out.println("getFirstUIActionOnProcessPropertyValue_PropertyValue5");
    System.setProperty(Main.FIRST_UI_ACTION_ON_PROCESS_PROPERTY_NAME,"");
    boolean expResult = propertyVal(Main.FIRST_UI_ACTION_ON_PROCESS_PROPERTY_NAME,
                                    Main.FIRST_UI_ACTION_ON_PROCESS_DEFAULT_VALUE);
    boolean expResult2 = false; // we set to false manually
    boolean result = Main.getFirstUIActionOnProcessPropertyValue();
    assertEquals(expResult, result);
    assertEquals(expResult2, result);
  }

  /**
   * Test of return value based on interpretation of value found in property.
   * Default value already in property with no property set non boolean value
   */
  @Test
  public void testGetFirstUIActionOnProcessPropertyValue_PropertyValue6() {
    System.out.println("getFirstUIActionOnProcessPropertyValue_PropertyValue6");
    System.setProperty(Main.FIRST_UI_ACTION_ON_PROCESS_PROPERTY_NAME,"asdf");
    boolean expResult = propertyVal(Main.FIRST_UI_ACTION_ON_PROCESS_PROPERTY_NAME,
                                    Main.FIRST_UI_ACTION_ON_PROCESS_DEFAULT_VALUE);
    boolean expResult2 = false; // we set to false manually
    boolean result = Main.getFirstUIActionOnProcessPropertyValue();
    assertEquals(expResult, result);
    assertEquals(expResult2, result);
  }

  /**
   * Utility method for simple property value to boolean methods.
   * Checks for null property and resets to the default value.
   */
  private boolean propertyVal(String propertyName, boolean defaultValue)
  {
    String propValue = System.getProperty(propertyName);
    boolean expResult = Boolean.parseBoolean(propValue);
    // if string was null, and we treated as false, swithch to default
    if (expResult==false && propValue==null)
    {
      expResult = defaultValue;
    }
    return expResult;
  }

  /**
   * Test of shouldInitializeJOGL_GLProfile_initSingleton method, of class Main,
   * with default value expected.
   */
  @Test
  public void testShouldInitializeJOGL_GLProfile_initSingleton_DefaultValue() {
    System.out.println("shouldInitializeJOGL_GLProfile_initSingleton_DefaultValue");
    // make sure the property is not set so that the default value will be
    // returned
    System.clearProperty(Main.INITIALIZE_JOGL_GLPROFILE_PROPERTY_NAME);
    boolean expResult = Main.INITIALIZE_JOGL_GLPROFILE_DEFAULT_VALUE;
    boolean result = Main.shouldInitializeJOGL_GLProfile_initSingleton();
    assertEquals(expResult, result);
  }

  /**
   * Test of shouldInitializeJOGL_GLProfile_initSingleton method, of class Main,
   * with true value expected.
   */
  @Test
  public void testShouldInitializeJOGL_GLProfile_initSingleton_true() {
    System.out.println("shouldInitializeJOGL_GLProfile_initSingleton_true");
    boolean expResult = true;
    System.setProperty(Main.INITIALIZE_JOGL_GLPROFILE_PROPERTY_NAME,
                       Boolean.toString(expResult));
    boolean result = Main.shouldInitializeJOGL_GLProfile_initSingleton();
    assertEquals(expResult, result);
  }

  /**
   * Test of shouldInitializeJOGL_GLProfile_initSingleton method, of class Main,
   * with true value expected.
   */
  @Test
  public void testShouldInitializeJOGL_GLProfile_initSingleton_false() {
    System.out.println("shouldInitializeJOGL_GLProfile_initSingleton_false");
    boolean expResult = false;
    System.setProperty(Main.INITIALIZE_JOGL_GLPROFILE_PROPERTY_NAME,
                       Boolean.toString(expResult));
    boolean result = Main.shouldInitializeJOGL_GLProfile_initSingleton();
    assertEquals(expResult, result);
  }

  /**
   * Test of return value based on interpretation of value found in property.
   * Default value already in property with no property value fiddling.
   */
  @Test
  public void testShouldInitializeJOGL_GLProfile_initSingleton_PropertyVal1() {
    System.out.println("shouldInitializeJOGL_GLProfile_initSingleton_PropertyValue1");
    boolean expResult = propertyVal(Main.INITIALIZE_JOGL_GLPROFILE_PROPERTY_NAME,
                                    Main.INITIALIZE_JOGL_GLPROFILE_DEFAULT_VALUE);
    boolean result = Main.shouldInitializeJOGL_GLProfile_initSingleton();
    assertEquals(expResult, result);
  }

  /**
   * Test of return value based on interpretation of value found in property.
   * Default value already in property with no property / value cleared.
   */
  @Test
  public void testShouldInitializeJOGL_GLProfile_initSingleton_PropertyVal2() {
    System.out.println("shouldInitializeJOGL_GLProfile_initSingleton_PropertyValue2");
    System.clearProperty(Main.INITIALIZE_JOGL_GLPROFILE_PROPERTY_NAME);
    boolean expResult = propertyVal(Main.INITIALIZE_JOGL_GLPROFILE_PROPERTY_NAME,
                                    Main.INITIALIZE_JOGL_GLPROFILE_DEFAULT_VALUE);
    boolean result = Main.shouldInitializeJOGL_GLProfile_initSingleton();
    assertEquals("from prop",expResult, result);
    // on null/cleared property also expected result to equal default value
    assertEquals("from default",Main.INITIALIZE_JOGL_GLPROFILE_DEFAULT_VALUE, result);
  }

  /**
   * Test of return value based on interpretation of value found in property.
   * Default value already in property with property value as true.
   */
  @Test
  public void testShouldInitializeJOGL_GLProfile_initSingleton_PropertyVal3() {
    System.out.println("shouldInitializeJOGL_GLProfile_initSingleton_PropertyValue3");
    System.setProperty(Main.INITIALIZE_JOGL_GLPROFILE_PROPERTY_NAME,"tRUe");
    boolean expResult = true;
    boolean expResult2 = propertyVal(Main.INITIALIZE_JOGL_GLPROFILE_PROPERTY_NAME,
                                    Main.INITIALIZE_JOGL_GLPROFILE_DEFAULT_VALUE);
    boolean result = Main.shouldInitializeJOGL_GLProfile_initSingleton();
    assertEquals(expResult,  result);
    assertEquals(expResult2, result);
  }

  /**
   * Test of return value based on interpretation of value found in property.
   * Default value already in property with property value as false.
   */
  @Test
  public void testShouldInitializeJOGL_GLProfile_initSingleton_PropertyVal4() {
    System.out.println("shouldInitializeJOGL_GLProfile_initSingleton_PropertyValue4");
    System.setProperty(Main.INITIALIZE_JOGL_GLPROFILE_PROPERTY_NAME,"false");
    boolean expResult = false;
    boolean expResult2 = propertyVal(Main.INITIALIZE_JOGL_GLPROFILE_PROPERTY_NAME,
                                    Main.INITIALIZE_JOGL_GLPROFILE_DEFAULT_VALUE);
    boolean result = Main.shouldInitializeJOGL_GLProfile_initSingleton();
    assertEquals(expResult,  result);
    assertEquals(expResult2, result);
  }

  /**
   * Test of return value based on interpretation of value found in property.
   * Default value already in property with property value as empty string.
   */
  @Test
  public void testShouldInitializeJOGL_GLProfile_initSingleton_PropertyVal5() {
    System.out.println("shouldInitializeJOGL_GLProfile_initSingleton_PropertyValue5");
    System.setProperty(Main.INITIALIZE_JOGL_GLPROFILE_PROPERTY_NAME,"");
    boolean expResult = false;
    boolean expResult2 = propertyVal(Main.INITIALIZE_JOGL_GLPROFILE_PROPERTY_NAME,
                                    Main.INITIALIZE_JOGL_GLPROFILE_DEFAULT_VALUE);
    boolean result = Main.shouldInitializeJOGL_GLProfile_initSingleton();
    assertEquals(expResult,  result);
    assertEquals(expResult2, result);
  }

  /**
   * Test of return value based on interpretation of value found in property.
   * Default value already in property with property value as empty string.
   */
  @Test
  public void testShouldInitializeJOGL_GLProfile_initSingleton_PropertyVal6() {
    System.out.println("shouldInitializeJOGL_GLProfile_initSingleton_PropertyValue6");
    System.setProperty(Main.INITIALIZE_JOGL_GLPROFILE_PROPERTY_NAME,"juiasedi");
    boolean expResult = false;
    boolean expResult2 = propertyVal(Main.INITIALIZE_JOGL_GLPROFILE_PROPERTY_NAME,
                                    Main.INITIALIZE_JOGL_GLPROFILE_DEFAULT_VALUE);
    boolean result = Main.shouldInitializeJOGL_GLProfile_initSingleton();
    assertEquals(expResult,  result);
    assertEquals(expResult2, result);
  }

  /**
   * Test of wasJOGL_GLProfile_initSingleton_called method, of class Main,
   * with default value expected.
   */
  @Test
  public void testWasJOGL_GLProfile_initSingleton_called_DefaultValue() {
    System.out.println("wasJOGL_GLProfile_initSingleton_called_DefaultValue");
    // make sure the property is not set so that the default value will be
    // returned
    System.clearProperty(Main.JOGL_GLPROFILE_INITIALIZED_PROPERTY_NAME);
    boolean expResult = Main.JOGL_GLPROFILE_INITIALIZED_DEFAULT_VALUE;
    boolean result = Main.wasJOGL_GLProfile_initSingleton_called();
    assertEquals(expResult, result);
  }

  /**
   * Test of wasJOGL_GLProfile_initSingleton_called method, of class Main,
   * with true value expected.
   */
  @Test
  public void testWasJOGL_GLProfile_initSingleton_called_true() {
    System.out.println("wasJOGL_GLProfile_initSingleton_called_true");
    boolean expResult = true;
    System.setProperty(Main.JOGL_GLPROFILE_INITIALIZED_PROPERTY_NAME,
                       Boolean.toString(expResult));
    boolean result = Main.wasJOGL_GLProfile_initSingleton_called();
    assertEquals(expResult, result);
  }

  /**
   * Test of wasJOGL_GLProfile_initSingleton_called method, of class Main,
   * with true value expected.
   */
  @Test
  public void testWasJOGL_GLProfile_initSingleton_called_false() {
    System.out.println("wasJOGL_GLProfile_initSingleton_called_false");
    boolean expResult = false;
    System.setProperty(Main.JOGL_GLPROFILE_INITIALIZED_PROPERTY_NAME,
                       Boolean.toString(expResult));
    boolean result = Main.wasJOGL_GLProfile_initSingleton_called();
    assertEquals(expResult, result);
  }

  /**
   * Test of return value based on interpretation of value found in property.
   * Default value already in property with no property value fiddling.
   */
  @Test
  public void testWasJOGL_GLProfile_initSingleton_called_PropertyVal1() {
    System.out.println("wasJOGL_GLProfile_initSingleton_called_PropertyValue1");
    boolean expResult = propertyVal(Main.JOGL_GLPROFILE_INITIALIZED_PROPERTY_NAME,
                                    Main.JOGL_GLPROFILE_INITIALIZED_DEFAULT_VALUE);
    boolean result = Main.wasJOGL_GLProfile_initSingleton_called();
    assertEquals(expResult, result);
  }

  /**
   * Test of return value based on interpretation of value found in property.
   * Default value already in property with no property / value cleared.
   */
  @Test
  public void testWasJOGL_GLProfile_initSingleton_called_PropertyVal2() {
    System.out.println("wasJOGL_GLProfile_initSingleton_called_PropertyValue2");
    System.clearProperty(Main.JOGL_GLPROFILE_INITIALIZED_PROPERTY_NAME);
    boolean expResult = propertyVal(Main.JOGL_GLPROFILE_INITIALIZED_PROPERTY_NAME,
                                    Main.JOGL_GLPROFILE_INITIALIZED_DEFAULT_VALUE);
    boolean result = Main.wasJOGL_GLProfile_initSingleton_called();
    assertEquals("from prop",expResult, result);
    // on null/cleared property also expected result to equal default value
    assertEquals("from default",Main.JOGL_GLPROFILE_INITIALIZED_DEFAULT_VALUE, result);
  }

  /**
   * Test of return value based on interpretation of value found in property.
   * Default value already in property with property value as true.
   */
  @Test
  public void testWasJOGL_GLProfile_initSingleton_called_PropertyVal3() {
    System.out.println("wasJOGL_GLProfile_initSingleton_called_PropertyValue3");
    System.setProperty(Main.JOGL_GLPROFILE_INITIALIZED_PROPERTY_NAME,"tRUe");
    boolean expResult = true;
    boolean expResult2 = propertyVal(Main.JOGL_GLPROFILE_INITIALIZED_PROPERTY_NAME,
                                    Main.JOGL_GLPROFILE_INITIALIZED_DEFAULT_VALUE);
    boolean result = Main.wasJOGL_GLProfile_initSingleton_called();
    assertEquals(expResult,  result);
    assertEquals(expResult2, result);
  }

  /**
   * Test of return value based on interpretation of value found in property.
   * Default value already in property with property value as false.
   */
  @Test
  public void testWasJOGL_GLProfile_initSingleton_called_PropertyVal4() {
    System.out.println("wasJOGL_GLProfile_initSingleton_called_PropertyValue4");
    System.setProperty(Main.JOGL_GLPROFILE_INITIALIZED_PROPERTY_NAME,"false");
    boolean expResult = false;
    boolean expResult2 = propertyVal(Main.JOGL_GLPROFILE_INITIALIZED_PROPERTY_NAME,
                                    Main.JOGL_GLPROFILE_INITIALIZED_DEFAULT_VALUE);
    boolean result = Main.wasJOGL_GLProfile_initSingleton_called();
    assertEquals(expResult,  result);
    assertEquals(expResult2, result);
  }

  /**
   * Test of return value based on interpretation of value found in property.
   * Default value already in property with property value as empty string.
   */
  @Test
  public void testWasJOGL_GLProfile_initSingleton_called_PropertyVal5() {
    System.out.println("wasJOGL_GLProfile_initSingleton_called_PropertyValue5");
    System.setProperty(Main.JOGL_GLPROFILE_INITIALIZED_PROPERTY_NAME,"");
    boolean expResult = false;
    boolean expResult2 = propertyVal(Main.JOGL_GLPROFILE_INITIALIZED_PROPERTY_NAME,
                                    Main.JOGL_GLPROFILE_INITIALIZED_DEFAULT_VALUE);
    boolean result = Main.wasJOGL_GLProfile_initSingleton_called();
    assertEquals(expResult,  result);
    assertEquals(expResult2, result);
  }

  /**
   * Test of return value based on interpretation of value found in property.
   * Default value already in property with property value as empty string.
   */
  @Test
  public void testWasJOGL_GLProfile_initSingleton_called_PropertyVal6() {
    System.out.println("wasJOGL_GLProfile_initSingleton_called_PropertyValue6");
    System.setProperty(Main.JOGL_GLPROFILE_INITIALIZED_PROPERTY_NAME,"juiasedi");
    boolean expResult = false;
    boolean expResult2 = propertyVal(Main.JOGL_GLPROFILE_INITIALIZED_PROPERTY_NAME,
                                    Main.JOGL_GLPROFILE_INITIALIZED_DEFAULT_VALUE);
    boolean result = Main.wasJOGL_GLProfile_initSingleton_called();
    assertEquals(expResult,  result);
    assertEquals(expResult2, result);
  }

  /**
   * Test of whitebox for setJOGL_GLProfile_initSingleton_called.
   */
  @Test
  public void testSetJOGL_GLProfile_initSingleton_called()
  {
    System.out.println("setJOGL_GLProfile_initSingleton_called");

    boolean firstValue = Main.wasJOGL_GLProfile_initSingleton_called();
    boolean expValue   = !firstValue;

    Main.JUnitWhiteBoxExposer.setJOGL_GLProfile_initSingleton_called(expValue);
    boolean newValue = Main.wasJOGL_GLProfile_initSingleton_called();

    assertEquals("Fist value flip", expValue, newValue);
    assertNotSame("First valueDifferent", firstValue, newValue);

    Main.JUnitWhiteBoxExposer.setJOGL_GLProfile_initSingleton_called(firstValue);
    newValue = Main.wasJOGL_GLProfile_initSingleton_called();
    assertEquals("Second value flip", firstValue, newValue);
    assertNotSame("Old expValue", expValue, newValue);
  }

  /**
   * Test of whitebox for setFirstUIActionOnProcessPropertyValue
   */
  @Test
  public void testSetFirstUIActionOnProcessPropertyValue()
  {
    System.out.println("setFirstUIActionOnProcessPropertyValue");

    boolean firstValue = Main.getFirstUIActionOnProcessPropertyValue();
    boolean expValue   = !firstValue;

    Main.JUnitWhiteBoxExposer.setFirstUIActionOnProcessPropertyValue(expValue);
    boolean newValue = Main.getFirstUIActionOnProcessPropertyValue();

    assertEquals("Fist value flip", expValue, newValue);
    assertNotSame("First valueDifferent", firstValue, newValue);

    Main.JUnitWhiteBoxExposer.setFirstUIActionOnProcessPropertyValue(firstValue);
    newValue = Main.getFirstUIActionOnProcessPropertyValue();
    assertEquals("Second value flip", firstValue, newValue);
    assertNotSame("Old expValue", expValue, newValue);
  }

  /**
   * Test of whitebox for setBooleanProperty
   */
  @Test
  public void testSetBooleanProperty()
  {
    System.out.println("testSetBooleanProperty");
    String propertyName = "org.tonoplace.glmotes.MainTest.properties.aBoolean";
    boolean defaultValue = false;
    System.clearProperty(propertyName);

    boolean firstValue  = propertyVal(propertyName, defaultValue);
    assertEquals("Initial default value", firstValue, false);

    boolean expValue  = !firstValue;

    Main.JUnitWhiteBoxExposer.setBooleanProperty("test", propertyName, expValue);
    boolean newValue = propertyVal(propertyName, !expValue);

    assertEquals("First value flip", expValue, newValue);
    assertNotSame("First valueDifferent", firstValue, newValue);

    Main.JUnitWhiteBoxExposer.setBooleanProperty("test2", propertyName, firstValue);
    newValue = propertyVal(propertyName, !firstValue);

    assertEquals("Second value flip", firstValue, newValue);
    assertNotSame("Old expValue", expValue, newValue);
  }
}