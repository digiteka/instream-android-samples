package com.digiteka.digiteka_sdk_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button TopLeft;
    Button TopRight;
    Button BottomLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TopLeft = (Button)findViewById(R.id.top_left);
        TopRight = (Button)findViewById(R.id.top_right);
        BottomLeft = (Button)findViewById(R.id.bottom_left);

        TopLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Demo.class);
                intent.putExtra("top_left", 1);
                startActivity(intent);
            }
        });

        TopRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Demo.class);
                intent.putExtra("top_right", 2);
                startActivity(intent);
            }
        });

        BottomLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Demo.class);
                intent.putExtra("bottom_left", 3);
                startActivity(intent);
            }
        });

    }
}