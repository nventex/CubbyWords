package com.nventex.cubbywords;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.nventex.core.views.ButtonManager;
import com.nventex.core.views.IActivityCore;
import com.nventex.core.views.ICommandResult;
import com.nventex.core.views.ViewHelper;
import java.util.List;

public class FragmentGameResult extends Fragment implements IActivityCore {
    private View inflatedView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.inflatedView = inflater.inflate(C0005R.layout.fragment_game_results, container, false);
        ButtonManager.setButtonCommand(this.inflatedView, C0005R.id.btnTryAgain, new StartGameCommand(), new StartGameCommandHandler(), this);
        WordScoreRepository wordScoreRepository = new WordScoreRepository();
        List<GameResult> results = wordScoreRepository.GetGameResults();
        int correctAnswers = wordScoreRepository.GetCorrectAnswers();
        int incorrectAnswers = wordScoreRepository.GetIncorrectAnswers();
        ((TextView) ViewHelper.getView(this.inflatedView, (int) C0005R.id.gameResultText)).setText(String.format("You selected %1$2s correct answers and %2$2s incorrect answers.", new Object[]{Integer.valueOf(correctAnswers), Integer.valueOf(incorrectAnswers)}));
        ((ListView) ViewHelper.getView(this.inflatedView, (int) C0005R.id.gameResults)).setAdapter(new GameResultsAdapter(getActivity().getApplicationContext(), results));
        return this.inflatedView;
    }

    public void OnEventCompleted(ICommandResult commandResult, String commandHandlerName) {
    }
}
