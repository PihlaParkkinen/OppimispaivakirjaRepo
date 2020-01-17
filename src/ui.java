import java.io.File;
import java.util.Scanner;

public class ui {
    private Scanner inputReader;


    public ui(){

        this.inputReader = new Scanner(System.in);
    }

    public void start() {


        while (true) {
            System.out.println("Welcome! 0 - end application, 1 - add new topic, 2 - add topic completion, 3 - print all topics");
            String input = inputReader.nextLine();

            if(input.equals("0")) {
                System.out.println("Goodbye!");
                break;
            }

            if(input.equals("1")){
                System.out.println("Write title, description and source");
                String title = inputReader.nextLine();
                String description = inputReader.nextLine();
                String source = inputReader.nextLine();
                Topic t = createTopic(title, description, source);

                Filemodifier filemodifier = new Filemodifier(new File("oppimispaivakirja.txt"));
                filemodifier.writetoFile(t);
            }
            if (input.equals("2")) {
                System.out.print("Topic to complete: ");
                String topicName = inputReader.nextLine();
                // Jatka tähän: miten haetaan aihe ja tehdään complete() metodi sille.
            }


        }
    }

    public Topic createTopic(String t, String d, String s) {
        Topic topic = new Topic(t, d, s);
        return topic;
    }














}
