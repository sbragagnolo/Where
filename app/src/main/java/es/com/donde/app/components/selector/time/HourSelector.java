package es.com.donde.app.components.selector.time;

import android.content.Context;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import es.com.donde.app.components.selector.AbstractSelector;

/**
 * Created by santiago on 6/1/14.
 */
public class HourSelector extends AbstractSelector {

    public HourSelector(Context context) {  super(context);   }
    public HourSelector(Context context, AttributeSet attrs) {  super(context, attrs);  }
    public HourSelector(Context context, AttributeSet attrs, int defStyle) {  super(context, attrs, defStyle); }

    private SimpleDateFormat format = new SimpleDateFormat("hh:mm");
    @Override
    protected void showDialog() {
        DialogFragment newFragment = new HourDialog(this);
        FragmentActivity activity = (FragmentActivity) this.getContext();
        newFragment.show(  activity.getSupportFragmentManager(), "HourPicker");
    }

    @Override
    protected void initText() {
        this.setText("hh:mm");
    }

    public Date getPickedHour () {
        try {
            return format.parse(this.getText().toString());
        } catch (ParseException e) {
            throw new RuntimeException("Hora malaa ");

        }
    }

    public void silentSetHour (Date date) {
        this.silentSetText(format.format(date));
    }
}