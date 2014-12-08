package es.com.donde.app.components.selector.day;

import android.content.Context;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import es.com.donde.app.components.selector.AbstractSelector;

/**
 * Created by santiago on 5/31/14.
 */
public class DaySelector extends AbstractSelector {

    public DaySelector(Context context) {  super(context);   }
    public DaySelector(Context context, AttributeSet attrs) {  super(context, attrs);  }
    public DaySelector(Context context, AttributeSet attrs, int defStyle) {  super(context, attrs, defStyle); }

    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    protected void showDialog() {
        DialogFragment newFragment = new DayDialog(this);
        FragmentActivity activity = (FragmentActivity) this.getContext();
        newFragment.show(  activity.getSupportFragmentManager(), "DayPicker");
    }



    @Override
    protected void initText() {
        this.setText("d/m/aa");
    }

    public Date getPickedDay () {

        try {
            return format.parse(this.getText().toString());
        } catch (ParseException e) {
            StringBuilder builder = new StringBuilder();
            throw new RuntimeException(builder.append(this.getText()).append(" ").append(e.getMessage()).toString());

        }
    }

    public void silentSetDay (Date date){
        this.silentSetText(format.format(date));
    }
}