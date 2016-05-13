package com.nventex.cubbywords;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "UsedWords")
public class UsedWords extends Model {
    @Column(name = "isCorrect")
    public boolean isCorrect;
    @Column(name = "wordId")
    public int wordId;

    public int getWordId() {
        return this.wordId;
    }

    public void setCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    public UsedWords(int wordId, boolean isCorrect) {
        this.wordId = wordId;
        this.isCorrect = isCorrect;
    }
}
