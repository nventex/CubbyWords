package com.nventex.cubbywords;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import java.util.UUID;

public class GameManager implements Parcelable {
    private List<WordChoice> choices;
    private boolean isGameOver;
    private boolean isGamePaused;
    private String sessionId;
    private final IUsedWordsRepository usedWordsRepository;
    private final WordManager wordManager;
    private IWordScoreRepository wordScoreRepository;

    public boolean isGameOver() {
        return this.isGameOver;
    }

    public boolean isGamePaused() {
        return this.isGamePaused;
    }

    public int getCorrectAnswer() {
        return this.wordManager.getCorrectWordId();
    }

    public GameManager(WordManager wordManager, IUsedWordsRepository usedWordsRepository, IWordScoreRepository wordScoreRepository) {
        this.isGameOver = false;
        this.isGamePaused = false;
        this.wordManager = wordManager;
        this.usedWordsRepository = usedWordsRepository;
        this.wordScoreRepository = wordScoreRepository;
    }

    public void StartNewGame() {
        this.sessionId = UUID.randomUUID().toString();
        this.wordManager.setCorrectWordId(0);
        this.usedWordsRepository.DeleteAll();
        this.isGameOver = false;
    }

    public void EndGame() {
        this.sessionId = BuildConfig.FLAVOR;
        this.wordManager.setCorrectWordId(0);
        this.usedWordsRepository.DeleteAll();
        this.isGameOver = true;
    }

    public void PauseGame(boolean pause) {
        this.isGamePaused = pause;
    }

    public List<WordChoice> GetChoices() {
        if (!isGamePaused()) {
            this.choices = this.wordManager.GetChoices();
        }
        this.isGameOver = this.choices.isEmpty();
        return this.choices;
    }

    public boolean IsCorrectAnswer(Integer selectedWordId) {
        this.wordScoreRepository.Save(new WordScore(this.sessionId, getCorrectAnswer(), selectedWordId.intValue()));
        boolean isCorrect = selectedWordId.intValue() == getCorrectAnswer();
        UsedWords usedWord = this.usedWordsRepository.Get(getCorrectAnswer());
        usedWord.setCorrect(isCorrect);
        this.usedWordsRepository.Save(usedWord);
        return isCorrect;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
    }
}
