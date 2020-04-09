import java.util.Scanner;
import java.io.*;

public class fileIn {
    static String fileName;
    static boolean append = false;

    public static void main(String[] args) {
        getFileName();
        readFileContents();
    }

    public static void readFileContents() {
        fertilizer Fert = new fertilizer();
        fileOut fOut = new fileOut();
        String number;
        int num;
        treeNode root = null;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((number = br.readLine()) != null) {
                num = Integer.parseInt(number);
                root = Fert.buildThatTreeOhYes(num);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        fOut.writeToFile(" ____________________________\n", append);
        append = true;
        fOut.writeToFile("|    Output \t|\tDuplicates  |\n", append);
        fOut.writeToFile("|_____________|_____________|\n", append);
        Fert.inOrderR(root);
        fOut.writeToFile("|___________________________|---> " + "Total Duplicates: " + Fert.totalDuplicates + "\n\n",
                append);
        fOut.writeToFile("Total Comparisons:", append);
        fOut.writeToFile("\n   Writing Out Tree = " + Fert.totalTreeWritingComparisons + "\n", append);
        fOut.writeToFile("     Building Tree = " + Fert.totalTreeBuildingComparisons + "\n", append);
    }

    public static void getFileName() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter file path: ");
        fileName = in.nextLine();
        System.out.println("\nYou entered " + fileName);
    }
}
