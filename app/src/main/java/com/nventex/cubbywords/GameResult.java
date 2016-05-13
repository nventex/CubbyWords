package com.nventex.cubbywords;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;

public class GameResult extends Model {
    @Column(name = "Answered")
    public String Answered;
    @Column(name = "Question")
    public String Question;

    public GameResult(String question, String answered) {
        this.Question = question;
        this.Answered = answered;
    }
}
