package utilities;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/** Holds a public PrintStream which can be written to
 * in-memory;
 * once finished, the written content can be retrieved
 * with getContents.
 */
public class MemIO {
  private ByteArrayOutputStream os;
  public  PrintStream out;

  /** Construct a new MemIO object
   */
  public MemIO() {
    this.os = new ByteArrayOutputStream();
    this.out = new PrintStream(this.os);
  }

  /** Return the written content as a string.
   *
   * @return The written content
   */
  public String getContents() {
    return new String( this.os.toByteArray() );
  }

}
