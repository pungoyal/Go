package com.thoughtworks.go.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.thoughtworks.go.domain.Pipelines;
import com.thoughtworks.go.views.PipelineView;

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
		return new PipelineView(context, pipelines.get(position));
	}
}
