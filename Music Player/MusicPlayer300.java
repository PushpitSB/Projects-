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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MusicPlayer300 {
  private Playlist playlist; // The current playlist of Songs

  private boolean filterPlay; // Whether the current playback mode should be filtered by artist;
                              // false by default
  private String filterArtist; // The artist to play if filterPlay is true; should be null otherwise

  /**
   * Creates a new MusicPlayer300 with an empty playlist
   * 
   */
  public MusicPlayer300() {
    playlist = new Playlist();
    filterPlay = false;// default value
    filterArtist = null;
  }

  /**
   * Stops any song that is playing and clears out the playlist
   * 
   */
  public void clear() {
    if (playlist.isEmpty()) {
      return;
    }
    playlist.peek().stop();
    while (!playlist.isEmpty()) {
      playlist.dequeue();
    }

  }

  /**
   * Loads a single song to the end of the playlist given the title, artist, and filepath. Filepaths
   * for P08 must refer to files in the audio directory.
   * 
   * @param title - the title of the song
   * @param -     artist - the artist of this song
   * @throws IllegalArgumentException - if the song file cannot be read
   * 
   */
  public void loadOneSong(String title, String artist, String filepath) {

    try {
      playlist.enqueue(new Song(title, artist, filepath));
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    // loading one song to the end of playlist
  }

  /**
   * Loads a playlist from a provided file, skipping any individual songs which cannot be loaded.
   * Note that filenames in the provided files do NOT include the audio directory, and will need
   * that added before they are loaded. Print "Loading" and the song's title in quotes before you
   * begin loading a song, and an "X" if the load was unsuccessful for any reason.
   * 
   * @param file - the File object to load
   * @throws FileNotFoundException - if the playlist file cannot be loaded
   */
  public void loadPlaylist(File file) throws FileNotFoundException {
    if (file == null || file.getPath().trim().equals("")) {
      throw new FileNotFoundException("the file is null or the file path is not valid"); // throw an
                                                                                         // error if
                                                                                         // the file
                                                                                         // is not
                                                                                         // valid
    }
    Scanner s = null;
    // read the files using a file scanner
    try {

      s = new Scanner(file);
      while (s.hasNext()) { // checking if it reaches the end of the code
        String l = s.nextLine();
        // checking if the line is empty
        // if yes then move to next line
        if (l == null || l.trim().equals("")) {
          continue;
        }

        // split the line according to commas
        String[] song = l.split(",");
        // if its not correctly formatted then move to the next line
        if (song.length != 3) {
          continue;
        }

        // add path
        song[2] = "audio" + File.separator + song[2];
        System.out.println("Loading \"" + song[0] + "\""); // print when the song is loading
        loadOneSong(song[0], song[1], song[2]);

      }
    } catch (FileNotFoundException e) {
      System.out.println("X");
      throw new FileNotFoundException("Playlist file cannot be loaded");
    } finally {
      if (s != null) {
        s.close();
      }
    }


  }

  /**
   * Stops playback of the current song (if one is playing) and advances to the next song in the
   * playlist.
   * 
   * @throws IllegalStateException - if the playlist is null or empty, or becomes empty at any time
   *                               during this method
   */
  public void playNextSong() throws IllegalStateException {
    if (playlist.isEmpty()) {
        throw new IllegalStateException("Playlist is null or empty");
    }

    // CHECK IF SONG IS PLAYING
    playlist.peek().stop(); // stop playing current song

    playlist.dequeue(); // dequeue current song
    
    if (filterPlay) {
        // dequeue until the song from the given artist is matched or until the
        // playlist is empty
        while (!playlist.isEmpty()
                && !(playlist.peek().getArtist().toLowerCase().equals(filterArtist.toLowerCase()))) {
            playlist.dequeue();
        }
    }
    
    if (playlist.isEmpty()) {
        throw new IllegalStateException("Playlist is null or empty");
    }
    playlist.peek().play();
}

  /**
   * Creates and returns the menu of options for the interactive console program.
   * 
   * @return the formatted menu String
   */
  public String getMenu() {
    String menu = "Enter one of the following options:\n"
        + "[A <filename>] to enqueue a new song file to the end of this playlist\n"
        + "[F <filename>] to load a new playlist from the given file\n"
        + "[L] to list all songs in the current playlist\n"
        + "[P] to start playing ALL songs in the playlist from the beginning\n"
        + "[P -t <Title>] to play all songs in the playlist starting from <Title>\n"
        + "[P -a <Artist>] to start playing only the songs in the playlist by Artist\n"
        + "[N] to play the next song\n" + "[Q] to stop playing music and quit the program";
    return menu;
  }

  /**
   * Provides a string representation of all songs in the current playlist
   * 
   * @return a string representation of all songs in the current playlist
   */
  public String printPlaylist() {
    return playlist.toString();
  }

  /**
   * Interactive method to display the MusicPlayer300 menu and get keyboard input from the user. See
   * writeup for details.
   * 
   * @param in - Scanner object to input
   */
  /**
   * Interactive method to display the MusicPlayer300 menu and get keyboard input from the user. See
   * writeup for further details.
   * 
   * @param in - Scanner object to input data
   */
  public void runMusicPlayer300(Scanner in) {
    if (in == null) {
      return;
    }
    final String MESSAGE_EMPTY_PLAYLIST = "\"No songs left :(\"";
    String uInput = "";
    while (!uInput.equals("Q")) {
      System.out.println(getMenu());
      System.out.print(">");
      uInput = in.nextLine().trim();
      if (uInput == null || uInput.trim().equals("")) {
        continue;
      }
      switch (uInput.charAt(0)) {
        case 'A':
          String audioFile = null;
          if (uInput.length() > 2) {
            audioFile = uInput.substring(2);
          }
          System.out.print("Title:");
          String title = in.nextLine();
          System.out.print("Artist:");
          String artist = in.nextLine();

          try {

            loadOneSong(title, artist, audioFile);
          } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
          }
          break;
        case 'F':
          String filename = null;
          if (uInput.length() > 2) {
            filename = uInput.substring(2);
            try {
              loadPlaylist(new File(filename));
            } catch (FileNotFoundException e) {
              // TODO Auto-generated catch block
              System.out.println(e.getMessage());
            }
          } else {
            System.out.println("Filename cannot be null or empty");
          }
          break;
        case 'L':
          System.out.println(printPlaylist());
          break;
        case 'P':
          if (uInput.contains(" -t ")) {
            // if - t part of command, play all songs in the playlist starting from <Title>
            String titleFilter = uInput.substring(1).replace(" -t ", "").trim();

            // if (playlist.peek().isPlaying())
            playlist.peek().stop(); // stop the song

            // Make a new playlist consisting of only songs starting from <Title>
            Playlist p = new Playlist();

            // remove all other songs that are not starting from <Title>
            while (!playlist.isEmpty()) {
              if (playlist.peek().getTitle().toLowerCase().startsWith(titleFilter.toLowerCase())) {
                p.enqueue(playlist.peek());
              }
              playlist.dequeue();
            }

            // update music player playlist with songs starting from <Title>
            playlist = p;

            p = null; // decrease garbage collector counter for playlist p

            // remove artist filter
            filterArtist = null;
            filterPlay = false;
          } else if (uInput.contains(" -a ")) {
            filterArtist = uInput.substring(1).replace(" -a ", "").trim();
            filterPlay = true;

            // if (playlist.peek().isPlaying())
            playlist.peek().stop(); // stop the song
            while (!playlist.isEmpty() && !(playlist.peek().getArtist().toLowerCase()
                .equals(filterArtist.toLowerCase()))) {
              playlist.dequeue();
            }

          }

          if (playlist.isEmpty()) {
            System.out.println(MESSAGE_EMPTY_PLAYLIST);
          } else {
            System.out.println(playlist.peek());
            playlist.peek().play();
          }
          break;
        case 'N':
          // Check if playlist is empty
          if (playlist.isEmpty()) {
            System.out.println(MESSAGE_EMPTY_PLAYLIST); // inform user playlist is empty and break
                                                    // switch
            break;
          }

          // if (playlist.peek().isPlaying())
          playlist.peek().stop(); // stop the song

          // play the song if playlist is not empty
          if (!playlist.isEmpty()) {
            try {
              playNextSong();
            } catch (IllegalStateException e) {
              System.out.println(MESSAGE_EMPTY_PLAYLIST);
            }
          } else {
            System.out.println(MESSAGE_EMPTY_PLAYLIST);
          }
          break;
        case 'Q':
          clear();
          System.out.println("Goodbye!");
          break;
        default:
          System.out.println("I don't know how to do that.");
      }

      if (playlist.isEmpty()) {
        filterArtist = null;
        filterPlay = false;
      }
    }
  }

}
