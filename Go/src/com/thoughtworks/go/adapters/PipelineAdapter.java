package com.thoughtworks.go.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.thoughtworks.go.domain.Pipelines;
import com.thoughtworks.go.views.PipelineView;

public class PipelineAdapter extends BaseAdapter {

	private final Activity activity;
	private final Pipelines pipelines;

	public PipelineAdapter(Activity activity, Pipelines pipelines) {
		this.activity = activity;
		this.pipelines = pipelines;
	}

	@Override
	public int getCount() {
		return pipelines.size();
	}

	@Override
	public Object getItem(int position) {
		return pipelines.get(position);
	}

	@Override
	public long getItemId(int position) {
		return pipelines.get(position).getId();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return new PipelineView(activity, pipelines.get(position));
	}
}
