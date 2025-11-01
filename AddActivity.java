package com.example.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    EditText dateInput, stepsInput, caloriesInput, workoutInput;
    Button saveBtn;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        dateInput = findViewById(R.id.dateInput);
        stepsInput = findViewById(R.id.stepsInput);
        caloriesInput = findViewById(R.id.caloriesInput);
        workoutInput = findViewById(R.id.workoutInput);
        saveBtn = findViewById(R.id.saveBtn);

        dbHelper = new DBHelper(this);

        saveBtn.setOnClickListener(v -> {
            String date = dateInput.getText().toString();
            int steps = Integer.parseInt(stepsInput.getText().toString());
            int calories = Integer.parseInt(caloriesInput.getText().toString());
            String workout = workoutInput.getText().toString();

            boolean result = dbHelper.insertData(date, steps, calories, workout);
            if (result) {
                Toast.makeText(this, "Data Saved!", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Error Saving Data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
