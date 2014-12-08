package es.com.donde.app.components.selector.privacy;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

/**
 * Created by santiago on 6/1/14.
 */
public class PrivacyDialog extends DialogFragment {

    private PrivacySelector selector;

    public PrivacyDialog() {
        super();
    }
    public PrivacyDialog(PrivacySelector selector) {
        this();
        this.selector = selector;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        return builder.setSingleChoiceItems(PrivacySelector.privacyOptions, selector.getChoice(), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                PrivacyDialog.this.selector.setChoice(which);
                dialog.dismiss();
            }
        }).create();

    }

}