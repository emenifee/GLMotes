/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.tonoplace.glmotes.utility;

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
public class FloatingPointComparisonTest {

    public FloatingPointComparisonTest() {
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
   * Test of AlmostEqual2sComplement method, of class FloatingPointComparison.
   */
  @Test
  public void testAlmostEqual2sComplement_3args_1_double() {
    // NEED to determine a way to validate doubles that are almost equal
    // accounting for a difference in fp precission based on being withen
    // a minimum value distance.  How do we test this?
    System.out.println("AlmostEqual2sComplement_double");
    fail("Double based fp precision errors AlmostEquals valid test has not been determined");
    /**
    double a = 0.0;
    double b = 0.0;
    long maxUlps = 0L;
    boolean expResult = false;
    boolean result = FloatingPointComparison.AlmostEqual2sComplement(a, b, maxUlps);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
     **/
  }

  /**
   * Test of AlmostEqual2sComplement method, of class FloatingPointComparison.
   */
  @Test
  public void testAlmostEqual2sComplement_3args_2_float() {
    // NEED to determine a way to validate doubles that are almost equal
    // accounting for a difference in fp precission based on being withen
    // a minimum value distance.  How do we test this?
    System.out.println("AlmostEqual2sComplement_float");
    fail("Float based fp precision errors AlmostEquals valid test has not been determined");
    /**
    System.out.println("AlmostEqual2sComplement");
    float a = 0.0F;
    float b = 0.0F;
    int maxUlps = 0;
    boolean expResult = false;
    boolean result = FloatingPointComparison.AlmostEqual2sComplement(a, b, maxUlps);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
     **/
  }

}