package com.example.flashcardapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AddFlashcardActivity extends AppCompatActivity {

    private EditText questionInput, answerInput;
    private Button saveBtn;
    private int position = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_flashcard);

        questionInput = findViewById(R.id.questionInput);
        answerInput = findViewById(R.id.answerInput);
        saveBtn = findViewById(R.id.saveBtn);

        Intent intent = getIntent();
        if (intent.hasExtra("question")) {
            questionInput.setText(intent.getStringExtra("question"));
            answerInput.setText(intent.getStringExtra("answer"));
            position = intent.getIntExtra("position", -1);
        }

        saveBtn.setOnClickListener(v -> {
            String question = questionInput.getText().toString();
            String answer = answerInput.getText().toString();
            Intent resultIntent = new Intent();
            resultIntent.putExtra("question", question);
            resultIntent.putExtra("answer", answer);
            resultIntent.putExtra("position", position);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}