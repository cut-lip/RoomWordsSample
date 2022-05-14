package com.example.roomwordssample;

import android.content.Context;

import androidx.room.*;
import androidx.lifecycle.*;

// Annotate class to be room database, declare entities belonging to database
@Database(entities = {Word.class}, version = 1, exportSchema = false)
public abstract class WordRoomDatabase  extends RoomDatabase
{
    //Define DAO that works with the database (abstract getter method)
    public abstract WordDao wordDao();

    // Create WordRoom Database as a singleton to prevent multiple instances instantiated
    private static WordRoomDatabase INSTANCE;
    public static WordRoomDatabase getDatabase(final Context context)
    {
        if (INSTANCE == null)
        {
            synchronized (WordRoomDatabase.class)
            {
                if (INSTANCE == null)
                {
                    // Create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WordRoomDatabase.class, "word_database")
                            .fallbackToDestructiveMigration().build();
                            // IN real app, wouldn't want to use destructive migration
                }
            }
        }
        return INSTANCE;
    }
}
