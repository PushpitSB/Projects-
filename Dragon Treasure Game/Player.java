//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: (descriptive title of the program making use of this file)
// Course: CS 300 Fall 2022
//
// Author: Pushpit Singh
// Email: psingh76@wisc.edu
// Lecturer: Hobbes LeGaul
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Soumya Kataria
// Partner Email: skataria2@wisc.edu
// Partner Lecturer: Mouna Kacem
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// X Write-up states that pair programming is allowed for this assignment.
// X We have both read and understand the course Pair Programming Policy.
// X We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE
// Online Sources: NONE
//
//////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.Random;

/**
 * the class Player is a subclass of Character and implements the interface Moveable. This class
 * concerns if the Player has a key, changes the room, teleports the player, checks if dragon, 
 * portal, or treasure are nearby.
 */

public class Player extends Character implements Moveable {

  private boolean hasKey; // this checks if there is a key

  /**
   * Constructor for player object. The label should be "PLAYER" and not have a key by default.
   * 
   * @param currentRoom - , the room that the player should start in
   * @throws IllegalArgumentException - if the currentRoom is not a StartRoom
   */
  public Player(Room currentRoom) {

    super(currentRoom, "PLAYER");
    if (!(currentRoom instanceof StartRoom)) {
      throw new IllegalArgumentException("the room is not Start room");
    }
    hasKey = false;


  }

  /**
   * Determines if the player has the key.
   * 
   * @return true if the player has the key, false otherwise
   */
  public boolean hasKey() {
    return hasKey;
  }

  /**
   * Gives player the key.
   */
  public void obtainKey() {
    hasKey = true;
  }

  /**
   * Moves the Player to the destination room.
   * 
   * @implements changeRoom in interface Moveable
   * @param destination, the Room to change it to
   * @return true if the change was successful, false otherwise
   */

  @Override
  public boolean changeRoom(Room destination) {
    // TODO Auto-generated method stub
    if (this.canMoveTo(destination)) {
      super.setCurrentRoom(destination);
      return true;
    }
    return false;
  }

  /**
   * Checks if the player can move to the given destination. A valid move is the destination is a
   * room adjacent to the player.
   * 
   * @param destination - , the room to check if the player can move towards
   * @return true if they can, false otherwise
   * 
   */
  @Override
  public boolean canMoveTo(Room destination) {
    ArrayList<Room> adjRooms = this.getAdjacentRooms();
    return adjRooms.contains(destination);
  }

  /**
   * Checks if the player needs to teleport and move them if needed.
   * 
   * @return true if a teleport occurred, false otherwise
   */
  public boolean teleport() {
    if (super.getCurrentRoom() instanceof PortalRoom) {
      ArrayList<Room> adjRooms = this.getAdjacentRooms();
      Random rand = new Random();
      int r = rand.nextInt(adjRooms.size());
      this.changeRoom(adjRooms.get(r));
      return true;
    }
    return false;
  }

  /**
   * Determines whether or not the given dragon is nearby. A dragon is considered nearby if it is in
   * one of the adjacent rooms.
   * 
   * @param d- the dragon to check if nearby
   * @return true if the dragon is nearby, false otherwise
   */
  public boolean isDragonNearby(Dragon d) {
    return this.getAdjacentRooms().contains(d.getCurrentRoom());
  }

  /**
   * Determines whether or not the treasure room is nearby. The treasure room is considered nearby
   * if it is one of the adjacent rooms.
   * 
   * @return true if the treasure room is nearby, false otherwise
   */
  public boolean isTreasureNearby() {
    ArrayList<Room> adjRooms = this.getAdjacentRooms();
    for (Room r : adjRooms) {
      if (r instanceof TreasureRoom) {
        return true;
      }
    }

    return false;
  }

  /**
   * Determines whether or not a portal room is nearby. A portal room is considered nearby if it is
   * one of the adjacent rooms.
   * 
   * @return true if a portal room is nearby, false otherwise
   */
  public boolean isPortalNearby() {
    ArrayList<Room> adjRooms = this.getAdjacentRooms();
    for (Room r : adjRooms) {
      if (r instanceof PortalRoom) {
        return true;
      }
    }
    return false;
  }

}
