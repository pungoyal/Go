package com.thoughtworks.go.views;

import android.content.Context;
import android.graphics.Color;
import android.widget.Button;
import android.widget.LinearLayout;

import com.thoughtworks.go.domain.BuildActivity;
import com.thoughtworks.go.domain.BuildStatus;
import com.thoughtworks.go.domain.Pipeline;

public class PipelineView extends LinearLayout {

	public PipelineView(Context context, Pipeline pipeline) {
		super(context);

		Button name = new Button(context);
		name.setText(pipeline.getName());
//		name.setBackgroundColor(getColor(BuildStatus.FAILURE, BuildActivity.BUILDING));
		name.setTextColor(Color.BLACK);
		addView(name, new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
	}

	private int getColor(BuildStatus lastStatus, BuildActivity activity) {
		if (activity == BuildActivity.BUILDING)
			return lastStatus == BuildStatus.SUCCESS ? Color.YELLOW : Color.rgb(255, 128, 64);
		return lastStatus == BuildStatus.SUCCESS ? Color.GREEN : Color.RED;
	}
}
