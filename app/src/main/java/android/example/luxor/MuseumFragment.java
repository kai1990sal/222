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
public class MuseumFragment extends Fragment {

    ArrayList<Place> facultyBuilding = new ArrayList<>();

    public MuseumFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        //// Get the resource from string-arrays
        Resources resources = getResources();
        String[] faculties = resources.getStringArray(R.array.museums);
        String[] addresses = resources.getStringArray(R.array.museum_address);
        String[] phone = resources.getStringArray(R.array.faculty_phone);
        String[] email = resources.getStringArray(R.array.faculty_email);
        int[] imageResources = new int[faculties.length];

        // Create an array from image resource IDs
        imageResources[0] = R.drawable.ic_launcher_background;
        imageResources[1] = R.drawable.ic_launcher_background;
        imageResources[2] = R.drawable.ic_launcher_background;
        imageResources[3] = R.drawable.ic_launcher_background;
        imageResources[4] = R.drawable.ic_launcher_background;
        imageResources[5] = R.drawable.ic_launcher_background;
        imageResources[6] = R.drawable.ic_launcher_background;
        imageResources[7] = R.drawable.ic_launcher_background;
        imageResources[8] = R.drawable.ic_launcher_background;
        imageResources[9] = R.drawable.ic_launcher_background;

        //  Create Place objects from the arrays
        for (int i = 0; i < faculties.length; i++) {
            Place buildings = new Place(faculties[i], addresses[i], phone[i], email[i], imageResources[i]);
            facultyBuilding.add(buildings);
        }

        PlaceAdapter adapter = new PlaceAdapter(getActivity(), facultyBuilding);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        return rootView;
    }

}