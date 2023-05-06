package processors;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import core.Chunk;
import parsers.Parser;
import utilities.MemIO;
import utilities.StringUtilities;

/** Test the processors.ShellProcessor class
 *
 */
class ShellProcessorTest {

  
  @Test
  public void testOneLineDoc() throws ExecutionException {
    String inputText = "some text";
    BufferedReader reader = StringUtilities.stringToBufferedReader(inputText);
    Parser parser = new Parser(reader);
    parser.parse();
    List<Chunk> chunks = parser.getChunks();

    MemIO mio = new MemIO();
    Processor processor = new ShellProcessor(mio.out, chunks);
    processor.merge();

    String actual = mio.getContents();
    //String expected = /* string goes here */;
    // assertEquals(expected, actual, "actual text should equal expected");
  }
  @Test
  public void test_usecase1() throws ExecutionException {
    String inputText1[]= {"XXXX","=<<<\n","XXXX",">>>\n" ,"XXXX"};
    String inputText = StringUtilities.arrayLinesToString(inputText1);
    BufferedReader reader = StringUtilities.stringToBufferedReader(inputText);
    Parser parser = new Parser(reader);
    parser.parse();
    List<Chunk> chunks = parser.getChunks();

    MemIO mio = new MemIO();
    Processor processor = new ShellProcessor(mio.out, chunks);
    processor.merge();

    String actual = mio.getContents();
    //String expected = /* string goes here */;
    // assertEquals(expected, actual, "actual text should equal expected");
  }
  @Test
  public void test_usecase2() throws ExecutionException {
    String inputText1[]= {"=<<<\n","XXX"};
    String inputText = StringUtilities.arrayLinesToString(inputText1);
    BufferedReader reader = StringUtilities.stringToBufferedReader(inputText);
    Parser parser = new Parser(reader);
    parser.parse();
    List<Chunk> chunks = parser.getChunks();

    MemIO mio = new MemIO();
    Processor processor = new ShellProcessor(mio.out, chunks);
    processor.merge();

    String actual = mio.getContents();
    //String expected = /* string goes here */;
    // assertEquals(expected, actual, "actual text should equal expected");
  }
  @Test
  public void test_usecase3() throws ExecutionException {
    String inputText1[]= {"XXXXX",">>>\n"};
    String inputText = StringUtilities.arrayLinesToString(inputText1);
    BufferedReader reader = StringUtilities.stringToBufferedReader(inputText);
    Parser parser = new Parser(reader);
    parser.parse();
    List<Chunk> chunks = parser.getChunks();

    MemIO mio = new MemIO();
    Processor processor = new ShellProcessor(mio.out, chunks);
    processor.merge();

    String actual = mio.getContents();
    //String expected = /* string goes here */;
    // assertEquals(expected, actual, "actual text should equal expected");
  }

  @Test
  public void test_usecase4() throws ExecutionException {
    String inputText1[]= {"=<<<\n","=<<<\n","echo XXXX",">>>\n"};
    String inputText = StringUtilities.arrayLinesToString(inputText1);
    BufferedReader reader = StringUtilities.stringToBufferedReader(inputText);
    Parser parser = new Parser(reader);
    parser.parse();
    List<Chunk> chunks = parser.getChunks();

    MemIO mio = new MemIO();
    Processor processor = new ShellProcessor(mio.out, chunks);
    processor.merge();

    String actual = mio.getContents();
    //String expected = /* string goes here */;
    // assertEquals(expected, actual, "actual text should equal expected");
  }


}
