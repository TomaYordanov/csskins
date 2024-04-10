package com.example.homoseksualizum;

public class SkinModel {


    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    String name;
    String image;
public void setName(String name)
{
    this.name = name;
}
    public String getName()
    {
        return name;
    }
    public void setImage(String image)
    {
        this.image = image;
    }
    public String getImage()
    {
        return image;
    }
public SkinModel(String name, String image, String id)
{
    this.name = name;
    this.image = image;
    this.id = id;
}

}
