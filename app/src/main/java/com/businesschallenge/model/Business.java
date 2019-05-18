package com.businesschallenge.model;


public class Business {

    private String mainName;
    private String description;
    private String image;

    /**
     * No args constructor for use in serialization
     */
    public Business() {
    }

    public Business(String mainName, String description, String image) {
        this.mainName = mainName;
        this.description = description;
        this.image = image;
    }

    public String getMainName() {
        return mainName;
    }

    public void setMainName(String mainName) {
        this.mainName = mainName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
