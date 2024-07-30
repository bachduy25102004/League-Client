package com.lolclient.model;

import org.json.JSONArray;

import java.util.Arrays;

public class Champion {
    private String name;
    private String title;
    private String[] tags;
    private String image;
    private String id;


    public Champion(String id, String name, String title, String[] tags, String image) {
        this.name = name;
        this.title = title;
        this.tags = tags;
        this.id = id;
        this.image = image;

    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String[] getTags() {
        return tags;
    }

    public String getImage() {
        return image;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Champion{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", tags=" + Arrays.toString(tags) +
                ", image='" + image + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
