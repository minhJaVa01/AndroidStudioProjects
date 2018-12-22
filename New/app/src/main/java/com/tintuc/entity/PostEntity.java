package com.tintuc.entity;

public class PostEntity {
    private int id;
    private String title;
    private String desc;
    private String thumb;
    private int categoryID;

    public PostEntity(int id, String title, String desc, String thumb, int categoryID) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.thumb = thumb;
        this.categoryID = categoryID;
    }

    public PostEntity(String desc){
    this.desc = desc;

}
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    @Override
    public String toString() {
        return "PostEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", thumb='" + thumb + '\'' +
                ", categoryID=" + categoryID +
                '}';
    }
}
