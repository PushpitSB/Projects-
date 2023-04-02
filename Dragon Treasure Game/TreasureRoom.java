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

import processing.core.PImage;

/*
 * The TreasureRoom is the child class of Room. This includes the treasure warning 
 * and the treasure background, including setters and getters. 
 * 
 */
public class TreasureRoom extends Room {
  private static final String TREASURE_WARNING = "You sense that there is treasure nearby.\n";
  //the teleport message that is printed
  private static PImage treasureBackground; // the image ALWAYS used for treasure rooms'


  /**
   * Constructor for a TresureRoom object and have a description of "In the back of this room, you
   * spot a treasure chest. It is locked...". Intializes all instance data fields.
   * 
   * @param ID - , the ID to give to this object
   */
  public TreasureRoom(int ID) {
    super(ID, "In the back of this room, you spot a treasure chest. It is locked...",
        treasureBackground);}
  
  /**
   * Getter for TREASURE_WARNING.
   * @return the string for warning about treasure being nearby.
   */
  public static String getTreasureWarning() {
    return TREASURE_WARNING;
  }
  
  /**
   * Sets the background image for the TreasureRoom class.
   @param treasureBackground - , the image to be the background
   */
  public static void setTreasureBackground(processing.core.PImage treasureBackground) {
    TreasureRoom.treasureBackground = treasureBackground;
  }
  
  /**
   * Determines whether or not the player can open the treasure chest in the room.
   * @param p - , the Player to check if they can open the chest
   * @return true if the player has the key and is in this TreasureRoom, false otherwise
   */
  public boolean playerCanGrabTreasure(Player p) {
    return (p.hasKey() && (p.getCurrentRoom() instanceof TreasureRoom));
  }

}
