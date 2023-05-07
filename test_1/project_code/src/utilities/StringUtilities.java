package utilities;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/** Utility methods operating on strings.
 */
public class StringUtilities {

  /** Return a BufferedReader, the content of which will be
   * the supplied String.
   *
   * @param s A string to use as contents
   * @return A BufferedReader object
   */
  public static BufferedReader stringToBufferedReader(String s) {
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(os);
    ps.print(s);
    byte[] buf = os.toByteArray();
    ByteArrayInputStream ins = new ByteArrayInputStream(buf);
    InputStreamReader r = new InputStreamReader(ins);
    BufferedReader reader = new BufferedReader(r);
    return reader;
  }

  /** Join an array of Strings into a single string
   * (using newline characters, '\n', as separator).
   *
   * @param arr An array of strings
   * @return The joined strings
   */
  public static String arrayLinesToString(String arr[]) {
    List<String> ss = Arrays.asList(arr);
    return ss.stream().map(s -> s + "\n").collect(Collectors.joining(""));
  }

}
