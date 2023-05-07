import org.junit.Test;
import org.junit.Assert;
import java.util.Arrays;

public class HangmanTest {

    @Test
    public void testGetHiddenWord() {
        Hangman game = new Hangman("hello");
        Assert.assertArrayEquals(new char[]{'_', '_', '_', '_', '_'}, game.getHiddenWord());
    }

    @Test
    public void testGuessCorrectLetter() {
        Hangman game = new Hangman("hello");
        Assert.assertTrue(game.guess('l'));
        Assert.assertArrayEquals(new char[]{'_', '_', 'l', 'l', '_'}, game.getHiddenWord());
    }

    @Test
    public void testGuessIncorrectLetter() {
        Hangman game = new Hangman("hello");
        Assert.assertFalse(game.guess('z'));
        Assert.assertArrayEquals(new char[]{'_', '_', '_', '_', '_'}, game.getHiddenWord());
    }

    @Test
    public void testGuessSameLetterTwice() {
        Hangman game = new Hangman("hello");
        Assert.assertTrue(game.guess('l'));
        Assert.assertFalse(game.guess('l'));
        Assert.assertArrayEquals(new char[]{'_', '_', 'l', 'l', '_'}, game.getHiddenWord());
    }

    @Test
    public void testIsGameWon() {
        Hangman game = new Hangman("hello");
        game.guess('h');
        game.guess('e');
        game.guess('l');
        game.guess('o');
        Assert.assertTrue(game.isGameWon());
    }

    @Test
    public void testIsGameLost() {
        Hangman game = new Hangman("hello");
        game.guess('z');
        game.guess('y');
        game.guess('x');
        game.guess('w');
        game.guess('v');
        game.guess('u');
        game.guess('t');
        game.guess('s');
        game.guess('r');
        game.guess('q');
        Assert.assertTrue(game.isGameLost());
    }

}
