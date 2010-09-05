package com.thoughtworks.go.views;

import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.thoughtworks.go.domain.BuildActivity;
import com.thoughtworks.go.domain.BuildStatus;
import com.thoughtworks.go.domain.Pipeline;

public class PipelineView extends LinearLayout {

	public PipelineView(Context context, Pipeline pipeline) {
		super(context);

		TextView name = new TextView(context);
		name.setText(pipeline.getName());
		name.setTextColor(getColor(pipeline.getLastBuildStatus(), pipeline.getActivity()));
		addView(name, new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
	}

	private int getColor(BuildStatus lastStatus, BuildActivity activity) {

		if (activity == BuildActivity.BUILDING) {
			return lastStatus == BuildStatus.SUCCESS ? Color.YELLOW : Color.parseColor("#FFFF8040");
		}

		return lastStatus == BuildStatus.SUCCESS ? Color.GREEN : Color.RED;
	}
}
