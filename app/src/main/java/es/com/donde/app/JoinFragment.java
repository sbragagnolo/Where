package es.com.donde.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import es.com.donde.app.components.privacylist.PrivacyBasedExpandableList;

/**
 * Created by santiago on 5/23/14.
 */
public class JoinFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_join, container, false);

        ExpandableListView view = (ExpandableListView) rootView.findViewById(R.id.listView);


        final PrivacyBasedExpandableList expListAdapter = new PrivacyBasedExpandableList(this.getActivity());
        view.setAdapter(expListAdapter);


        return rootView;
    }
}
