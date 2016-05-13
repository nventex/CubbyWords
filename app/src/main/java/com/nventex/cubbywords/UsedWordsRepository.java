package com.nventex.cubbywords;

import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import java.util.List;

public class UsedWordsRepository implements IUsedWordsRepository {
    public void Save(UsedWords usedWords) {
        usedWords.save();
    }

    public List<UsedWords> GetAll() {
        return new Select().from(UsedWords.class).execute();
    }

    public void DeleteAll() {
        new Delete().from(UsedWords.class).execute();
    }

    public UsedWords Get(int wordId) {
        return (UsedWords) new Select().from(UsedWords.class).where("wordId = ?", Integer.valueOf(wordId)).executeSingle();
    }
}
