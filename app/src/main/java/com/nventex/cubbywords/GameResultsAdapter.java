package com.nventex.cubbywords;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.nventex.core.views.ViewHelper;
import java.util.List;

public class GameResultsAdapter extends BaseAdapter {
    private final Context context;
    private final List<GameResult> gameResultList;

    public GameResultsAdapter(Context context, List<GameResult> gameResultList) {
        this.context = context;
        this.gameResultList = gameResultList;
        this.gameResultList.add(0, new GameResult("Question", "Your Answer"));
    }

    public int getCount() {
        return this.gameResultList.size();
    }

    public Object getItem(int position) {
        return this.gameResultList.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(C0005R.layout.game_result_list_item, null);
        TextView questionText = (TextView) ViewHelper.getView(convertView, (int) C0005R.id.cellQuestion);
        TextView answeredText = (TextView) ViewHelper.getView(convertView, (int) C0005R.id.cellAnswered);
        if (position == 0) {
            questionText.setTextSize(16.0f);
            answeredText.setTextSize(16.0f);
            answeredText.setTypeface(null, 1);
            questionText.setTypeface(null, 1);
            answeredText.setTypeface(null, 1);
            questionText.setTextColor(-65536);
            answeredText.setTextColor(-65536);
        }
        GameResult gameResult = (GameResult) this.gameResultList.get(position);
        questionText.setText(gameResult.Question);
        answeredText.setText(gameResult.Answered);
        return convertView;
    }
}
