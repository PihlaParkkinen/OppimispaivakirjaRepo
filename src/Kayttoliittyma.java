import java.io.File;
import java.util.Scanner;

public class Kayttoliittyma {
    private Scanner lukija;


    public Kayttoliittyma(){
        this.lukija = new Scanner(System.in);
    }

    public void kaynnista() {

        while (true) {
            System.out.println("Syötä otsikko, kuvaus ja lähde:");
            String otsikko = lukija.nextLine();
            if (otsikko.equals("Lopeta")) {
                break;
            }
            String kuvaus = lukija.nextLine();
            String lahde = lukija.nextLine();


            Topic t = luoTopic(otsikko, kuvaus, lahde);


            Tiedostonmuokkaaja kirjoittaja = new Tiedostonmuokkaaja(new File("oppimispaivakirja.txt"));
            kirjoittaja.kirjoita(t);

        }
    }

    public Topic luoTopic(String o, String k, String l) {
        Topic topic = new Topic(o, k, l);
        return topic;
    }










}
