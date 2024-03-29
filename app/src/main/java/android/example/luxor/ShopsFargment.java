package android.example.luxor;


import android.content.res.Resources;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopsFargment extends Fragment {

    ArrayList<Place> shops = new ArrayList<>();

    public ShopsFargment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        // Get the resource from a string-array and create Place objects from each of the array items (split them to name and address)
        Resources resources = getResources();
        String[] dormsWithAddress = resources.getStringArray(R.array.Shops);
        String[] splitter = new String[2];

        for (int i = 0; i < dormsWithAddress.length; i++) {
            splitter = dormsWithAddress[i].split("/");
            Place place = new Place(splitter[0], splitter[1]);
            shops.add(place);
        }

        // Create a new PlaceAdapter object with the resource ArrayList in it.
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), shops);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;
    }

}