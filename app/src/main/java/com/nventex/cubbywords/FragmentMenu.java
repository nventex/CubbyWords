package com.nventex.cubbywords;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.nventex.core.views.ButtonManager;
import com.nventex.core.views.IActivityCore;
import com.nventex.core.views.ICommandResult;

public class FragmentMenu extends Fragment implements IActivityCore {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(C0005R.layout.fragment_menu, container, false);
        ButtonManager.setButtonCommand(inflatedView, C0005R.id.btnStart, new StartGameCommand(), new StartGameCommandHandler(), this);
        return inflatedView;
    }

    public void OnEventCompleted(ICommandResult commandResult, String commandHandlerName) {
    }
}
