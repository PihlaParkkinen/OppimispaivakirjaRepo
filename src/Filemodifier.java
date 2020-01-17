import java.io.*;
import java.util.Scanner;

public class Filemodifier {
    public FileWriter fwriter;
    public PrintWriter pwriter;
    public  BufferedWriter bwriter;

    public Filemodifier(File filename){
        try {
            this.fwriter = new FileWriter(filename, true);
        } catch (IOException e) {
            System.out.println("IO error occurred");
        }
        this.pwriter = new PrintWriter(fwriter);
        this.bwriter = new BufferedWriter(pwriter);
    }

    public void writetoFile(Topic topic){
        try {
            bwriter.write(topic.toString());
            bwriter.close();
        } catch (IOException e) {
            System.out.println("IO error occurred");
        }


    }



}
