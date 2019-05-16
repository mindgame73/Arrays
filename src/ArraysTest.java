import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ArraysTest {
    int arr[][] = {{5,4,3},{9,2,8}};
    Main main = new Main();
    @Test
    public void sort() {

        int expected[][] = main.sort(arr);
        int actual[][] = {{2,3,4},{5,8,9}};
        Assert.assertArrayEquals(expected,actual);
    }

    @Test
    public void maxNumber() {
        int expected = main.maxNumber(arr);
        int actual = 9;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void minNumber() {
        int expected = main.minNumber(arr);
        int actual = 2;
        Assert.assertEquals(expected,actual);
    }


    @Test
    public void getSumOfArray() {
        int expected = main.getSumOfArray(arr);
        int actual = 31;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getEven() {
        ArrayList<Integer> expected = main.getEven(arr);
        ArrayList<Integer> actual = new ArrayList<>() {{
           add(4);
           add(2);
           add(8);
        }};
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getOdd() {
        ArrayList<Integer> expected = main.getOdd(arr);
        ArrayList<Integer> actual = new ArrayList<>() {{
            add(5);
            add(3);
            add(9);
        }};
        Assert.assertEquals(expected,actual);
    }

}