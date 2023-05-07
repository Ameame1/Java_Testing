package processors;

import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import core.Chunk;
import core.CodeChunk;

/** A sub-class of Processor which makes use of
 * the <code>CommandRunner</code> class to run the
 * commands found in code chunks.
 * Code chunks are executed, and the resulting output
 * is "spliced" together with the non-code (document)
 * chunks to produce an output document.
 */
public class ShellProcessor extends Processor {

  /** Construct a processor by supplying a destination
   * and a list of chunks.
   *
   * @param destination The destination to which output is written
   * @param chunks The input chunks
   */
  public ShellProcessor(PrintStream destination, List<Chunk> chunks) {
    this.destination = destination;
    this.chunks = chunks;
  }

  @Override
  public void merge() throws ExecutionException {
    for (Chunk chunk : chunks) {
      if (chunk instanceof CodeChunk) {
        try {
          List<String> results = CommandRunner.executeCommands(chunk.getContents());
          String resultString = String.join("\n", results) + "\n";
          destination.print(resultString);
        } catch (IOException | InterruptedException e) {
          throw new ExecutionException("couldn't execute commands in chunk", e);
        }
      } else {
        String startMarker = chunk.getStartMarker();
        if (startMarker.length() != 0) {
          destination.println(startMarker);
        }
        destination.print(chunk.getContents());
        String endMarker = chunk.getEndMarker();
        if (endMarker.length() != 0) {
          destination.println(endMarker);
        }
      }
    }
  }

}
