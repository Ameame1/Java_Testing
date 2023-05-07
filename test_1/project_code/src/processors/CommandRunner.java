package processors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/** Run commands via the shell.
 */
public class CommandRunner {

  /* Consume all of stream, so call to Runtime.exec
   * will complete.
   */
  static class StreamConsumer implements Runnable {
    private InputStream inputStream;
    private Consumer<String> consumer;

    /** Construct a StreamConsumer object with its
     * input stream set to <code>inputStream</code>,
     * and the stream consumer set to <code>consumer</code>.
     *
     * @param inputStream The input stream
     * @param consumer The stream consumer
     */
    public StreamConsumer(InputStream inputStream, Consumer<String> consumer) {
        this.inputStream = inputStream;
        this.consumer = consumer;
    }

    @Override
    public void run() {
        new BufferedReader(new InputStreamReader(inputStream)).lines()
          .forEach(consumer);
    }
  }

  /** Execute a string of commands (typically multi-line),
   * which are fed as standard input to the shell.
   *
   * Output is captured and returned as a list of Strings.
   *
   * Standard error is printed to the current process's stand
   * error.
   *
   * This method is not portable, and will only work on Unix-like
   * systems, as it makes use of the <code>/dev/stdin</code> file.
   *
   * @param commands Commands to be run
   * @return The output from executing the commands
   * @throws IOException
   * @throws InterruptedException
   * @throws ExecutionException
   */
  public static List<String> executeCommands(String commands)
      throws IOException, InterruptedException, ExecutionException
  {
    ProcessBuilder builder = new ProcessBuilder();
    builder.command("bash", "/dev/stdin");
    builder.redirectError(Redirect.INHERIT);
    Process process = builder.start();
    OutputStream os = process.getOutputStream();
    PrintWriter writer = new PrintWriter(os);
    writer.println(commands);
    writer.flush();
    writer.close();

    List<String> outputLines = new ArrayList<>();

    CommandRunner.StreamConsumer consumer =
        new CommandRunner.StreamConsumer(process.getInputStream(),
                                        (s) -> outputLines.add(s)  );
    consumer.run();
    int exitCode = process.waitFor();

    if (exitCode != 0) {
      throw new ExecutionException("couldn't execute commands '" + commands + ", "
                                  + " exit code was: " + exitCode);
    }
    assert exitCode == 0;
    return outputLines;
  }

}
