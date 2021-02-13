package com.example.flagmenttest_210211;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button01 = findViewById(R.id.button);

        if(savedInstanceState == null){

            button01.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // FragmentManagerのインスタンス生成
                    FragmentManager fragmentManager = getSupportFragmentManager();

                    // FragmentTransactionのインスタンスを取得
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                    // BackStackを設定
                    fragmentTransaction.addToBackStack(null);

                    // インスタンスに対して張り付け方を指定する
                    fragmentTransaction.replace(R.id.container,
                            SampleFragment.newInstance("Fragment!!!"));

                    // counterをパラメータとして設定
                    int count = 0;
                    fragmentTransaction.replace(R.id.container, Fragment01.newInstance(count));

                    // 張り付けを実行
                    fragmentTransaction.commit();
                }
            });
        }
    }
}