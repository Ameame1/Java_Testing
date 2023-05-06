/**
 *
 */
package processors;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import core.Chunk;

/** Interface for an abstract "Processor", capable of taking
 * a list of chunks, and "weaving" them into an output
 * document that is emitted to a "destination"
 * (a <code>PrintStream</code>).
 *
 */
public interface IProcessor {

  /** Get the destination stream.
   *
   * @param destination the destination
   */
  public OutputStream getDestination();

  /** Set the destination stream.
   *
   * @param destination the destination to set
   */
  public void setDestination(PrintStream destination);

  /** Return the list of chunks fed to the processor.
   *
   * @return the chunks
   */
  public List<Chunk> getChunks();

  /** Supply the processor with a list of chunks.
   *
   * @param chunks the chunks to set
   */
  public void setChunks(List<Chunk> chunks);

  /** Merge the supplied chunks (which may be
   * code chunks or non-code (document) chunks)
   * into an output document.
   *
   * Throws an ExecutionException if commands in the
   * code chunks are not able to be executed.
   *
   * @throws ExecutionException
   */
  public void merge() throws ExecutionException;

}
