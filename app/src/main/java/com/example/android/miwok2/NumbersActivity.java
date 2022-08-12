package com.example.android.miwok2;

import android.media.MediaPlayer;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> Words = new ArrayList<Word>();
        Words.add (new Word("One","Lutti",R.drawable.number_one,R.raw.number_one));
        Words.add (new Word("Two","Otiiko",R.drawable.number_two,R.raw.number_two));
        Words.add (new Word("Three","Tolookosu",R.drawable.number_three,R.raw.number_three));
        Words.add (new Word("Four","Oyyisa",R.drawable.number_four,R.raw.number_four));
        Words.add (new Word("Five","Massokka",R.drawable.number_five,R.raw.number_five));
        Words.add (new Word("Six","temmokka",R.drawable.number_six,R.raw.number_six));
        Words.add (new Word("Seven","kenekaku",R.drawable.number_seven,R.raw.number_seven));
        Words.add (new Word("Eight","kawinta",R.drawable.number_eight,R.raw.number_eight));
        Words.add (new Word("Nine","wo'e",R.drawable.number_nine,R.raw.number_nine));
        Words.add (new Word("Ten","na'aacha",R.drawable.number_ten,R.raw.number_ten));


        WordAdapter itemsAdapter = new WordAdapter(this,Words,R.color.category_numbers);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                releaseMediaPlayer();
                Word word = Words.get(position);
                Log.v("NumbersActivity", "Current word: " + word);
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getmAudioResourceId());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }


        });
    }
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        if (mMediaPlayer != null){
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

}
