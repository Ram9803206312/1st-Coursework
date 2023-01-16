package com.ram.ramnepali;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
  private   Button btnSlider;
  int count = 1;
    FirstFragment firsFragment = new FirstFragment();
    SecondFragment secondFragment = new SecondFragment();
    ThirdFragment thirdFragment = new ThirdFragment();
    @SuppressLint("SetTextI18n")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSlider = findViewById(R.id.btnSlider);
        getSupportFragmentManager().beginTransaction().replace(R.id.ImageSlider_layout, firsFragment).commit();
        btnSlider.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          if (count==1){
            btnSlider.setText("Next");
            getSupportFragmentManager().beginTransaction().replace(R.id.ImageSlider_layout, secondFragment).commit();
            }else if(count==2){
              btnSlider.setText("Done");
             getSupportFragmentManager().beginTransaction().replace(R.id.ImageSlider_layout, thirdFragment).commit();
           } else {
              Intent intent = new Intent(MainActivity.this, SubActivity.class);
              startActivity(intent);
              Toast.makeText(MainActivity.this,"Wel come to  my home page !!",Toast.LENGTH_SHORT).show();

          }
          count++;
        }

      });

    }
}