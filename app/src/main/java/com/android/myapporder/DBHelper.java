package com.android.myapporder;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.android.myapporder.databinding.ActivityDetailBinding;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "mydatabase.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "orders";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_NUMBER = "number";
    private static final String COLUMN_PRICE = "price";
    private static final String COLUMN_IMAGE = "image";
    private static final String COLUMN_FOOD_NAME = "food_name";
    private static final String COLUMN_DESCRIPTION = "description";
    private static final String COLUMN_QUANTITY = "quantity";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_NUMBER + " TEXT, " +
                COLUMN_PRICE + " INTEGER, " +
                COLUMN_IMAGE + " INTEGER, " +
                COLUMN_FOOD_NAME + " TEXT, " +
                COLUMN_DESCRIPTION + " TEXT, " +
                COLUMN_QUANTITY + " INTEGER)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Insert method
    public boolean insertOrder(String name, String number, int price, int image, String foodName, String description, int quantity) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, name);
        contentValues.put(COLUMN_NUMBER, number);
        contentValues.put(COLUMN_PRICE, price);
        contentValues.put(COLUMN_IMAGE, image);
        contentValues.put(COLUMN_FOOD_NAME, foodName);
        contentValues.put(COLUMN_DESCRIPTION, description);
        contentValues.put(COLUMN_QUANTITY, quantity);

        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }
}

