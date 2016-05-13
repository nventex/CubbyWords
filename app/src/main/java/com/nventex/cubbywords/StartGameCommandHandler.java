package com.nventex.cubbywords;

import com.nventex.core.views.FragmentActivityManager;
import com.nventex.core.views.ICommand;
import com.nventex.core.views.ICommandHandler;
import com.nventex.core.views.ICommandResult;
import com.nventex.core.views.UnitType;

public class StartGameCommandHandler implements ICommandHandler<UnitType> {
    public void Execute(ICommand command) {
        FragmentActivityManager.ReplaceFragment(C0005R.id.mainContainer, new FragmentGame());
    }

    public ICommandResult<UnitType> getCommandResult() {
        return null;
    }
}
