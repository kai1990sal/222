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
public class FoodAndDrinksFragment extends Fragment {
    ArrayList<Place> foodDrink = new ArrayList<>();

    public FoodAndDrinksFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        // Get the resource from a string-array and create Place objects from each of the array items (split them to name and address)
        Resources resources = getResources();
        String[] foodWithAddress = resources.getStringArray(R.array.FoodAndDrinks);
        String[] splitter;

        for (int i = 0; i < foodWithAddress.length; i++) {
            splitter = foodWithAddress[i].split("/");
            Place place = new Place(splitter[0], splitter[1]);
            foodDrink.add(place);
        }

        PlaceAdapter adapter = new PlaceAdapter(getActivity(), foodDrink);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;
    }

}