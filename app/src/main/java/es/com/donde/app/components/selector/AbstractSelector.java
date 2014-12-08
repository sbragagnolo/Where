package es.com.donde.app.components.selector;

/**
 * Created by santiago on 6/1/14.
 */

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by santiago on 5/31/14.
 */
abstract public class AbstractSelector extends ReactiveTextView implements View.OnClickListener, View.OnFocusChangeListener, View.OnTouchListener {



    public AbstractSelector(Context context) {
        this(context, null);
    }

    public AbstractSelector(Context context, AttributeSet attrs) {
        this(context, attrs, 0x0101006e);
    }

    public AbstractSelector(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.initText();

        this.setOnFocusChangeListener(this);
        this.setOnClickListener(this);

    }

    abstract protected void initText () ;
    abstract protected void showDialog () ;

    @Override
    public void onClick(View v) {
        this.showDialog();
    }
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) this.showDialog();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        this.showDialog();
        return false;
    }
}