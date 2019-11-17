import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.Properties​;

public class CS245A1 {

    //  public static String checkSpelling(String[] inputWords) {
    //     // takes in a word and checks it letter by letter 
    //     // returns up to 3 words that it could be if it does not find that word in tree

    //     // String returnArray[];

    //     // // else go letter by letter in the tree until (until nil)
    //     // String tempString = "";
    //     // String searchString = "";
    //     // for(char c : inputWords.toLowerCase().toCharArray()) {
    //     //     tempString += c;
    //     //     if(!tree.find(tempString)){
    //     //         // use searchString to get the nodes before and return three of them
    //     //         // TODO add get to BST file
    //     //         //return tree.get(searchString); // want get to return an array. might have to return only a portion of that becasue  a max of 3 should be returned
    //     //     }
    //     //     searchString += c;
    //     // }

    //     // return returnArray;
    // }


    public static void main(String[] args) throws FileNotFoundException, IOException {

        if(args.length < 2) {
            System.out.println("Error: not enough arguments.");
            System.exit(1);
        }

        Search tree;
        String inputFile = args[0];
        String outputFile = args[1];
        String fileLine;
        // String word;


        // create BST/TRIE obj to find/insert
        Properties p = new Properties();
        p.load(new FileInputStream("a1properties.txt"));

       // Boolean useBST;

        // default to trie tree if no configuration exists
        String path = p.getProperty("storage");
        if (path != null) {
            if(path.equals("tree")) {
                //useBST = true;
                tree = new Tree();
            } else {
                //useBST = false;
                tree = new Trie();
            }
        } else {
             //useBST = false;
            tree = new Trie();
        }

        //reads from GitHub
        String jazzyEnglish = "https://raw.githubusercontent.com/magsilva/jazzy/master/resource/dict/english.0";
        URL url = new URL(jazzyEnglish);
        Scanner jazzyScanner = new Scanner(url.openStream());
        int counter = 0;
        while (jazzyScanner.hasNextLine()){
            fileLine = jazzyScanner.nextLine();
            if (!fileLine.equals("")) {
                tree.insert(fileLine.toLowerCase());
                //System.out.println(fileLine + " " + ++counter);
            }
        }

        //ArrayList<String> inputArray = new ArrayList<>();

        Scanner inputScanner = new Scanner(new File(inputFile));
            while(inputScanner.hasNextLine()){
            //System.out.println("hello");
            fileLine = inputScanner.nextLine();
            System.out.println(tree.find(fileLine.toLowerCase()));
        }

        //System.out.print(inputArray);

        //checkSpelling(inputArray);

        PrintStream output = new PrintStream(new File(outputFile));
        PrintStream print = System.out;
        System.setOut(output);
        System.setOut(print);

        jazzyScanner.close();
        inputScanner.close();

    }
}