package com.dboy.mylog;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Logger.setDefTag("Dboy");
        Logger.d("============MyLog=============");
        Logger.d();
        Logger.d("List", Arrays.asList("list1", "list2", "list3"));
        Logger.dd("Line", "one", "two", "three");

       ((View) findViewById(R.id.testx)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logger.d();
            }
        });
    }
}
