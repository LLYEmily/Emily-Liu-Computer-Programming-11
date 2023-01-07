import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
//Method to search the word
    public static int Search(String finding) throws IOException{
        FileReader fr = new FileReader("in.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        int count = 0;
        int lineCounter = 0;
        int indexBeginning = 0;
        System.out.println("");
        System.out.println("Searching for word: " + finding);
        while((line = br.readLine()) != null){
            lineCounter++;
            indexBeginning = line.indexOf(finding);
            while(indexBeginning >= 0){
                System.out.println("Found word: " + finding + ", at index position: " + indexBeginning + ", on Array: " + lineCounter);
                indexBeginning = line.indexOf(finding, indexBeginning + 1);
                count++;
            }
        }
        return indexBeginning;
    }

    public static void main(String[] args) throws IOException{
        //copies each line into an ArrayList
        ArrayList<String> lines = new ArrayList<>();
        FileReader fileReader = new FileReader("in.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while((line = bufferedReader.readLine()) != null){
            System.out.println("Just Read: " + line);
            lines.add(line);
        }
        bufferedReader.close();
        //prints text over to an "out" file
        FileWriter fw = new FileWriter("out.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        for(String i : lines){
            bw.write(i + "\r");
        }
        bw.close();
        //runs the method that finds the text
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the word you want to search");
        String a = s.nextLine();
        Search(a);
    }
        /*BufferedReader br = new BufferedReader(new FileReader("in.txt"));
        String line;
        byte[] data = new byte[10];
        System.in.read(data);
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }*/
        /*FileInputStream in;
        FileOutputStream out;
        in = new FileInputStream("in.txt");
        out = new FileOutputStream("out.txt");


        Scanner s = new Scanner(new File("filepath"));
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNext()){
            list.add(s.next());
        }
        s.close();*/


        /*FileReader in = new FileReader("in.txt");

        System.out.println("Type in one key");
        System.in.read(data);
        for (byte b : data) {
            System.out.println("Byte: " + b + "\tChar: " + (char)b);
        }*/

}