package org.alexcawl.health_check_application.resource;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.res.ResourcesCompat;

import org.alexcawl.health_check_application.R;

import java.util.Objects;

public class ExtendedEditText extends AppCompatEditText {
    Drawable mClearButtonImage;

    public ExtendedEditText(@NonNull Context context) {
        super(context);
        init();
    }

    public ExtendedEditText(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ExtendedEditText(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        // Initialize Drawable member variable.
        mClearButtonImage = ResourcesCompat.getDrawable(getResources(), R.drawable.icon_cross_24dp, getContext().getTheme());

        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if ((getCompoundDrawablesRelative()[2] != null)) {
                    float clearButtonStart; // Used for LTR languages
                    float clearButtonEnd;  // Used for RTL languages
                    boolean isClearButtonClicked = false;
                    if (getLayoutDirection() == LAYOUT_DIRECTION_RTL) {
                        clearButtonEnd = mClearButtonImage.getIntrinsicWidth() + getPaddingStart();
                        if (event.getX() < clearButtonEnd) {
                            isClearButtonClicked = true;
                        }
                    } else {
                        clearButtonStart = (getWidth() - getPaddingEnd()
                                - mClearButtonImage.getIntrinsicWidth());
                        if (event.getX() > clearButtonStart) {
                            isClearButtonClicked = true;
                        }
                    }
                    if (isClearButtonClicked) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            mClearButtonImage = ResourcesCompat.getDrawable(getResources(), R.drawable.icon_cross_focused_24dp, getContext().getTheme());
                            showClearButton();
                        }
                        if (event.getAction() == MotionEvent.ACTION_UP) {
                            mClearButtonImage = ResourcesCompat.getDrawable(getResources(), R.drawable.icon_cross_24dp, getContext().getTheme());
                            Objects.requireNonNull(getText()).clear();
                            hideClearButton();
                            return true;
                        }
                    } else {
                        return false;
                    }
                }
                return false;
            }
        });

        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s,
                                          int start, int count, int after) {
                // Do nothing.
            }

            @Override
            public void onTextChanged(CharSequence s,
                                      int start, int before, int count) {
                if (getText() == null || getText().toString().isEmpty()) {
                    hideClearButton();
                } else {
                    showClearButton();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Do nothing.
            }
        });

        setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus && getText() != null && !getText().toString().isEmpty()) {
                    showClearButton();
                } else {
                    hideClearButton();
                }
            }
        });
    }

    /**
     * Shows the clear (X) button.
     */

    private void showClearButton() {
        // Sets the Drawables (if any) to appear to the left of,
        // above, to the right of, and below the text.
        setCompoundDrawablesRelativeWithIntrinsicBounds(
                getCompoundDrawablesRelative()[0],
                getCompoundDrawablesRelative()[1],
                mClearButtonImage,
                getCompoundDrawablesRelative()[3]
        );
    }

    /**
     * Hides the clear button.
     */
    private void hideClearButton() {
        setCompoundDrawablesRelativeWithIntrinsicBounds(
                getCompoundDrawablesRelative()[0],
                getCompoundDrawablesRelative()[1],
                null,
                getCompoundDrawablesRelative()[3]
        );
    }
}
