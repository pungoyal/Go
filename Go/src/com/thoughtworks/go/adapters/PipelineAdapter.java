package com.thoughtworks.go.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.thoughtworks.go.domain.Pipelines;

public class PipelineAdapter extends BaseAdapter {

	private final Context context;
	private Pipelines pipelines;

	public PipelineAdapter(Activity activity, Pipelines pipelines) {
		this.context = activity;
		this.pipelines = pipelines;
	}

	public int getCount() {
		return pipelines.size();
	}

	public Object getItem(int position) {
		return pipelines.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		TextView name = new TextView(context);
		String pipe = pipelines.get(position).toString();
		Log.d("Adapter", pipe);
		name.setText(pipe);
		name.setTextColor(Color.argb(255, 102, 0, 0));
		name.setLayoutParams(new AbsListView.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

		return name;
	}
}
