package com.ryfa.spanwords;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.widget.TextView;

import com.ryfa.spannablewords.SpannableWords;
import com.ryfa.spanwords.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SpannableWords spanOne = new SpannableWords()
                .append("Hello", new StyleSpan(Typeface.BOLD_ITALIC))
                .append(" my friends", new UnderlineSpan());

        binding.tvOne.setText(spanOne);

        String text = "Hello my        friends";
        SpannableWords spanTwo = new SpannableWords(text).findAndSpan("friends", false, true, new SpannableWords.GetSpan() {
            @Override
            public Object getSpan() {
                return new StyleSpan(Typeface.BOLD_ITALIC);
            }
        });

        binding.tvTwo.setText(spanTwo);


    }
}