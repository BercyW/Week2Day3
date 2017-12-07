package security.bercy.com.week2day3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import security.bercy.com.week2day3.DatabaseContract;
import security.bercy.com.week2day3.Model.Animal;
import security.bercy.com.week2day3.Model.Category;

/**
 * Created by Bercy on 12/6/17.
 */

public class DatabaseOpenHelper extends SQLiteOpenHelper {

    public static final String CREATE_CATEGORY_TABLE = "create table " + DatabaseContract.CategoryEntry.TABLE_NAME + "(" +
            DatabaseContract.CategoryEntry._ID + " INTEGER PRIMARY KEY autoincrement," +
            DatabaseContract.CategoryEntry.TYPE + " TEXT," +
            DatabaseContract.CategoryEntry.BODY_TYPE + " TEXT" + ")";

    public static final String CREATE_ANIMAL_TABLE = "create table " + DatabaseContract.AnimalyEntry.TABLE_NAME + "(" +
            DatabaseContract.AnimalyEntry._ID + " INTEGER PRIMARY KEY autoincrement," +
            DatabaseContract.AnimalyEntry.NAME + " TEXT," +
            DatabaseContract.AnimalyEntry.WEIGHT + " INTEGER," +
            DatabaseContract.AnimalyEntry.TYPE + " TEXT," +
            DatabaseContract.AnimalyEntry.DESCRIPTION + " TEXT," +
            DatabaseContract.AnimalyEntry.SOUND + " TEXT," +
            " CONSTRAINT fk_animal_category FOREIGN KEY (type) REFERENCES category (type))";

    public DatabaseOpenHelper(Context context) {
        super(context, "zoo.db", null, 1);
        //saveData();

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        sqLiteDatabase.execSQL(CREATE_CATEGORY_TABLE);

        sqLiteDatabase.execSQL(CREATE_ANIMAL_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public List<Category> getCategory() {
        List<Category> categories = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();


        Cursor categoryCursor = db.rawQuery("select * from " + DatabaseContract.CategoryEntry.TABLE_NAME,
                null);


        if (categoryCursor.moveToFirst()) {
            do {
                Category c = new Category(categoryCursor.getString(1),
                        categoryCursor.getString(2)
                );

                categories.add(c);
            } while (categoryCursor.moveToNext());


        }
        return categories;

    }

    public List<Animal> getAnimal(String type) {
        List<Animal> animals = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();


        Cursor categoryCursor = db.rawQuery("select * from " + DatabaseContract.AnimalyEntry.TABLE_NAME +" where type = "+ "'"+type+"'",
                null);
        Log.d("", "getAnimal: "+categoryCursor);

        if (categoryCursor.moveToFirst()) {
            do {
                Animal animal = new Animal(categoryCursor.getString(0),
                        categoryCursor.getString(1),
                        categoryCursor.getInt(2),
                        categoryCursor.getString(3),
                        categoryCursor.getString(4)

                );

                animals.add(animal);
            } while (categoryCursor.moveToNext());


        }
        return animals;

    }

    public void insertCategory(Animal c) {


        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseContract.AnimalyEntry.NAME, c.getName());
        contentValues.put(DatabaseContract.AnimalyEntry.TYPE, c.getType());
        contentValues.put(DatabaseContract.AnimalyEntry.WEIGHT, c.getWeight());
        contentValues.put(DatabaseContract.AnimalyEntry.DESCRIPTION, c.getDescription());
        contentValues.put(DatabaseContract.AnimalyEntry.SOUND, c.getSound());
        database.insert(DatabaseContract.AnimalyEntry.TABLE_NAME, null, contentValues);

    }


    /*
       insert into data to database
     */

    public void saveData() {

//        Category c = new Category("Dog", "Small");
//        Category c1 = new Category("Cat", "Middle");
//        Category c2 = new Category("Bird", "Small");
//        insertCategory(c);
//        insertCategory(c1);
//        insertCategory(c2);

//        Animal a1 = new Animal("dog","dog",40,"Yellow","n/1");
//        Animal a2 = new Animal("lion","cat",300,"Yellow","n/a");
//        Animal a3 = new Animal("swallow","bird",5,"black","n/a");
//        Animal a4 = new Animal("tiger","cat",400,"Yellow","n/a");
//
//        insertCategory(a1);
//        insertCategory(a2);
//        insertCategory(a3);
//        insertCategory(a4);
    }

}
