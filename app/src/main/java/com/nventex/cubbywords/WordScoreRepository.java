package com.nventex.cubbywords;

import com.activeandroid.Model;
import com.activeandroid.query.Select;
import java.util.List;

public class WordScoreRepository implements IWordScoreRepository {
    public void Save(WordScore wordScore) {
        wordScore.save();
    }

    public List<GameResult> GetGameResults() {
        return Model.rawQuery(GameResult.class, "select wb.Word 'Question', wb2.Word 'Answered' from WordScore ws1 join WordBank wb on ws1.wordIdAnswer = wb.Id join WordBank wb2 on ws1.wordIdSelected = wb2.Id where sessionId = ? order by ws1.Id", new String[]{GetLastSessionId()});
    }

    public String GetLastSessionId() {
        return ((WordScore) new Select("sessionId").from(WordScore.class).orderBy("Id DESC").executeSingle()).sessionId;
    }

    public int GetCorrectAnswers() {
        String sessionId = GetLastSessionId();
        return new Select().from(WordScore.class).where("sessionId = ? and wordIdAnswer = wordIdSelected", sessionId).execute().size();
    }

    public int GetIncorrectAnswers() {
        String sessionId = GetLastSessionId();
        return new Select().from(WordScore.class).where("sessionId = ? and wordIdAnswer != wordIdSelected", sessionId).execute().size();
    }
}
