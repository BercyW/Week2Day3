package security.bercy.com.week2day3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import security.bercy.com.week2day3.Model.Animal;

public class AnimalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);

        Intent intent = getIntent();
        String type = intent.getStringExtra("type");


        DatabaseOpenHelper databaseOpenHelper = new DatabaseOpenHelper(this);
        List<Animal> animalList = databaseOpenHelper.getAnimal(type);
        Log.d("", "onCreate: "+animalList);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        AnimalAdapter animalAdapter = new AnimalAdapter(animalList);
        recyclerView.setAdapter(animalAdapter);
    }
}
