package es.com.donde.app.components.selector.time;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.LinearLayout;
import android.widget.TimePicker;

/**
 * Created by santiago on 6/1/14.
 */
public class HourDialog extends DialogFragment {


    private HourSelector selector;
    private TimePicker picker;
    public HourDialog () {
        super();
    }
    public HourDialog(HourSelector selector) {
        this();
        this.selector = selector;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //View view = LayoutInflater.from(this.getActivity()).inflate(R.layout.pick_day, null);

        LinearLayout view = new LinearLayout(this.getActivity());
        picker = new TimePicker(this.getActivity());
        picker.setIs24HourView(true);



        view.addView(picker);

        return builder.setView(view).setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                StringBuilder builder = new StringBuilder();
                builder.append(HourDialog.this.picker.getCurrentHour()).append(":").append(picker.getCurrentMinute());
                selector.setText(builder.toString());

            }
        }).create();

    }

}