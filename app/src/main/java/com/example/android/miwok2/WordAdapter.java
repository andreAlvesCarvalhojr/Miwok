package com.example.android.miwok2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;


public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorReourceId;


    public WordAdapter (Activity context, ArrayList<Word> Word, int colorResourceId){
        super(context, 0, Word);
        mColorReourceId = colorResourceId;
    }


    public View getView(int position, View convertView,  ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Word currentWord = getItem(position);

        TextView MiwokTranslation = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        MiwokTranslation.setText(currentWord.getMiwokTranslation());

        TextView DefaultTranslation = (TextView) listItemView.findViewById(R.id.default_text_view);
        DefaultTranslation.setText(currentWord.getDefaultTranslation());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        if (currentWord.hasImage()){
            imageView.setImageResource(currentWord.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        }else{
            imageView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(),mColorReourceId);
        textContainer.setBackgroundColor(color);



        return listItemView;
    }

}
