package com.nventex.cubbywords;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import java.util.Date;

@Table(name = "WordScore")
public class WordScore extends Model {
    @Column(name = "createdOn")
    public Date createdOn;
    @Column(name = "sessionId")
    public String sessionId;
    @Column(name = "wordIdAnswer")
    public int wordIdAnswer;
    @Column(name = "wordIdSelected")
    public int wordIdSelected;

    public int getWordIdSelected() {
        return this.wordIdSelected;
    }

    public WordScore(String sessionId, int wordIdAnswer, int wordIdSelected) {
        this.sessionId = sessionId;
        this.wordIdAnswer = wordIdAnswer;
        this.wordIdSelected = wordIdSelected;
        this.createdOn = new Date();
    }
}
