package com.example.demo4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 1.调用getSharedPreferences()方法获取SharedPreferences对象
        SharedPreferences sharedPreferences = getSharedPreferences("weather", Context.MODE_PRIVATE);
        // 2.通过getXXX()方法获取数据，defValue为未找到对应key-value时返回的默认值
        String weatherString = sharedPreferences.getString("weather", null);
        if (weatherString != null) {
            Intent intent = new Intent(this, WeatherActivity.class);
            startActivity(intent);
            finish();
        }
    }
    
}
