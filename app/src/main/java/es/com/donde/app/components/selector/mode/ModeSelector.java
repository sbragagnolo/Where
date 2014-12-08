package es.com.donde.app.components.selector.mode;

import android.content.Context;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;

import es.com.donde.app.components.selector.AbstractSelector;

/**
 * Created by santiago on 6/1/14.
 */
public class ModeSelector extends AbstractSelector  {

    public interface OnChoiceListener {
        void onChoice (ModeSelector selector);
    }

    private OnChoiceListener onChoiceListener;

    public ModeSelector(Context context) {  super(context);   }
    public ModeSelector(Context context, AttributeSet attrs) {  super(context, attrs);  }
    public ModeSelector(Context context, AttributeSet attrs, int defStyle) {  super(context, attrs, defStyle); }


    static final CharSequence[] modes = {"Futbol5", "Futbol7", "Futbol11", "Otro"};
    static final int[] modeSizes = {9, 13, 21, 0};

    private int choice = 1;
    @Override
    protected void showDialog() {
        DialogFragment newFragment = new ModeDialog(this);
        FragmentActivity activity = (FragmentActivity) this.getContext();
        newFragment.show(  activity.getSupportFragmentManager(), "ModePicker");
    }

    @Override
    protected void initText() {
        this.setText(ModeSelector.modes[choice]);
    }
    public int getChoiceSize () { return ModeSelector.modeSizes[choice];}
    public int getChoice () { return choice;}

    public void setChoice (int choice) {
        this.choice = choice;
        this.initText();
        if(this.onChoiceListener != null) this.onChoiceListener.onChoice(this);
    }

    public void setOnChoiceListener(OnChoiceListener onChoiceListener) {
        this.onChoiceListener = onChoiceListener;
    }
}