package com.bdconsulting.signinapplication;



import android.graphics.Bitmap;

import java.io.ByteArrayOutputStream;

public class Employees {

    private int _id;
    private String _lastname;
    private String _firstname;
    private String _phone;
    private String _email;
    private String _location;
    private String _title;
    private Bitmap _picture;

    public Employees() {
    }

    public Employees(String lastname, String firstname, String phone, String email, String location, String title, Bitmap picture) {
        this._lastname = lastname;
        this._firstname = firstname;
        this._phone = phone;
        this._email = email;
        this._location = location;
        this._title = title;
        this._picture = picture;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_lastname(String _lastname) {
        this._lastname = _lastname;
    }

    public void set_firstname(String _firstname) {
        this._firstname = _firstname;
    }

    public void set_phone(String _phone) {
        this._phone = _phone;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public void set_location(String _location) {
        this._location = _location;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    public void set_picture(Bitmap _picture) {
        this._picture = _picture;
    }

    public int get_id() {
        return _id;
    }

    public String get_lastname() {
        return _lastname;
    }

    public String get_firstname() {
        return _firstname;
    }

    public String get_phone() {
        return _phone;
    }

    public String get_email() {
        return _email;
    }

    public String get_location() {
        return _location;
    }

    public String get_title() {
        return _title;
    }

    public byte[] get_picture(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        } else {
            byte[] b = null;
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
                b = byteArrayOutputStream.toByteArray();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return b;
        }
    }
}
