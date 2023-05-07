package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.List;

import core.Chunk;
import parsers.Parser;
import processors.ReverseProcessor;


public class JDocGen {

  public static void generate(String inputFile, String outputFile) throws FileNotFoundException  {
    BufferedReader inputReader = new BufferedReader(new FileReader(inputFile));
    Parser parser = new Parser(inputReader);
    parser.parse();
    List<Chunk> chunks = parser.getChunks();
    System.out.println(chunks);

    PrintStream outputStream = new PrintStream(new File(outputFile));

    ReverseProcessor processor = new ReverseProcessor(outputStream, chunks);
    processor.merge();
  }

  /** Run the JDocGen app.
   *
   * <code>args[0]</code>
   * should contain the path to the input file, and <code>args[1]</code>
   * the path to the output file.
   *
   * @param args Command-line arguments to the JDocGen app
   * @throws FileNotFoundException
   */
  public static void main(String args[]) throws FileNotFoundException  {
    generate(args[0], args[1]);
  }


}
