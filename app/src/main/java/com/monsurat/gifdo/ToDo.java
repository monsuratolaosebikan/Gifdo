package com.monsurat.gifdo;

/**
 * Created by monsurat on 9/11/17.
 */

public class ToDo {
    int id;
    String description;
    String imageUrl;
    boolean isDone;

    ToDo(int id, String description, String imageUrl, int isDone) {
        this.id = id;
        this.description = description;
        this.imageUrl = imageUrl;
        this.isDone = isDone == 1;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(boolean done) {
        isDone = done;
    }
}