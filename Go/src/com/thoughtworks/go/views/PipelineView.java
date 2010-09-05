package com.thoughtworks.go.views;

import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.thoughtworks.go.domain.Pipeline;

public class PipelineView extends LinearLayout {

	public PipelineView(Context context, Pipeline pipeline) {
		super(context);
		setOrientation(VERTICAL);

		TextView name = new TextView(context);
		name.setText(pipeline.getName());
		name.setTextColor(Color.argb(255, 102, 0, 0));
		addView(name, new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
	}
}
