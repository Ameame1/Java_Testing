/**
 *
 */
package parsers;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import core.Chunk;
import core.CodeChunk;
import core.DocChunk;

/** Parses an input document into "chunks". A Parser object can be constructed
 * by supplying it with input content in the form of a <code>BufferedReader</code>
 * object; then, the <code>parse</code> method will parse the input content
 * into chunks; once <code>parse</code> has been called, the
 * chunks can be obtained by calling <code>getChunks</code>.
 */
public class Parser {

  protected final List<String> sourceLines;
  protected final ArrayList<Chunk> chunks;
  protected final String codeStartMarker = "=<<<";
  protected final String codeEndMarker = ">>>";

  // return a list of lines from a BufferedReader source
  private static List<String> readLines(BufferedReader source) {
    return source.lines().collect(Collectors.toList());
  }

  /** Construct a new Parser object. The input (source
   * document) should be provided as a <code>BufferedReader</code>.
   *
   * @param Source document.
   */
  public Parser(BufferedReader source) {
    this.sourceLines = readLines(source);
    this.chunks = new ArrayList<Chunk>();
  }

  /** Once a document has been parsed, will return
   * the constituent chunks that make up the document.
   *
   * @return A list of chunks.
   */
  public List<Chunk> getChunks() {
    return chunks;
  }

  /** Parse the input (provided as a <code>BufferedReader</code>
   * object when the Parser is constructed) into a
   * list of chunks.
   */
  public void parse( ) {

    StringBuffer currentChunk = new StringBuffer();
    boolean inCodeChunk = false;

    for(int lineNum = 1; lineNum <= sourceLines.size(); lineNum++) {
      String currentLine = sourceLines.get(lineNum-1);

      if (inCodeChunk) {
              if (currentLine.equals(  CodeChunk.END_MARKER )) {
                // finish code chunk
                inCodeChunk = false;
                  CodeChunk c = new CodeChunk(currentChunk.toString(), lineNum);
                  currentChunk = new StringBuffer();
                  this.chunks.add(c);
              } else {
                // add to code chunk
                currentChunk.append(currentLine + "\n");
              }
      } else {
              if (currentLine.equals(CodeChunk.START_MARKER)  ) {
                // finish doc chunk
                inCodeChunk = true;
                  DocChunk d = new DocChunk(currentChunk.toString(), lineNum);
                  currentChunk = new StringBuffer();
                  this.chunks.add(d);
              } else if (lineNum == sourceLines.size()) {
                // finish end-of-file doc chunk
                currentChunk.append(currentLine + "\n");
                  DocChunk d = new DocChunk(currentChunk.toString(), lineNum);
                  currentChunk = new StringBuffer();
                  this.chunks.add(d);
              } else {
                // add line to code chunk
                currentChunk.append(currentLine + "\n");
              }
      }
    } // end for
  }

}



