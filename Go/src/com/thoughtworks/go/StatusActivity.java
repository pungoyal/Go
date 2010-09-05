package com.thoughtworks.go;

import android.app.ListActivity;
import android.os.Bundle;

import com.thoughtworks.go.adapters.PipelineAdapter;
import com.thoughtworks.go.domain.Pipelines;
import com.thoughtworks.go.web.GoClient;

public class StatusActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.status);

		GoClient client = new GoClient(this);

		Pipelines pipelines = new Pipelines();
		pipelines = client.getStatus(getResources().openRawResource(R.raw.cctray));

		setListAdapter(new PipelineAdapter(this, pipelines));
	}
}