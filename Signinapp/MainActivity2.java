package com.bdconsulting.signinapplication;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class Main2Activity extends ActionBarActivity {

    EditText employeeLast;
    EditText employeeFirst;
    EditText employeePhone;
    EditText employeeEmail;
    EditText employeeLocation;
    EditText employeeTitle;
    ImageView employeePicture;

    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employees);
        employeeLast = (EditText) findViewById(R.id.employeeLast);
        employeeFirst = (EditText) findViewById(R.id.employeeFirst);
        employeePhone = (EditText) findViewById(R.id.employeePhone);
        employeeEmail = (EditText) findViewById(R.id.employeeEmail);
        employeeLocation = (EditText) findViewById(R.id.employeeLocation);
        employeeTitle = (EditText) findViewById(R.id.employeeTitle);
        employeePicture = (ImageView) findViewById(R.id.employeePicture);
        dbHandler = new MyDBHandler(this, null, null, 1);
        printDatabase();
    }

    //Add a product to the database
    public void addButtonClicked(View view){
        BitmapDrawable bd = (BitmapDrawable) employeePicture.getDrawable();
        Bitmap picture = bd.getBitmap();
        Employees employees = new Employees(
                employeeLast.getText().toString(),
                employeeFirst.getText().toString(),
                employeePhone.getText().toString(),
                employeeEmail.getText().toString(),
                employeeLocation.getText().toString(),
                employeeTitle.getText().toString(),
                picture);
        dbHandler.addEmployees(employees);
        printDatabase();
    }



    //Print the database
    public void printDatabase(){
        String dbString = dbHandler.databaseToString();
        employeeLast.setText("");
        employeeFirst.setText("");
        employeePhone.setText("");
        employeeEmail.setText("");
        employeeLocation.setText("");
        employeeTitle.setText("");


    }

}
