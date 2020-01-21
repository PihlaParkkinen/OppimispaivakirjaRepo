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

    public void writetoFile(Topic topic){ //TÄÄLLÄ VIRHE!!! Ei pysty kirjoittamaan tiedostoon. MIKSI?
        String topicAsString = topic.toString();
        try {
            bwriter.write(topicAsString);
            bwriter.close();
        } catch (IOException e) {
            System.out.println("IO error occurred when writing to file");
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
