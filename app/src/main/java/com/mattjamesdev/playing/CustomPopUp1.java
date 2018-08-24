package com.mattjamesdev.playing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class CustomPopUp1 extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.mattjamesdev.playing.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_pop_up1);

    }

    public void goToPage2(View v){
        Intent intent = new Intent(this, CustomPopUp2.class);
        EditText txtTestField = findViewById(R.id.txtTestField);
        String testMessage = txtTestField.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, testMessage);
        startActivity(intent);
    }
}
