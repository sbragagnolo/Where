package es.com.donde.app.components.selector.day;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.LinearLayout;

/**
 * Created by santiago on 5/31/14.
 */

public class DayDialog extends DialogFragment {


    private DaySelector selector;
    private DatePicker picker;
    public DayDialog () {
        super();
    }
    public DayDialog(DaySelector selector) {
        this();
        this.selector = selector;
    }
    
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //View view = LayoutInflater.from(this.getActivity()).inflate(R.layout.pick_day, null);

        LinearLayout view = new LinearLayout(this.getActivity());
        picker = new DatePicker(this.getActivity());
        picker.setCalendarViewShown(true);
        picker.setSpinnersShown(true);


        view.addView(picker);

        return builder.setView(view).setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                StringBuilder builder = new StringBuilder();
                builder.append(DayDialog.this.picker.getDayOfMonth()).append("/").append(picker.getMonth()).append("/").append(picker.getYear());
                selector.setText(builder.toString());

            }
        }).create();

    }

}