package es.com.donde.app.components.selector.mode;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

/**
 * Created by santiago on 6/1/14.
 */
public class ModeDialog extends DialogFragment {

    private ModeSelector selector;

    public ModeDialog () {
        super();
    }
    public ModeDialog(ModeSelector selector) {
        this();
        this.selector = selector;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        return builder.setSingleChoiceItems(ModeSelector.modes, this.selector.getChoice(),new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ModeDialog.this.selector.setChoice(which);
                dialog.dismiss();
            }
        }).create();

    }

}