package com.thoughtworks.go.views;

import android.app.ListActivity;
import android.os.Bundle;

import com.thoughtworks.go.R;
import com.thoughtworks.go.adapters.StatusAdapter;
import com.thoughtworks.go.domain.Pipelines;
import com.thoughtworks.go.web.GoClient;

public class StatusActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.status);

		GoClient client = new GoClient(this);
		Pipelines pipelines;
		try {
			pipelines = client.getStatus();
		} catch (Exception e) {
			pipelines = new Pipelines();
			e.printStackTrace();
		}

		setListAdapter(new StatusAdapter(this, pipelines));
	}
}
