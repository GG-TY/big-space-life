/**
 * 
 */
package conways;

/**
 *
 */
public class LifePoint
{
  public LifePoint(long xVal, long yVal, boolean hasLife)
  {
    x = xVal;
    y = yVal;
  }

  public LifePoint(long xVal, long yVal)
  {
    x = xVal;
    y = yVal;
  }
  
  public LifePoint()
  {
    this(0,0);
  }
  
  public boolean isAdjacent(LifePoint other)
  {
    if(Math.abs(x - other.x) <= 1 && Math.abs(y - other.y) <= 1)
      return true;
    return false;
  }

  public LifePoint[] getNeighbors()
  {
    if(neighbors == null)
    {
      neighbors = new LifePoint[]
          { new LifePoint(x-1, y+1), new LifePoint(x, y+1), new LifePoint(x+1, y+1),
            new LifePoint(x-1, y), new LifePoint(x+1, y),
            new LifePoint(x-1, y-1), new LifePoint(x, y-1), new LifePoint(x+1, y-1) };
    }
    return neighbors;
  }
  
  private LifePoint[] neighbors;
  
  /**
   * Eclipse Generated hashing function
   */
  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (x ^ (x >>> 32));
    result = prime * result + (int) (y ^ (y >>> 32));
    return result;
  }

  /** 
   * Eclipse Generated Equals
   */
  @Override
  public boolean equals(Object obj)
  {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (!(obj instanceof LifePoint))
      return false;
    LifePoint other = (LifePoint) obj;
    if (x != other.x)
      return false;
    if (y != other.y)
      return false;
    return true;
  }
    
  @Override
  public String toString()
  {
    return x + " " + y;
  }
  
  
  
  private long x;
  private long y;
}
