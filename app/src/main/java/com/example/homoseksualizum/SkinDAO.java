package com.example.homoseksualizum;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SkinDAO {
    @Insert
    void insertSkin(SkinEntity entity);
    @Query(value = "SELECT * FROM skin")
    List<SkinEntity> findAllSkins();
    @Query(value = "SELECT * FROM skin WHERE id = :id")
    List<SkinEntity> findSkinById(String id);



}
