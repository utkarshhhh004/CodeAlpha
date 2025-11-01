package com.example.randomquote;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView quoteText, authorText;
    private Button newQuoteBtn;

    private String[][] quotes = {
            {"The best way to get started is to quit talking and begin doing.", "Walt Disney"},
            {"Don’t let yesterday take up too much of today.", "Will Rogers"},
            {"It’s not whether you get knocked down, it’s whether you get up.", "Vince Lombardi"},
            {"If you are working on something exciting, it will keep you motivated.", "Steve Jobs"},
            {"Success is not final, failure is not fatal: it is the courage to continue that counts.", "Winston Churchill"},
            {"Your time is limited, so don’t waste it living someone else’s life.", "Steve Jobs"},
            {"Believe you can and you’re halfway there.", "Theodore Roosevelt"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quoteText = findViewById(R.id.quoteText);
        authorText = findViewById(R.id.authorText);
        newQuoteBtn = findViewById(R.id.newQuoteBtn);

        showRandomQuote();

        newQuoteBtn.setOnClickListener(v -> showRandomQuote());
    }

    private void showRandomQuote() {
        Random random = new Random();
        int index = random.nextInt(quotes.length);
        quoteText.setText("\"" + quotes[index][0] + "\"");
        authorText.setText("- " + quotes[index][1]);
    }
}
