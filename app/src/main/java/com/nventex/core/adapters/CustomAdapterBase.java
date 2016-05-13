package com.nventex.core.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

public abstract class CustomAdapterBase<T> extends BaseAdapter {
    private final Activity activity;
    private final int customListItemViewId;
    private final List<T> items;

    protected abstract void setItem(View view, int i);

    public CustomAdapterBase(List<T> items, Activity activity, int customListItemViewId) {
        this.items = items;
        this.activity = activity;
        this.customListItemViewId = customListItemViewId;
    }

    public int getCount() {
        return this.items.size();
    }

    public Object getItem(int position) {
        return this.items.get(position);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = ((LayoutInflater) this.activity.getSystemService("layout_inflater")).inflate(this.customListItemViewId, parent, false);
        }
        setItem(convertView, position);
        return convertView;
    }
}
