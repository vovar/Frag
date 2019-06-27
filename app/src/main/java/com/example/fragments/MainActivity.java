package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements FragmentOne.FragmentOneListener, FragmentTwo.FragmentTwoListener{

    private FragmentOne fragmentOne;
    private FragmentTwo fragmentTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentOne = new FragmentOne();
        fragmentTwo = new FragmentTwo();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment1, fragmentOne)
                .replace(R.id.fragment2, fragmentTwo)
                .commit();
    }

    @Override
    public void onInputOneSent(CharSequence input2) {
        fragmentTwo.updateEditText(input2);

    }

    @Override
    public void onInputTwoSent(CharSequence input) {
        fragmentOne.updateEditText(input);

    }

}
