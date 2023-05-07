package processors;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import core.Chunk;

/** An abstract class implementing some behaviour for the
 * <code>IProcessor</code> interface.
 *
 * Implementations are provided for all methods of
 * <code>IProcessor</code> except for <code>merge</code>.
 *
 */
public abstract class Processor implements IProcessor {

  protected PrintStream destination;
  protected List<Chunk> chunks;


  /**
   * @return the destination
   */
  @Override
  public PrintStream getDestination() {
    return destination;
  }
  /**
   * @param destination the destination to set
   */
  @Override
  public void setDestination(PrintStream destination) {
    this.destination = destination;
  }

  /**
   * @return the chunks
   */
  @Override
  public List<Chunk> getChunks() {
    return chunks;
  }

  @Override
  public void setChunks(List<Chunk> chunks) {
    this.chunks = new ArrayList<Chunk>(chunks); //chunks;
  }

  @Override
  public abstract void merge() throws ExecutionException;



}
