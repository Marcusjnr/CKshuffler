package com.cuid.gigabytedevelopersinc.ckshuffler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {
    private Button btnForCreate;
    static EditText editTextForInputToCreate;
    private LinearLayout listLayout;
    private Button btnDisplay;
    private Button btnShuffleTxt;
    static int length;
    static int i;
    EditText[] editTextCollection;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnForCreate = (Button) findViewById(R.id.btnCreateTxt);
        editTextForInputToCreate = (EditText) findViewById(R.id.textForInputToCreate);
        listLayout = (LinearLayout) findViewById(R.id.listLayout);
        btnDisplay = (Button) findViewById(R.id.btnDisplay);
        btnShuffleTxt = (Button) findViewById(R.id.btnShuffleTxt);


        editTextForInputToCreate.animate().translationX(-1000f);



        btnForCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bringTextInputBackOnScreen();


            }
        });


        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (editTextForInputToCreate.getText().toString().length() >= 0) {
                    try {
                        listLayout.removeAllViews();

                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                }


                length = Integer.parseInt(editTextForInputToCreate.getText().toString());

                editTextCollection = new EditText[length];
                for (i = 0; i < length; i++) {
                    editText = new EditText(MainActivity.this);
                    editText.setId(i + 1);
                    editText.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    editText.setText("Input" + " " + (i + 1));
                    listLayout.addView(editText);
                    editTextCollection[i] = editText;
                }


            }


        });

        btnShuffleTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listLayout.removeAllViews();
                ArrayList<String> inputList = new ArrayList<String>();
                for (EditText et : editTextCollection)
                {
                    String gottenText = et.getText().toString();
                    inputList.add(gottenText);

                }
                Collections.shuffle(inputList);
                System.out.println(inputList);
                createViews(listLayout,inputList);

            }


        });


    }

    private void createViews( ViewGroup layout, ArrayList<String> titles) {

        for (String title : titles)
        {
            EditText editText1 =  new EditText(MainActivity.this);
            editText1.setText(title);
            editText1.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            layout.addView(editText1);
        }

    }



    private void bringTextInputBackOnScreen()
    {
        editTextForInputToCreate.animate().translationXBy(1000f).setDuration(2000);
    }

}
