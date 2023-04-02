//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:  P08 MusicPlayer300
// Course: CS 300 Fall 2022
//
// Author: pushpit Singh
// Email: psingh76@wisc.edu
// Lecturer: Hobbes LeGault,
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Aarav Anand 
// Partner Email:   aanand43@wisc.edu
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         (identify each by name and describe how they helped)
// Online Sources:  (identify each by URL and describe how it helped)
//
///////////////////////////////////////////////////////////////////////////////
/**
 * 
 * @author pushpitsingh
 *
 */
/**
 * A FIFO linked queue of SongNodes, conforming to our QueueADT interface.
 */
public class Playlist implements QueueADT<Song> {
  private SongNode first; // The current first song in the queue; the next one up to play (front of
                          // the queue)

  private SongNode last; // The current last song in the queue; the most-recently added one (back of
                         // the queue)

  private int numSongs; // The number of songs currently in the queue



  /**
   * Constructs a new, empty playlist queue
   */
  public Playlist() {
    first = null;
    last = null;
    numSongs = 0;
  }

  /**
   * Adds a new song to the end of the queue
   * 
   * @specifiedBy - enqueue in interface QueueADT<Song>
   * 
   * @param element - - the song to add to the Playlist
   */
  @Override
  public void enqueue(Song element) {
    SongNode elm = new SongNode(element);
    // check if the list is empty
    if (isEmpty()) {
      // iif thelist is empty then the head and tail are same

      first = elm;
      last = elm;
      numSongs++;
    } else {
      // if the list is not empty
      last.setNext(elm);
      last = elm;// adding tot he end
      numSongs++;
    }


  }

  /**
   * Removes the song from the beginning of the queue specified by - dequeue in interface
   * QueueADT<Song>
   * 
   * @return - the song that was removed from the queue, or null if the queue is empty
   * 
   */
  @Override
  public Song dequeue() {
    // TODO Auto-generated method stub
    if (isEmpty()) {
        return null;
    }
    
    Song song = first.getSong();
    first = first.getNext();
    
    // if front is empty, make rear empty as well
    if(first == null) {
        last = null;
    }
    
    numSongs--;
    if (song.isPlaying()) {
        song.stop();
    }
    return song;
}

  /**
   * Returns the song at the front of the queue without removing it SPECIFIED BY peek in interface
   * QueueADT<Song>
   * 
   * @return- the song that is at the front of the queue, or null if the queue is empty
   * 
   */
  @Override
  public Song peek() {
    if (isEmpty()) {
      return null;
    } else {
      return first.getSong();
    }
  }

  /**
   * Returns the number of songs in this queue Specified by: size in interface QueueADT<Song>
   * 
   * @return - the number of songs in this queue
   */
  @Override
  public int size() {
    return numSongs; // getter for numSongs
  }

  /**
   * Creates and returns a formatted string representation of this playlist, with the string version
   * of each song in the list on a separate line. For example: "He's A Pirate" (1:21) by Klaus
   * Badelt "Africa" (4:16) by Toto "Waterloo" (2:45) by ABBA "All I Want For Christmas Is You"
   * (4:10) by Mariah Carey "Sandstorm" (5:41) by Darude "Never Gonna Give You Up" (3:40) by Rick
   * Astley Specified by: toString in interface QueueADT<Song> Overrides: toString in class Object
   * @return - the string representation of this playlist
   */
  
  @Override
  public String toString() {
      if (isEmpty()) {
          return "";
      }
      String Str = "";

      SongNode temp = first;
      while (temp != null) {
          Str += temp.getSong().toString() + "\n";
          temp = temp.getNext();
      }
      return Str;
  }

  /**
   * Returns true if and only if there are no songs in this queue SPECIFIED BY isEmpty in interface
   * QueueADT<Song>
   * 
   * @return - true if this queue is empty, false otherwise
   * 
   */
  @Override
  public boolean isEmpty() {
    return (numSongs == 0 && first == null && last == null); // all checks for an empty list
  }

}
