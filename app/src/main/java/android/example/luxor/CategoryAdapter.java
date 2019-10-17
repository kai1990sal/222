package android.example.luxor;


import android.content.Context;
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
public class CategoryAdapter extends FragmentPagerAdapter {

    private Context context;

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
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

    // Set pages and titles of the tab
    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getResources().getString(R.string.category_musems);
            case 1:
                return context.getResources().getString(R.string.category_shops);
            case 2:
                return context.getResources().getString(R.string.category_food_drink);
            case 3:
                return context.getResources().getString(R.string.category_hotels);
            default:
                return null;
        }
    }
}