import java.io.File;
import java.util.Scanner;

public class ui {
    Scanner inputReader = new Scanner(System.in);

    Filemodifier filemodifier =  new Filemodifier(new File("oppimispaivakirja.txt"));

    public ui(){

    }

    public void start() {


        while (true) {

            Topiclist topiclist = new Topiclist();
            System.out.println("Welcome! 0 - end application, 1 - add new topic, 2 - add topic completion, 3 - print all topics&info");
            String input = inputReader.nextLine();

            if(input.equals("0")) {
                System.out.println("Goodbye!");
                break;
            }

            if(input.equals("1")) {
                while (true) {
                    System.out.println("Write title, description and source. Type 'stop' if no topics to add.");
                    String title = inputReader.nextLine();
                    if (title.equals("stop")) {
                        break;
                    }
                    String description = inputReader.nextLine();
                    String source = inputReader.nextLine();
                    Topic t = createTopic(title, description, source);
                    topiclist.addtoList(t);
                }
                addListToFile(topiclist);
            }


            if (input.equals("2")) {
                System.out.print("Topic to complete: ");
                String topicName = inputReader.nextLine();
                // Jatka tähän: miten haetaan aihe ja tehdään complete() metodi sille.
                //searchTopic(topicName);
            }

            if (input.equals("3")) {
            filemodifier.readFile();
            }

        }
    }

    public Topic createTopic(String t, String d, String s) {
        Topic topic = new Topic(t, d, s);
        return topic;
    }

    /*public Topic searchTopic(String topicName) {
        return topicName;
    }*/
    public void addListToFile(Topiclist topiclist) {
        for (int i = 0; i < topiclist.size(); i++) {
            Topic addable = topiclist.get(i);
            filemodifier.writetoFile(addable);
            System.out.println(addable);
        }

    }



}
