package es.com.donde.app.components.selector;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;

/**
 * Created by santiago on 6/3/14.
 */
public class ReactiveEditText extends EditText {

    public ReactiveEditText(Context context) {
       super(context);
       this.wireUpState();
    }

    public ReactiveEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.wireUpState();
    }

    public ReactiveEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.wireUpState();
    }

    protected void wireUpState() {
        this.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                ReactiveEditText.this.fireTextChanged();
            }
        });
    }


    public interface OnTextChangeListener {
        void onTextChange(ReactiveEditText view);
    }
    protected OnTextChangeListener onTextChangeListener;

    public void setOnTextChangeListener(OnTextChangeListener onTextChangeListener) {
        this.onTextChangeListener = onTextChangeListener;
    }

    public void silentSetText(CharSequence text) { super.setText(text, BufferType.NORMAL) ;}

    protected void fireTextChanged () {
        if(this.onTextChangeListener != null) this.onTextChangeListener.onTextChange(this);
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(text, type);
        this.fireTextChanged();
    }
}
