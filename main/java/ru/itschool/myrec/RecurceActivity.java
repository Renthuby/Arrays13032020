package ru.itschool.myrec;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class RecurceActivity extends AppCompatActivity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyDraw(this));
    }
}
