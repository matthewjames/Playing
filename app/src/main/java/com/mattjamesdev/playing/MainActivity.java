package com.mattjamesdev.playing;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.mattjamesdev.playing.MESSAGE";
    public static int size = 100, upperBound = 250;

    /******** POP UP VARIABLES ********/
    Dialog popUpDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /******* GRAPH VIEW TEST ********/
        GraphView graph = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(
                generateDataPointSet(size, upperBound)
        );
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(0);
        graph.getViewport().setMaxY(upperBound);

        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(4);
        graph.getViewport().setMaxX(size);

        graph.getViewport().setScalable(true);
        graph.getViewport().setScalableY(true);

        graph.addSeries(series);
        /*******************************/

        /********* POP UP TEST *********/
        popUpDialog = new Dialog(this);
        /*******************************/
    }

    public void ShowPopUp(View v){
        TextView txtPage1;
        TextView txtPage2;
        TextView txtPage3;
        Button btnPage1Next;
        Button btnPage2Prev;
        Button btnPage2Next;
        Button btnPage3Prev;

        popUpDialog.setContentView(R.layout.activity_custom_pop_up1);
        txtPage1 = (TextView) popUpDialog.findViewById(R.id.txtPage1);


        popUpDialog.show();
    }

    public void sendMessage(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    public DataPoint[] generateDataPointSet(int size, int upperBound){
        Random rand = new Random();
        DataPoint[] set = new DataPoint[size];

        for(int i = 0; i < size; i++){
            set[i] = new DataPoint(i, rand.nextInt(upperBound));
        }

        return set;
    }
}
