import java.util.ArrayList;
import java.util.Scanner;

public class Arrays {

    static int[][] sort (int[][] arr) {
        boolean isSorted = false;
        int buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length-1; j++) {

                    if (arr[i][j] > arr[i][j+1]) {
                        isSorted = false;

                        buf = arr[i][j];
                        arr[i][j] = arr[i][j+1];
                        arr[i][j+1] = buf;

                    }
                }
            }
        }
        return arr;
    }


    static void print (int[][] arr){
        for (int i = 0; i<arr.length; i++){
            for (int j=0;j<arr[i].length; j++){
                System.out.print("[" + arr[i][j] + "]");
            }
            System.out.println();
        }
    }

    static int maxNumber (int [][] arr){
        int max = 0;
        for (int i = 0; i<arr.length; i++){
            for (int j=0;j<arr[i].length; j++){
                if (arr[i][j] > max) max = arr[i][j];
            }

        }
        return max;
    }

    static int minNumber (int [][] arr){
        int min = 10000;
        for (int i = 0; i<arr.length; i++){
            for (int j=0;j<arr[i].length; j++){
                if (arr[i][j] < min) min = arr[i][j];
            }

        }
        return min;
    }

    static String getCell (int [][] arr){
        int cell = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of row: ");
        int a = scanner.nextInt();
        System.out.print("Enter number of column: ");
        int b = scanner.nextInt();

        try{
            cell = arr[a][b];
        }
        catch (IndexOutOfBoundsException ex){
            return "Index is out of Array. Try again.";
        }
        return "[" + a + "][" + b + "] = " + cell;
    }

    static int getSumOfArray (int[][] arr){
        int sum = 0;
        for (int i = 0; i<arr.length; i++){
            for (int j=0;j<arr[i].length; j++){
                sum+= arr[i][j];
            }

        }
        return sum;
    }

    static ArrayList<Integer> getEven (int [][] arr){
        ArrayList<Integer> listEven = new ArrayList<>();
        for (int i = 0; i<arr.length; i++){
            for (int j=0;j<arr[i].length; j++){
                if (arr[i][j] % 2 == 0) listEven.add(arr[i][j]);
            }

        }
        return listEven;
    }

    static ArrayList<Integer> getOdd (int [][] arr){
        ArrayList<Integer> listOdd = new ArrayList<>();
        for (int i = 0; i<arr.length; i++){
            for (int j=0;j<arr[i].length; j++){
                if (arr[i][j] % 2 != 0) listOdd.add(arr[i][j]);
            }

        }
        return listOdd;
    }

}
