package com.nventex.cubbywords;

import com.activeandroid.query.Select;

public class WordRepository implements IWordRepository {
    public WordBank GetWord(int wordId) {
        return (WordBank) new Select().from(WordBank.class).where("wordId = ?", Integer.valueOf(wordId)).executeSingle();
    }
}
