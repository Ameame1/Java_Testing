/**
 *
 */
package processors;

import java.io.PrintStream;
import java.util.List;

import core.Chunk;

/** A "do-nothing" sub-class of Processor, intended for use
 * in testing. Rather than executing code chunks, it simply
 * "splices" all code chunks back together, producing an
 * output document that should be (with the exception that
 * whitespace may have changed) identical to the input document.
 */
public class ReverseProcessor extends Processor {

  /** Construct a processor by supplying a destination
   * and a list of chunks.
   *
   * @param destination The destination to which output is written
   * @param chunks The input chunks
   */
  public ReverseProcessor(PrintStream destination, List<Chunk> chunks) {
    this.destination = destination;
    this.chunks = chunks;
  }

  @Override
  public void merge() {
    for (Chunk chunk : chunks) {

      String startMarker = chunk.getStartMarker();
      if (startMarker.length() != 0) {
        destination.println(startMarker);
      }
      destination.print( chunk.getContents() );
      String endMarker = chunk.getEndMarker();
      if (endMarker.length() != 0) {
        destination.println(endMarker);
      }
    }
  }

}
