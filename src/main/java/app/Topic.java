package app;

import java.io.Serializable;
import java.time.LocalDate;

public class Topic implements Serializable {
    private static int id;
    private final int idcount;
    private String title;
    private String description;
    private String additionalSource;
    private boolean complete;
    private LocalDate creationDate;
    private LocalDate completionDate;


    public Topic (String title, String description, String additionalSource) {
        this.title = title;
        this.description = description;
        this.additionalSource = additionalSource;
        this.complete = false;
        this.creationDate = LocalDate.now();
        this.idcount = id++;
    }

    public void complete() {
        this.complete = true;
        this.completionDate = LocalDate.now();
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return  this.title + " , " + this.description + " , " + this.additionalSource + "\n"
                + "Created on: " + this.creationDate + "\n" +
                "Complete? " + this.complete + " , " + "Completion date: " + this.completionDate + "\n" +
                "TopicID: " + this.idcount + "\n";

    }


}

