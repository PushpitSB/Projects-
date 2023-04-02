//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: player
// Course: CS 300 Fall 2022
//
// Author: Pushpit Singh
// Email: psingh76@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: (name of your pair programming partner)
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: none
// Online Sources: none
//
///////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;

public class Player {
  private Room currentRoom;

  /**
   * constructor for class Player
   * 
   * @param current room, current room of the player
   * @return void
   * @author pushpitsingh
   */

  public Player(Room currentRoom) {
    this.currentRoom = currentRoom; // initilization
  }

  /**
   * returns the current room
   * 
   * @param none
   * 
   * @return current room of the player
   * @author pushpitsingh
   */
  public Room getCurrentRoom() {
    return currentRoom; // getter
  }

  /**
   * 
   * @param newRoom, changes the room to the new room
   */
  public void changeRoom(Room newRoom) { // change Room
    this.currentRoom = newRoom; // setter
  }

  /**
   * checks if a player can move to a particular room
   * 
   * @param destination, the destination
   * @return true, if he can else return false
   */
  public boolean canMoveTo(Room destination) {
    if (currentRoom.isAdjacent(destination)) { // uses is adjacent method to check if the player can
                                               // move to a particular room
      return true;
    }
    return false;
  }

  /**
   * tells if a player should teleport if its in the portal room
   * 
   * @return true if it can false if it can not
   */
  public boolean shouldTeleport() {
    if (currentRoom.getType() == RoomType.PORTAL) { // checks if the room is a portal room
      return true;

    } else {
      return false;
    }
  }

  /**
   * getter for item list
   * 
   * @return adjacent items list
   */
  public ArrayList<Room> getAdjacentRoomsToPlayer() {
    ArrayList<Room> list = new ArrayList<Room>();
    list = (ArrayList) currentRoom.getAdjacentRooms().clone(); // clones list so that a copy is
                                                               // returned not the orognal list
    return list;
  }

  /**
   * checks if the dragon is in any adjacent rooms
   * 
   * @param d
   * @return true, if dragon is there false, otherwise
   */
  public boolean isDragonNearby(Dragon d) {
    ArrayList<Room> list = new ArrayList<Room>(); // creates a new list
    list = currentRoom.getAdjacentRooms();
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i) == Dragon.getCurrentRoom()) { // checks if the dragon is in adjacent room
        return true;
      }
    }

    return false;

  }

  /**
   * checks through the nearby array list if any portal is nearby
   * 
   * @return true, if any portal is nearby false, if there are no portals nearby
   */
  public boolean isPortalNearby() {
    ArrayList<Room> list = new ArrayList<Room>();
    list = currentRoom.getAdjacentRooms();
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getType() == RoomType.PORTAL) { // checks if portal room is any of the
                                                      // adjacent rooms
        return true;
      }
    }

    return false;
  }

  /**
   * checks for treasure
   * 
   * @return true, if treasure is nearby false, if its not
   * @author pushpitsingh
   */

  public boolean isTreasureNearby() {
    ArrayList<Room> list = new ArrayList<Room>();
    list = currentRoom.getAdjacentRooms();
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getType() == RoomType.TREASURE) { // checks if the room in the adjacent room
                                                        // list is treasure room
        return true;
      }

    }
    return false;
  }



}
