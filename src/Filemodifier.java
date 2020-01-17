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
        try {
            bwriter.write(topic.toString());
            bwriter.close();
        } catch (IOException e) {
            System.out.println("IO error occurred");
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



}
