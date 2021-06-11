package com.ryfa.spannablewords;

import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.widget.TextView;

import java.util.ArrayList;

public class SpannableWords extends SpannableStringBuilder {

    private int flag = Spannable.SPAN_EXCLUSIVE_EXCLUSIVE;

    public SpannableWords() {
        super("");
    }

    public SpannableWords(CharSequence text) {
        super(text);
    }

    /**
     * Appends the character sequence {@code text} and spans {@code spans} over the appended part.
     *
     * @param text  the character sequence to append.
     * @param spans the object or objects to be spanned over the appended text.
     * @return this {@code Spanny}.
     */
    public SpannableWords append(CharSequence text, Object... spans) {
        append(text);
        for (Object span : spans) {
            setSpan(span, length() - text.length(), length());
        }
        return this;
    }

    /**
     * Append plain text.
     *
     * @return this {@code SpannableWords}.
     */
    @Override
    public SpannableWords append(CharSequence text) {
        super.append(text);
        return this;
    }

    public SpannableWords findAndSpan(String target, GetSpan getSpan) {

        ArrayList<String> words = new ArrayList<>();
        String[] splitOne = toString().split("\\W+");

        for (int i = 0; i < splitOne.length; i++) {
                words.add(splitOne[i]);
        }

        for (int i = 0; i < words.size(); i++) {

            if (words.get(i).equals(target)) {
                int startSpan = 0, endSpan = 0;
                startSpan = toString().indexOf(words.get(i));
                endSpan = startSpan + words.get(i).length();

                if (startSpan < 0)
                    break;

                if (endSpan > length())
                    break;

                setSpan(getSpan.getSpan(), startSpan, endSpan);
            }
        }
        return this;
    }

    public SpannableWords findAndSpan(String target, boolean contains, boolean toLowerCase, GetSpan getSpan) {

        String[] split = toString().split("\\W+");

        for (int i = 0; i < split.length; i++) {
            String word;
            String currentTarget;
            if (toLowerCase) {
                word = split[i].toLowerCase();
                currentTarget = target.toLowerCase();
            } else {
                word = split[i];
                currentTarget = target;
            }

            if (contains) {
                if (word.contains(currentTarget)) {
                    int startSpan = 0, endSpan = 0;
                    startSpan = toString().indexOf(split[i]);
                    endSpan = startSpan + split[i].length();

                    if (startSpan < 0)
                        break;

                    if (endSpan > length())
                        break;

                    setSpan(getSpan.getSpan(), startSpan, endSpan);
                }
            } else {
                if (word.equals(currentTarget)) {
                    int startSpan = 0, endSpan = 0;
                    startSpan = toString().indexOf(split[i]);
                    endSpan = startSpan + split[i].length();

                    if (startSpan < 0)
                        break;

                    if (endSpan > length())
                        break;

                    setSpan(getSpan.getSpan(), startSpan, endSpan);
                }
            }
        }
        return this;
    }

    /**
     * Mark the specified range of text with the specified object.
     * The flags determine how the span will behave when text is
     * inserted at the start or end of the span's range.
     */
    private void setSpan(Object span, int start, int end) {
        setSpan(span, start, end, flag);
    }


    public interface GetSpan {

        /**
         * @return A new span object should be returned.
         */
        Object getSpan();
    }
}
