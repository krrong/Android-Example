package com.example.tablayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 어댑터 생성
        FragmentAdapter adapter = new FragmentAdapter(this);

        // fragment 추가
        ArrayList<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(new OneFragment());
        fragments.add(new TwoFragment());

        // tab의 타이틀 변경을 위한 리스트
        ArrayList<String> tabTitles = new ArrayList<String>();
        tabTitles.add("one");
        tabTitles.add("two");

        // adapter의 fragments에 위에서 만든 fragments로 넣어준다.
        adapter.fragments = fragments;

        // binding
        ViewPager2 viewPager = (ViewPager2) findViewById(R.id.viewPager);
        TabLayout tabLayout = findViewById(R.id.tabLayout);

        // adapter 연결 -> 탭을 바꿀 때 페이지도 같이 변해야 함
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy(){
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                TextView textView = new TextView(MainActivity.this);
                textView.setText(tabTitles.get(position));
                tab.setCustomView(textView);
            }
        }).attach();
    }
}