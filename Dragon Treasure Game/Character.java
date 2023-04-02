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

/*
 * 
 * This class creates a character that is in a room and has a label/description with
 * getters and setters of label, currentRoom, and it's adjRooms
 * 
 */

public class Character {
  private Room currentRoom; // current room the character is in
  private String label; // a label giving a basic description of the character

  /**
   * Constructor for a Character object. Initializes all instance fields
   *
   * @param currentRoom - , the room that the Character is located in label - , a descriptive label
   *                    of this Character
   * @throws: IllegalArgumentException - with a descriptive message if currentRoom is null.
   */
  public Character(Room currentRoom, String label) {
    if (currentRoom == null) {
      throw new IllegalArgumentException("the current room is null");
    }
    this.currentRoom = currentRoom;
    this.label = label;

  }

  /**
   * 
   * Getter for the current room of this Character
   * 
   * @return the room where the character is
   */
  public Room getCurrentRoom() {
    return currentRoom;
  }
  
  /**
   * Getter for the label of this Character.
   * @return this Character's descriptive label
   */
  public String getLabel() {
    return label;
  }
  
  
  /**
   * Gets the list of rooms adjacent to this Character.
   * @return an ArrayList of rooms adjacent to this character
   */
  public ArrayList<Room> getAdjacentRooms(){
    return  currentRoom.getAdjacentRooms();
  }
  
  /**
   * Sets the current room to the one given
   */
  public void setCurrentRoom(Room newRoom) {
    this.currentRoom = newRoom;
  }
}
