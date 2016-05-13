package com.nventex.cubbywords;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "WordBank")
public class WordBank extends Model {
    @Column(name = "imageName")
    public String imageName;
    @Column(name = "word")
    public String word;
    @Column(name = "wordId")
    public int wordId;

    public int getWordId() {
        return this.wordId;
    }

    public String getWord() {
        return this.word;
    }

    public String getImageName() {
        return this.imageName;
    }

    public WordBank(int wordId, String word, String imageName) {
        this.wordId = wordId;
        this.word = word;
        this.imageName = imageName;
    }
}
