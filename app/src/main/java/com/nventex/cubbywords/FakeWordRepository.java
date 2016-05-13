package com.nventex.cubbywords;

import java.util.ArrayList;
import java.util.List;

public class FakeWordRepository implements IWordRepository {
    private List<WordBank> words;

    public FakeWordRepository() {
        this.words = new ArrayList();
        this.words.add(new WordBank(1, "Dog", "dog"));
        this.words.add(new WordBank(2, "Bird", "bird"));
        this.words.add(new WordBank(3, "Cat", "cat"));
        this.words.add(new WordBank(4, "Fish", "fish"));
        this.words.add(new WordBank(5, "Penguin", "penguin"));
        this.words.add(new WordBank(6, "Elephant", "elephant"));
    }

    public WordBank GetWord(int wordId) {
        for (WordBank word : this.words) {
            if (word.getWordId() == wordId) {
                return word;
            }
        }
        return null;
    }
}
