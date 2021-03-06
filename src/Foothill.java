/*
 Omar Patel
 CS1B - Professor Cecil
 */

import java.text.*;
import java.util.*;

//------------------------------------------------------
public class Foothill
{ 
   
   public static void main(String[] args) throws Exception
   {
      // multiples of 6, 12, 70, 25, 70, 140 and total must be <= 500
      // Basic Troop, Elite Troop, Command Unit, Command Troop Unit, Fast Attack
      // Unit, Heavy Attack Unit, respectively.
      Army space_marines = new Army("Space Marines", 60, 60, 70, 100, 70, 140);
      Army tyranids = new Army("Tyranids", 60, 60, 70, 100, 70, 140);
      
      System.out.println("Space Marine Army\n");
      for (Units p : space_marines.unitsList)
         System.out.println("\nStrength: " + p.strength + "\nToughness" 
            + p.toughness + "\nAttacks: " + p.attacks + "\n" + "Save: " + p.save
            + "\nWounds: " + p.wounds);
      
      System.out.println("Tyranid Army\n");
      for (Units p : tyranids.unitsList)
         System.out.println("\nStrength: " + p.strength + "\nToughness" 
            + p.toughness + "\nAttacks: " + p.attacks + "\n" + "Save: " + p.save
            + "\nWounds: " + p.wounds);
      
      //Determine who goes first and sets the first and second player
      Army.turn(space_marines, tyranids);
      
      Army firstPlayer, secondPlayer;
      
      if (space_marines.player == "First player" 
            && tyranids.player == "Second player")
      {
         firstPlayer = space_marines;
         secondPlayer = tyranids;
      }
      else
      {
         firstPlayer = tyranids;
         secondPlayer = space_marines;
      }
      
      boolean quit = false;
      System.out.println("The Battle Begins!");
      
      while (quit == false)
      {
         if (firstPlayer.numUnits > 0 && secondPlayer.numUnits > 0)
            firstPlayer.attackArmy(secondPlayer);
         if (space_marines.numUnits > 0 && tyranids.numUnits > 0)
            secondPlayer.attackArmy(firstPlayer);
         else
            quit = true;
      }
   }

}

/*----------------------------------Output--------------------------------------
Space Marine Army


Strength: 3
Toughness3
Attacks: 1
Save: 5
Wounds: 1

Strength: 3
Toughness3
Attacks: 1
Save: 5
Wounds: 1

Strength: 3
Toughness3
Attacks: 1
Save: 5
Wounds: 1

Strength: 3
Toughness3
Attacks: 1
Save: 5
Wounds: 1

Strength: 3
Toughness3
Attacks: 1
Save: 5
Wounds: 1

Strength: 3
Toughness3
Attacks: 1
Save: 5
Wounds: 1

Strength: 3
Toughness3
Attacks: 1
Save: 5
Wounds: 1

Strength: 3
Toughness3
Attacks: 1
Save: 5
Wounds: 1

Strength: 3
Toughness3
Attacks: 1
Save: 5
Wounds: 1

Strength: 3
Toughness3
Attacks: 1
Save: 5
Wounds: 1

Strength: 3
Toughness3
Attacks: 1
Save: 4
Wounds: 1

Strength: 3
Toughness3
Attacks: 1
Save: 4
Wounds: 1

Strength: 3
Toughness3
Attacks: 1
Save: 4
Wounds: 1

Strength: 3
Toughness3
Attacks: 1
Save: 4
Wounds: 1

Strength: 3
Toughness3
Attacks: 1
Save: 4
Wounds: 1

Strength: 5
Toughness4
Attacks: 3
Save: 5
Wounds: 3

Strength: 4
Toughness4
Attacks: 3
Save: 4
Wounds: 3

Strength: 5
Toughness5
Attacks: 3
Save: 2
Wounds: 3
Tyranid Army


Strength: 3
Toughness3
Attacks: 1
Save: 5
Wounds: 1

Strength: 3
Toughness3
Attacks: 1
Save: 5
Wounds: 1

Strength: 3
Toughness3
Attacks: 1
Save: 5
Wounds: 1

Strength: 3
Toughness3
Attacks: 1
Save: 5
Wounds: 1

Strength: 3
Toughness3
Attacks: 1
Save: 5
Wounds: 1

Strength: 3
Toughness3
Attacks: 1
Save: 5
Wounds: 1

Strength: 3
Toughness3
Attacks: 1
Save: 5
Wounds: 1

Strength: 3
Toughness3
Attacks: 1
Save: 5
Wounds: 1

Strength: 3
Toughness3
Attacks: 1
Save: 5
Wounds: 1

Strength: 3
Toughness3
Attacks: 1
Save: 5
Wounds: 1

Strength: 3
Toughness3
Attacks: 1
Save: 4
Wounds: 1

Strength: 3
Toughness3
Attacks: 1
Save: 4
Wounds: 1

Strength: 3
Toughness3
Attacks: 1
Save: 4
Wounds: 1

Strength: 3
Toughness3
Attacks: 1
Save: 4
Wounds: 1

Strength: 3
Toughness3
Attacks: 1
Save: 4
Wounds: 1

Strength: 5
Toughness4
Attacks: 3
Save: 5
Wounds: 3

Strength: 4
Toughness4
Attacks: 3
Save: 4
Wounds: 3

Strength: 5
Toughness5
Attacks: 3
Save: 2
Wounds: 3
The Battle Begins!

Space Marines attack the Tyranids

Ahhhhhhhh!
A Basic Troop has been killed
Ahhhhhhhh!
A Basic Troop has been killed
Ahhhhhhhh!
A Basic Troop has been killed
Ahhhhhhhh!
A Basic Troop has been killed
Ahhhhhhhh!
A Basic Troop has been killed
Ahhhhhhhh!
A Elite has been killed
Ahhhhhhhh!
A Elite has been killed

Tyranids have 11 units left


Tyranids attack the Space Marines

Ahhhhhhhh!
A Basic Troop has been killed
Ahhhhhhhh!
A Basic Troop has been killed
Ahhhhhhhh!
A Basic Troop has been killed
Ahhhhhhhh!
A Basic Troop has been killed
Ahhhhhhhh!
A Basic Troop has been killed
Ahhhhhhhh!
A Elite has been killed
Ahhhhhhhh!
A Elite has been killed

Space Marines have 11 units left


Space Marines attack the Tyranids

Ahhhhhhhh!
A Basic Troop has been killed
Ahhhhhhhh!
A Basic Troop has been killed
Ahhhhhhhh!
A Elite has been killed
Ahhhhhhhh!
A Elite has been killed

Tyranids have 7 units left


Tyranids attack the Space Marines

Ahhhhhhhh!
A Basic Troop has been killed
Ahhhhhhhh!
A Basic Troop has been killed
Ahhhhhhhh!
A Basic Troop has been killed
Ahhhhhhhh!
A Elite has been killed
Ahhhhhhhh!
A Command has been killed

Space Marines have 6 units left


Space Marines attack the Tyranids

Ahhhhhhhh!
A Basic Troop has been killed
Ahhhhhhhh!
A Basic Troop has been killed
Ahhhhhhhh!
A Command has been killed
Ahhhhhhhh!
A Heavy Attack has been killed

Tyranids have 3 units left


Tyranids attack the Space Marines

Ahhhhhhhh!
A Elite has been killed

Space Marines have 5 units left


Space Marines attack the Tyranids

Ahhhhhhhh!
A Basic Troop has been killed

Tyranids have 2 units left


Tyranids attack the Space Marines

Ahhhhhhhh!
A Basic Troop has been killed
Ahhhhhhhh!
A Elite has been killed

Space Marines have 3 units left


Space Marines attack the Tyranids

Ahhhhhhhh!
A Fast Attack has been killed

Tyranids have 1 units left


Tyranids attack the Space Marines

Ahhhhhhhh!
A Basic Troop has been killed

Space Marines have 2 units left


Space Marines attack the Tyranids

Ahhhhhhhh!
A Elite has been killed

Tyranids have 0 units left

Space Marines win the game!

 */
