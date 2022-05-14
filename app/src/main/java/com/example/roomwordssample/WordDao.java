package com.example.roomwordssample;

import java.util.List;
import androidx.room.*;
import androidx.annotation.*;
import androidx.lifecycle.*;

@Dao
public interface WordDao
{
    @Insert
    void insert(Word word);

    @Query("DELETE FROM word_table")  //No convenience annotation for deleting multiple entities
    void deleteAll();

    @Query("SELECT * from word_table ORDER BY word ASC")
    LiveData<List<Word>> getAllWords();
}
