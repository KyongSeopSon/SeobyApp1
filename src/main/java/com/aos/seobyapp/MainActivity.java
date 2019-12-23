package com.aos.seobyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.aos.seobyapp.FirebaseInterface;

public class MainActivity extends AppCompatActivity {

    private FirebaseInterface ieFirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ieFirebase = new FirebaseInterface(this);

        // 화면뷰 트래킹
        ieFirebase.SendFirebaseEvent("PAGEVIEW", "APP_메인", "MainActivity", null);
        Toast.makeText(getApplicationContext(), "앱 화면뷰 페이지뷰를 전송하였습니다",Toast.LENGTH_LONG).show();
    }

    public void btnEvent_Click(View v)
    {
        // 앱 클릭 이벤트 트래킹
        ieFirebase.SendFirebaseEvent("EVENT", "APP_메인", "클릭", "앱이벤트");
        Toast.makeText(getApplicationContext(), "앱 이벤트 클릭 이벤트를 전송하였습니다",Toast.LENGTH_LONG).show();

    }

    public void btnWebView_Click(View v)
    {
        // 앱 클릭 이벤트 트래킹
        ieFirebase.SendFirebaseEvent("EVENT", "APP_메인", "클릭", "웹뷰호출");
        Toast.makeText(getApplicationContext(), "앱 웹뷰호출 클릭 이벤트를 전송하였습니다",Toast.LENGTH_LONG).show();

        Intent intent = new Intent(getApplicationContext(), ViewWebview.class);
        startActivity(intent);
    }
}
