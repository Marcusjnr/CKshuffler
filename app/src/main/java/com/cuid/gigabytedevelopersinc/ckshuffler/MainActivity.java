package com.cuid.gigabytedevelopersinc.ckshuffler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.transitionseverywhere.ChangeBounds;
import com.transitionseverywhere.ChangeBounds;
import com.transitionseverywhere.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;


public class MainActivity extends AppCompatActivity {
    private Button btnForCreate;
    static EditText editTextForInputToCreate;
    private LinearLayout listLayout;
    private Button btnDisplay;
    private Button btnShuffleTxt;
    private Button btnGroupTxt;
    static int length;
    static int i;
    EditText[] editTextCollection;
    EditText editText;
    TextView txtForNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnForCreate = (Button) findViewById(R.id.btnCreateTxt);
        editTextForInputToCreate = (EditText) findViewById(R.id.textForInputToCreate);
        listLayout = (LinearLayout) findViewById(R.id.listLayout);
        btnDisplay = (Button) findViewById(R.id.btnDisplay);
        btnShuffleTxt = (Button) findViewById(R.id.btnShuffleTxt);
        btnGroupTxt = (Button)findViewById(R.id.btnGroupTxt);
//        txtForNumber =(TextView)findViewById(R.id.txtForNumbers);







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
                    editText.setHint("Input" + " " + (i + 1));
                    editText.setInputType(2);
//                    txtForNumber.setText(i);
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
                com.transitionseverywhere.TransitionManager.beginDelayedTransition(listLayout, new ChangeBounds());
                Collections.shuffle(inputList);
                createViews(listLayout,inputList);

            }


        });

        btnGroupTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });




    }

    private void createViews( ViewGroup layout, ArrayList<String> titles) {

        for (String title : titles)
        {
            EditText editText1 =  new EditText(MainActivity.this);
            editText1.setText(title);
            editText1.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            editText1.setInputType(2);
            com.transitionseverywhere.TransitionManager.setTransitionName(editText1,title);
            layout.addView(editText1);
        }

    }



    private void bringTextInputBackOnScreen()
    {
        editTextForInputToCreate.animate().translationXBy(1000f).setDuration(2000);
    }

}
