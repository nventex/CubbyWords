package com.nventex.cubbywords;

import java.util.List;

public interface IUsedWordsRepository {
    void DeleteAll();

    UsedWords Get(int i);

    List<UsedWords> GetAll();

    void Save(UsedWords usedWords);
}
