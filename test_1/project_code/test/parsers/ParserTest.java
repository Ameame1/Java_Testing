package parsers;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import core.Chunk;
import core.CodeChunk;
import core.DocChunk;
import utilities.StringUtilities;

/** Test the parsers.Parser class
 */
public class ParserTest {

  /**
   * Test method for {@link parsers.Parser#parse()}.
   *
   * Parse the empty document.
   */
  @Test
  public void testEmptyDoc() {
    String inputText = "";
    BufferedReader reader = StringUtilities.stringToBufferedReader(inputText);
    Parser parser = new Parser(reader);
    parser.parse();
    List<Chunk> chunks = parser.getChunks();

    assertEquals(0, chunks.size(), "chunk list has size 0");
  }

  /**
   * Test method for {@link parsers.Parser#parse()}.
   */
  @Test
  public void testDoc() {
    String inputTextLines[] = { "a line", /* possibly more lines*/ "last line" };

    String inputText = StringUtilities.arrayLinesToString(inputTextLines);
    BufferedReader reader = StringUtilities.stringToBufferedReader(inputText);
    Parser parser = new Parser(reader);
    parser.parse();
    List<Chunk> chunks = parser.getChunks();

    // assertEquals(???, chunks.size(), "splits input into ??? chunks");

    Chunk expectedArr[] = { new DocChunk("a line\n", 2), /* possibly more chunks */
        new DocChunk("last line\n", 5) };
    List<Chunk> expected = Arrays.asList(expectedArr);

    //assertEquals(expected, chunks, "????");
  }
  @Test
  public void test_usecase1() {
    String inputText1[]= {"=<<<"};
    String inputText = StringUtilities.arrayLinesToString(inputText1);
    BufferedReader reader = StringUtilities.stringToBufferedReader(inputText);
    Parser parser = new Parser(reader);
    parser.parse();
    List<Chunk> chunks = parser.getChunks();

    assertEquals(2, chunks.size(), "chunk list has size 2");
  }
  @Test
  public void test_usecase2() {
    String inputText1[]= {"First Doc Trunk"};
    String inputText = StringUtilities.arrayLinesToString(inputText1);
    BufferedReader reader = StringUtilities.stringToBufferedReader(inputText);
    Parser parser = new Parser(reader);
    parser.parse();
    List<Chunk> chunks = parser.getChunks();

    assertEquals(1, chunks.size(), "chunk list has size 1");
  }
  @Test
  public void test_usecase3() {
    String inputText1[] = {"First Doc Chunk","=<<<","echo XXXX",">>>","Second Doc Chunk"};
    String inputText = StringUtilities.arrayLinesToString(inputText1);
    BufferedReader reader = StringUtilities.stringToBufferedReader(inputText);
    Parser parser = new Parser(reader);
    parser.parse();
    List<Chunk> chunks = parser.getChunks();

    assertEquals(3, chunks.size(), "chunk list has size 3");
  }

}
