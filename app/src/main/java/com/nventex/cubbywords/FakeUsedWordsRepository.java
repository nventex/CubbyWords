package com.nventex.cubbywords;

import java.util.ArrayList;
import java.util.List;

public class FakeUsedWordsRepository implements IUsedWordsRepository {
    private List<UsedWords> usedWords;

    public FakeUsedWordsRepository() {
        this.usedWords = new ArrayList();
        this.usedWords.add(new UsedWords(3, true));
    }

    public void Save(UsedWords usedWords) {
        if (Find(usedWords.getWordId()) == null) {
            this.usedWords.add(usedWords);
        } else {
            UsedWords foundUsedWord = usedWords;
        }
    }

    public List<UsedWords> GetAll() {
        return this.usedWords;
    }

    public void DeleteAll() {
        this.usedWords = new ArrayList();
    }

    public UsedWords Get(int wordId) {
        return Find(wordId);
    }

    private UsedWords Find(int wordId) {
        for (UsedWords usedWord : this.usedWords) {
            if (usedWord.getWordId() == wordId) {
                return usedWord;
            }
        }
        return null;
    }
}
