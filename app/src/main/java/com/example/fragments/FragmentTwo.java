package com.example.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class FragmentTwo extends Fragment {

    private FragmentTwoListener listener;
    private TextView textView;
    private EditText editText;
    private Button button;

    public interface FragmentTwoListener {
        void onInputTwoSent(CharSequence input2);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment_two, container, false);

        editText = v.findViewById(R.id.editText2);
        button = v.findViewById(R.id.button2);
        textView = v.findViewById(R.id.textView2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence input = editText.getText();
                listener.onInputTwoSent(input);
                CharSequence input2 = textView.getText();
                textView.setText(editText.getText());
            }
        });

        return v;
    }

    public void updateEditText(CharSequence newText) {
        editText.setText(newText);
    }
    public void updateTextView(CharSequence newText) {
        textView.setText(newText);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentTwoListener) {
            listener = (FragmentTwoListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentTwoListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}