package com.example.noteapp;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkTask1, checkTask2, checkTask3;
    private CheckBox checkTravel1, checkTravel2, checkTravel3;
    private FloatingActionButton fabAddNote;
    private EditText searchNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main); // Ensure this matches your XML file name

        // Initialize UI elements
        checkTask1 = findViewById(R.id.check1);
        checkTask2 = findViewById(R.id.check2);
        checkTask3 = findViewById(R.id.check3);

        checkTravel1 = findViewById(R.id.check1);
        checkTravel2 = findViewById(R.id.check2);
        checkTravel3 = findViewById(R.id.check3);

        fabAddNote = findViewById(R.id.addnote);

        // Checkboxes Click Listener
        setupCheckboxListeners();

        // Floating Action Button Click
        fabAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Add new note", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupCheckboxListeners() {
        CheckBox[] allCheckboxes = {checkTask1, checkTask2, checkTask3, checkTravel1, checkTravel2, checkTravel3};

        for (CheckBox checkBox : allCheckboxes) {
            if (checkBox != null) {
                checkBox.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        CheckBox clicked = (CheckBox) v;
                        String message = clicked.isChecked() ? "Completed: " : "Unmarked: ";
                        message += clicked.getText().toString();
                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
    }
}
