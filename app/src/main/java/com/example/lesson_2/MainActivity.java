package com.example.lesson_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.lesson_2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding.btnWriteWish.setOnClickListener(v ->{
            binding.etMyWish.setVisibility(View.VISIBLE);
            binding.btnPassWish.setVisibility(View.VISIBLE);
            binding.btnWriteWish.setVisibility(View.INVISIBLE);
        });
        binding.btnPassWish.setOnClickListener(v1->{
            try {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,"My message");
                emailIntent.putExtra(Intent.EXTRA_TEXT,binding.etMyWish.getText().toString());
            }catch (IllegalStateException ex){
                Toast.makeText(this, "Takpogo prolijen netu", Toast.LENGTH_SHORT).show();

            }
        });}
}