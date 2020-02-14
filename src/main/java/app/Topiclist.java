package app;

import java.util.ArrayList;

import java.util.List;


public class Topiclist {

    private List<Topic> topiclist;

    public Topiclist(){
        this.topiclist = new ArrayList<>();
    }

    public void addtoList(Topic topic) {

        this.topiclist.add(topic);
    }

    public  void addToListWithIndex(int indeksi, Topic topic) {
        this.topiclist.add(indeksi, topic);
    }

    public int size() {
        return this.topiclist.size();
    }

    public Topic get(int i) {
       return this.topiclist.get(i);
    }




    /*public Topic getTopi(String name) {
        return this.topiclist.get(name);
    }*/

}
