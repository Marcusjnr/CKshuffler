/**
 * Written By Okocha Ebube Emmanuel
 * Company GigabyteDevelopersinc/C.U.I.D
 * Licence @GigabyteDevelopersinc
 * This code must not be copied
 */

package com.cuid.gigabytedevelopersinc.ckshuffler;

import android.animation.Animator;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import cn.pedant.SweetAlert.SweetAlertDialog;


public class MainActivity extends AppCompatActivity {
    private Button btnForCreate;
    private EditText editTextForInputToCreate;
    private LinearLayout listLayout;
    private Button btnDisplay;
    private Button btnShuffleTxt;
    private Button btnGroupTxt;
    static int length;
    static int i=0;
    private EditText[] editTextCollection;
    private EditText[] editTextCollection2;
    private int[] editTextIdCollection;
    private LinearLayout[] layoutCollection;
    private EditText editText;
    private String gottenText;
    private ArrayList<String> inputList;
    private int gottenUserInputInInteger;
    final Context context = this;
    private LinearLayout linearLayout1;
    private EditText editTextForLayout;
    private int counter;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnForCreate = (Button) findViewById(R.id.btnCreateTxt);
        editTextForInputToCreate = (EditText) findViewById(R.id.textForInputToCreate);
        listLayout = (LinearLayout) findViewById(R.id.listLayout);
        btnDisplay = (Button) findViewById(R.id.btnDisplay);
        btnShuffleTxt = (Button) findViewById(R.id.btnShuffleTxt);
        btnGroupTxt = (Button)findViewById(R.id.btnGroupTxt);


        editTextForInputToCreate.animate().translationX(-1000f);



        btnForCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bringTextInputBackOnScreen();
            }
        });

        editTextForInputToCreate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(final View v, final boolean hasFocus) {
                if (hasFocus && editTextForInputToCreate.isEnabled() && editTextForInputToCreate.isFocusable()) {
                    editTextForInputToCreate.post(new Runnable() {
                        @Override
                        public void run() {
                            final InputMethodManager imm = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.showSoftInput(editTextForInputToCreate,InputMethodManager.SHOW_IMPLICIT);
                        }
                    });
                }
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

                try
                {
                    length = Integer.parseInt(editTextForInputToCreate.getText().toString());


                    editTextCollection = new EditText[length];
                    editTextIdCollection = new int[length];
                    for (i = 0; i < length; i++) {
                        editText = new EditText(MainActivity.this);
                        editText.setId(i + 1);
                        editText.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                        editText.setHint("Input" + " " + (i + 1));
                        editText.setHintTextColor(Color.WHITE);
                        editText.setInputType(2);
                        editText.setTextColor(Color.WHITE);
//                    txtForNumber.setText(i);
                        listLayout.addView(editText);
                        editTextCollection[i] = editText;
                        editTextIdCollection[i] = editText.getId();
                    }
                }catch (Exception e)
                {
                    showErrorForNoArrayForDisplay();
                }



            }


        });


        btnShuffleTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                try {
                    listLayout.removeAllViews();
                    inputList = new ArrayList<String>();

                    for (EditText et : editTextCollection)
                    {
                        gottenText = et.getText().toString();
                        inputList.add(gottenText);

                    }
                    Collections.shuffle(inputList);
                    createViews(listLayout,inputList);

                }catch (Exception e)
                {
                 showErrorForNoArray();
                }



            }


        });

        btnGroupTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listLayout.removeAllViews();
                // Creating alert Dialog with one Button
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this,R.style.DialogeTheme);


                // Setting Dialog Title
                alertDialog.setTitle("GROUP NUMBER");

                // Setting Dialog Message
                alertDialog.setMessage("Enter Group Number");
            final EditText input = new EditText(MainActivity.this);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
                input.setTextColor(Color.parseColor("#f06292"));
                input.setInputType(2);
                alertDialog.setView(input);


                // Setting Positive "Yes" Button
                alertDialog.setPositiveButton("DONE",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int which) {
                                // Write your code here to execute after dialog
                                String gottenUserInputInString = input.getText().toString();
                                 gottenUserInputInInteger = Integer.parseInt(gottenUserInputInString);

                                layoutCollection = new LinearLayout[gottenUserInputInInteger];
                                int groupNumber;

                                 for ( groupNumber = 0; groupNumber < gottenUserInputInInteger; groupNumber++)
                                 {
                                     linearLayout1 = new LinearLayout(MainActivity.this);
                                     linearLayout1.setId(i + 1);
                                     linearLayout1.setOrientation(LinearLayout.VERTICAL);
                                     linearLayout1.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                                     listLayout.addView(linearLayout1);
                                     layoutCollection[groupNumber]=linearLayout1;
                                 }

                                int numberOfTxtBoxesInEachLayout = length/gottenUserInputInInteger;
                                EditText[] layoutEditTextCollection = new EditText[numberOfTxtBoxesInEachLayout];
                                while (counter==0)
                                {
                                    counter++;
                                }

                                for (LinearLayout editLoopThrough :layoutCollection)
                                {


                                    TextView textViewForGroupNumber = new TextView(MainActivity.this);
                                    textViewForGroupNumber.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                                    textViewForGroupNumber.setGravity(Gravity.CENTER);
                                    textViewForGroupNumber.setTextColor(Color.WHITE);
                                    textViewForGroupNumber.setText("Group" + " " + counter);
                                    editLoopThrough.addView(textViewForGroupNumber);
                                    System.out.println("editloopnumber" + editLoopThrough);

                                }



                                editTextCollection2 = new EditText[numberOfTxtBoxesInEachLayout];
                                for (int l = 0; l<numberOfTxtBoxesInEachLayout; l++)
                                {

                                    for (LinearLayout loopThrough : layoutCollection)
                                    {

                                        editTextForLayout = new EditText(MainActivity.this);
                                        editTextForLayout.setId(i + 1);
                                        editTextForLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                                        editTextForLayout.setInputType(2);
                                        editTextForLayout.setTextColor(Color.WHITE);
                                        loopThrough.addView(editTextForLayout);
                                        editTextCollection2[l]=editTextForLayout;

                                    }

                                }



                            }
                        });
                // Setting Negative "NO" Button
                alertDialog.setNegativeButton("CANCEL",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Write your code here to execute after dialog
                                dialog.cancel();
                            }
                        });
                // Showing Alert Message
                alertDialog.create();
                alertDialog.show();



            }
        });




    }


    private void showErrorForNoArray()
    {
        new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                .setTitleText("Missing requirements")
                .setContentText("Oga CK, it seems like you forgot to create some fields")
                .setConfirmText("OK")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismissWithAnimation();
                    }
                })
                .show();
    }

    private void showErrorForNoArrayForDisplay()
    {
        new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                .setTitleText("Missing requirements")
                .setContentText("Sup CK, seems like you forgot to type the number of inputs to display")
                .setConfirmText("OK")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismissWithAnimation();
                    }
                })
                .show();
    }

    private void createViews( ViewGroup layout, ArrayList<String> titles) {

        for (String title : titles)
        {
            EditText editText1 =  new EditText(MainActivity.this);
            editText1.setText(title);
            editText1.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            editText1.setInputType(2);
            editText1.setTextColor(Color.WHITE);
            editText1.setHintTextColor(Color.WHITE);
            layout.addView(editText1);
        }

    }

    private void createViewsForDisplay(ViewGroup layout, EditText editText, ArrayList<String> numbers)
    {
        for (String nums : numbers)
        {
            editText.setText(nums);
            layout.addView(editText);
        }
    }




    private void bringTextInputBackOnScreen()
    {
        editTextForInputToCreate.animate().translationXBy(1000f).setDuration(2000).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                btnForCreate.setClickable(false);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });


    }

}
