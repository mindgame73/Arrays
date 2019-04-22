import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main extends Arrays {
    public static void main(String[] args) throws IOException {
        // Commit from PCs
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
            System.out.println("");
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

            System.out.println("Enter operation number : \n 0. - Exit \n 1. - Print \n 2. - Sort and Print \n 3. - Dimension of array \n 4. - Max and Min numbers in array " +
                    "\n 5. - Get cell \n 6. - Get sum of array \n 7. - Get even elements \n 8. - Get odd elements ");

            String answr = answr = scanner.nextLine();
            while (!answr.equals("0")) {
                answr = scanner.nextLine();
                switch (answr) {
                    case "1":
                        print(arr);
                        break;
                    case "2":
                        print(sort(arr));
                        break;
                    case "3":
                        System.out.println("Dimension is " + arr.length + "x" + arr[1].length);
                        break;
                    case "4":
                        System.out.println("Max number is - " + maxNumber(arr));
                        System.out.println("Min number is - " + minNumber(arr));
                        break;
                    case "5":
                        System.out.println(getCell(arr));
                        break;
                    case "6":
                        System.out.println("Sum of array: " + getSumOfArray(arr));
                        break;
                    case "7":
                        System.out.println("Even elements : ");
                        getEven(arr).forEach(x -> System.out.print(x.toString() + " "));
                        System.out.println();
                        break;
                    case "8":
                        System.out.println("Odd elements: ");
                        getOdd(arr).forEach(x -> System.out.print(x.toString() + " "));
                        System.out.println();
                        break;
                    case "0":
                        break;
                    case "cls":
                        Runtime.getRuntime().exec("cls");
                    default:
                        System.out.println("Invalid operation");
                        break;

                }
            }


        }

    }

}
