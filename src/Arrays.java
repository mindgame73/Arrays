import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Arrays {

     static int[][] sort (int [][] arr){
        int temp;
        int le = arr.length;
        int w = arr[0].length;
        for(int i = 0; i < le; i++) {
            for(int j = 0; j < w; j++) {
                for(int k = 0; k < le; k++) {
                    for(int l = 0; l < w; l++)
                        if(arr[i][j] < arr[k][l]) {
                            temp = arr[i][j];
                            arr[i][j] = arr[k][l];
                            arr[k][l] = temp;
                        }
                }
            }
        }
        return arr;
    }

    static void print (int[][] arr, boolean flush) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt", true));
        if (flush){
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    bw.write("[" + arr[i][j] + "]");
                }
                bw.newLine();
            }
            bw.newLine();
            bw.flush();
        }
        else {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print("[" + arr[i][j] + "] \t");
                }
                System.out.println();
            }
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
        int cell;
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
