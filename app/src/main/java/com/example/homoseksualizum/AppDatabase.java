package com.example.homoseksualizum;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = {SkinEntity.class}, version = 1)
abstract class AppDatabase extends RoomDatabase {
    public abstract SkinDAO skinDAO();
}
