/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.tonoplace.glmotes.geometry;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

    Double x = instance.getX();
    Double y = instance.getY();
    Double z = instance.getZ();


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
    assertEquals("null: ", expResult, result);

    expResult = true;
    result = instance.equals(instance);
    assertEquals("sameref: ", expResult, result);

    Point3D instance2 = new Point3D();
    result = instance.equals(instance2);
    assertEquals("newdef: ", expResult, result);

    instance2 = new Point3D(0,0,0);
    result = instance.equals(instance2);
    assertEquals("new0", expResult, result);

    expResult = false;
    instance2 = new Point3D(0,0,1);
    result = instance.equals(instance2);
    assertEquals("diffZ", expResult, result);

    instance2 = new Point3D(0,1,0);
    result = instance.equals(instance2);
    assertEquals("diffY", expResult, result);

    instance2 = new Point3D(1,0,0);
    result = instance.equals(instance2);
    assertEquals("diffX", expResult, result);

    instance2 = new Point3D(1.1,2.3,3.4);
    result = instance.equals(instance2);
    assertEquals("diffAll", expResult, result);

    instance =  new Point3D(instance2);
    expResult = true;
    result = instance.equals(instance2);
    assertEquals("copyCon", expResult, result);
  }

  /**
   * Test of trulyEquals method, of class Point3D.
   */
  @Test
  public void almostEquals() {
    // need to figure out how to determine if almostEquals is working...
    fail("PROTOTYPE: need to determine math/proof of almostEquals.");
  }

  /**
   * Test of trulyEquals method, of class Point3D.
   */
  @Test
  public void almostEqualsULPS() {
    // need to figure out how to detminer if almostEquals is working...
    fail("PROTOTYPE: need to determine math/proof of almostEquals(long ULPS).");
  }

  /**
   * Test of distance method, of class Point3D.
   */
  @Test
  public void testDistance() {
    System.out.println("distance(Point 3D");
    // algorithm specific test for meaning of distance.
    Random r = new Random(1);
    Point3D otherPoint = new Point3D(12*r.nextDouble(), 12*r.nextDouble(), 12*r.nextDouble());
    Point3D instance = new Point3D(r.nextDouble(), r.nextDouble(), r.nextDouble());
    double x1 = instance.getX();
    double y1 = instance.getY();
    double z1 = instance.getZ();
    double x2 = otherPoint.getX();
    double y2 = otherPoint.getY();
    double z2 = otherPoint.getZ();
    double xDiff = x1 - x2;
    double yDiff = y1 - y2;
    double zDiff = z1 - z2;
    double expResult = Math.sqrt(xDiff*xDiff + yDiff*yDiff + zDiff*zDiff);
    double result = instance.distance(otherPoint);
    assertEquals("distance 1: ", expResult, result, 0.0);
    result = otherPoint.distance(instance);
    assertEquals("distance 2: ", expResult, result, 0.0);
  }
  @Test(expected=NullPointerException.class)
  public void testDistanceNull() {
    System.out.println("distance(Point 3D=Null");
    Point3D instance = new Point3D();
    double dist = instance.distance(null);
  }


  /**
   * Test of distanceSq method, of class Point3D.
   */
  @Test
  public void testDistanceSq() {
    System.out.println("distanceSq(Point 3D");
    // algorithm specific test for meaning of distance.
    Random r = new Random(1);
    Point3D otherPoint = new Point3D(12*r.nextDouble(), 12*r.nextDouble(), 12*r.nextDouble());
    Point3D instance = new Point3D(r.nextDouble(), r.nextDouble(), r.nextDouble());
    double x1 = instance.getX();
    double y1 = instance.getY();
    double z1 = instance.getZ();
    double x2 = otherPoint.getX();
    double y2 = otherPoint.getY();
    double z2 = otherPoint.getZ();
    double xDiff = x1 - x2;
    double yDiff = y1 - y2;
    double zDiff = z1 - z2;
    double expResult = xDiff*xDiff + yDiff*yDiff + zDiff*zDiff;
    double result = instance.distanceSq(otherPoint);
    assertEquals("distance 1: ", expResult, result, 0.0);
    result = otherPoint.distanceSq(instance);
    assertEquals("distance 2: ", expResult, result, 0.0);
  }

  @Test(expected=NullPointerException.class)
  public void testDistanceSqNull() {
    System.out.println("distanceSq(Point 3D=Null");
    Point3D instance = new Point3D();
    double dist = instance.distanceSq(null);
  }

  @Test
  public void testPoint3DNoArg()
  {
    System.out.println("Point3D()");
    Point3D instance = new Point3D();
    double expXResult = 0.0;
    double expYResult = 0.0;
    double expZResult = 0.0;
    double xResult = instance.getX();
    double yResult = instance.getY();
    double zResult = instance.getZ();
    assertEquals("x", expXResult, xResult, 0.0);
    assertEquals("y", expYResult, yResult, 0.0);
    assertEquals("z", expZResult, zResult, 0.0);
  }

  @Test
  public void testPoint3DCopyCon()
  {
    System.out.println("Point3D(Point3d copy)");
    Point3D original = new Point3D();
    Point3D copyOf   = new Point3D(original);
    boolean expResult = true;
    double  expXResult = original.getX();
    double  expYResult = original.getY();
    double  expZResult = original.getZ();
    boolean result = original.equals(copyOf);
    double xResult = copyOf.getX();
    double yResult = copyOf.getY();
    double zResult = copyOf.getZ();

    assertEquals("equals 1", expResult, result);
    assertEquals("x same 1", expXResult, xResult, 0.0);
    assertEquals("y same 1", expYResult, yResult, 0.0);
    assertEquals("z same 1", expZResult, zResult, 0.0);

    expXResult = Math.PI;
    expYResult = Math.E;
    expZResult = expXResult * expXResult * expYResult * 7 / 2;
    original = new Point3D(expXResult, expYResult, expZResult);
    copyOf   = new Point3D(original);

    result = original.equals(copyOf);
    xResult = copyOf.getX();
    yResult = copyOf.getY();
    zResult = copyOf.getZ();

    assertEquals("equals 2", expResult, result);
    assertEquals("x same 2", expXResult, xResult, 0.0);
    assertEquals("y same 2", expYResult, yResult, 0.0);
    assertEquals("z same 2", expZResult, zResult, 0.0);
  }

  @Test (expected=NullPointerException.class)
  public void testPoint3DCopyConWithNull()
  {
    System.out.println("Point3D(Point3d NULL)");
    Point3D copyFrom = null;
    Point3D instance = new Point3D(copyFrom);
  }

  @Test
  public void testPoint3DArrayCon()
  {
    System.out.println("Point3D(double[] doubles)");
    double expXResult = 0.0;
    double expYResult = 0.0;
    double expZResult = 0.0;
    double[] conValues = new double[3];
    conValues[0] = expXResult;
    conValues[1] = expYResult;
    conValues[2] = expZResult;
    Point3D instance = new Point3D(conValues);
    double xResult = instance.getX();
    double yResult = instance.getY();
    double zResult = instance.getZ();

    assertEquals("x 1", expXResult, xResult, 0.0);
    assertEquals("y 1", expYResult, yResult, 0.0);
    assertEquals("z 1", expZResult, zResult, 0.0);

    Random r = new Random(1);
    expXResult = 3 * r.nextDouble();
    expYResult = 2 * r.nextDouble();
    expZResult = 5 * r.nextDouble();
    conValues[0] = expXResult;
    conValues[1] = expYResult;
    conValues[2] = expZResult;
    instance = new Point3D(conValues);
    xResult = instance.getX();
    yResult = instance.getY();
    zResult = instance.getZ();

    assertEquals("x 2", expXResult, xResult, 0.0);
    assertEquals("y 2", expYResult, yResult, 0.0);
    assertEquals("z 2", expZResult, zResult, 0.0);

  }
  @Test(expected=NullPointerException.class)
  public void testPoint3DArrayConWithNull()
  {
    System.out.println("Point3D(double[] doubles=NULL)");
    double[] conValues = null;
    Point3D instance = new Point3D(conValues);
  }
  @Test(expected=IllegalArgumentException.class)
  public void testPoint3DArrayConWithSmallArray()
  {
    System.out.println("Point3D(double[] doubles=doubles[2])");
    double[] conValues = new double[2];
    conValues[0] = 1;
    conValues[1] = 1;
    Point3D instance = new Point3D(conValues);
  }
  @Test
  public void testPoint3DArrayOffsetCon()
  {
    System.out.println("Point3D(double[] doubles, int offset)");
    double expXResult = 0.0;
    double expYResult = 0.0;
    double expZResult = 0.0;
    double[] conValues = new double[5];
    conValues[0] = expXResult;
    conValues[1] = expYResult;
    conValues[2] = expZResult;
    Point3D instance = new Point3D(conValues,0);
    double xResult = instance.getX();
    double yResult = instance.getY();
    double zResult = instance.getZ();

    assertEquals("x 1,0", expXResult, xResult, 0.0);
    assertEquals("y 1,0", expYResult, yResult, 0.0);
    assertEquals("z 1,0", expZResult, zResult, 0.0);

    conValues[1] = expXResult;
    conValues[2] = expYResult;
    conValues[3] = expZResult;
    instance = new Point3D(conValues,1);
    xResult = instance.getX();
    yResult = instance.getY();
    zResult = instance.getZ();

    assertEquals("x 1,1", expXResult, xResult, 0.0);
    assertEquals("y 1,1", expYResult, yResult, 0.0);
    assertEquals("z 1,1", expZResult, zResult, 0.0);

    conValues[2] = expXResult;
    conValues[3] = expYResult;
    conValues[4] = expZResult;
    instance = new Point3D(conValues,2);
    xResult = instance.getX();
    yResult = instance.getY();
    zResult = instance.getZ();

    assertEquals("x 1,2", expXResult, xResult, 0.0);
    assertEquals("y 1,2", expYResult, yResult, 0.0);
    assertEquals("z 1,2", expZResult, zResult, 0.0);


    Random r = new Random(1);
    double expVResult = conValues[0] = r.nextDouble();
    double expWResult = conValues[1] = 4 * r.nextDouble();
    expXResult        = conValues[2] = 3 * r.nextDouble();
    expYResult        = conValues[3] = 2 * r.nextDouble();
    expZResult        = conValues[4] = 5 * r.nextDouble();

    instance = new Point3D(conValues,0);
    xResult = instance.getX();
    yResult = instance.getY();
    zResult = instance.getZ();
    assertEquals("x 2,0", expVResult, xResult, 0.0);
    assertEquals("y 2,0", expWResult, yResult, 0.0);
    assertEquals("z 2,0", expXResult, zResult, 0.0);


    instance = new Point3D(conValues,1);
    xResult = instance.getX();
    yResult = instance.getY();
    zResult = instance.getZ();
    assertEquals("x 2,1", expWResult, xResult, 0.0);
    assertEquals("y 2,1", expXResult, yResult, 0.0);
    assertEquals("z 2,1", expYResult, zResult, 0.0);

    instance = new Point3D(conValues,2);
    xResult = instance.getX();
    yResult = instance.getY();
    zResult = instance.getZ();
    assertEquals("x 2,2", expXResult, xResult, 0.0);
    assertEquals("y 2,2", expYResult, yResult, 0.0);
    assertEquals("z 2,2", expZResult, zResult, 0.0);
  }

  @Test(expected=NullPointerException.class)
  public void testPoint3DArrayOffsetConWithNull()
  {
    System.out.println("Point3D(double[] doubles=NULL, int offset=20)");
    double[] values = null;
    Point3D instance = new Point3D(values, 20);
  }

  @Test(expected=IllegalArgumentException.class)
  public void testPoint3DArrayOffsetConWithSmallArray()
  {
    System.out.println("Point3D(double[] doubles=[5], int offset=3)");
    double[] values = { 1.0, 2.0, 3.0, 4.0, 5.0 };
    Point3D instance = new Point3D(values, 3);
  }

  @Test
  public void testSerialization() 
  {
    try
    {
      System.out.println("serialization:");
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      ObjectOutputStream oos = new ObjectOutputStream(baos);
      Random r = new Random(1);
      Point3D expResult1 = new Point3D();
      Point3D expResult2 = new Point3D(r.nextDouble(), r.nextDouble(), r.nextDouble());
      oos.writeObject(expResult1);
      oos.writeObject(expResult2);
      oos.close();
      byte[] data = baos.toByteArray();
      ByteArrayInputStream bais = new ByteArrayInputStream(data);
      ObjectInputStream ois = new ObjectInputStream(bais);
      Point3D result1 = (Point3D) ois.readObject();
      Point3D result2 = (Point3D) ois.readObject();
      assertEquals("result1", expResult1, result1);
      assertEquals("result2", expResult2, result2);
    } catch (Exception e) {
      e.printStackTrace(System.out);
      fail("Exception thrown durring serialization!");
    }
  }

}