import org.junit.Test;
import org.junit.Assert;
import java.util.Arrays;

public class BinarySearchTest {

    @Test
    public void testBinarySearchWithEmptyArray() {
        int[] arr = {};
        Assert.assertEquals(-1, BinarySearch.search(arr, 5));
    }

    @Test
    public void testBinarySearchWithNotFound() {
        int[] arr = {1, 3, 7, 10, 15};
        Assert.assertEquals(-1, BinarySearch.search(arr, 5));
    }

    @Test
    public void testBinarySearchWithFound() {
        int[] arr = {1, 3, 7, 10, 15};
        Assert.assertEquals(3, BinarySearch.search(arr, 10));
    }

    @Test
    public void testBinarySearchWithDuplicateValues() {
        int[] arr = {1, 3, 7, 7, 10, 15};
        Assert.assertEquals(2, BinarySearch.search(arr, 7));
    }

    @Test
    public void testBinarySearchWithLargeArray() {
        int[] arr = new int[1000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        Assert.assertEquals(500, BinarySearch.search(arr, 500));
    }

}
