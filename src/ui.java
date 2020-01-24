import java.io.*;
import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ui {
    Scanner inputReader = new Scanner(System.in);
    //Filemodifier filemodifier =  new Filemodifier(opfile);*/
    public final File opfile = new File("oppimispaivakirja.txt");


    public void start() {
        List<Topic> topiclist = new ArrayList<>();
        optionsLoop(topiclist);
    }

    private void optionsLoop(List<Topic> list)  {
        while (true) {
            System.out.println("Welcome! 0 - end application, 1 - add new topic, 2 - add topic completion, 3 - print all topics&info, 4 - remove topic from list");
            String input = inputReader.nextLine();
            if (input.equals("0")) {
                //fileout.close();
                System.out.println("Goodbye!");
                break;
            } else if (input.equals("1")) {
                list.addAll(ifInputIs1());
            } else if (input.equals("2")) {
                while(true) {
                    System.out.print("Type topic ID to add completion. Type 'stop' if no topics to complete.");
                    String in = inputReader.nextLine();
                    if (in.equals("stop")) {
                        break;
                    }
                    int indeksi = Integer.valueOf(in);
                    Topic topicToComplete = list.get(indeksi);
                    topicToComplete.complete();
                    list.remove(indeksi);
                    list.add(indeksi, topicToComplete);
                    System.out.println("Topic " + topicToComplete.getTitle() + " completed!");
                }

            } else if (input.equals("3")) {
                for (Topic topicOnList : list) {
                    System.out.println(topicOnList);
                }
            } else if (input.equals("4")){
                System.out.print("Type topic ID to delete topic from list. Type stop if no topics to delete");
                String inp = inputReader.nextLine();
                if (inp.equals("stop")) {
                    break;
                }
                int indeksi = Integer.valueOf(inp);
                Topic topicToRemove = list.get(indeksi);
                list.remove(indeksi);
                System.out.println("Topic " + topicToRemove.getTitle() + " deleted!");
            } else {
                System.out.println("You typed invalid number, try again!");
            }
        }

    }

    private void readingObjectFromFile() throws IOException {
        List<Topic> topics = new ArrayList<>();
        try {
            FileInputStream fileinput = new FileInputStream(opfile);
            ObjectInputStream objectIn = new ObjectInputStream(fileinput);
            BufferedReader br = new BufferedReader(new FileReader(opfile));
            while(br.readLine() != null) {
                Object objFromFile = objectIn.readObject();

                Topic tfromFile = (Topic) objFromFile;
                System.out.println(tfromFile);
            }
            objectIn.close();
            br.close();

            } catch (ClassNotFoundException e) {
                System.out.println("Class not found" + e.getMessage());
            }

    }


    private List<Topic> ifInputIs1(){
        List<Topic> list = new ArrayList<>();
        while (true) {
            System.out.println("Write title, description and source. Type 'stop' if no topics to add.");
            String title = inputReader.nextLine();
            if (title.equals("stop")) {
                break;
            }
            String description = inputReader.nextLine();
            String source = inputReader.nextLine();
            Topic t = createTopic(title, description, source);
            list.add(t);

            //objectOut.writeObject(t);
            //System.out.println("Topic was successfully saved to file!");
        }
        return list;

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






