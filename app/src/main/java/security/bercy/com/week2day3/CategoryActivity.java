package security.bercy.com.week2day3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import security.bercy.com.week2day3.Model.Category;

public class CategoryActivity extends AppCompatActivity {


    List<Category> categoryList;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        DatabaseOpenHelper databaseOpenHelper = new DatabaseOpenHelper(this);
        categoryList = databaseOpenHelper.getCategory();
        ArrayAdapter<Category> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,categoryList);
        listView = findViewById(R.id.lv_category);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s = categoryList.get(i).getType();
                Intent intent = new Intent(CategoryActivity.this,AnimalActivity.class);

                intent.putExtra("type",s);
                startActivity(intent);
            }
        });

    }





}
