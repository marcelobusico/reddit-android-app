package com.busico.reddit.model;

import java.util.List;

public class RedditDataModel {

    private List<RedditDataModel> children;
    private RedditDataModel data;
    private String title;
    private String thumbnail;

    public List<RedditDataModel> getChildren() {
        return children;
    }

    public void setChildren(List<RedditDataModel> children) {
        this.children = children;
    }

    public RedditDataModel getData() {
        return data;
    }

    public void setData(RedditDataModel data) {
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
