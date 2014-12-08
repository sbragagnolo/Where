package es.com.donde.app.components.selector.place;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import es.com.donde.app.R;

/**
 * Created by santiago on 5/25/14.
 */
public class LocationDialog extends DialogFragment {
    LinearLayout view;
    Dialog self;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = (LinearLayout) inflater.inflate(R.layout.digital_signin, container);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);

    }

    @Override
    public void onStart() {
        super.onStart();
        /*self.setContentView(view);
        Fragment map = new SupportMapFragment();
        FragmentTransaction tx = this.getFragmentManager().beginTransaction();
        tx.add(R.id.popup_selector_map, map, map.getTag());
        tx.commit();*/
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());



        builder
                // Add action buttons
                .setPositiveButton("Yeah", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // sign in the user ...
                    }
                })
                .setNegativeButton("FKYOU", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        LocationDialog.this.getDialog().cancel();
                    }
                });
        self = builder.create();
        return self;

    }



  /*  @Override
    public void show (FragmentManager manager, String tag) {
        super.show(manager, tag);
        manager.beginTransaction().add(R.id.popup_selector_map, new SupportMapFragment()).commit();


    }*/
}