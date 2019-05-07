import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main extends Arrays {

    public static void main(String[] args) throws IOException {
        final File inputFile = new File("input.txt");
        final File dataFile = new File("data.txt");
        final File outputFile = new File("output.txt");
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<>();
        String readStr;
        int[][] arr;


        // полуинтерактивный, результаты в консоль
        if (inputFile.exists()){
            FileInputStream fileInputStream = new FileInputStream(inputFile);
            BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
            try{
                while ((readStr = br.readLine()) != null){
                    if (!readStr.trim().equals(""))
                        lines.add(readStr);
                }
                System.out.println("Array was read from 'input.txt' file");
            }
            catch (IOException ex){
                System.out.println("An error occured while reading the file: " + inputFile);
            }

            try {
                arr = fillArray(lines, lines.size(), getColumns(lines));
                getMenu(scanner, arr);
            }
            catch (NumberFormatException ex){
                System.out.println("There was a problem while reading not number value in file! Please check input.txt file");
            }


        }
        // неинтерактивный, результаты в output.txt
        else if (dataFile.exists()){
            FileInputStream fileInputStream = new FileInputStream(dataFile);
            BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, true));
            try{
                while ((readStr = br.readLine()) != null){
                    if (!readStr.trim().equals(""))
                        lines.add(readStr);
                }
            }
            catch (IOException ex){
                System.out.println("An error occured while reading the file: " + inputFile);
            }
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            bw.newLine();
            bw.write("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            bw.newLine();
            bw.write(format.format(new Date()));
            bw.newLine();
            bw.flush();
            try {
                arr = fillArray(lines, lines.size(), getColumns(lines));
                print(arr,true);
                bw.write("Sorted array");
                bw.newLine();
                bw.flush();
                print(sort(arr), true);
                bw.write("The size of array is " + arr.length + "x" + arr[0].length);
                bw.newLine();
                bw.write("Max number is - " + maxNumber(arr));
                bw.newLine();
                bw.write("Min number is - " + minNumber(arr));
                bw.newLine();
                bw.write("Sum of elements: " + getSumOfArray(arr));
                bw.newLine();
                bw.write("Even elements: " + getEven(arr).toString());
                bw.newLine();
                bw.write("Odd elements: " + getOdd(arr).toString());
                bw.flush();
            }
            catch (NumberFormatException ex){
                bw.write("There was a problem while reading not number value in file! Please check data.txt file");
                bw.flush();
            }

        }
        // интерактивный данные в консоль вводятся, выводятся туда же
        else
        {
            System.out.println("Input or data files not found!");
            System.out.print("Input number of rows: ");
            int a = scanner.nextInt();
            System.out.print("Input number of columns: ");
            int b = scanner.nextInt();

            arr = new int[a][b];

            for (int i = 0; i<arr.length; i++){
                for (int j=0;j<arr[i].length; j++){
                    System.out.print("[" + i  + "][" + j + "] = ");
                    try {
                        arr[i][j] = scanner.nextInt();
                    }
                    catch (InputMismatchException ex){
                        System.out.println("Only numeric values are allowed.");
                        System.exit(-1);
                    }
                }
                System.out.println();
            }
            getMenu(scanner, arr);
        }

    }


    private static void getMenu(Scanner scanner, int[][] arr) throws IOException {
        System.out.println("Enter operation number : \n 0. - Exit \n 1. - Print \n 2. - Sort and Print \n 3. - Dimension of array \n 4. - Max and Min numbers in array " +
                "\n 5. - Get cell \n 6. - Get sum of array \n 7. - Get even elements \n 8. - Get odd elements ");

        String answr = "";
        while (!answr.equals("0")) {
            answr = scanner.nextLine();
            switch (answr) {
                case "1":
                    print(arr,false);
                    break;
                case "2":
                    print(sort(arr),false);
                    break;
                case "3":
                    System.out.println("The size of array is " + arr.length + "x" + arr[0].length);
                    break;
                case "4":
                    System.out.println("Max number is - " + maxNumber(arr));
                    System.out.println("Min number is - " + minNumber(arr));
                    break;
                case "5":
                    System.out.println(getCell(arr));
                    break;
                case "6":
                    System.out.println("Sum of elements: " + getSumOfArray(arr));
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
                case "":
                case "0" :
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
