package com.thoughtworks.go;

import com.thoughtworks.go.xml.FeedParser;

import android.app.Activity;
import android.os.Bundle;

public class GoActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        FeedParser feedParser = new FeedParser();
        feedParser.parse(getResources().openRawResource(R.raw.cctray));
        
    }
}