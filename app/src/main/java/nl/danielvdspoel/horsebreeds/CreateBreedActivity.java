package nl.danielvdspoel.horsebreeds;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import nl.danielvdspoel.horsebreeds.database.DatabaseControl;

public class CreateBreedActivity extends AppCompatActivity {

    public Button backButton;
    public Button createButton;
    public EditText nameEditText;
    public EditText descriptionEditText;

    public EditText colorEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_breed);

        backButton = findViewById(R.id.backButton);
        createButton = findViewById(R.id.createButton);
        nameEditText = findViewById(R.id.nameEditText);
        descriptionEditText = findViewById(R.id.descriptionEditText);
        colorEditText = findViewById(R.id.colorEditText);

        backButton.setOnClickListener(v -> {
            finish();
        });

        createButton.setOnClickListener(v -> {
            String name = nameEditText.getText().toString();
            String description = descriptionEditText.getText().toString();
            String color = colorEditText.getText().toString();

            DatabaseControl databaseControl = new DatabaseControl(this);
            databaseControl.open();
            databaseControl.insert(name, description, color);
            databaseControl.close();
            finish();
        });
    }

}