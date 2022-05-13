package conways;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Game
{
  
  /**
   * TODO: normalize input vector.
   * @param initialState should not contain any duplicate points or initial generation will be wrong
   */
  public Game(List<LifePoint> initialState)
  {
    currGeneration.addAll(initialState);

    // init point map
    updateActiveCells(initialState);
  }


  /**
   * update the game one generation
   */
  public void tick()
  {
    Iterator<Entry<LifePoint, LifeData>> activeCells = currPoints.entrySet().iterator();
    currGeneration.clear();
    while (activeCells.hasNext())
    {
      Entry<LifePoint, LifeData> point = activeCells.next();
      LifeData pointData = point.getValue();
      if(pointData.tick())
      {
        currGeneration.add(point.getKey());
      }
      else if (pointData.isAlone())
      {
        activeCells.remove(); // if it didn't survive and had no neighbors lets prune it
      }
      pointData.clearNumAdjacent();
    }
    
    updateActiveCells(currGeneration);
    ++generation;
  }

  public List<LifePoint> getLiveCells()
  {
    return currGeneration;
  }
  
  private void updateActiveCells(List<LifePoint> liveCells)
  {
    for (LifePoint point: liveCells)
    {
      LifeData pointData = getOrAllocateData(currPoints, point);
      pointData.setLife(true);
      incrementAdjacent(point);
    }    
  }
  
  private void incrementAdjacent(LifePoint point)
  {
    LifePoint[] neighbors = point.getNeighbors();
    for(LifePoint n: neighbors)
    {
      LifeData adjData = getOrAllocateData(currPoints, n);
      adjData.incrementNumAdjacent();
    }
  }
  
  private LifeData getOrAllocateData(Map<LifePoint, LifeData> pointMap, LifePoint p)
  {
    LifeData data = pointMap.get(p);
    if(data == null)
    {
      data = new LifeData();
      pointMap.put(p, data);
    }
    return data;
  }

  private List<LifePoint> currGeneration = new ArrayList<LifePoint>();
  private Map<LifePoint, LifeData> currPoints = new HashMap<LifePoint, LifeData>();
  private int generation = 0;
  public int getGenerationNumber() { return generation; }
}
