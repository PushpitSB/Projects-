//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    (descriptive title of the program making use of this file)
// Course:   CS 300 Fall 2022
//
// Author:   Pushpit Singh
// Email:    psingh76@wisc.edu
// Lecturer: Hobbes LeGaul
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Soumya Kataria
// Partner Email:           skataria2@wisc.edu
// Partner Lecturer:        Mouna Kacem
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   X Write-up states that pair programming is allowed for this assignment.
//   X We have both read and understand the course Pair Programming Policy.
//   X We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         NONE
// Online Sources:  NONE
//
//////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.Random;


/*
 * The Dragon class is a subclass of Character and implements the interface Moveable. This class
 * contains many methods concerning the dragon including the warning and encounter. 
 * 
 */

public class Dragon extends Character implements Moveable {
  private Random randGen; // random num generator used for moving
  private static final String DRAGON_WARNING = "You hear a fire breathing nearby!\n"; //the dragon warning if the player is near the dragon
  private static final String DRAGON_ENCOUNTER = "Oh no! You ran into the fire breathing dragon!\n";
  //the print statement is when the player encounters the dragon
  
  /**
   * Constructor for a Dragon object. Initializes all instance fields. The label should be "DRAGON"
   * by default.
   * 
   * @param currentRoom - , the room that the Dragon starts in
   * @throws IllegalArgumentException - with a descriptive message if currentRoom is not a
   *                                  TreasureRoom
   */
  public Dragon(Room currentRoom) {

    super(currentRoom, "DRAGON");
    if (!(this.getCurrentRoom() instanceof TreasureRoom)) {
      throw new IllegalArgumentException("the room is not Treasure room");
    }

    randGen = new Random();
  }

  /**
   * Moves the Dragon to the destination room Specified by: changeRoom in interface Moveable
   * 
   * @param destination - , the Room to change it to
   * @return true if the change was successful, false otherwise
   * 
   */
  @Override
  public boolean changeRoom(Room destination) {
    // TODO Auto-generated method stub
    if (!this.canMoveTo(destination)) {
      return false;
    }
    this.setCurrentRoom(destination);
    return super.getCurrentRoom().equals(destination);
  }

  /**
   * Checks if the dragon can move to the given destination. A valid move is the destination not a
   * PortalRoom. Specified by: canMoveTo in interface Moveable 
   * @param destination - , the room to check if
   * the dragon can move towards
   * 
   * @return true if they can, false otherwise
   */
  @Override
  public boolean canMoveTo(Room destination) {
    // TODO Auto-generated method stub
    if (destination instanceof PortalRoom) {
      return false;
    }
    ArrayList<Room> adjRooms = this.getAdjacentRooms();
    if(!adjRooms.contains(destination)) {
      return false;
    }
    return true;

  }
  /**
   * Picks randomly ONCE an adjacent room to move into.
   * @return the room that this Dragon should try to move into
   */
  public Room pickRoom() {
    ArrayList<Room> adjRooms = this.getAdjacentRooms();
    return adjRooms.get(randGen.nextInt(adjRooms.size()));
    

  }
  /**
   * Getter for DRAGON_WARNING.
   * @return the string for warning about a dragon being nearby.
   */
  public static String getDragonWarning() {
    return Dragon.DRAGON_WARNING;
    
  }
  
  /**
   * Getter for DRAGON_ENCOUNTER
   * @return the string for letting the player know they ran into the dragon.
   */
  public static String getDragonEncounter() {
    return Dragon.DRAGON_ENCOUNTER;
  }

}
