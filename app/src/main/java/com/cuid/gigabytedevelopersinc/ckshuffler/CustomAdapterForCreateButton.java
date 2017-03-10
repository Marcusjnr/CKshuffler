package com.cuid.gigabytedevelopersinc.ckshuffler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Emmanuel on 2/7/2017.
 */

 class CustomAdapterForCreateButton extends ArrayAdapter <Integer> {




    CustomAdapterForCreateButton(Context context, ArrayList<Integer>newTextBoxes)
    {
        super(context, R.layout.custom_list_view_for_btncreate ,newTextBoxes);
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View customView = layoutInflater.inflate(R.layout.custom_list_view_for_btncreate,parent,false);

//        int singleSubject = getItem(position);

        EditText singleText = (EditText) customView.findViewById(R.id.textViewForCustom);
        TextView showLineNumbers = (TextView) customView.findViewById(R.id.showLineNumbers);
        showLineNumbers.setText( String.valueOf(position+1));


//        singleText.setText(singleSubject);





        return customView;
    }

    @Override
    public int getCount() {

       return MainActivity.length;
    }
}
