package com.nventex.cubbywords;

import java.util.ArrayList;
import java.util.List;

public class FakeWordScoreRepository implements IWordScoreRepository {
    private List<WordScore> wordScores;

    public FakeWordScoreRepository() {
        this.wordScores = new ArrayList();
    }

    public void Save(WordScore wordScore) {
        this.wordScores.add(wordScore);
    }
}
