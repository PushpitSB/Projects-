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

import processing.core.PApplet;
import processing.core.PImage;

/*
 * The Room class has many subclasses. There are getters and setters for the variables. 
 * 
 */
public class Room {
  private String description; // verbal description of the room
  private ArrayList<Room> adjRooms; // list of all rooms directly connect
  private final int ID; // a "unique" identifier for each room
  protected static PApplet processing; // PApplet object which the rooms will use to
  // draw stuff to the GUI
  private PImage image; // stores the image that corresponds to the background of a room

  /**
   * 
   * @param ID,             the ID that this Room should have
   * @param description,the verbal description this Room should have
   * @param image,          the image that should be used as a background when drawing this Room.
   */
  public Room(int ID, String description, processing.core.PImage image) {
    this.ID = ID; // initializing all the fields
    this.description = description;
    this.image = image;
    this.adjRooms = new ArrayList<Room>();

  }

  /**
   * the ID of this Room
   * 
   * @return ID, the ID of this Room
   */
  public int getID() {
    return ID;
  }

  /**
   * Getter for description.
   * 
   * @return description, the verbal description of this room
   */
  public String getDescription() {
    return description;
  }

  /**
   * Getter for the list of adjacentRooms.
   * 
   * @return adjRooms,the list of adjacent rooms
   */
  public ArrayList<Room> getAdjacentRooms() {
    return adjRooms;
  }

  /**
   * Sets the processing for the class.
   * 
   * @param processing - , the PApplet that this room will use to draw to the window
   */

  public static void setProcessing(processing.core.PApplet processing) {
    Room.processing = processing;
  }

  /**
   * Adds the given room to the list of rooms adjacent to this room.
   * 
   * @param toAdd, the room to be added
   */
  public void addToAdjacentRooms(Room toAdd) {
    adjRooms.add(toAdd);
  }

  /**
   * Checks whether or not the given room is adjacent to this room.
   * 
   * @param r - , the room to check for adjacency
   * @return true if it is adjacent, false otherwise
   */

  public boolean isAdjacent(Room r) {
    return adjRooms.contains(r);
  }

  /**
   * Overrides Object.equals(). Determines if two objects are equal.
   * 
   * @Overrides equals in class Object
   * @param other - , the object to check against this Room
   * @return true if other is of type Room and has the same ID, false otherwise
   */
  @Override
  public boolean equals(Object other) {

    if (other instanceof Room) {
      Room otherRoom = (Room) other;
      return this.ID == otherRoom.ID;
    }

    return false;
  }

  /**
   * Overrides Object.toString(). Returns a string representation of a Room object.
   * 
   * @Overrides toString in class Object
   * @return Returns a string in the form of "<ID>: <description>\n Adjacent Rooms: <r1's ID> <r2's
   *         ID>" list of adjacent room IDs continues for all rooms adjacent to this Room.
   */
  @Override
  public String toString() {
    String s = this.ID + ": " + this.description + "\n Adjacent Rooms: ";
    if(adjRooms.isEmpty()) {
      System.out.println("the array list is empty");
      return s;
    }
    
    for (int i = 0; i < adjRooms.size(); i++) {
      s += adjRooms.get(i).ID + " ";
    }

    return s;
  }

  /**
   * Draws this Room to the window by drawing the background image, a rectangle, and some text.
   */
  public void draw() {
    processing.image(image,0,0);
    processing.fill(-7028);
    processing.rect(0, 500, 800, 600);
    processing.fill(0);
    processing.text(toString(),300, 525);
    
    }


}
