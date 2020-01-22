import java.io.*;
import java.util.Scanner;

public class Filemodifier {
    public FileWriter fwriter;
    public PrintWriter pwriter;
    public  BufferedWriter bwriter;
    public FileReader freader;
    public BufferedReader breader;

    public Filemodifier(File filename){
        try {
            this.fwriter = new FileWriter(filename, true);
            this.pwriter = new PrintWriter(fwriter);
            this.bwriter = new BufferedWriter(pwriter);
            this.freader = new FileReader(filename);
            this.breader = new BufferedReader(freader);
        } catch (IOException e) {
            System.out.println("IO error occurred");
        }

    }

    public void writetoFile(Topic topic){
        String topicAsString = topic.toString();
        try {
            fwriter.write(topicAsString);

        } catch (IOException e) {
            System.out.println("IO error occurred when writing to file" + e.getMessage());
        }


    }

    public void readFile() {
      try {
          String line = " ";

          while ((line = breader.readLine()) != null) {
              System.out.println(line);
          }
      } catch (IOException e) {
          System.out.println("IO error occurred");
      }
    }

    public void readFileToList(File filename){ // palauttaa objektin
        try{
             FileInputStream fileinput = new FileInputStream(filename);
             ObjectInputStream objectIn = new ObjectInputStream(fileinput);
             Object topicAsObject = objectIn.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("IO Exception occurred: " +e.getMessage());
        }
    }



}
