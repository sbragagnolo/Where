package es.com.donde.app.components.selector.privacy;

import android.content.Context;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;

import es.com.donde.app.components.selector.AbstractSelector;

/**
 * Created by santiago on 6/1/14.
 */
public class PrivacySelector extends AbstractSelector  {

    public interface OnChoiceListener {
        void onChoice (PrivacySelector selector);
    }

    private OnChoiceListener onChoiceListener;

    public PrivacySelector(Context context) {  super(context);   }
    public PrivacySelector(Context context, AttributeSet attrs) {  super(context, attrs);  }
    public PrivacySelector(Context context, AttributeSet attrs, int defStyle) {  super(context, attrs, defStyle); }


    static final CharSequence[] privacyOptions = { "Todos", "Solo amigos", "Amigos de amigos"};


    private int choice = 1;
    @Override
    protected void showDialog() {
        DialogFragment newFragment = new PrivacyDialog(this);
        FragmentActivity activity = (FragmentActivity) this.getContext();
        newFragment.show(  activity.getSupportFragmentManager(), "PrivacyPicker");
    }

    @Override
    protected void initText() {
        this.setText(PrivacySelector.privacyOptions[choice]);
    }

    public int getChoice () { return choice;}
    public String getChoiceValue () { return PrivacySelector.privacyOptions[choice].toString(); }
    public void setChoice (int choice) {
        this.choice = choice;
        this.initText();
        if(this.onChoiceListener != null) this.onChoiceListener.onChoice(this);
    }

    public void setOnChoiceListener(OnChoiceListener onChoiceListener) {
        this.onChoiceListener = onChoiceListener;
    }
}