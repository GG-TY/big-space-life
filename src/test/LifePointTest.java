package test;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

import conways.LifePoint;

public class LifePointTest
{

  private static LifePoint p00 = new LifePoint(-1,1);
  private static LifePoint p0 = new LifePoint(-1,1);
  private static LifePoint p1 = new LifePoint(0,1);
  private static LifePoint p2 = new LifePoint(1,1);
  private static LifePoint p3 = new LifePoint(-1,0);
  private static LifePoint p4 = new LifePoint(0,0);
  private static LifePoint p5 = new LifePoint(1,0);
  private static LifePoint p6 = new LifePoint(-1,-1);
  private static LifePoint p7 = new LifePoint(0,-1);
  private static LifePoint p8 = new LifePoint(1,-1);

  @BeforeClass
  public static void setup()
  {
  }
  
  @Test
  public void testIsAdjacent()
  {
    assertTrue(p0.isAdjacent(p1));
    assertTrue(p1.isAdjacent(p2));
    assertTrue(p1.isAdjacent(p0));
    assertTrue(p8.isAdjacent(p4));
    
    assertFalse(p0.isAdjacent(p2));
    assertFalse(p0.isAdjacent(p6));
    assertFalse(p0.isAdjacent(p8));
  }

  @Test
  public void testEquals()
  {
    assertTrue(p1.equals(p1));
    assertTrue(p0.equals(p00));
    assertTrue(p00.equals(p0));
    
    assertFalse(p5.equals(p3));
  }
  
  @Test
  public void testGetNeighbors()
  {
    LifePoint[] res = p4.getNeighbors();
    assertEquals(res.length, 8);
    assertEquals(res[0], p0);
    assertEquals(res[1], p1);
    assertEquals(res[2], p2);
    assertEquals(res[3], p3);
    assertEquals(res[4], p5);
    assertEquals(res[5], p6);
    assertEquals(res[6], p7);
    assertEquals(res[7], p8);
  }
}