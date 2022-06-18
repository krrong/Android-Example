package com.example.tablayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

class FragmentAdapter extends FragmentStateAdapter {

    public ArrayList<Fragment> fragments;

    public FragmentAdapter(@NonNull FragmentActivity fragmentActivity){
        super(fragmentActivity);
    }

    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }


    @Override
    public int getItemCount() {
        return fragments.size();
    }
}
