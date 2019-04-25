import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Arrays {

    public static void main(String[] args) throws IOException {
        final File inputFile = new File("input.txt");
        final File dataFile = new File("data.txt");
        final File outputFile = new File("output.txt");
        Scanner scanner = new Scanner(System.in);
        int[][] arr;


        // полуинтерактивный, результаты в консоль
        if (inputFile.exists()){
            ArrayList<String> lines = new ArrayList<>();
            try{
                FileInputStream fileInputStream = new FileInputStream(inputFile);
                BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
                String readStr;

                while ((readStr = br.readLine()) != null){
                    lines.add(readStr);
                }
            }
            catch (IOException ex){
                System.out.println("An error occured while reading the file: " + inputFile);
            }
            arr = fillArray(lines, lines.size(), getColumns(lines));
            getMenu(scanner, arr);

        }
        // неинтерактивный, результаты в output.txt
        else if (dataFile.exists()){
            System.out.println("data file exists");
        }
        // интерактивный данные в консоль вводятся, выводятся туда же
        else
        {
            System.out.println("");
            System.out.print("Input numbers of rows: ");
            int a = scanner.nextInt();
            System.out.print("Input numbers of columns: ");
            int b = scanner.nextInt();

            arr = new int[a][b];

            for (int i = 0; i<arr.length; i++){
                for (int j=0;j<arr[i].length; j++){
                    System.out.print("[" + i  + "][" + j + "] = ");
                    arr[i][j] = scanner.nextInt();
                }
                System.out.println();
            }
            getMenu(scanner, arr);
        }

    }


    private static void getMenu(Scanner scanner, int[][] arr){
        System.out.println("Enter operation number : \n 0. - Exit \n 1. - Print \n 2. - Sort and Print \n 3. - Dimension of array \n 4. - Max and Min numbers in array " +
                "\n 5. - Get cell \n 6. - Get sum of array \n 7. - Get even elements \n 8. - Get odd elements ");

        String answr = "";
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
                default:
                    System.out.println("Invalid operation");
                    break;

            }
        }
    }

    private static int getColumns(ArrayList lines){
        int max = 0;
        for (Object s : lines){
            if (s.toString().trim().split(" ").length > max)
                max = s.toString().trim().split(" ").length;
        }
        return max;
    }

    private static int[][] fillArray(ArrayList lines, int a, int b){
        int[][] arr = new int[a][b];

        for (int i = 0; i<arr.length; i++){
                String[] line = lines.get(i).toString().trim().split(" ");
            for (int j=0;j<arr[i].length; j++){
                if (j <= line.length-1){
                    arr[i][j] = Integer.parseInt(line[j]);
                }
            }
        }
        return arr;
    }

}
