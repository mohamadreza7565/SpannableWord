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

        String text = "\n" +
                "Point it at me.\n" +
                "Like you're gonna shoot me.\n" +
                "\n" +
                "Go ahead.\n" +
                "\n" +
                "Come on.\n" +
                "\n" +
                "That the way you hold a gun?\n" +
                "\n" +
                "That's the way I hold it, yeah\n";
        SpannableWords spanTwo = new SpannableWords(text).findAndSpan("friends", false, true, new SpannableWords.GetSpan() {
            @Override
            public Object getSpan() {
                return new StyleSpan(Typeface.BOLD_ITALIC);
            }
        });

        binding.tvTwo.setText(spanTwo);


    }
}