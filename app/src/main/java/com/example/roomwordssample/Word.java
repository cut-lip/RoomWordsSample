package com.example.roomwordssample;

import androidx.room.*;
import androidx.annotation.*;

@Entity(tableName = "word_table")
public class Word {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    private String mWord;

    public Word(@NonNull String word) {this.mWord = word;}
    public String getWord() {return this.mWord;}
}
