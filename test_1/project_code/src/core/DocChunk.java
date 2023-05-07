/**
 *
 */
package core;

/** A chunk containing normal document content.
 *
 */
public class DocChunk extends Chunk {

  /** Construct a chunk by supplying the contents,
   * and the line it starts on.
   *
   * @param contents The contents of the chunk
   * @param startLineNumber The line number the chunk starts on
   */
  public DocChunk(String contents, int startLineNumber) {
    super(contents, startLineNumber);
  }

  @Override
  public String getStartMarker() {
    return "";
  }

  @Override
  public String getEndMarker() {
    return "";
  }

}
