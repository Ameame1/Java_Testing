package processors;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

/** Test the processors.CommandRunner class
 */
class CommandRunnerTest {

  /**
   * Test method for {@link processors.CommandRunner#executeCommands(java.lang.String)}.
   *
   * @throws ExecutionException
   * @throws InterruptedException
   * @throws IOException
   */
  @Test
  void testExecuteCommands() throws IOException, InterruptedException, ExecutionException {
    List<String> expected = List.of("XXX");
    List<String> actual   = CommandRunner.executeCommands("echo XXX");
    assertEquals(expected, actual);
  }

  /**
   * Test method for {@link processors.CommandRunner#executeCommands(java.lang.String)}.
   * @throws ExecutionException
   * @throws InterruptedException
   * @throws IOException
   */
  @Test
  void whenCommandsBadExecuteCommandsFails() throws IOException, InterruptedException, ExecutionException {

    @SuppressWarnings("unused")
    ExecutionException ex = assertThrows(ExecutionException.class, () -> {
      List<String> res   = CommandRunner.executeCommands("ls /tmpxxx");
    });
  }

}
