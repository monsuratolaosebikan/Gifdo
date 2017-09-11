package com.monsurat.gifdo;

/**
 * Created by monsurat on 9/11/17.
 */

public class ToDo {
    String description;
    String imageUrl;
    boolean isDone;

    ToDo(String description, String imageUrl) {
        this.description = description;
        this.imageUrl = imageUrl;
        this.isDone = false;
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
