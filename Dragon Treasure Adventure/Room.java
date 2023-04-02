//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Room
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

public class Room {
  private RoomType type; // one of the four types a room could be
  private String roomDescription; // a brief description of the room
  private ArrayList<Room> adjRooms; // arraylist that holds the rooms adjacent
  private final int ID; // unique ID for each room to identify it
  private static int teleportLocationID; // place where all portal rooms will go to
  private static final String PORTAL_WARNING = "You feel a distortion in space nearby.\n";
  private static final String TREASURE_WARNING = "You sense that there is treasure nearby.\n";


  /**
   * Constructor of the class Room
   * @param id, specific integer id of the room
   *        roomDescription, Brief Description 
   * @return nothing
   * @author Pushpit
   */
  public Room(int id, String roomDescription) {
    this.ID = id; //id of the room
    this.roomDescription = roomDescription; //description
    this.type = RoomType.NORMAL;
    this.adjRooms = new ArrayList<Room>();//type of room default value normal
  }
  /**
   * accesor method for private field ID
   * @return ID
   * @author Pushpit
   * */
  public int getID() {
    return ID;
  }
  /**
   * accesor method for private field descripton
   * @return String
   * @author Pushpit
   * */
  public String getRoomDescription() {
    return roomDescription;
  }
  /**
   * accesor method for private field adjacent rooms
   * @return ArrayList
   * @author Pushpit
   * */
  
  public ArrayList<Room> getAdjacentRooms(){
    return adjRooms;
    
  }
  
  /**
   * accesor method for private field type
   * @return type, the room type
   * @author Pushpit
   * */
  public RoomType getType() {
    return type; 
  }
  /**
   * add room to adjacent room list
   * @param Room, room to be added
   * @return none
   * @author Pushpit
   * */
  public void addToAdjacentRooms(Room toAdd) {
    adjRooms.add(toAdd);
  }
  /**
   * mutator method to change the room type
   * @param Roomtype, 
   * @return none
   * @author Pushpit
   * */
  public void setRoomType(RoomType newType) {
    this.type = newType;
  }
  //return teleportation Room id
  public static int getTeleportationRoom() {
    return teleportLocationID;
  }
  /*
   *Checks whether this given room is adjacent to this
   * @param  r room to be checked  */ 
  public boolean isAdjacent(Room r) {
    for(int i = 0; i < adjRooms.size();i++) {
      if(adjRooms.get(i)!= null && adjRooms.get(i) == r) {
        return true; //checks the array list for the specific room
      }
    }
    return false;
  }
  public static void assignTeleportLocation(int teleportID) {
    teleportLocationID = teleportID;
  }
  /**
   * 
   * Returns the string that is the room class's portal warning, 
   * @return String 
   * @author pushpit
*/
  public static String getPortalWarning() {
    return PORTAL_WARNING;
  }
  /**
   * 
   * Returns the string that is the room class's treasure warning, 
   * @author pushpit
*/
  public static String getTreasureWarning() {
    return TREASURE_WARNING;
  }
 
  
  

  /**
   * Determines if the given object is equal to this room. They are equal if other is a Room and
   * their IDs are the same.
   * 
   * @param other, another object to check if it is equal to this
   * @return true if the two rooms are equal, false otherwise
   * @author Michelle
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
   * Returns a String representation of this room.
   * 
   * @return the string representation of this room and its object data field values
   * @author Michelle
   */
  @Override
  public String toString() {
    String s = this.ID + ": " + this.roomDescription + " (" + type + ")\n Adjacent Rooms: ";
    for (int i = 0; i < adjRooms.size(); i++) {
      s += adjRooms.get(i).ID + " ";
    }
    return s;
  }



}
