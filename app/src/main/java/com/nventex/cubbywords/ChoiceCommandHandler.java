package com.nventex.cubbywords;

import android.view.View;
import android.widget.ImageButton;
import com.nventex.core.views.CommandResult;
import com.nventex.core.views.ICommand;
import com.nventex.core.views.ICommandHandler;
import com.nventex.core.views.ICommandResult;
import com.nventex.core.views.ViewHelper;

public class ChoiceCommandHandler implements ICommandHandler<Integer> {
    private ChoiceCommand command;
    private Integer wordChoice;

    public void Execute(ICommand command) {
        this.command = (ChoiceCommand) command;
        View view = this.command.getView();
        this.wordChoice = (Integer) ((ImageButton) ViewHelper.getView(view, view.getId())).getTag();
    }

    public ICommandResult<Integer> getCommandResult() {
        ICommandResult<Integer> commandResult = new CommandResult();
        commandResult.setResultData(this.wordChoice);
        return commandResult;
    }
}
