package com.nventex.cubbywords;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import com.nventex.core.sounds.SoundManager;
import com.nventex.core.views.ButtonManager;
import com.nventex.core.views.FragmentActivityManager;
import com.nventex.core.views.IActivityCore;
import com.nventex.core.views.ICommandResult;
import com.nventex.core.views.ViewHelper;
import java.util.ArrayList;
import java.util.List;

public class FragmentGame extends Fragment implements IActivityCore {
    private GameManager GameManager;
    private SoundManager SoundManager;
    private View inflatedView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            this.GameManager = (GameManager) savedInstanceState.getParcelable("GameManager");
        }
        this.inflatedView = inflater.inflate(C0005R.layout.fragment_game, container, false);
        this.SoundManager = new SoundManager(getActivity());
        List<Integer> sounds = new ArrayList();
        sounds.add(Integer.valueOf(C0005R.raw.correct));
        sounds.add(Integer.valueOf(C0005R.raw.incorrect));
        this.SoundManager.setSounds(sounds);
        IUsedWordsRepository usedWordsRepository = new UsedWordsRepository();
        if (this.GameManager == null) {
            this.GameManager = new GameManager(new WordManager(new WordRepository(), usedWordsRepository), usedWordsRepository, new WordScoreRepository());
            this.GameManager.StartNewGame();
        }
        SetButtons();
        StartQuestion();
        return this.inflatedView;
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("GameManager", this.GameManager);
    }

    public void onPause() {
        super.onPause();
        this.GameManager.PauseGame(!this.GameManager.isGameOver());
    }

    private void EndGameManager() {
        if (this.GameManager != null) {
            this.GameManager.EndGame();
            this.GameManager = null;
        }
    }

    private void SetButtons() {
        ChoiceCommandHandler choiceCommandHandler = new ChoiceCommandHandler();
        ChoiceCommand choiceCommand = new ChoiceCommand();
        ButtonManager.setButtonCommand(this.inflatedView, C0005R.id.choice1, choiceCommand, choiceCommandHandler, this);
        ButtonManager.setButtonCommand(this.inflatedView, C0005R.id.choice2, choiceCommand, choiceCommandHandler, this);
        ButtonManager.setButtonCommand(this.inflatedView, C0005R.id.choice3, choiceCommand, choiceCommandHandler, this);
        ButtonManager.setButtonCommand(this.inflatedView, C0005R.id.choice4, choiceCommand, choiceCommandHandler, this);
    }

    private void StartQuestion() {
        List<WordChoice> wordChoices = this.GameManager.GetChoices();
        this.GameManager.PauseGame(false);
        if (this.GameManager.isGameOver()) {
            FragmentActivityManager.ReplaceFragment(C0005R.id.mainContainer, new FragmentGameResult());
            EndGameManager();
            return;
        }
        SetImage(C0005R.id.choice1, (WordChoice) wordChoices.get(0));
        SetImage(C0005R.id.choice2, (WordChoice) wordChoices.get(1));
        SetImage(C0005R.id.choice3, (WordChoice) wordChoices.get(2));
        SetImage(C0005R.id.choice4, (WordChoice) wordChoices.get(3));
    }

    private void SetImage(int imageButtonId, WordChoice wordChoice) {
        ImageButton imageButton = (ImageButton) ViewHelper.getView(this.inflatedView, imageButtonId);
        imageButton.setImageResource(getResources().getIdentifier(wordChoice.getImageName(), "drawable", getActivity().getApplicationContext().getPackageName()));
        imageButton.setTag(Integer.valueOf(wordChoice.getWordId()));
        if (wordChoice.isAnswer()) {
            ((TextView) ViewHelper.getView(this.inflatedView, (int) C0005R.id.questionText)).setText(wordChoice.getWord());
        }
    }

    public void OnEventCompleted(ICommandResult commandResult, String commandHandlerName) {
        if (!commandHandlerName.equalsIgnoreCase("ChoiceCommandHandler")) {
            return;
        }
        if (this.GameManager.IsCorrectAnswer((Integer) commandResult.getResultData())) {
            this.SoundManager.playSound(C0005R.raw.correct);
            StartQuestion();
            return;
        }
        this.SoundManager.playSound(C0005R.raw.incorrect);
    }
}
