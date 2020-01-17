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

}
