package nl.danielvdspoel.horsebreeds;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import nl.danielvdspoel.horsebreeds.database.DatabaseControl;

public class BreedDetailActivity extends AppCompatActivity {

    TextView nameTextView;
    TextView colorTextView;
    TextView descriptionTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breed_detail);

        nameTextView = findViewById(R.id.nameText);
        colorTextView = findViewById(R.id.colorText);
        descriptionTextView = findViewById(R.id.descriptionText);


        int id = getIntent().getIntExtra("id", 0);
        DatabaseControl databaseControl = new DatabaseControl(this);
        databaseControl.open();
        BreedModel breedModel = databaseControl.getBreed(id);

        nameTextView.setText(breedModel.getName());
        colorTextView.setText(breedModel.getColor());
        descriptionTextView.setText(breedModel.getDescription());

        databaseControl.close();
    }
}