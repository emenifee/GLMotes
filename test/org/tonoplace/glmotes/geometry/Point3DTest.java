/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.tonoplace.glmotes.geometry;

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
   * Test of getX method, of class Point3D.
   */
  @Test
  public void testGetX() {
    System.out.println("getX");
    Point3D instance = new Point3D();
    double expResult = 0.0;
    double result = instance.getX();
    assertEquals(expResult, result, 0.0);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getY method, of class Point3D.
   */
  @Test
  public void testGetY() {
    System.out.println("getY");
    Point3D instance = new Point3D();
    double expResult = 0.0;
    double result = instance.getY();
    assertEquals(expResult, result, 0.0);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getZ method, of class Point3D.
   */
  @Test
  public void testGetZ() {
    System.out.println("getZ");
    Point3D instance = new Point3D();
    double expResult = 0.0;
    double result = instance.getZ();
    assertEquals(expResult, result, 0.0);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of toString method, of class Point3D.
   */
  @Test
  public void testToString() {
    System.out.println("toString");
    Point3D instance = new Point3D();
    String expResult = "";
    String result = instance.toString();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of hashCode method, of class Point3D.
   */
  @Test
  public void testHashCode() {
    System.out.println("hashCode");
    Point3D instance = new Point3D();
    int expResult = 0;
    int result = instance.hashCode();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
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
  public void testTrulyEquals() {
    System.out.println("trulyEquals");
    Point3D otherPoint = null;
    Point3D instance = new Point3D();
    boolean expResult = false;
    boolean result = instance.trulyEquals(otherPoint);
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