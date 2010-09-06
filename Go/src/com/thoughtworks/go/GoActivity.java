package com.thoughtworks.go;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

import com.thoughtworks.go.preferences.GoPreferences;
import com.thoughtworks.go.views.StatusActivity;

public class GoActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		View viewStatusButton = findViewById(R.id.view_status_button);
		viewStatusButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(GoActivity.this, StatusActivity.class);
				startActivity(intent);
			}
		});

		View aboutButton = findViewById(R.id.about_button);
		aboutButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(GoActivity.this, About.class));
			}
		});

		View exitButton = findViewById(R.id.exit_button);
		exitButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.settings:
			startActivity(new Intent(this, GoPreferences.class));
			return true;
		}
		return false;
	}
}