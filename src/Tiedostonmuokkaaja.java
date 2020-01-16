import java.io.*;
import java.util.Scanner;

public class Tiedostonmuokkaaja {
    public FileWriter kirjoittaja;
    public PrintWriter tokakirjoittaja;
    public  BufferedWriter bkirjoittaja;

    public Tiedostonmuokkaaja(File tiedostonimi){
        try {
            this.kirjoittaja = new FileWriter(tiedostonimi, true);
        } catch (IOException e) {
            System.out.println("IO virhe");
        }
        this.tokakirjoittaja = new PrintWriter(kirjoittaja);
        this.bkirjoittaja = new BufferedWriter(tokakirjoittaja);
    }

    public void kirjoita(Topic topic){
        try {
            bkirjoittaja.write(topic.toString());
        } catch (IOException e) {
            System.out.println("IO virhe");
        }
        try {
            bkirjoittaja.close();
        } catch (IOException e) {
            System.out.println("IO virhe");
        }
    }



}
