package es.com.donde.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.android.gms.maps.SupportMapFragment;

/**
 * Created by santiago on 5/23/14.
 */
public class PlayNowFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_playnow, container, false);


        LinearLayout mapContainer = (LinearLayout) rootView.findViewById(R.id.map_play);
        ViewGroup parent = (ViewGroup) mapContainer.getParent();

        mapContainer.getLayoutParams().height = parent.getHeight() / 3;

        Bundle bundle = new Bundle();
        bundle.putString("layout_width", "match_parent");
        bundle.putString("layout_height", Integer.toString(parent.getHeight() / 3) + "dp");

        Fragment map = new SupportMapFragment();



        FragmentTransaction tx = this.getFragmentManager().beginTransaction();

        tx.add(R.id.map_play, map);
        tx.commit();

        return rootView;
    }
}
