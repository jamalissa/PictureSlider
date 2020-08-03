package com.example.Jamal.PictureSlider;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // display the interface
         setContentView(R.layout.activity_main);


        final ImageView imageView_large = (ImageView) findViewById(R.id.imageView_large);
        SeekBar tuner = (SeekBar) findViewById(R.id.seekBar_tuner);

        // load the image file in the ImageView
        //The image is Saved in resources under drawable
        imageView_large.setImageResource(R.drawable.drawing);

        // attach a listener to the seekBar to get to know the value selected by the user
        tuner.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            // last known position of the cursor
            int lastProgress;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // update last known position of the cursor
                lastProgress = progress;
            }
                //make the color changes when the cursor is moving
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            //make the color changes when the cursor stop moving
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // the user released the cursor, apply a new colored filter to the image
                //the green value is the last value of the SeekBar and the Blue value is the opposite
                imageView_large.setColorFilter(Color.argb(255, 0, lastProgress, 255-lastProgress));
            }
        });
    }
}
