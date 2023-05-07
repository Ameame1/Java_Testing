/**
 *
 */
package core;

/** A chunk containing code to be run.
 */
public class CodeChunk extends Chunk {

  public static final String START_MARKER = "=<<<";
  public static final String END_MARKER = ">>>";

  public CodeChunk(String contents, int startLineNumber) {
    super(contents, startLineNumber);
  }

  @Override
    public String getStartMarker() {
      return START_MARKER;
    }

  @Override
    public String getEndMarker() {
      return END_MARKER;
    }

}
