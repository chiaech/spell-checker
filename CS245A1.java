import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.Properties​;

public class CS245A1 {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        if(args.length < 2) {
            System.out.println("Error: not enough arguments.");
            System.exit(1);
        }

        Search tree;
        String inputFile = args[0];
        String outputFile = args[1];
        String fileLine;

        Properties p = new Properties();
        p.load(new FileInputStream("a1properties.txt"));

        String path = p.getProperty("storage");
        if (path != null) {
            if(path.equals("tree")) {
                tree = new Tree();
            } else {
                tree = new Trie();
            }
        } else {
            tree = new Trie();
        }

        //reads from GitHub
        String jazzyEnglish = "https://raw.githubusercontent.com/magsilva/jazzy/master/resource/dict/english.0";
        URL url = new URL(jazzyEnglish);
        Scanner jazzyScanner = new Scanner(url.openStream());
        int counter = 0;
        while (jazzyScanner.hasNextLine()) {
            fileLine = jazzyScanner.nextLine();
            if (!fileLine.equals("")) {
                tree.insert(fileLine.toLowerCase());
            }
        }

        Scanner inputScanner = new Scanner(new File(inputFile));
            while(inputScanner.hasNextLine()) {
            fileLine = inputScanner.nextLine();
            System.out.println(tree.find(fileLine.toLowerCase()));
        }

        PrintStream output = new PrintStream(new File(outputFile));
        PrintStream print = System.out;
        System.setOut(output);
        System.setOut(print);

        jazzyScanner.close();
        inputScanner.close();
    }
}