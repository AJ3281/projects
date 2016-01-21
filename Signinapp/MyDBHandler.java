package com.bdconsulting.signinapplication;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;
import android.graphics.Bitmap;

import java.util.Date;


public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "blob.db";

    //products table

    public static final String TABLE_VISITORS = "visitors";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_LASTNAME = "lastname";
    public static final String COLUMN_FIRSTNAME = "firstname";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_CITIZEN = "citizen";
    public static final String COLUMN_ORGANIZATION = "organization";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_PICTURE = "picture";
    public static final String COLUMN_SIGNATURE = "signature";

    //employees table

    public static final String TABLE_EMPLOYEES = "employees";
    public static final String COLUMN_EID = "_eid";
    public static final String COLUMN_ELASTNAME = "elastname";
    public static final String COLUMN_EFIRSTNAME = "efirstname";
    public static final String COLUMN_EEMAIL = "eemail";
    public static final String COLUMN_ELOCATION = "elocation";
    public static final String COLUMN_EPHONE = "ephone";
    public static final String COLUMN_ETITLE = "etitle";
    public static final String COLUMN_EPICTURE = "epicture";

    //visit table

    public static final String TABLE_VISIT = "visit";
    public static final String COLUMN_VID = "_vid";
    public static final String COLUMN_VLASTNAME = "vlastname";
    public static final String COLUMN_VFIRSTNAME = "vfirstname";
    public static final String COLUMN_VIN = "vin";
    public static final String COLUMN_VOUT = "vout";



    //We need to pass database information along to superclass
    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_VISITORS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_LASTNAME + " TEXT NOT NULL, " +
                COLUMN_FIRSTNAME + " TEXT NOT NULL, " +
                COLUMN_EMAIL + " TEXT NOT NULL, " +
                COLUMN_PHONE + " TEXT NOT NULL, " +
                COLUMN_CITIZEN + " TEXT NOT NULL, " +
                COLUMN_ORGANIZATION + " TEXT NOT NULL, " +
                COLUMN_TITLE + " TEXT NOT NULL, " +
                COLUMN_PICTURE + " BLOB, " +
                COLUMN_SIGNATURE + " BLOB " +
                ");";
        String query1 = "CREATE TABLE " + TABLE_EMPLOYEES + "(" +
                COLUMN_EID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_ELASTNAME + " TEXT NOT NULL, " +
                COLUMN_EFIRSTNAME + " TEXT NOT NULL, " +
                COLUMN_EPHONE + " TEXT NOT NULL, " +
                COLUMN_EEMAIL + " TEXT NOT NULL, " +
                COLUMN_ELOCATION + " TEXT NOT NULL, " +
                COLUMN_ETITLE + " TEXT NOT NULL, " +
                COLUMN_EPICTURE + " BLOB " +
                ");";
        String query2 = "CREATE TABLE " + TABLE_VISIT + "(" +
                COLUMN_VID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_VLASTNAME + " TEXT NOT NULL, " +
                COLUMN_VFIRSTNAME + " TEXT NOT NULL, " +
                COLUMN_VIN + "  TIMESTAMP DEFAULT CURRENT_TIMESTAMP , " +
                COLUMN_VOUT + "  TIMESTAMP DEFAULT CURRENT_TIMESTAMP " +
                ");";
        db.execSQL(query);
        db.execSQL(query1);
        db.execSQL(query2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_VISITORS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMPLOYEES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_VISIT);
        onCreate(db);
    }

    //Add a new row to the database
    public void addVisitors(Visitors product, Bitmap picture, Bitmap signature) {



        ContentValues values = new ContentValues();
        values.put(COLUMN_LASTNAME, product.get_lastname());
        values.put(COLUMN_FIRSTNAME, product.get_firstname());
        values.put(COLUMN_EMAIL, product.get_email());
        values.put(COLUMN_PHONE, product.get_phone());
        values.put(COLUMN_CITIZEN, product.get_citizen());
        values.put(COLUMN_ORGANIZATION, product.get_organization());
        values.put(COLUMN_TITLE, product.get_title());
        values.put(COLUMN_PICTURE, product.get_picture(picture));
        values.put(COLUMN_SIGNATURE, product.get_signature(signature));

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_VISITORS, null, values);
        db.close();
    }

    public void addEmployees(Employees employee) {


        ContentValues values = new ContentValues();
        values.put(COLUMN_ELASTNAME, employee.get_lastname());
        values.put(COLUMN_EFIRSTNAME, employee.get_firstname());
        values.put(COLUMN_EPHONE, employee.get_phone());
        values.put(COLUMN_EEMAIL, employee.get_email());
        values.put(COLUMN_ELOCATION, employee.get_location());
        values.put(COLUMN_ETITLE, employee.get_title());
        values.put(COLUMN_EPICTURE, employee.get_picture(null));
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_EMPLOYEES, null, values);
        db.close();
    }

    public void addVisit(Visit visit) {

        Date d = new Date();
        ContentValues values = new ContentValues();
        values.put(COLUMN_VLASTNAME, visit.get_lastname());
        values.put(COLUMN_VFIRSTNAME, visit.get_firstname());
        values.put(COLUMN_VIN, visit.get_in(d));
        values.put(COLUMN_VOUT, visit.get_out(d));
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_VISIT, null, values);
        db.close();
    }

    public boolean verification(String _email) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_VISITORS + " WHERE " + COLUMN_EMAIL + "=?", new String[]{_email});
        boolean exists = c.moveToFirst();
        c.close();
        System.out.println(exists);
        return exists;



    }


    //Delete a product from the database
    public void deleteProduct(String productName){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_VISITORS + " WHERE " + COLUMN_LASTNAME + "=\"" + productName + "\";");
        db.execSQL("DELETE FROM " + TABLE_EMPLOYEES + " WHERE " + COLUMN_ELASTNAME + "=\"" + productName + "\";");
        db.execSQL("DELETE FROM " + TABLE_EMPLOYEES + " WHERE " + COLUMN_VLASTNAME + "=\"" + productName + "\";");
    }

    public String databaseToString(){
        String dbString = "";

        return dbString;
    }

}
