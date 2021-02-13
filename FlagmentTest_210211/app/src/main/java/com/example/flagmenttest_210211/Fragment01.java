package com.example.flagmenttest_210211;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.annotation.NonNull;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Fragment01 extends Fragment {

    private int cnt = 0;

    static Fragment01 newInstance(int count){
        // Fragemnt01 インスタンス生成
        Fragment01 fragment01 = new Fragment01();

        // Bundle にパラメータを設定
        Bundle args = new Bundle();
        args.putInt("Counter", count);
        fragment01.setArguments(args);

        return fragment01;
    }

    // FragmentのViewを生成して返す
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment01,
                container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle args = getArguments();

        if(args != null ){
            int count = args.getInt("Counter");
            String str = "Fragment01: " + String.valueOf(count);
            cnt = count +1;

            TextView textView = view.findViewById(R.id.textview_01);
            textView.setText(str);
        }

        Button button01 = view.findViewById(R.id.button_01);
        button01.setOnClickListener( v -> {
            FragmentManager fragmentManager = getFragmentManager();

            if(fragmentManager != null){
                FragmentTransaction fragmentTransaction =
                        fragmentManager.beginTransaction();
                // BackStackを設定
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.replace(R.id.container,
                        Fragment02.newInstance(cnt));
                fragmentTransaction.commit();
            }

        });

        // BackStackで１つ戻す
        Button pop01 = view.findViewById(R.id.pop_01);
        pop01.setOnClickListener( v -> {
            FragmentManager fragmentManager = getFragmentManager();
            if(fragmentManager != null) {
                fragmentManager.popBackStack();
            }
        });
    }
}
