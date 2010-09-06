package com.thoughtworks.go.views;

import android.app.ListActivity;
import android.os.Bundle;

import com.thoughtworks.go.R;
import com.thoughtworks.go.adapters.PipelineAdapter;
import com.thoughtworks.go.domain.Pipeline;
import com.thoughtworks.go.web.GoClient;

public class PipelineDetails extends ListActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pipeline_details);

		GoClient client = new GoClient(this);
		String name = getIntent().getExtras().getString("com.thoughtworks.go.pipeline.name");
		Pipeline pipeline;
		try {
			pipeline = client.getStatusOf(name);
		} catch (Exception e) {
			pipeline = new Pipeline(name);
			e.printStackTrace();
		}
		setListAdapter(new PipelineAdapter(this, pipeline));
	}
}
