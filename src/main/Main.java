package main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import conways.Game;
import conways.LifePoint;

public class Main {

  public static void main(String[] args) {
    try (InputStreamReader in = new InputStreamReader(System.in)) {      

      BufferedReader input = new BufferedReader(in);
      String str;
      String[] tokens;
      List<LifePoint> points = new ArrayList<LifePoint>();
      
      System.out.print("Input initial points in (x, y) format followed by enter.  enter '-' to start game:");
      
      while ((str = input.readLine()) != null && !str.startsWith("-"))
      {
        if(str.startsWith("(") && str.endsWith(")"))
        {
          tokens = str.substring(1,str.length() - 1).split(",");
          points.add(new LifePoint(Long.parseLong(tokens[0].trim()), Long.parseLong(tokens[1].trim())));
        }
      }
      
      Game lifeGame = new Game(points);
      printLifeOutput(System.out, points);
      while((str = input.readLine()) != null && !str.startsWith("q"))
      {
        lifeGame.tick();
        System.out.println("Generation: " + lifeGame.getGenerationNumber());
        printLifeOutput(System.out, lifeGame.getLiveCells());
      }

    } catch (IOException io) {
      io.printStackTrace();
    }
  }

  private static void printLifeOutput(PrintStream printer, List<LifePoint> points)
  {
    printer.println("Life 1.06");
    for (LifePoint point : points)
    {
      printer.println(point);
    }    
  }
}
