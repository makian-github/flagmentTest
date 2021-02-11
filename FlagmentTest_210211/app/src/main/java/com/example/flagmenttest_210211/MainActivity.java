package com.example.flagmenttest_210211;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            // FragmentManagerのインスタンス生成
            FragmentManager fragmentManager = getSupportFragmentManager();

            // FragmentTransactionのインスタンスを取得
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            // インスタンスに対して張り付け方を指定する
            fragmentTransaction.replace(R.id.container, new SampleFragment());

            // 張り付けを実行
            fragmentTransaction.commit();
        }
    }
}