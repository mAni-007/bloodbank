package com.example.mani.datbase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class helper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "BloodManager";

    // Table Names
    private static final String TABLE_BLOOD = "blood_bank";


    // Common column names
    private static final String ID = "id";
    private static final String SQL_ID = "sqlid";
    private static final String NAME = "name";
    private static final String BLOODGROUP = "bloodgroup";
    private static final String HOSTEL = "bloodgroup";
    private static final String AGE = "bloodgroup";
    private static final String GENDER = "bloodgroup";





    // Table Create Statements
    // Todo table create statement
    private static final String CREATE_TABLE_BLOOD = "CREATE TABLE "
            + TABLE_BLOOD + "(" + ID + " INTEGER PRIMARY KEY,"  + NAME
            + " TEXT," + SQL_ID +" INTEGER," + BLOODGROUP +" TEXT," + GENDER +" TEXT," + AGE +" TEXT," + HOSTEL +" TEXT" + ")";


    public helper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables
        db.execSQL(CREATE_TABLE_BLOOD);
        Log.i("blood", "done");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BLOOD);

        // create new tables
        onCreate(db);
    }

    /*
 * Creating a blood
 */
    public long createBlood(Blood blood) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ID, blood.getId());
        values.put(SQL_ID, blood.getsqlId());
        values.put(NAME, blood.getName());
        values.put(BLOODGROUP, blood.getBloodgroup());
        values.put(GENDER, blood.getGender());
        values.put(AGE, blood.getAge());
        values.put(HOSTEL, blood.getHostel());




        // insert row
        long blood_id = db.insert(TABLE_BLOOD, null, values);


        return blood_id;
    }

    /*
 * get single BLOOD
 */
    public Blood getBlood(long blood_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_BLOOD + " WHERE "
                + ID + " = " +blood_id;

        //Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);
        Blood blood = new Blood();
        if (c.moveToFirst()) {

            blood.setId(c.getInt(c.getColumnIndex(ID)));
            blood.setName((c.getString(c.getColumnIndex(NAME))));
            blood.setGender((c.getString(c.getColumnIndex(GENDER))));
            blood.setAge((c.getString(c.getColumnIndex(AGE))));
            blood.setHostel((c.getString(c.getColumnIndex(HOSTEL))));
            blood.setBloodgroup((c.getString(c.getColumnIndex(BLOODGROUP))));

        }

        return blood;
    }


    /*
 * getting all bloods
 * */

    public List<Blood> getAllBloods() {
        List<Blood> bloods = new ArrayList<Blood>();
        String selectQuery = "SELECT  * FROM " + TABLE_BLOOD;


        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Blood blood = new Blood();
                blood.setId(c.getInt(c.getColumnIndex(ID)));
                blood.setName((c.getString(c.getColumnIndex(NAME))));
                blood.setGender((c.getString(c.getColumnIndex(GENDER))));
                blood.setAge((c.getString(c.getColumnIndex(AGE))));
                blood.setHostel((c.getString(c.getColumnIndex(HOSTEL))));
                blood.setBloodgroup((c.getString(c.getColumnIndex(BLOODGROUP))));

                // adding to blood list
                bloods.add(blood);
            } while (c.moveToNext());
        }

        return bloods;
    }

    /*
 * getting all bloods under single tag
 * */

    /*
     * Updating a blood
     */


    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }
}
