package nl.danielvdspoel.horsebreeds.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import nl.danielvdspoel.horsebreeds.BreedModel;

public class DatabaseControl {
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase database;

    public DatabaseControl(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }

    public void open() {
        database = databaseHelper.getWritableDatabase();
    }

    public void close() {
        databaseHelper.close();
    }

    public ArrayList<BreedModel> getAllBreeds() {
        ArrayList<BreedModel> breedModels = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM breeds", null);


        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String color = cursor.getString(2);
            String description = cursor.getString(3);

            BreedModel breedModel = new BreedModel(id, name, color, description);
            breedModels.add(breedModel);
        }

        cursor.close();
        return breedModels;
    }

    public void insert(String name, String description, String color) {
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("description", description);
        values.put("color", color);
        database.insert("breeds", null, values);
    }

    public void delete(String name) {
        database.delete("breeds", "name = " + name, null);
    }

    public BreedModel getBreed(int id) {
        Cursor cursor = database.rawQuery("SELECT * FROM breeds WHERE id = " + id, null);
        cursor.moveToFirst();
        int breedId = cursor.getInt(0);
        String name = cursor.getString(1);
        String color = cursor.getString(2);
        String description = cursor.getString(3);
        cursor.close();
        return new BreedModel(breedId, name, color, description);
    }

}
