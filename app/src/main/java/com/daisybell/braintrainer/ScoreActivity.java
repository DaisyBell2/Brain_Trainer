package com.daisybell.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    private TextView mTextViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        mTextViewResult = findViewById(R.id.textViewResult);
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("result")) {
            int result = intent.getIntExtra("result", 0);
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
            int max = preferences.getInt("max", 0);
            String score = String.format("Ваш результат: %s\nМаксимальный результат: %s", result, max);
            mTextViewResult.setText(score);
        }
    }

    public void onClickStartNewGame(View view) {
        Intent intent = new Intent(ScoreActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
