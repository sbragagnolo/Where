package es.com.donde.app.components.selector;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by santiago on 6/3/14.
 */
public class ReactiveTextView extends TextView {
    public ReactiveTextView(Context context) {
        super(context);
    }

    public ReactiveTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ReactiveTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public interface OnTextChangeListener {
        void onTextChange(ReactiveTextView view);
    }
    protected OnTextChangeListener onTextChangeListener;

    public void setOnTextChangeListener(OnTextChangeListener onTextChangeListener) {
        this.onTextChangeListener = onTextChangeListener;
    }

    public void silentSetText(CharSequence text) { super.setText(text, BufferType.NORMAL) ;}


    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(text, type);
        if(this.onTextChangeListener != null) this.onTextChangeListener.onTextChange(this);
    }
}
