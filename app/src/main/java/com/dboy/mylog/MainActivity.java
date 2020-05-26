package com.dboy.mylog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Logger.setDefTAG("Dboy");
        Logger.d("============MyLog=============");
        Logger.d("List", Arrays.asList("list1","list2","list3"));
        Logger.dd("Line", "one","two","three");
    }
}
