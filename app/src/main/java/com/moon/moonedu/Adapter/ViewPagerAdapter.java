package com.moon.moonedu.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.moon.moonedu.Fragment.AllFragment;
import com.moon.moonedu.Fragment.DiscoverFragment;
import com.moon.moonedu.Fragment.HomeFragment;
import com.moon.moonedu.Fragment.UniverseFragment;
import com.moon.moonedu.Fragment.UserFragment;

import org.jetbrains.annotations.NotNull;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull @NotNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NotNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new DiscoverFragment();
            case 2:
                return new UniverseFragment();
            case 3:
                return new AllFragment();
            case 4:
                return new UserFragment();
            default:
                return new HomeFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
