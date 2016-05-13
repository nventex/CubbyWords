package com.nventex.cubbywords;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WordManager {
    public int MaxWords;
    private int correctWordId;
    private final IUsedWordsRepository usedWordsRepository;
    private final List<WordBank> wordBanks;
    private final List<WordChoice> wordChoices;
    private final List<Integer> wordIdList;
    private final IWordRepository wordRepository;

    public int getCorrectWordId() {
        return this.correctWordId;
    }

    public void setCorrectWordId(int correctWordId) {
        this.correctWordId = correctWordId;
    }

    public WordManager(IWordRepository wordRepository, IUsedWordsRepository usedWordsRepository) {
        this.wordIdList = new ArrayList();
        this.wordChoices = new ArrayList();
        this.wordBanks = new ArrayList();
        this.MaxWords = 50;
        this.wordRepository = wordRepository;
        this.usedWordsRepository = usedWordsRepository;
        PopulateLists();
    }

    private void PopulateLists() {
        for (int i = 1; i < this.MaxWords; i++) {
            this.wordIdList.add(Integer.valueOf(i));
        }
    }

    public List<WordChoice> GetChoices() {
        this.wordBanks.clear();
        this.wordChoices.clear();
        WordBank wordBank = GetAnswer();
        if (wordBank != null) {
            GetAlternates(wordBank);
            SetChoices();
        }
        return this.wordChoices;
    }

    private WordBank GetAnswer() {
        List<UsedWords> usedWords = this.usedWordsRepository.GetAll();
        List<Integer> wordIdsToShuffle = new ArrayList(this.wordIdList);
        for (UsedWords usedWord : usedWords) {
            wordIdsToShuffle.remove(Integer.valueOf(usedWord.getWordId()));
        }
        if (wordIdsToShuffle.isEmpty()) {
            return null;
        }
        Collections.shuffle(wordIdsToShuffle);
        WordBank wordBank = this.wordRepository.GetWord(((Integer) wordIdsToShuffle.get(0)).intValue());
        this.wordBanks.add(wordBank);
        return wordBank;
    }

    private void GetAlternates(WordBank wordBank) {
        List<Integer> wordIdsToShuffle = new ArrayList(this.wordIdList);
        wordIdsToShuffle.remove(Integer.valueOf(wordBank.getWordId()));
        Collections.shuffle(wordIdsToShuffle);
        this.wordBanks.add(this.wordRepository.GetWord(((Integer) wordIdsToShuffle.get(0)).intValue()));
        this.wordBanks.add(this.wordRepository.GetWord(((Integer) wordIdsToShuffle.get(1)).intValue()));
        this.wordBanks.add(this.wordRepository.GetWord(((Integer) wordIdsToShuffle.get(2)).intValue()));
    }

    private void SetChoices() {
        for (WordBank wordBank : this.wordBanks) {
            this.wordChoices.add(new WordChoice(wordBank.getWordId(), wordBank.getWord(), wordBank.getImageName()));
        }
        setCorrectWordId(((WordChoice) this.wordChoices.get(0)).getWordId());
        ((WordChoice) this.wordChoices.get(0)).setAnswer(true);
        this.usedWordsRepository.Save(new UsedWords(this.correctWordId, false));
        Collections.shuffle(this.wordChoices);
    }
}
