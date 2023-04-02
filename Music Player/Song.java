


public class Song {
  private String title; // The title of this song
  private String artist; // The artist of this song
  private int duration;/// The duration of this song in number of seconds
  private AudioUtility audioClip;// This song's AudioUtility interface to javax.sound.sampled

  /**
   * Initializes all instance data fields according to the provided values
   * 
   * @param title    - the title of the song, set to empty string if null
   * @param artist   - - the artist of this song, set to empty string if null
   * @param filepath - the full relative path to the song file, begins with the "audio" directory
   *                 for P08
   * @throws IllegalArgumentException - - if the song file cannot be read
   * @throws IOException
   */
  public Song(String title, String artist, String filepath)
      throws IllegalArgumentException {
    // check if null
    // if yes set to empty string
    if (title == null) {
      this.title = "";
    } // else set to normal
    else {
      this.title = title;
    }
    // if artist is null set it to empty
    if (artist == null)
      artist = "";
    else
      this.artist = artist;
    if (filepath == null || filepath.trim().equals("")) {
      throw new IllegalArgumentException("Filename cannot be null or empty");
    }


    try {
      audioClip = new AudioUtility(filepath);
    }
    catch(Exception e) {
      throw new IllegalArgumentException("Unable to load that song");
    }
    
    this.duration = audioClip.getClipLength();

  }

  /**
   * Tests whether this song is currently playing using the AudioUtility
   * 
   * @return -
   */
  public boolean isPlaying() {
    return audioClip.isRunning(); // uses audiutility method
  }

  /*
   * Uses the AudioUtility to start playback of this song, reopening the clip for playback if
   * necessary
   * 
   * 
   */
  public void play() {

    if (audioClip.isReadyToPlay()) { // if the clip is ready to play then start the clip

      audioClip.startClip();
      System.out.println("playing" + toString());
    }
    // else reopen the clip
    else {

      audioClip.reopenClip();

      audioClip.startClip(); // plays it again
    }
  }

  /**
   * Uses the AudioUtility to stop playback of this song
   * 
   */
  public void stop() {
    if (isPlaying()) {
      audioClip.stopClip();
    } // stops the clip
  }

  /**
   * Accessor method for the song's title
   * 
   * @return the title of this song
   * 
   */
  public String getTitle() {
    return title; // getter
  }

  /**
   * Accessor method for the song's artist
   * 
   * @return - the artist of this song
   * 
   */
  public String getArtist() {
    return artist;
  }

  /**
   * Creates and returns a string representation of this Song, for example: "Africa" (4:16) by Toto
   * The title should be in quotes, the duration should be split out into minutes and seconds
   * (recall it is stored as seconds only!), and the artist should be preceded by the word "by". It
   * is intended for this assignment to leave single-digit seconds represented as 0:6, for example,
   * but if you would like to represent them as 0:06, this is also allowed.
   * 
   * @Override - toString in class Object
   * @return - a formatted string representation of this Song
   */
  @Override
  public String toString() {
    String answer =
        "\"" + title + "\" (" + (duration / 60) + ":" + (duration % 60) + ") by " + artist; // format
    // according
    // to
    // specs
    return answer;
  }



}
