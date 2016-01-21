package com.bdconsulting.signinapplication;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Visit {

    private int _id;
    private String _lastname;
    private String _firstname;
    private Timestamp _in;
    private Timestamp _out;
    private String _elastname;
    private String _efirstname;

    public Visit() {
    }

    public Visit(String lastname, String firstname) {
        this._lastname = lastname;
        this._firstname = firstname;
    }

    public Visit(String lastname, String firstname, Timestamp in, Timestamp out) {
        this._lastname = lastname;
        this._firstname = firstname;
        this._in = in;
        this._out = out;
    }

    public Visit(String lastname, String firstname, Timestamp in, Timestamp out, String elastname, String efirstname) {
        this._lastname = lastname;
        this._firstname = firstname;
        this._in = in;
        this._out = out;
        this._elastname = elastname;
        this._efirstname = efirstname;
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

    public void set_in(Timestamp _in) {
        this._in = _in;
    }

    public void set_out(Timestamp _out) {
        this._out = _out;
    }

    public void set_elastname(String _elastname) {
        this._elastname = _elastname;
    }

    public void set_efirstname(String _efirstname) {
        this._efirstname = _efirstname;
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

    public String get_elastname() {
        return _elastname;
    }

    public String get_efirstname() {
        return _efirstname;
    }

    private static final DateFormat DATE_FORMAT =
            new SimpleDateFormat("dd/MM/yy HH:mm");

    public String get_in(Date date) {
        return DATE_FORMAT.format(date);
    }

    public String get_out(Date date) {
        return DATE_FORMAT.format(date);
    }
}
