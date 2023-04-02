
public class SongNode {
  private Song song; // The Song object in this node
  private SongNode next;// The next SongNode in this queue

  /**
   * Constructs a single SongNode containing the given data, not linked to any other SongNodes
   * 
   * @param data - the Song for this node
   * @throws IllegalArgumentException - if data is null
   */
  public SongNode(Song data) throws IllegalArgumentException {
    // check if data isnull
    if (data == null) {
      throw new IllegalArgumentException("the data cannot be null");
    } else {
      this.song = data;
      next = null;
    }
  }



  /**
   * Constructs a single SongNode containing the given data, linked to the specified SongNode
   * 
   * @param data- - the Song for this node
   * @param next- the next node in the queue
   * @throws IllegalArgumentException - if data is null
   */
  public SongNode(Song data, SongNode next) throws IllegalArgumentException {
    if (data == null) { // check if null
      throw new IllegalArgumentException("the data cannot be null");
    } else {
      this.next = next;
      this.song = data;
    }

  }

  /**
   * Accessor method for this node's data
   * 
   * @return - the Song in this node
   * 
   */
  public Song getSong() {
    return song; // getter for song
  }

  /**
   * Accessor method for the next node in the queue
   * 
   * @return -the SongNode following this one, if any
   * 
   */
  public SongNode getNext() {
    return next;
  }

  /**
   * Changes the value of this SongNode's next data field to the given value
   * 
   * @param next - the SongNode to follow this one; may be null
   */
  public void setNext(SongNode next) {
    this.next = next; //setter 
  }


}
