
//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    (descriptive title of the program making use of this file)
// Course:   CS 300 Fall 2022
//
// Author:   Pushpit Singh
// Email:    psingh76@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Soumya Kataria
// Partner Email:   skataria2@wisc.edu
// Partner Lecturer's Name: Mouna Kacem
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   X Write-up states that pair programming is allowed for this assignment.
//   X We have both read and understand the course Pair Programming Policy.
//   X We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         None
// Online Sources:  None
//
///////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;

/**
 * The class PathUtils counts the paths and find all paths.
 */
public class PathUtils {

  /**
   * Finds the number of valid Paths between the given start and end Intersections. If it is not
   * possible to get from the start to the end intersection by moving up or right, then 0 should be
   * returned. For example, if start is Intersection(0, 0) and end is Intersection(2, 1), this
   * method should return 3. If start is Intersection(1, 0) and end is Intersection(0, 0), this
   * method should return 0.
   * 
   * @param start - Intersection to start at
   * @param end   - Intersection to end at
   * @return - the number of valid Paths which start and end at the given Intersections
   */
  public static int countPaths(Intersection start, Intersection end) {
    int count = 0;

    if (start.equals(end)) {
      count++;
      return count;

    }
    if (start.getX() < end.getX()) {
      count = count + countPaths(start.goEast(), end);
    }
    if (start.getY() < end.getY()) {
      count = count + countPaths(start.goNorth(), end);
    }

    return count;
  }

  /**
   * Finds all valid Paths between the given start and end Intersections. If it is not possible to 
   * get from the start to the end intersection by moving up or right, then an empty ArrayList 
   * should be returned.
   * 
   * @return an ArrayList containing all valid Paths which start and end at the given Intersections
   */
  public static ArrayList<Path> findAllPaths(Intersection start, Intersection end) {
    ArrayList<Path> paths = new ArrayList<Path>();
    
      if (start.equals(end)) {
        Path path = new Path();
        path.addTail(start);
        paths.add(path);
        return paths;
      }
      
      if(start.getX()>end.getX() || start.getY()>end.getY()) {
        return paths;
      }
      
      if(start.getX()<end.getX()) {
        ArrayList<Path> east = new ArrayList<Path>();
        east = findAllPaths(start.goEast(),end);
        
        for(int i = 0; i <east.size(); i++ ) {
          east.get(i).addHead(start);
          paths.add(east.get(i));
        }
      }
      
      if(start.getY()<end.getY()) {
        ArrayList<Path> North = new ArrayList<Path>();
        North = findAllPaths(start.goNorth(),end);
        
        for(int i = 0; i <North.size(); i++ ) {
          North.get(i).addHead(start);
          paths.add(North.get(i));
        }
      }
    return paths;
    }

}