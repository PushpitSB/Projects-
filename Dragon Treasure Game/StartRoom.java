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

/**
 * 
 * StartRoom is the child class of Room and starts the room with an ID, description, and image.
 * 
 */

public class StartRoom extends Room {
  
  /*
   * the StartRoom method takes in 2 variables and sets the description as 
   * "You find yourself in the entrance to a cave holding treasure."
   * 
   * @param Id, the ID that uniquely identifies the room
   * @param image, the PImage that sets the background
   */
  public StartRoom(int Id, PImage image) {
    super(Id,"You find yourself in the entrance to a cave holding treasure.", image);
    
  }
  
}
