package com.example.homoseksualizum;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "skin")
public class SkinEntity {
    @PrimaryKey
    @NonNull
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    String name;
    String image;
    public SkinEntity(String name, String image, String id)
    {
        this.name = name;
        this.image = image;
        this.id = id;
    }
}
