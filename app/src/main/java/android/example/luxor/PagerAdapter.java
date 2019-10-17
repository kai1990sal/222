package android.example.luxor;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class PagerAdapter extends FragmentPagerAdapter {
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MuseumFragment();
            case 1:
                return new ShopsFargment();
            case 2:
                return new FoodAndDrinksFragment();
            case 3:
                return new HotelsFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}