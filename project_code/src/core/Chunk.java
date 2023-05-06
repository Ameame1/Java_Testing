/**
 *
 */
package core;

import java.util.Objects;

/** A document "chunk". Chunks start on a particular line number
 * (numbering from 1), and contain specified contents.
 */
public class Chunk {
  private final String contents;
  private final int startLineNumber;

  /** Return the chunk contents.
   *
   * @return The chunk contents.
   */
  public String getContents() {
    return contents;
  }

  /** Return the line number the chunk starts on.
   *
   * @return The starting line number.
   */
  public int getStartLineNumber() {
    return startLineNumber;
  }

  /**
   * @param contents
   * @param startLineNumber
   */
  public Chunk(String contents, int startLineNumber) {
    this.contents = contents;
    this.startLineNumber = startLineNumber;
  }


  /** Return a String representation of the chunk
   * for debugging purposes.
   */
   @Override
  public String toString() {
    return "Chunk [contents='" + contents + "', startLineNumber=" + startLineNumber + "]";
  }

  /** Return the String that represents the "start marker"
   * for the chunk.
   *
   * @return The start marker string
   */
  public String getStartMarker() {
    throw new RuntimeException("not implemented");
  }

  /** Return the String that represents the "end marker"
   * for the chunk.
   *
   * @return The end marker string
   */
  public String getEndMarker() {
    throw new RuntimeException("not implemented");
  }

  @Override
  public int hashCode() {
    return Objects.hash(contents, startLineNumber);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!(obj instanceof Chunk))
      return false;
    Chunk other = (Chunk) obj;
    return Objects.equals(this.contents, other.contents) &&
        this.startLineNumber == other.startLineNumber;
  }

}
