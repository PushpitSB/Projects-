//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Dragon Treasure Tester
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

/**
 * Tests all the methods instance and static and tries all the edge case scenarios to check for bugs
 * has a main method
 * @author pushpitsingh
 *
 */

public class DragonTreasureTester {


  /**
   * tests all the instance methods and checks for any bugs
   * @return true, if all the tests are passed
   *        false, if any of the tests fails 
   */
  public static boolean testRoomInstanceMethods() {
    try {
      Room testRoom = new Room(3, "dum"); // creates a room testRoom with
      // id 3 and description dum
      Room room2 = new Room(2, "lol"); // a random room to be added nearby
      Room room4 = new Room(4, "lol4"); // a random room to be added nearby

      testRoom.addToAdjacentRooms(room2); //adds room to adjacent list 
      testRoom.addToAdjacentRooms(testRoom);
      
      if (testRoom.getType() != RoomType.NORMAL) { // checks if the room type was declared correctly
                                                   // and checks the getType,getDescription and
                                                   // getId
                                                   // accesor method
        if (testRoom.getID() != 3 && (!testRoom.getRoomDescription().equals("dum"))) {


          System.out.println(
              "problem/constructor room the constructor did not work, default room type should be normal");
          return false;
        }
      }
      /*
       * tests addToAdjacent list method. isAdjacent and checks get adjacent rooms method
       */
      if (testRoom.isAdjacent(room4) || testRoom.isAdjacent(room2) != true) {
        System.out.println(
            "problem in addToAdjacent room, method does not add room properly to the array");
        return false;
      }
      // test for checking the if room type is set correctly
      testRoom.setRoomType(RoomType.START);
      if (testRoom.getType() != RoomType.START) {
        System.out.println("problem set rom type/ the set room type method didnt work");
        return false;
      }


      // Your tester scenarios and checking for expected behaviors and output come here

    } catch (Exception e) {
      // an unexpected exception was thrown
      e.printStackTrace(); // this will help locate the source of the bug
      return false;
    }

    return true; // no bug detected



  }
  /**
   * tests all the static methods
   * 
   * @return true if every test passes false otherwise
   */

  public static boolean testRoomStaticMethods() {
    // checks if assignTeleportLocation and getTeleportLocation works correctly

    Room testr = new Room(4, "tex");
    testr.assignTeleportLocation(3); 
    if (testr.getTeleportationRoom() != 3) { //checking
      System.out.println(
          "problem assignTeleportLocationROom , the method assugn teleport location did not assign properly"); //error message
      return false;
    }

    return true;

  }

  /**
   * tests testPlayerCanMoveTo
   * 
   * @return true, if player can move to that room false, if player cannot move to that room
   * @author pushpitsingh
   */
  public static boolean testPlayerCanMoveTo() {

    Room testRoom = new Room(3, "dum"); // creates a room testRoom with
    // id 3 and description dum
    Room room2 = new Room(2, "lol"); // a random room to be added nearby
    Room room4 = new Room(4, "lol4"); // a random room to be added nearby
    Player p1 = new Player(testRoom);
    room2.setRoomType(RoomType.PORTAL);
    testRoom.addToAdjacentRooms(room2);

    if (!p1.canMoveTo(room2)) { //checks a normal scenario
      System.out.println("the testplayerCanMoveTO method did not work properly"); // error message
      return false;
    }
    return true;

  }

  /**
   * tests testPlayerShouldTeleport
   * 
   * @return true, if player can teleport false, if player cannot
   * @author pushpitsingh
   */
  public static boolean testPlayerShouldTeleport() {
    Room testRoom = new Room(3, "dum"); // creates a room testRoom with
    // id 3 and description dum
    Room room2 = new Room(2, "lol"); // a random room to be added nearby
    Room room4 = new Room(4, "lol4"); // a random room to be added nearby
    Player p1 = new Player(room2);
    room2.setRoomType(RoomType.PORTAL);
    testRoom.addToAdjacentRooms(room2);
    if (!p1.shouldTeleport()) {
      System.out.println("problem/testPlayerShouldTeleport, method did not work"); // error message
      return false;
    }
    return true;

  }

  /**
   * tests playerShouldTeleport and PlayerCanMoveTO
   * 
   * @return true, if methods work correctly false, if method cannot cannot
   * @author pushpitsingh
   */
  public static boolean testPlayerDetectNearbyRooms() {
    if (testPlayerCanMoveTo() && testPlayerShouldTeleport()) {
      return true; // checks if both the methods works correctly
    }
    System.out.println("the methods dont work properly to detect nearby rooms");
    return false; // else returns false
  }

  public static boolean testDragonChangeRooms() {
    boolean sign = true;
    String errorMessage = "";

    // Generate a started room and 4 rooms connected to the start room.
    Room startRoom = new Room(0, "test start room");
    Room nRoom1 = new Room(1, "test normal room 1");
    Room nRoom2 = new Room(2, "test normal room 2");
    Room tRoom = new Room(3, "test treasure room");
    Room pRoom = new Room(4, "test portal room");

    // Set one of the room connected to start room as portal room to test changeRoom method.
    pRoom.setRoomType(RoomType.PORTAL);

    // Connect all room in order.
    startRoom.addToAdjacentRooms(nRoom1);
    startRoom.addToAdjacentRooms(nRoom2);
    startRoom.addToAdjacentRooms(tRoom);
    startRoom.addToAdjacentRooms(pRoom);
    nRoom1.addToAdjacentRooms(startRoom);
    nRoom2.addToAdjacentRooms(startRoom);
    tRoom.addToAdjacentRooms(startRoom);
    pRoom.addToAdjacentRooms(startRoom);

    Dragon testDragon = new Dragon(startRoom);

    // prevRoom variable used to store the previous room dragon was in.
    Room prevRoom;
    // Check the changeRoom method for 100 times to make sure random generating is working.
    for (int i = 0; i < 100; i++) {
      // Dragon should change room in every iteration
      // thus the prevRoom must be different from current room.
      prevRoom = testDragon.getCurrentRoom();
      testDragon.changeRooms();
      if (testDragon.getCurrentRoom() == prevRoom) {
        sign = false;
        errorMessage +=
            "Error - Dragon:" + "changeRoom method failed, did not generate and change to new room";
      }
      // Check if the dragon move to a portal room
      if (testDragon.getCurrentRoom().getType() == RoomType.PORTAL) {
        sign = false;
        errorMessage += "Error - Dragon:" + "changeRoom method moved dragon to a portal room,.\n";
      }
      if (!sign) {
        break;
      }
    }

    if (!sign) {
      System.out.println(errorMessage);
    }
    return sign;
  }



  public static void main(String[] args) {
    System.out.println("test instance method" + testRoomInstanceMethods());
    System.out.println("testRoomStaticMethods" + testRoomStaticMethods());
    System.out.println("testPlayerCanMoveTo()" + testPlayerCanMoveTo());
    System.out.println("testPlayerShouldTeleport()" + testPlayerShouldTeleport());
    System.out.println("testPlayerDetectNearbyRooms()" + testPlayerDetectNearbyRooms());
    System.out.println("testDragonChangeRooms()" + testDragonChangeRooms());

  }

}
