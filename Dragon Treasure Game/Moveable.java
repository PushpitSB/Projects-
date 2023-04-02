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
// Partner Name:        Soumya Kataria
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

/**
 * Interface for things that can move between rooms in the DragonTreasureGame.
 * @author Michelle
 *
 */
public interface Moveable {
	/**
	 * Changes the room where the object is.
	 * @param destination, the Room to change it to
	 * @return true if the change is successful (a valid move), and false otherwise
	 */
	public boolean changeRoom(Room destination);
	
	/**
	 * Gets the list of rooms adjacent to this movable object.
	 * @return an ArrayList of rooms adjacent to the object
	 */
	public ArrayList<Room> getAdjacentRooms();
	
	/**
	 * Checks whether or not this object can move to that room.
	 * @param destination, the Room to check if it can move to
	 * @return true if it can move there (a valid move), and false otherwise
	 */
	public boolean canMoveTo(Room destination);
}
