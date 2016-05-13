package com.nventex.cubbywords;

import android.os.Parcel;
import android.os.Parcelable;

public class WordChoice implements Parcelable {
    private String imageName;
    private boolean isAnswer;
    private String word;
    private int wordId;

    public boolean isAnswer() {
        return this.isAnswer;
    }

    public void setAnswer(boolean isAnswer) {
        this.isAnswer = isAnswer;
    }

    public String getImageName() {
        return this.imageName;
    }

    public String getWord() {
        return this.word;
    }

    public int getWordId() {
        return this.wordId;
    }

    public WordChoice(int wordId, String word, String imageName) {
        this.wordId = wordId;
        this.word = word;
        this.imageName = imageName;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
    }
}
