import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ui {
    Scanner inputReader = new Scanner(System.in);
    //Filemodifier filemodifier =  new Filemodifier(opfile);*/
    File opfile = new File("oppimispaivakirja.txt");


    public void start() {
        //ObjectOutputStream objectOut;
        try {
            FileOutputStream fileout = new FileOutputStream(opfile);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileout);
            optionsLoop(objectOut);
        } catch (IOException e) {
            System.out.println("IO Exception occurred: " + e.getMessage());
        }


    }

    private void optionsLoop(ObjectOutputStream objectOut) throws IOException {
        while (true) {
            Topiclist topiclist = new Topiclist();
            System.out.println("Welcome! 0 - end application, 1 - add new topic, 2 - add topic completion, 3 - print all topics&info");
            String input = inputReader.nextLine();

            if (input.equals("0")) {
                System.out.println("Goodbye!");
                break;
            } else if (input.equals("1")) {
                ifInputIs1(topiclist, objectOut);
            } else if (input.equals("2")) {
                System.out.print("Topic to complete: ");
                // Jatka tähän: miten haetaan aihe ja tehdään complete() metodi sille.
            } else if (input.equals("3")) {
                readingObjectFromFile();
            } else {
                System.out.println("You typed invalid number, try again!");
            }
        }

    }

    private void readingObjectFromFile() throws IOException { // EI LUE KAIKKIA OBJEKTEJA?!
        List<Topic> topics = new ArrayList<>();
        try {
            FileInputStream fileinput = new FileInputStream(opfile);
            ObjectInputStream objectIn = new ObjectInputStream(fileinput);
             Object objFromFile = objectIn.readObject();
                    Topic tfromFile = (Topic) objFromFile;
                    topics.add(tfromFile);
                    objectIn.close();
            } catch (ClassNotFoundException e) {
                System.out.println("Class not found" + e.getMessage());
            }
        System.out.println(topics.toString());
    }


    private void ifInputIs1(Topiclist topiclist, ObjectOutputStream objectOut) throws IOException{
        while (true) {
            System.out.println("Write title, description and source. Type 'stop' if no topics to add.");
            String title = inputReader.nextLine();
            if (title.equals("stop")) {
                objectOut.close();
                break;
            }
            String description = inputReader.nextLine();
            String source = inputReader.nextLine();
            Topic t = createTopic(title, description, source);
            objectOut.writeObject(t);
            System.out.println("Topic was successfully saved to file!");
        }
        //addListToFile(topiclist);
    }

    public Topic createTopic(String t, String d, String s) {
        Topic topic = new Topic(t, d, s);
        return topic;
    }
}

    /*public Topic searchTopic(String topicName) {
        return topicName;
    }*/
    /*public void addListToFile(Topiclist topiclist) {
        for (int i = 0; i < topiclist.size(); i++) {
            Topic addable = topiclist.get(i);
            filemodifier.writetoFile(addable);

        }
        try {
            filemodifier.bwriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/






