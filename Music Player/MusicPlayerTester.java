
import java.io.File;
import java.io.IOException;
/**
 * tester class of the project 
 * has main method
 * @author pushpitsingh
 *
 */
public class MusicPlayerTester {
  /**
   * checks the correctness of constructor and the get() and toString(() 
   * @return true if all the tests pass, false otherwise
   */
  public static boolean testSongConstructor() {
    boolean f1 = false; // flags to determine result
    boolean f2 = false;

    boolean f3 = false;
    boolean f4 = false;

    // trying with null file
    try {
      Song song = new Song("Ne Up", "Rley", null);
      return false;
    } catch (Exception e) {
      if(e instanceof IllegalArgumentException) f3 = true;
      else return false;
    }

    // trying with empty file name
    try {
      Song song = new Song("NYou Up", "k sey", "");
      return false;
    } catch ( IllegalArgumentException e) { 
      f4 = true;
    }



    try {
      // trying with a file which does not exsists
      Song newS = new Song("hello", "arijit", "3.mid");
    } catch (Exception e) {
      if (e instanceof IllegalArgumentException)
        f1 = true;
      else {

        System.out.println("the constructor did not catch invalid file path");
        return false;

      }
    }


    // trying with a invalid file
    try {
      Song newS2 = new Song("hello", "arijit", "test_playlist.txt");
    } catch (Exception e) {
      if (e instanceof IllegalArgumentException)
        f2 = true;
      else {
        System.out.println("did not give exception with invalid file type");
        return false;

      }
    }


    Song song2 = null;
    //valid file 
    try {
      song2 = new Song("Dr", "drake", "audio" + File.separator + "darude-sandstorm.mid");
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println(song2.toString());
    return f1 && f2 && f3&&f4;

  }
  /**
   * tests song playback, including stop clear
   * @return true if all methods work correctly
   */
  public static boolean testSongPlayback() {

    Song s1 = null;

    // initializing the song variable
    try {
      s1 = new Song("3.mid", "dr",
          "audio" + File.separator + "3.mid");
    } catch (IllegalArgumentException e1) {
      // TODO Auto-generated catch block
      return false;
    }

    // play
    if (s1.isPlaying() == true) {
      System.out.println("problem in isPlaying()");
      return false;
    }
    // playing the song
    s1.play();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    // testing if it startedplaying
    if (s1.isPlaying() == false) {
      System.out.println("problem in play()");
      return false;
    }

    // testing forstopping
    s1.stop();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      return false;
    }
    if (s1.isPlaying()) {
      System.out.println("problem in stop()");
      return false;
    }


    // isPlaying stop

    return true;

  }
  /**
   * tests the class songNode and its methods 
   * @return true if all tests passed false otherwise
   */
  public static boolean testSongNode() {
    Song song1 = new Song("Never Gonna Give You Up", "Rick Astley",
        "audio" + File.separator + "exactly-what-you-think.mid");
    try {
      SongNode s1 = new SongNode(null);
    } catch (Exception e) {
      if (!(e instanceof IllegalArgumentException)) {
        System.out.println("constructor of SongNode did not give an error with  null data");
        return false;
      }


    }

    // constructing a new element
    SongNode s2 = null, s3 = null;
    Song ss1 = null;
    SongNode s4;
    try {
      ss1 = new Song("r", "ssd", "audio" + File.separator + "2.mid");
      s2 = new SongNode(ss1);
      s4 = new SongNode( new Song("r", "ssd", "audio" + File.separator + "2.mid"),s2);
      s3 = new SongNode(new Song("r", "ssd", "audio" + File.separator + "1.mid"),s2);
      if(!s4.getNext().equals(s2)) return false;
    } catch (IllegalArgumentException e) {
      // TODO Auto-generated catch block
      return false;
    }
    // test scenario 2 for SongNode data-only Constructor.
    SongNode node1 = new SongNode(song1);
    boolean test2 = node1.getSong() != null && node1.getSong() == song1;

    // test scenario 3 for SongNode data and next Constructor. Data is null
    boolean test3 = false;
    try {
        SongNode songNode = new SongNode(null);
        return false;
    } catch (IllegalArgumentException e) {
        test3 = true;
    }

    // setNext()
    s2.setNext(s3);
    // getSong()
    if (!s2.getSong().equals(ss1)) {
      System.out.println("the contructor did notwork properly SongNode");
      return false;
    }
    // getNext()
    if (!s2.getNext().equals(s3)) {
      System.out.println("setNext() did not work as expected SongNode() class");
      return false;
    }
    return true;
  }
  /**
   * tests the methods of playlist class and the enque method
   * @return true if all tests pass false otherwise
   * 
   */
  public static boolean testEnque() {

    // toString()
    // isEmpty

    Playlist p1 = new Playlist();
    if (!p1.isEmpty()) {
      System.out.println("the is empty method does not work properly"); // if isEmpty returns false
      return false;
    }
    Song ss1, s2, s3;
    try {
      ss1 = new Song("r", "ssd", "audio" + File.separator + "2.mid");
      s2 = new Song("r12", "ss2d", "audio" + File.separator + "1.mid");
      s3 = new Song("r", "ssd", "audio" + File.separator + "3.mid");
    } catch (IllegalArgumentException e) {
      // TODO Auto-generated catch block
      return false;
    }

    // add to the playlist
    // and check if added correctly, check size too
    p1.enqueue(ss1);
    if (!p1.peek().equals(ss1) || p1.isEmpty() || p1.size() != 1) {
      System.out.println("the enque method did not work properly when added to an empty list"); // print
                                                                                                // error
      return false;
    }

    // check if peek works properly even afer addding new element

    p1.enqueue(s2);
    if (!p1.peek().equals(ss1) || p1.isEmpty() || p1.size() != 2) {
      System.out.println("the enque method did not work properly when added to a non-empty list"); // print
                                                                                                   // error
      return false;
    }


    // test toString()

    System.out.println(p1.toString());

    return true; // of everything passes
  }
  /**
   * tests the dequeue method with various edge case scenarios 
   * @return true if all tests pass false otherwise
   */
  public static boolean testDequeue() {
    Playlist p1 = new Playlist();
    boolean test4 = false;
    boolean test5 = false;
    Song ss1, s2, s3;
    try {
      ss1 = new Song("r", "ssd", "audio" + File.separator + "2.mid");
      s2 = new Song("r12", "ss2d", "audio" + File.separator + "1.mid");
      s3 = new Song("r", "ssd", "audio" + File.separator + "3.mid");
    } catch (IllegalArgumentException e) {
      // TODO Auto-generated catch block
      return false;
    }
    
    //testing the playlist constructorr
   boolean f1 = p1.isEmpty()&& p1.size() == 0;
   if(!f1) {
     System.out.println("error in constructor");
   }
   boolean test2 = p1.dequeue() == null && p1.peek() == null;
   if(!test2) System.out.println("problem in dequeue when implemented on empty playlist");
   p1.enqueue(ss1);
   //
   // and check if added correctly, check size too
   p1.enqueue(s2);
   Song song = p1.dequeue();
   boolean test3 = p1.size() == 1 && !p1.isEmpty() && p1.peek() != null && p1.peek().getTitle().equals("r12")
           && song.getTitle().equals("r");
   song = p1.dequeue();
 
   try {
    test4 = p1.size() == 0 && p1.isEmpty() && song != null && song.getTitle().equals("r12")&&p1.peek()==null;

   // test scenario 4 for dequeue()
    test5 = p1.dequeue() == null && p1.peek() == null;}
   catch(Exception e) {
     return false;
   }


    
    

    return f1&&test2&&test3&&test4&&test5;
  }
  /**
   * the main method
   * @param args
   */
  public static void main(String[] args) {
    System.out.println("contructor tested " + testSongConstructor());
    System.out.println("testSongPlayback tested " + testSongPlayback());
    System.out.println("TestSongNode() " + testSongNode());
    System.out.println("testEnque() " + testEnque());
    System.out.println(testDequeue());
  }
}
