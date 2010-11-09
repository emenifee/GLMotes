/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.tonoplace.glmotes.geometry;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Random;
import org.hamcrest.core.IsNull;
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
public class Point3DTest {

  public Point3DTest() {
  }

  static Field fieldX;
  static Field fieldY;
  static Field fieldZ;
  static Field fieldHashCode;
  static Method methodGetX;
  static Method methodGetY;
  static Method methodGetZ;

  @BeforeClass
  public static void setUpClass() throws Exception {
    try {
      Class<Point3D> clz = Point3D.class;
      fieldX = clz.getDeclaredField("x_");
      fieldY = clz.getDeclaredField("y_");
      fieldZ = clz.getDeclaredField("z_");
      fieldHashCode = clz.getDeclaredField("hashCodeCache_");
      fieldX.setAccessible(true);
      fieldY.setAccessible(true);
      fieldZ.setAccessible(true);
      fieldHashCode.setAccessible(true);
      Class[] methodParameters = null;
      methodGetX = clz.getMethod("getX", methodParameters);
      methodGetY = clz.getMethod("getY", methodParameters);
      methodGetZ = clz.getMethod("getZ", methodParameters);
    }
    catch (Exception e)
    {
      e.printStackTrace(System.out);
    }
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

  private double getGetMethodDoubleValue0Arg(Method method, Point3D instance)
  {
    double val = Double.NaN;
    Object[] methodParameters = new Object[0];
    try
    {
      Object methodReturnValue = method.invoke(instance, methodParameters);
      if (methodReturnValue instanceof Double)
      {
        val = ((Double)methodReturnValue).doubleValue();
      }
    }
    catch(Exception e)
    {
      e.printStackTrace(System.out);
    }
    return val;
  }

  private double getFieldDoubleValue(Field field, Point3D instance)
  {
    double val = Double.NaN;
    try
    {
      val = field.getDouble(instance);
    }
    catch(Exception e)
    {
      e.printStackTrace(System.out);
    }
    return val;
  }

  private Integer getFieldIntegerValue(Field field, Point3D instance)
  {
    Object obj = null;
    try
    {
      obj = field.get(instance);
    }
    catch(Exception e)
    {
      e.printStackTrace(System.out);
    }
    if (obj==null)
      return null;
    if (obj instanceof Integer)
    {
      return (Integer)obj;
    }
    return null;
  }

  private void testGetMethodDoubleValue0Arg(Method methodToTest,
                                            Field  methodsReturnField,
                                            String message,
                                            double valueToTestAgainst,
                                            Point3D instance)
  {
    System.out.println("Testing for value '"+valueToTestAgainst+"'");

    double fieldValue   = getFieldDoubleValue(methodsReturnField, instance);
    double methodValue  = getGetMethodDoubleValue0Arg(methodToTest, instance);
    if (Double.isNaN(valueToTestAgainst))
    {
      boolean fieldNaN  = Double.isNaN(fieldValue);
      boolean methodNaN = Double.isNaN(methodValue);
      assertTrue(message + " isNaN:", fieldNaN);
      assertTrue(message + " field isNaN:", methodNaN);
    }
    else
    {
      assertEquals(message + ":",       valueToTestAgainst, methodValue, 0.0);
      assertEquals(message + " field:", fieldValue,         methodValue, 0.0);
    }
  }

  private Point3D createInstanceParams(double value, int constructorPos, double others)
  {
    switch(constructorPos)
    {
      case 0:
        return new Point3D(value, others, others);
      case 1:
        return new Point3D(others, value, others);
      case 2:
        return new Point3D(others, others, value);
      default:
        return null;
    }
  }
  private void testGet(Method methodToTest, Field methodField, int constructorPos)
  {
    double expResult = 0.0;
    Point3D instance = new Point3D();
    testGetMethodDoubleValue0Arg( methodToTest, methodField, "default constructor", expResult, instance);
    instance = createInstanceParams(expResult, constructorPos, 0.0d);
    testGetMethodDoubleValue0Arg( methodToTest, methodField, "constructor with "+expResult+" and 0s", expResult, instance);
    instance = createInstanceParams(expResult, constructorPos, 1.0d);
    testGetMethodDoubleValue0Arg( methodToTest, methodField, "constructor with "+expResult+" and 1s", expResult, instance);
    expResult = 1.0;
    instance = createInstanceParams(expResult, constructorPos, 0.0d);
    testGetMethodDoubleValue0Arg( methodToTest, methodField, "constructor with "+expResult+" and 0s", expResult, instance);
    instance = createInstanceParams(expResult, constructorPos, 1.0d);
    testGetMethodDoubleValue0Arg( methodToTest, methodField, "constructor with "+expResult+" and 1s", expResult, instance);
    expResult = -76.124;
    instance = createInstanceParams(expResult, constructorPos, 0.0d);
    testGetMethodDoubleValue0Arg( methodToTest, methodField, "constructor with "+expResult+" and 0s", expResult, instance);
    instance = createInstanceParams(expResult, constructorPos, 1.0d);
    testGetMethodDoubleValue0Arg( methodToTest, methodField, "constructor with "+expResult+" and 1s", expResult, instance);
    expResult = Double.MAX_VALUE;
    instance = createInstanceParams(expResult, constructorPos, 0.0d);
    testGetMethodDoubleValue0Arg( methodToTest, methodField, "constructor with "+expResult+" and 0s", expResult, instance);
    instance = createInstanceParams(expResult, constructorPos, 1.0d);
    testGetMethodDoubleValue0Arg( methodToTest, methodField, "constructor with "+expResult+" and 1s", expResult, instance);
    expResult = Double.MIN_VALUE;
    instance = createInstanceParams(expResult, constructorPos, 0.0d);
    testGetMethodDoubleValue0Arg( methodToTest, methodField, "constructor with "+expResult+" and 0s", expResult, instance);
    instance = createInstanceParams(expResult, constructorPos, 1.0d);
    testGetMethodDoubleValue0Arg( methodToTest, methodField, "constructor with "+expResult+" and 1s", expResult, instance);
    expResult = Double.POSITIVE_INFINITY;
    instance = createInstanceParams(expResult, constructorPos, 0.0d);
    testGetMethodDoubleValue0Arg( methodToTest, methodField, "constructor with "+expResult+" and 0s", expResult, instance);
    instance = createInstanceParams(expResult, constructorPos, 1.0d);
    testGetMethodDoubleValue0Arg( methodToTest, methodField, "constructor with "+expResult+" and 1s", expResult, instance);
    expResult = Double.NEGATIVE_INFINITY;
    instance = createInstanceParams(expResult, constructorPos, 0.0d);
    testGetMethodDoubleValue0Arg( methodToTest, methodField, "constructor with "+expResult+" and 0s", expResult, instance);
    instance = createInstanceParams(expResult, constructorPos, 1.0d);
    testGetMethodDoubleValue0Arg( methodToTest, methodField, "constructor with "+expResult+" and 1s", expResult, instance);
    expResult = Double.NaN;
    instance = createInstanceParams(expResult, constructorPos, 0.0d);
    testGetMethodDoubleValue0Arg( methodToTest, methodField, "constructor with "+expResult+" and 0s", expResult, instance);
    instance = createInstanceParams(expResult, constructorPos, 1.0d);
    testGetMethodDoubleValue0Arg( methodToTest, methodField, "constructor with "+expResult+" and 1s", expResult, instance);
  }
  /**
   * Test of getX method, of class Point3D.
   */
  @Test
  public void testGetX() {
    System.out.println("getX");
    testGet(methodGetX, fieldX, 0);
    /*
    

    double expResult = 0.0;

    Point3D instance = new Point3D();
    double field  = getFieldDoubleValue(fieldX, instance);
    double result = instance.getX();
    assertEquals("default constructor", expResult, result, 0.0);
    assertEquals("default constructor: field", field, result, 0.0);

    instance = new Point3D(0.0, 0.0, 0.0);
    field    = getFieldDoubleValue(fieldX, instance);
    result   = instance.getX();
    assertEquals("explicit constructor 0,0,0", expResult, result, 0.0);
    assertEquals("explicit constructor 0,0,0: field", field, result, 0.0);

    instance = new Point3D(expResult, 0.0, 0.0);
    field    = getFieldDoubleValue(fieldX, instance);
    result   = instance.getX();
    assertEquals("explicit constructor expResult=0,0,0", expResult, result, 0.0);
    assertEquals("explicit constructor 0,0,0: field", field, result, 0.0);

    instance = new Point3D(expResult, 15.6701, 300.03);
    field    = getFieldDoubleValue(fieldX, instance);
    result   = instance.getX();
    assertEquals("explicit constructor expResult=0,15.6701, 300.03", expResult, result, 0.0);
    assertEquals("explicit constructor 0,0,0: field", field, result, 0.0);

    expResult = 1.56;
    instance = new Point3D(expResult, 0, 0);
    field    = getFieldDoubleValue(fieldX, instance);
    result   = instance.getX();
    assertEquals("explicit constructor (expResult=1.56, 0, 0", expResult, result, 0.0);
    assertEquals("explicit constructor 0,0,0: field", field, result, 0.0);
     **/
  }

  /**
   * Test of getY method, of class Point3D.
   */
  @Test
  public void testGetY() {
    System.out.println("getY()");
    testGet(methodGetY, fieldY, 1);
    /*
    double expResult = 0.0;

    Point3D instance = new Point3D();
    double field  = getFieldDoubleValue(fieldY, instance);
    double result = instance.getY();
    assertEquals("default constructor", expResult, result, 0.0);
    assertEquals("default constructor: field", field, result, 0.0);

    instance = new Point3D(0.0, 0.0, 0.0);
    field    = getFieldDoubleValue(fieldY, instance);
    result   = instance.getY();
    assertEquals("explicit constructor 0,0,0", expResult, result, 0.0);
    assertEquals("explicit constructor 0,0,0: field", field, result, 0.0);

    instance = new Point3D(0.0, expResult, 0.0);
    field    = getFieldDoubleValue(fieldY, instance);
    result   = instance.getY();
    assertEquals("explicit constructor 0,expResult=0,0", expResult, result, 0.0);
    assertEquals("explicit constructor 0,expResult=0,0: field", field, result, 0.0);

    instance = new Point3D(15.6701, expResult, 300.03);
    field    = getFieldDoubleValue(fieldY, instance);
    result   = instance.getY();
    assertEquals("explicit constructor 15.6701, expResult=0, 300.03", expResult, result, 0.0);
    assertEquals("explicit constructor 0,0,0: field", field, result, 0.0);

    expResult = 1.56;
    instance = new Point3D(0, expResult, 0);
    field    = getFieldDoubleValue(fieldY, instance);
    result   = instance.getY();
    assertEquals("explicit constructor (0, expResult=1.56, 0", expResult, result, 0.0);
    assertEquals("explicit constructor 0,0,0: field", field, result, 0.0);
     */
  }

  /**
   * Test of getZ method, of class Point3D.
   */
  @Test
  public void testGetZ() {
    System.out.println("getZ()");
    testGet(methodGetZ, fieldZ, 2);
    /*
    double expResult = 0.0;
    Field testField = fieldZ;

    Point3D instance = new Point3D();

    double field  = getFieldDoubleValue(testField, instance);
    double result = instance.getZ();
    assertEquals("default constructor", expResult, result, 0.0);
    assertEquals("default constructor: field", field, result, 0.0);

    instance = new Point3D(0.0, 0.0, 0.0);
    field    = getFieldDoubleValue(testField, instance);
    result   = instance.getY();
    assertEquals("explicit constructor 0,0,0", expResult, result, 0.0);
    assertEquals("explicit constructor 0,0,0: field", field, result, 0.0);

    instance = new Point3D(0.0, 0.0, expResult);
    field    = getFieldDoubleValue(testField, instance);
    result   = instance.getZ();
    assertEquals("explicit constructor 0,expResult=0,0", expResult, result, 0.0);
    assertEquals("explicit constructor 0,expResult=0,0: field", field, result, 0.0);

    instance = new Point3D(15.6701, expResult, 300.03);
    field    = getFieldDoubleValue(fieldY, instance);
    result   = instance.getY();
    assertEquals("explicit constructor 15.6701, expResult=0, 300.03", expResult, result, 0.0);
    assertEquals("explicit constructor 0,0,0: field", field, result, 0.0);

    expResult = 1.56;
    instance = new Point3D(0, expResult, 0);
    field    = getFieldDoubleValue(fieldY, instance);
    result   = instance.getY();
    assertEquals("explicit constructor (0, expResult=1.56, 0", expResult, result, 0.0);
    assertEquals("explicit constructor 0,0,0: field", field, result, 0.0);
     */
  }


  /**
   * Test of toString method, of class Point3D.
   */
  @Test
  public void testToString() {
    System.out.println("toString");
    Point3D instance = new Point3D();
    double x = getFieldDoubleValue(fieldX, instance);
    double y = getFieldDoubleValue(fieldY, instance);
    double z = getFieldDoubleValue(fieldZ, instance);
    String expResult = "Point3D["+x+","+y+","+z+"]";
    String result = instance.toString();
    assertEquals("Default: ", expResult, result);

    instance = new Point3D(12.4345, -18.0382, 93783.03);
    x = getFieldDoubleValue(fieldX, instance);
    y = getFieldDoubleValue(fieldY, instance);
    z = getFieldDoubleValue(fieldZ, instance);
    expResult = "Point3D["+x+","+y+","+z+"]";
    result = instance.toString();
    assertEquals("With (12.4345, -18.0382, 93783.03): ", expResult, result);
  }

  /**
   * Test of hashCode method, of class Point3D.
   */
  @Test
  public void testHashCode() {
    System.out.println("hashCode()");
    // whitebox test of hash algorithm to make sure alg fits expected value
    // implementation specific test.
    Point3D instance = new Point3D();
    // cache should be null initially
    Integer hashCache = getFieldIntegerValue(fieldHashCode, instance);
    assertNull("hashCache not cached",hashCache);

    Double x = getFieldDoubleValue(fieldX, instance);
    Double y = getFieldDoubleValue(fieldY, instance);
    Double z = getFieldDoubleValue(fieldZ, instance);


    int hx = x.hashCode();
    int hy = y.hashCode();
    int hz = z.hashCode();
    hz <<= 20;
    hy <<= 10;

    int expResult = hx ^ hy ^ hz;
    int result = instance.hashCode();
    assertEquals("Expected hash algorithm:", expResult, result);

    hashCache = getFieldIntegerValue(fieldHashCode, instance);
    assertNotNull("value cached",hashCache);
    assertEquals("hashCache matches", result, hashCache.intValue());

    Random r = new Random(18736);
    instance = new Point3D( -3000 * r.nextDouble(), 5000 * r.nextDouble(), 250 * r.nextDouble());
    x = getFieldDoubleValue(fieldX, instance);
    y = getFieldDoubleValue(fieldY, instance);
    z = getFieldDoubleValue(fieldZ, instance);


    hx = x.hashCode();
    hy = y.hashCode();
    hz = z.hashCode();
    hz <<= 20;
    hy <<= 10;
    int expResult2 =  hx ^ hy ^ hz;
    int result2 = instance.hashCode();
    assertEquals(expResult2, result2);
    hashCache = getFieldIntegerValue(fieldHashCode, instance);
    assertNotNull("value cached",hashCache);
    assertEquals("hashCache matches", result2, hashCache.intValue());
    // alg should be different for different double values.
    assertNotSame("Different values, differnt hash", result, result2);
  }

  /**
   * Test of equals method, of class Point3D.
   */
  @Test
  public void testEquals() {
    System.out.println("equals");
    Object obj = null;
    Point3D instance = new Point3D();
    boolean expResult = false;
    boolean result = instance.equals(obj);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of trulyEquals method, of class Point3D.
   */
  @Test
  public void almostEquals() {
    // need to figure out how to determine if almostEquals is working...
    System.out.println("trulyEquals(Object other)");
    Point3D otherPoint = null;
    Point3D instance = new Point3D();
    boolean expResult = false;
    boolean result = instance.almostEquals(otherPoint);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of trulyEquals method, of class Point3D.
   */
  @Test
  public void almostEqualsULPS() {
    // need to figure out how to detminer if almostEquals is working...
    System.out.println("trulyEquals(Object other, long ULPS");
    Point3D otherPoint = null;
    Point3D instance = new Point3D();
    boolean expResult = false;
    boolean result = instance.almostEquals(otherPoint, 0);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of distance method, of class Point3D.
   */
  @Test
  public void testDistance() {
    System.out.println("distance");
    Point3D otherPoint = null;
    Point3D instance = new Point3D();
    double expResult = 0.0;
    double result = instance.distance(otherPoint);
    assertEquals(expResult, result, 0.0);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of distanceSq method, of class Point3D.
   */
  @Test
  public void testDistanceSq() {
    System.out.println("distanceSq");
    Point3D otherPoint = null;
    Point3D instance = new Point3D();
    double expResult = 0.0;
    double result = instance.distanceSq(otherPoint);
    assertEquals(expResult, result, 0.0);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

}