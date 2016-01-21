package com.bdconsulting.signinapplication;

import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;

public class Visitors {

    private int _id;
    private String _lastname;
    private String _firstname;
    private String _email;
    private String _phone;
    private String _citizen;
    private String _organization;
    private String _title;
    public Bitmap _picture;
    public Bitmap _signature;

    public Visitors() {
    }


    public Visitors(String email) {
        this._email = email;
    }

    public Visitors(String lastname, String firstname) {
        this._firstname = firstname;
        this._lastname = lastname;
    }

    public Visitors(String lastname, String firstname, String email) {
        this._lastname = lastname;
        this._firstname = firstname;
        this._email = email;
    }

    public Visitors(String lastname, String firstname, String email, String phone) {
        this._lastname = lastname;
        this._firstname = firstname;
        this._email = email;
        this._phone = phone;
    }

    public Visitors(String lastname, String firstname, String email, String phone, String citizen) {
        this._lastname = lastname;
        this._firstname = firstname;
        this._email = email;
        this._phone = phone;
        this._citizen = citizen;
    }

    public Visitors(String lastname, String firstname, String email, String phone, String citizen, String organization) {
        this._lastname = lastname;
        this._firstname = firstname;
        this._email = email;
        this._phone = phone;
        this._citizen = citizen;
        this._organization = organization;
    }


    public Visitors(String lastname, String firstname, String email, String phone, String citizen, String organization, String title) {
        this._lastname = lastname;
        this._firstname = firstname;
        this._email = email;
        this._phone = phone;
        this._citizen = citizen;
        this._organization = organization;
        this._title = title;
    }

    public Visitors(String lastname, String firstname, String email, String phone, String citizen, String organization, String title, Bitmap picture) {
        this._lastname = lastname;
        this._firstname = firstname;
        this._email = email;
        this._phone = phone;
        this._citizen = citizen;
        this._organization = organization;
        this._title = title;
        this._picture = picture;
    }

    public Visitors(String lastname, String firstname, String email, String phone, String citizen, String organization, String title, Bitmap picture, Bitmap signature) {
        this._lastname = lastname;
        this._firstname = firstname;
        this._email = email;
        this._phone = phone;
        this._citizen = citizen;
        this._organization = organization;
        this._title = title;
        this._picture = picture;
        this._signature = signature;
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

    public void set_email(String _email) {
        this._email = _email;
    }

    public void set_phone(String _phone) {
        this._phone = _phone;
    }

    public void set_citizen(String _citizen) {
        this._citizen = _citizen;
    }

    public void set_organization(String _organization) {
        this._organization = _organization;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    public void set_picture(Bitmap _picture) {
        this._picture = _picture;
    }

    public void set_signature(Bitmap _signature) {
        this._signature = _signature;
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

    public String get_email() {
        return _email;
    }

    public String get_phone() {
        return _phone;
    }

    public String get_citizen() {
        return _citizen;
    }

    public String get_organization() {
        return _organization;
    }

    public String get_title() {
        return _title;
    }

    public byte[] get_picture(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
        return stream.toByteArray();
    }

    public byte[] get_signature(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
        return stream.toByteArray();
    }
}
