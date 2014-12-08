package es.com.donde.app.components.selector.place;

import android.support.v4.app.DialogFragment;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import es.com.donde.app.components.selector.place.LocationDialog;

/**
 * Created by santiago on 5/24/14.
 */
public class LocationSelector extends TextView implements View.OnClickListener {



    public LocationSelector(Context context) {
        super(context);
        setText("MAP");
        this.setOnClickListener(this);

    }

    public LocationSelector(Context context, AttributeSet attrs) {
        super(context, attrs);
        setText("MAP");
        this.setOnClickListener(this);
    }

    public LocationSelector(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setText("MAP");
        this.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        DialogFragment newFragment = new LocationDialog();

        FragmentActivity activity = (FragmentActivity) this.getContext();
        newFragment.show(  activity.getSupportFragmentManager(), "missiles");





    }
}
