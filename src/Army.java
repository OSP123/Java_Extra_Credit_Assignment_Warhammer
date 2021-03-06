/*
 Omar Patel
 CS1B - Professor Cecil
 */

import java.util.ArrayList;
import java.util.List;

public class Army
{
   final static int MAX_POINTS = 500;
   final static int MAX_COMMAND_UNITS = 1;
   final static int TROOP_COST = 6;
   final static int ELITE_TROOP_COST = 12;
   final static int COMMAND_COST = 70;
   final static int COMMAND_TROOP_COST = 25;
   final static int FAST_ATTACK_COST = 70;
   final static int HEAVY_ATTACK_COST = 140;
   
   public int numUnits = 0;
   public int commandUnits = 0;
   public int points = 0;
   public String player = "";
   List<Units> unitsList = new ArrayList<Units>();
   String race;
   
   public Army(String raceName, int troopPoints, int eliteTroopPoints, 
      int commandPoints, int commandTroopPoints, int fastAttackPoints, 
      int heavyAttackPoints)
   {
      if (troopPoints >= 0 && eliteTroopPoints >= 0 && commandPoints >= 0 
            && commandTroopPoints >= 0 && fastAttackPoints >= 0 
            && heavyAttackPoints >= 0)
      {
      race = raceName;
      for (int i = 0; i < (troopPoints/TROOP_COST); i++)
      {
         if (troopPoints % TROOP_COST == 0 && points < MAX_POINTS) 
         {
            unitsList.add(new TroopUnit());
            points += TROOP_COST;
            numUnits++;
         }
      }
      for (int i = 0; i < (eliteTroopPoints/ELITE_TROOP_COST); i++)
      {
         if (eliteTroopPoints % ELITE_TROOP_COST == 0 && points < MAX_POINTS) 
         {
            unitsList.add(new EliteTroopUnit());
            points += ELITE_TROOP_COST;
            numUnits++;
         }
      }
      for (int i = 0; i < (commandPoints/COMMAND_COST); i++)
      {
         if (commandPoints % COMMAND_COST == 0 && points < MAX_POINTS 
               && commandUnits < MAX_COMMAND_UNITS) 
         {
            unitsList.add(new CommandUnit());
            points += COMMAND_COST;
            commandUnits++;
            numUnits++;
         }
      }
      for (int i = 0; i < (fastAttackPoints/FAST_ATTACK_COST); i++)
      {
         if (fastAttackPoints % FAST_ATTACK_COST == 0 && points < MAX_POINTS) 
         {
            unitsList.add(new FastAttackUnit());
            points += FAST_ATTACK_COST;
            numUnits++;
         }
      }
      for (int i = 0; i < (heavyAttackPoints/HEAVY_ATTACK_COST); i++)
      {
         if (heavyAttackPoints % HEAVY_ATTACK_COST == 0 && points < MAX_POINTS) 
         {
            unitsList.add(new HeavyAttackUnit());
            points += HEAVY_ATTACK_COST;
            numUnits++;
         }
      }
      }
   }
   
   public static Army turn(Army army1, Army army2)
   {
      int dieRoll1 = (int)(Math.random()*6) + 1;
      int dieRoll2 = (int)(Math.random()*6) + 1;
      if (dieRoll1 > dieRoll2)
      {
         army1.player = "First player";
         army2.player = "Second player";
         return army1;
      }
      else
      {
         army2.player = "First player";
         army1.player = "Second player";
         return army2;
      }
   }
   
   public int getNumUnits()
   {
      return numUnits;
   }

   public void setNumUnits(int numUnits)
   {
      this.numUnits = numUnits;
   }

   public int getCommandUnits()
   {
      return commandUnits;
   }

   public void setCommandUnits(int commandUnits)
   {
      this.commandUnits = commandUnits;
   }

   public int getPoints()
   {
      return points;
   }

   public void setPoints(int points)
   {
      this.points = points;
   }

   public String getPlayer()
   {
      return player;
   }

   public void setPlayer(String player)
   {
      this.player = player;
   }

   public void setUnitsList(List<Units> unitsList)
   {
      this.unitsList = unitsList;
   }

   public String getRace()
   {
      return race;
   }

   public void setRace(String race)
   {
      this.race = race;
   }

   public void displayWinner()
   {
      System.out.println(getRace() + " win the game!");
   }
   
   public void displayUnitsLeft()
   {
      System.out.println("\n" + getRace() + " have " + getNumUnits() + " units left" 
         + "\n");
   }
   
   public void displayAttackingArmy(Army enemyArmy)
   {
      System.out.println("\n" + getRace() + " attack the " + enemyArmy.getRace() + "\n");
   }
   
   public void attackArmy(Army enemyArmy)
   {
      displayAttackingArmy(enemyArmy);
      for (int i = 0; i < getNumUnits() && i < enemyArmy.getNumUnits()
         && enemyArmy.unitsList.get(i) != null; i++)
      {
         unitsList.get(i).attackUnit(enemyArmy, enemyArmy.unitsList.get(i));
      }
      
      enemyArmy.displayUnitsLeft();
      
      if (getNumUnits() < 1 && enemyArmy.getNumUnits() > 0)
      {
         enemyArmy.displayWinner();
      }
      else if (enemyArmy.getNumUnits() < 1 && getNumUnits() > 0)
      {
         this.displayWinner();
      }
   }

}