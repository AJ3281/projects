package com.bdconsulting.signinapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class Main3Activity extends ActionBarActivity {

    EditText visitLast;
    EditText visitFirst;
    EditText visitIn;
    EditText visitOut;

    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visit);
        visitLast = (EditText) findViewById(R.id.visitLast);
        visitFirst = (EditText) findViewById(R.id.visitFirst);
        visitIn = (EditText) findViewById(R.id.visitIn);
        visitOut = (EditText) findViewById(R.id.visitOut);
        dbHandler = new MyDBHandler(this, null, null, 1);
        printDatabase();
    }

    //Add a product to the database
    public void addButtonClicked(View view){

        Visit visit = new Visit(
                visitLast.getText().toString(),
                visitFirst.getText().toString()

        );
        dbHandler.addVisit(visit);
        printDatabase();
    }



    //Print the database
    public void printDatabase(){
        String dbString = dbHandler.databaseToString();
        visitLast.setText("");
        visitFirst.setText("");

    }

}
