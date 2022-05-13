package conways;

public class LifeData
{
  public LifeData(boolean alive)
  {
    isAlive = alive;
    couldChange = true;
  }

  public LifeData()
  {
    this(false);
  }

  public void incrementNumAdjacent()
  {
    ++numAdjacent;
    if(numAdjacent > 8) System.out.println("ERROR: point cannot have more than 8 neighbors!");
    couldChange = true;
  }
  
  public boolean isAlone()
  {
    return numAdjacent == 0;
  }
  
  public void clearNumAdjacent()
  {
    numAdjacent = 0;
  }
  
  public boolean survives()
  {
    boolean survives = isAlive && (numAdjacent == 2 || numAdjacent == 3); // live cell stays live
    survives = survives || (!isAlive && numAdjacent == 3); // dead cell born
    
    return survives;
  }
  
  public boolean tick()
  {
    isAlive = survives();
    return isAlive();
  }
  
  public boolean isAlive() { return isAlive; }
  public void setLife(boolean alive)
  {
    if (alive != isAlive) couldChange = true;
    isAlive = alive;
  }
  private boolean isAlive;

  public boolean changePossible() { return couldChange; }
  public void resetChangePossible() { couldChange = false; }
  private boolean couldChange;
  private int numAdjacent = 0;
}
