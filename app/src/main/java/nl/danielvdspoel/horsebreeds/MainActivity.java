package nl.danielvdspoel.horsebreeds;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import nl.danielvdspoel.horsebreeds.database.DatabaseControl;

public class MainActivity extends AppCompatActivity {

    ArrayList<BreedModel> breedModels = new ArrayList<>();
    Button createBreedButton;
    BreedAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);

        createBreedButton = findViewById(R.id.createBreedButton);

        setUpBreeds();
        BreedAdapter breedAdapter = new BreedAdapter(this, breedModels);
        recyclerView.setAdapter(breedAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        createBreedButton.setOnClickListener(v -> {
            startActivity(new Intent(this, CreateBreedActivity.class));
        });
    }

    private void setUpBreeds() {
        DatabaseControl databaseControl = new DatabaseControl(this);
        databaseControl.open();
        breedModels = databaseControl.getAllBreeds();
        databaseControl.close();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpBreeds();
        BreedAdapter breedAdapter = new BreedAdapter(this, breedModels);
        recyclerView.setAdapter(breedAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}