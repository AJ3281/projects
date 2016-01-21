
package com.bdconsulting.signinapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    TextView buckysText;
    EditText buckysLast;
    EditText buckysFirst;
    EditText buckysEmail;
    EditText buckysPhone;
    EditText buckysCitizen;
    EditText buckysOrganization;
    EditText buckysTitle;
    ImageView buckysPicture;
    ImageView buckysSignature;
    MyDBHandler dbHandler;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buckysLast = (EditText) findViewById(R.id.buckysLast);
        buckysFirst = (EditText) findViewById(R.id.buckysFirst);
        buckysEmail = (EditText) findViewById(R.id.buckysEmail);
        buckysPhone = (EditText) findViewById(R.id.buckysPhone);
        buckysCitizen = (EditText) findViewById(R.id.buckysCitizen);
        buckysOrganization = (EditText) findViewById(R.id.buckysOrganization);
        buckysTitle = (EditText) findViewById(R.id.buckysTitle);
        buckysText = (TextView) findViewById(R.id.buckysText);
        buckysPicture = (ImageView) findViewById(R.id.buckysPicture);
        buckysSignature = (ImageView) findViewById(R.id.buckysSignature);
        dbHandler = new MyDBHandler(this, null, null, 1);
        printDatabase();
        addListenerOnButton();
    }

    //Add a product to the database
    public void addButtonClicked(View view){
        BitmapDrawable bd = (BitmapDrawable) buckysPicture.getDrawable();
        Bitmap picture = bd.getBitmap();
       BitmapDrawable bd2 = (BitmapDrawable) buckysSignature.getDrawable();
        Bitmap signature = bd2.getBitmap();
        Visitors visitors = new Visitors(
                buckysLast.getText().toString(),
                buckysFirst.getText().toString(),
                buckysEmail.getText().toString(),
                buckysPhone.getText().toString(),
                buckysCitizen.getText().toString(),
                buckysOrganization.getText().toString(),
                buckysTitle.getText().toString());
        dbHandler.addVisitors(visitors, picture, signature);
        printDatabase();
    }

    public void verifyButtonClicked (View view) {

        dbHandler.verification(buckysEmail.getText().toString());
        printDatabase();
    }

    //Delete items
    public void deleteButtonClicked(View view){
        String inputLast = buckysLast.getText().toString();
        String inputFirst = buckysFirst.getText().toString();
        String inputEmail = buckysEmail.getText().toString();
        String inputPhone = buckysPhone.getText().toString();
        String inputOrganization = buckysOrganization.getText().toString();
        String inputCitizen = buckysCitizen.getText().toString();
        String inputTitle = buckysTitle.getText().toString();

        dbHandler.deleteProduct(inputLast);
        dbHandler.deleteProduct(inputFirst);
        dbHandler.deleteProduct(inputEmail);
        dbHandler.deleteProduct(inputPhone);
        dbHandler.deleteProduct(inputOrganization);
        dbHandler.deleteProduct(inputCitizen);
        dbHandler.deleteProduct(inputTitle);
        printDatabase();
    }

    //Print the database
    public void printDatabase(){
        String dbString = dbHandler.databaseToString();
        buckysText.setText(dbString);
        buckysLast.setText("");
        buckysFirst.setText("");
        buckysEmail.setText("");
        buckysPhone.setText("");
        buckysCitizen.setText("");
        buckysOrganization.setText("");
        buckysTitle.setText("");

    }

    public void addListenerOnButton() {

        final Context context = this;

        button = (Button) findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, Main2Activity.class);
                startActivity(intent);

            }

        });

    }
}
