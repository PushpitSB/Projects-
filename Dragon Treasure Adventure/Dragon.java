//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Dragon
// Course:   CS 300 Fall 2022
//
// Author:   Pushpit Singh
// Email:    psingh76@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    (name of your pair programming partner)
// Partner Email:   (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         none
// Online Sources:  none
//
///////////////////////////////////////////////////////////////////////////////
import java.util.ArrayList;
import java.util.Random;

public class Dragon {
  private static Room currentRoom; // current location of the dragon
  private Random randGen; // random num generator used for moving
  private static final String DRAGON_WARNING = "You hear a fire breathing nearby!\n"; // warning
                                                                                      // dragon
                                                                                      // nearby
                                                                                      // message


  public Dragon(Room currentRoom) {
    this.currentRoom = currentRoom;
    randGen = new Random();
  }

  /**
   * accesor method for current room of dragpn
   * 
   * @return room
   * @author pushpitsingh
   */
  public static Room getCurrentRoom() {
    return currentRoom;
  }

  /**
   * Dragon picks one of the rooms at random and moves there if possible. If it is not a valid move,
   * then it will pick again. Dragons abide by the follow rules when moving: 1) The dragon can only
   * move into rooms that are adjacent to it. 2) The dragon CANNOT move into portal rooms.
   * 
   */
  public void changeRooms() {
    // Keep picking random target room until there is a valid one.
    while (true) {
      // Pick a random target room from the Adjacent Room list
      Room targetRoom = currentRoom.getAdjacentRooms()
          .get(randGen.nextInt(currentRoom.getAdjacentRooms().size()));
      // If valid, break out from the dead loop and mutate the currentRoom.
      if (targetRoom.getType() != RoomType.PORTAL) {
        this.currentRoom = targetRoom; // changes current room to the new room
        break;
      }
    }
  }

  /**
   * accesor method for warning that dragon is nearby
   * 
   * @return String, warning
   */

  public static String getDragonWarning() {

    return DRAGON_WARNING;


  }


}
