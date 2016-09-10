package com.kesteli.filip.sciencebrowser1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Filip on 9.9.2016..
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "stranicaDB.db";
    private static final String TABLE_STRANICE = "stranice";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_SITE = "_site";
    public static final String COLUMN_HISTORY = "_history";
    public static final String COLUMN_FAVORITE = "_favorite";
    public static final String COLUMN_EUREKA = "_eureka";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PRODUCTS_TABLE =
                "CREATE TABLE " + TABLE_STRANICE
                        + "("
                        + COLUMN_ID + " INTEGER PRIMARY KEY, "
                        + COLUMN_SITE + " TEXT, "
                        + COLUMN_HISTORY + " INTEGER, "
                        + COLUMN_FAVORITE + " INTEGER, "
                        + COLUMN_EUREKA + " INTEGER"
                        + ");";
        db.execSQL(CREATE_PRODUCTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STRANICE);
        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    /**
     * Dodaj produkt metoda -> Dodaje se vrijednost unutar baze podataka
     */
    public void addStranica(Stranica stranica) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_SITE, stranica.get_site());
        contentValues.put(COLUMN_HISTORY, stranica.get_history());
        contentValues.put(COLUMN_FAVORITE, stranica.get_favorite());
        contentValues.put(COLUMN_EUREKA, stranica.get_eureka());

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(TABLE_STRANICE, null, contentValues);
        sqLiteDatabase.close();
    }

    /**
     * Get single stranica prema ID-ju
     */
    Stranica getStranicaPremaID(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_STRANICE,
                new String[]{COLUMN_ID, COLUMN_SITE, COLUMN_HISTORY, COLUMN_FAVORITE, COLUMN_EUREKA},
                COLUMN_ID + "=?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor != null)
            cursor.moveToFirst();

        Stranica contact = new Stranica(
                Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                Integer.parseInt(cursor.getString(2)),
                Integer.parseInt(cursor.getString(3)),
                Integer.parseInt(cursor.getString(4)));

        // return contact
        return contact;
    }

    /**
     * Get single stranica prema imenu stranice (site-u)
     */
    Stranica getStranicaPremaSite(String site) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                TABLE_STRANICE,
                new String[]{COLUMN_ID, COLUMN_SITE, COLUMN_HISTORY, COLUMN_FAVORITE, COLUMN_EUREKA},
                COLUMN_SITE + "=?",
                new String[]{String.valueOf(site)},
                null,
                null,
                null,
                null);
        if (cursor != null)
            cursor.moveToFirst();

        Stranica contact = new Stranica(
                Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                Integer.parseInt(cursor.getString(2)),
                Integer.parseInt(cursor.getString(3)),
                Integer.parseInt(cursor.getString(4)));

        // return contact
        return contact;
    }

    /**
     * Getting all stranice
     */
    public List<Stranica> getAllStranice() {
        List<Stranica> contactList = new ArrayList<Stranica>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_STRANICE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Stranica contact = new Stranica();
                contact.set_id(Integer.parseInt(cursor.getString(0)));
                contact.set_site(cursor.getString(1));
                contact.set_history(cursor.getInt(2));
                contact.set_favorite(cursor.getInt(3));
                contact.set_eureka(cursor.getInt(4));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        // return contact list
        return contactList;
    }

    // Updating single contact
    public int updateStranica(Stranica stranica) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_SITE, stranica.get_site());
        contentValues.put(COLUMN_HISTORY, stranica.get_history());
        contentValues.put(COLUMN_FAVORITE, stranica.get_favorite());
        contentValues.put(COLUMN_EUREKA, stranica.get_eureka());

        // updating row
        return db.update(TABLE_STRANICE,
                contentValues,
                COLUMN_ID + " = ?",
                new String[]{String.valueOf(stranica.get_id())});
    }

    /**
     * Deleting single stranica:
     */
    public void deleteStranica(Stranica stranica) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_STRANICE, COLUMN_ID + " = ?",
                new String[]{String.valueOf(stranica.get_id())});
        db.close();
    }
}

