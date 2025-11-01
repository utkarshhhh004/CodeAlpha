package com.example.languagelearning;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    TextView questionWord;
    EditText answerInput;
    Button checkBtn, nextBtn;
    ArrayList<String[]> words;
    String correctAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        questionWord = findViewById(R.id.questionWord);
        answerInput = findViewById(R.id.answerInput);
        checkBtn = findViewById(R.id.checkBtn);
        nextBtn = findViewById(R.id.nextBtn);

        DBHelper dbHelper = new DBHelper(this);
        words = new ArrayList<>();
        Cursor cursor = dbHelper.getAllWords();
        while (cursor.moveToNext()) {
            words.add(new String[]{cursor.getString(1), cursor.getString(2)});
        }

        loadNewQuestion();

        checkBtn.setOnClickListener(v -> {
            String userAnswer = answerInput.getText().toString().trim();
            if (userAnswer.equalsIgnoreCase(correctAnswer)) {
                Toast.makeText(this, "✅ Correct!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "❌ Wrong! Correct: " + correctAnswer, Toast.LENGTH_SHORT).show();
            }
        });

        nextBtn.setOnClickListener(v -> loadNewQuestion());
    }

    private void loadNewQuestion() {
        Random random = new Random();
        int index = random.nextInt(words.size());
        questionWord.setText("Translate: " + words.get(index)[0]);
        correctAnswer = words.get(index)[1];
        answerInput.setText("");
    }
}
