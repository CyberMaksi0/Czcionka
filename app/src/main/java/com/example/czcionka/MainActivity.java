package com.example.czcionka;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView quoteTextView;
    private Button changeQuoteButton;
    private SeekBar fontSizeSeekBar;

    private String[] quotes = {"Dzień dobry", "Good morning", "Buenos dias"};
    private int currentQuoteIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quoteTextView = findViewById(R.id.quoteTextView);
        changeQuoteButton = findViewById(R.id.changeQuoteButton);
        fontSizeSeekBar = findViewById(R.id.fontSizeSeekBar);

        quoteTextView.setTextSize(fontSizeSeekBar.getProgress());

        changeQuoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentQuoteIndex = (currentQuoteIndex + 1) % quotes.length;
                quoteTextView.setText(quotes[currentQuoteIndex]);
            }
        });

        fontSizeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                quoteTextView.setTextSize(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }
}