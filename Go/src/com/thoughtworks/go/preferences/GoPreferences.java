package com.thoughtworks.go.preferences;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.thoughtworks.go.R;
import com.thoughtworks.go.domain.Constants;
import com.thoughtworks.go.listeners.PreferenceChangeListener;

public class GoPreferences extends PreferenceActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.settings);

		PreferenceChangeListener preferenceChangeListener = new PreferenceChangeListener(this);
		findPreference(Constants.SERVER_KEY).setOnPreferenceChangeListener(preferenceChangeListener);
	}
}
