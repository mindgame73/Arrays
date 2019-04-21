import java.io.File;
import java.util.Scanner;

public class Main extends Arrays {
    public static void main(String[] args) {
        File inputFile = new File("input.txt");
        File dataFile = new File("data.txt");
        File outputFile = new File("output.txt");


        // полуинтерактивный, результаты в консоль
        if (inputFile.exists()){
            System.out.println("input file exists");
        }
        // неинтерактивный, результаты в output.txt
        else if (dataFile.exists()){
            System.out.println("data file exists");
        }
        // интерактивный данные в консоль вводятся, выводятся туда же
        else
        {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Input numbers of rows: ");
            int a = scanner.nextInt();
            System.out.print("Input numbers of columns: ");
            int b = scanner.nextInt();

            int[][] arr = new int[a][b];

            for (int i = 0; i<arr.length; i++){
                for (int j=0;j<arr[i].length; j++){
                    System.out.print("[" + i  + "][" + j + "] = ");
                    arr[i][j] = scanner.nextInt();
                }
                System.out.println();
            }

            //print(sort(arr));
            System.out.println("Максимальный элемент массива - " + maxNumber(arr));
            System.out.println("Минимальный элемент массива - " + minNumber(arr));
            System.out.println(getCell(arr));
            System.out.println("Сумма массива: " + getSumOfArray(arr));

            System.out.print("Четные элементы массива: ");
            getEven(arr).forEach(x -> System.out.print(x.toString() + " "));
            System.out.println();
            System.out.print("Нечетные элементы массива: ");
            getOdd(arr).forEach(x -> System.out.print(x.toString() + " "));
        }

    }

}
