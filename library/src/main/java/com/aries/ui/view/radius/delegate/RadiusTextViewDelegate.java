package com.aries.ui.view.radius.delegate;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.aries.ui.util.DrawableUtil;
import com.aries.ui.widget.R;

/**
 * Created: AriesHoo on 2018/2/5/005 13:53
 * E-Mail: AriesHoo@126.com
 * Function: TextView特有代理类
 * Description:
 * 1、2018-2-4 17:42:18 增加 CompoundButton 类(CheckBox和RadioButton)增加ButtonDrawable属性
 * 2、2018-2-5 11:02:51 增加TextView类设置drawable属性
 */
public class RadiusTextViewDelegate extends RadiusViewDelegate {

    private TextView mTextView;
    private int mTextColor;
    private int mTextPressedColor;
    private int mTextDisabledColor;
    private int mTextSelectedColor;
    private int mTextCheckedColor;

    private float mLeftDrawableColorRadius;
    private boolean mLeftDrawableColorCircleEnable;
    private int mLeftDrawableWidth;
    private int mLeftDrawableHeight;
    private Drawable mLeftDrawable;
    private Drawable mLeftPressedDrawable;
    private Drawable mLeftDisabledDrawable;
    private Drawable mLeftSelectedDrawable;
    private Drawable mLeftCheckedDrawable;

    private float mTopDrawableColorRadius;
    private boolean mTopDrawableColorCircleEnable;
    private int mTopDrawableWidth;
    private int mTopDrawableHeight;
    private Drawable mTopDrawable;
    private Drawable mTopPressedDrawable;
    private Drawable mTopDisabledDrawable;
    private Drawable mTopSelectedDrawable;
    private Drawable mTopCheckedDrawable;


    private float mRightDrawableColorRadius;
    private boolean mRightDrawableColorCircleEnable;
    private int mRightDrawableWidth;
    private int mRightDrawableHeight;
    private Drawable mRightDrawable;
    private Drawable mRightPressedDrawable;
    private Drawable mRightDisabledDrawable;
    private Drawable mRightSelectedDrawable;
    private Drawable mRightCheckedDrawable;

    private float mBottomDrawableColorRadius;
    private boolean mBottomDrawableColorCircleEnable;
    private int mBottomDrawableWidth;
    private int mBottomDrawableHeight;
    private Drawable mBottomDrawable;
    private Drawable mBottomPressedDrawable;
    private Drawable mBottomDisabledDrawable;
    private Drawable mBottomSelectedDrawable;
    private Drawable mBottomCheckedDrawable;

    public RadiusTextViewDelegate(TextView view, Context context, AttributeSet attrs) {
        super(view, context, attrs);
    }

    @Override
    protected void initAttributes(Context context, AttributeSet attrs) {
        mTextColor = mTypedArray.getColor(R.styleable.RadiusCheckBox_rv_textColor, Integer.MAX_VALUE);
        mTextPressedColor = mTypedArray.getColor(R.styleable.RadiusCheckBox_rv_textPressedColor, mTextColor);
        mTextDisabledColor = mTypedArray.getColor(R.styleable.RadiusCheckBox_rv_textDisabledColor, mTextColor);
        mTextSelectedColor = mTypedArray.getColor(R.styleable.RadiusCheckBox_rv_textSelectedColor, mTextColor);
        mTextCheckedColor = mTypedArray.getColor(R.styleable.RadiusCheckBox_rv_textCheckedColor, mTextColor);

        mLeftDrawableColorRadius = mTypedArray.getDimension(R.styleable.RadiusCheckBox_rv_leftDrawableColorRadius, 0);
        mLeftDrawableColorCircleEnable = mTypedArray.getBoolean(R.styleable.RadiusCheckBox_rv_leftDrawableColorCircleEnable, false);
        mLeftDrawableWidth = mTypedArray.getDimensionPixelSize(R.styleable.RadiusCheckBox_rv_leftDrawableWidth, -1);
        mLeftDrawableHeight = mTypedArray.getDimensionPixelSize(R.styleable.RadiusCheckBox_rv_leftDrawableHeight, -1);
        mLeftDrawable = mTypedArray.getDrawable(R.styleable.RadiusCheckBox_rv_leftDrawable);
        mLeftPressedDrawable = mTypedArray.getDrawable(R.styleable.RadiusCheckBox_rv_leftPressedDrawable);
        mLeftDisabledDrawable = mTypedArray.getDrawable(R.styleable.RadiusCheckBox_rv_leftDisabledDrawable);
        mLeftSelectedDrawable = mTypedArray.getDrawable(R.styleable.RadiusCheckBox_rv_leftSelectedDrawable);
        mLeftCheckedDrawable = mTypedArray.getDrawable(R.styleable.RadiusCheckBox_rv_leftCheckedDrawable);

        mTopDrawableColorRadius = mTypedArray.getDimension(R.styleable.RadiusCheckBox_rv_topDrawableColorRadius, 0);
        mTopDrawableColorCircleEnable = mTypedArray.getBoolean(R.styleable.RadiusCheckBox_rv_topDrawableColorCircleEnable, false);
        mTopDrawableWidth = mTypedArray.getDimensionPixelSize(R.styleable.RadiusCheckBox_rv_topDrawableWidth, -1);
        mTopDrawableHeight = mTypedArray.getDimensionPixelSize(R.styleable.RadiusCheckBox_rv_topDrawableHeight, -1);
        mTopDrawable = mTypedArray.getDrawable(R.styleable.RadiusCheckBox_rv_topDrawable);
        mTopPressedDrawable = mTypedArray.getDrawable(R.styleable.RadiusCheckBox_rv_topPressedDrawable);
        mTopDisabledDrawable = mTypedArray.getDrawable(R.styleable.RadiusCheckBox_rv_topDisabledDrawable);
        mTopSelectedDrawable = mTypedArray.getDrawable(R.styleable.RadiusCheckBox_rv_topSelectedDrawable);
        mTopCheckedDrawable = mTypedArray.getDrawable(R.styleable.RadiusCheckBox_rv_topCheckedDrawable);

        mRightDrawableColorRadius = mTypedArray.getDimension(R.styleable.RadiusCheckBox_rv_rightDrawableColorRadius, 0);
        mRightDrawableColorCircleEnable = mTypedArray.getBoolean(R.styleable.RadiusCheckBox_rv_rightDrawableColorCircleEnable, false);
        mRightDrawableWidth = mTypedArray.getDimensionPixelSize(R.styleable.RadiusCheckBox_rv_rightDrawableWidth, -1);
        mRightDrawableHeight = mTypedArray.getDimensionPixelSize(R.styleable.RadiusCheckBox_rv_rightDrawableHeight, -1);
        mRightDrawable = mTypedArray.getDrawable(R.styleable.RadiusCheckBox_rv_rightDrawable);
        mRightPressedDrawable = mTypedArray.getDrawable(R.styleable.RadiusCheckBox_rv_rightPressedDrawable);
        mRightDisabledDrawable = mTypedArray.getDrawable(R.styleable.RadiusCheckBox_rv_rightDisabledDrawable);
        mRightSelectedDrawable = mTypedArray.getDrawable(R.styleable.RadiusCheckBox_rv_rightSelectedDrawable);
        mRightCheckedDrawable = mTypedArray.getDrawable(R.styleable.RadiusCheckBox_rv_rightCheckedDrawable);

        mBottomDrawableColorRadius = mTypedArray.getDimension(R.styleable.RadiusCheckBox_rv_bottomDrawableColorRadius, 0);
        mBottomDrawableColorCircleEnable = mTypedArray.getBoolean(R.styleable.RadiusCheckBox_rv_bottomDrawableColorCircleEnable, false);
        mBottomDrawableWidth = mTypedArray.getDimensionPixelSize(R.styleable.RadiusCheckBox_rv_bottomDrawableWidth, -1);
        mBottomDrawableHeight = mTypedArray.getDimensionPixelSize(R.styleable.RadiusCheckBox_rv_bottomDrawableHeight, -1);
        mBottomDrawable = mTypedArray.getDrawable(R.styleable.RadiusCheckBox_rv_bottomDrawable);
        mBottomPressedDrawable = mTypedArray.getDrawable(R.styleable.RadiusCheckBox_rv_bottomPressedDrawable);
        mBottomDisabledDrawable = mTypedArray.getDrawable(R.styleable.RadiusCheckBox_rv_bottomDisabledDrawable);
        mBottomSelectedDrawable = mTypedArray.getDrawable(R.styleable.RadiusCheckBox_rv_bottomSelectedDrawable);
        mBottomCheckedDrawable = mTypedArray.getDrawable(R.styleable.RadiusCheckBox_rv_bottomCheckedDrawable);
        super.initAttributes(context, attrs);
    }

    @Override
    public void init() {
        mTextView = (TextView) mView;
        setTextSelector();
        setTextDrawable(mLeftDrawable, mLeftCheckedDrawable,
                mLeftSelectedDrawable, mLeftPressedDrawable, mLeftDisabledDrawable, Gravity.LEFT);
        setTextDrawable(mTopDrawable, mTopCheckedDrawable,
                mTopSelectedDrawable, mTopPressedDrawable, mTopDisabledDrawable, Gravity.TOP);
        setTextDrawable(mRightDrawable, mRightCheckedDrawable,
                mRightSelectedDrawable, mRightPressedDrawable, mRightDisabledDrawable, Gravity.RIGHT);
        setTextDrawable(mBottomDrawable, mBottomCheckedDrawable,
                mBottomSelectedDrawable, mBottomPressedDrawable, mBottomDisabledDrawable, Gravity.BOTTOM);
        super.init();
    }

    /**
     * 设置文本常态颜色
     *
     * @param color
     * @return
     */
    public RadiusTextViewDelegate setTextColor(int color) {
        this.mTextColor = color;
        return this;
    }

    /**
     * 设置文本按下颜色
     *
     * @param color
     * @return
     */
    public RadiusTextViewDelegate setTextPressedColor(int color) {
        this.mTextPressedColor = color;
        return this;
    }

    /**
     * 设置文本不可点击状态颜色--setEnable(false)时的颜色{@link View#setEnabled(boolean)}
     *
     * @param color
     * @return
     */
    public RadiusTextViewDelegate setTextDisabledColor(int color) {
        this.mTextDisabledColor = color;
        return this;
    }

    /**
     * 设置文本selected颜色
     *
     * @param color
     * @return
     */
    public RadiusTextViewDelegate setTextSelectedColor(int color) {
        this.mTextSelectedColor = color;
        return this;
    }

    /**
     * 设置文本checked颜色
     *
     * @param color
     * @return
     */
    public RadiusTextViewDelegate setTextCheckedColor(int color) {
        this.mTextCheckedColor = color;
        return this;
    }

    public RadiusTextViewDelegate setLeftDrawableWidth(int leftDrawableWidth) {
        mLeftDrawableWidth = leftDrawableWidth;
        return this;
    }

    public RadiusTextViewDelegate setLeftDrawableHeight(int leftDrawableHeight) {
        mLeftDrawableHeight = leftDrawableHeight;
        return this;
    }

    /**
     * 设置左边drawable
     *
     * @param drawable
     * @return
     */
    public RadiusTextViewDelegate setLeftDrawable(Drawable drawable) {
        mLeftDrawable = drawable;
        return this;
    }

    public RadiusTextViewDelegate setLeftDrawable(int resId) {
        return setLeftDrawable(getDrawable(resId));
    }

    public RadiusTextViewDelegate setLeftPressedDrawable(Drawable drawable) {
        mLeftPressedDrawable = drawable;
        return this;
    }

    public RadiusTextViewDelegate setLeftPressedDrawable(int resId) {
        return setLeftPressedDrawable(getDrawable(resId));
    }

    public RadiusTextViewDelegate setLeftDisabledDrawable(Drawable drawable) {
        mLeftDisabledDrawable = drawable;
        return this;
    }

    public RadiusTextViewDelegate setLeftDisabledDrawable(int resId) {
        return setLeftDisabledDrawable(getDrawable(resId));
    }

    public RadiusTextViewDelegate setLeftSelectedDrawable(Drawable drawable) {
        mLeftSelectedDrawable = drawable;
        return this;
    }

    public RadiusTextViewDelegate setLeftSelectedDrawable(int resId) {
        return setLeftSelectedDrawable(getDrawable(resId));
    }

    public RadiusTextViewDelegate setLeftCheckedDrawable(Drawable drawable) {
        mLeftCheckedDrawable = drawable;
        return this;
    }

    public RadiusTextViewDelegate setLeftCheckedDrawable(int resId) {
        return setLeftCheckedDrawable(getDrawable(resId));
    }

    public RadiusTextViewDelegate setTopDrawableWidth(int topDrawableWidth) {
        mTopDrawableWidth = topDrawableWidth;
        return this;
    }

    public RadiusTextViewDelegate setTopDrawableHeight(int topDrawableHeight) {
        mTopDrawableHeight = topDrawableHeight;
        return this;
    }

    /**
     * 设置top drawable
     *
     * @param drawable
     * @return
     */
    public RadiusTextViewDelegate setTopDrawable(Drawable drawable) {
        mTopDrawable = drawable;
        return this;
    }

    public RadiusTextViewDelegate setTopDrawable(int resId) {
        return setTopDrawable(getDrawable(resId));
    }

    public RadiusTextViewDelegate setTopPressedDrawable(Drawable drawable) {
        mTopPressedDrawable = drawable;
        return this;
    }

    public RadiusTextViewDelegate setTopPressedDrawable(int resId) {
        return setTopPressedDrawable(getDrawable(resId));
    }

    public RadiusTextViewDelegate setTopDisabledDrawable(Drawable drawable) {
        mTopDisabledDrawable = drawable;
        return this;
    }

    public RadiusTextViewDelegate setTopDisabledDrawable(int resId) {
        return setTopDisabledDrawable(getDrawable(resId));
    }

    public RadiusTextViewDelegate setTopSelectedDrawable(Drawable drawable) {
        mTopSelectedDrawable = drawable;
        return this;
    }

    public RadiusTextViewDelegate setTopSelectedDrawable(int resId) {
        return setTopSelectedDrawable(getDrawable(resId));
    }

    public RadiusTextViewDelegate setTopCheckedDrawable(Drawable drawable) {
        mTopCheckedDrawable = drawable;
        return this;
    }

    public RadiusTextViewDelegate setTopCheckedDrawable(int resId) {
        return setTopCheckedDrawable(getDrawable(resId));
    }

    public RadiusTextViewDelegate setRightDrawableWidth(int rightDrawableWidth) {
        mRightDrawableWidth = rightDrawableWidth;
        return this;
    }

    public RadiusTextViewDelegate setRightDrawableHeight(int rightDrawableHeight) {
        mRightDrawableHeight = rightDrawableHeight;
        return this;
    }

    /**
     * 设置right drawable
     *
     * @param drawable
     * @return
     */
    public RadiusTextViewDelegate setRightDrawable(Drawable drawable) {
        mRightDrawable = drawable;
        return this;
    }

    public RadiusTextViewDelegate setRightDrawable(int resId) {
        return setRightDrawable(getDrawable(resId));
    }

    public RadiusTextViewDelegate setRightPressedDrawable(Drawable drawable) {
        mRightPressedDrawable = drawable;
        return this;
    }

    public RadiusTextViewDelegate setRightPressedDrawable(int resId) {
        return setRightPressedDrawable(getDrawable(resId));
    }

    public RadiusTextViewDelegate setRightDisabledDrawable(Drawable drawable) {
        mRightDisabledDrawable = drawable;
        return this;
    }

    public RadiusTextViewDelegate setRightDisabledDrawable(int resId) {
        return setRightDisabledDrawable(getDrawable(resId));
    }

    public RadiusTextViewDelegate setRightSelectedDrawable(Drawable drawable) {
        mRightSelectedDrawable = drawable;
        return this;
    }

    public RadiusTextViewDelegate setRightSelectedDrawable(int resId) {
        return setRightSelectedDrawable(getDrawable(resId));
    }

    public RadiusTextViewDelegate setRightCheckedDrawable(Drawable drawable) {
        mRightCheckedDrawable = drawable;
        return this;
    }

    public RadiusTextViewDelegate setRightCheckedDrawable(int resId) {
        return setRightCheckedDrawable(getDrawable(resId));
    }

    public RadiusTextViewDelegate setBottomDrawableWidth(int bottomDrawableWidth) {
        mBottomDrawableWidth = bottomDrawableWidth;
        return this;
    }

    public RadiusTextViewDelegate setBottomDrawableHeight(int bottomDrawableHeight) {
        mBottomDrawableHeight = bottomDrawableHeight;
        return this;
    }

    /**
     * 设置bottom drawable
     *
     * @param drawable
     * @return
     */
    public RadiusTextViewDelegate setBottomDrawable(Drawable drawable) {
        mBottomDrawable = drawable;
        return this;
    }

    public RadiusTextViewDelegate setBottomDrawable(int resId) {
        return setBottomDrawable(getDrawable(resId));
    }

    public RadiusTextViewDelegate setBottomPressedDrawable(Drawable drawable) {
        mBottomPressedDrawable = drawable;
        return this;
    }

    public RadiusTextViewDelegate setBottomPressedDrawable(int resId) {
        return setBottomPressedDrawable(getDrawable(resId));
    }

    public RadiusTextViewDelegate setBottomDisabledDrawable(Drawable drawable) {
        mBottomDisabledDrawable = drawable;
        return this;
    }

    public RadiusTextViewDelegate setBottomDisabledDrawable(int resId) {
        return setBottomDisabledDrawable(getDrawable(resId));
    }

    public RadiusTextViewDelegate setBottomSelectedDrawable(Drawable drawable) {
        mBottomSelectedDrawable = drawable;
        return this;
    }

    public RadiusTextViewDelegate setBottomSelectedDrawable(int resId) {
        return setBottomSelectedDrawable(getDrawable(resId));
    }

    public RadiusTextViewDelegate setBottomCheckedDrawable(Drawable drawable) {
        mBottomCheckedDrawable = drawable;
        return this;
    }

    public RadiusTextViewDelegate setBottomCheckedDrawable(int resId) {
        return setBottomCheckedDrawable(getDrawable(resId));
    }

    /**
     * 设置TextView的Left、Top、Right、Bottom Drawable属性
     *
     * @param normal
     * @param checked
     * @param selected
     * @param pressed
     * @param disabled
     * @param gravity
     */
    private void setTextDrawable(Drawable normal, Drawable checked, Drawable selected, Drawable pressed,
                                 Drawable disabled, int gravity) {
        if (normal != null || pressed != null || disabled != null
                || selected != null || checked != null) {
            int index = 0;
            int width = mLeftDrawableWidth;
            int height = mLeftDrawableHeight;
            float radius = mLeftDrawableColorCircleEnable ? width + height / 2 : mLeftDrawableColorRadius;
            switch (gravity) {
                case Gravity.TOP:
                    index = 1;
                    width = mTopDrawableWidth;
                    height = mTopDrawableHeight;
                    radius = mTopDrawableColorCircleEnable ? width + height / 2 : mTopDrawableColorRadius;
                    break;
                case Gravity.RIGHT:
                    index = 2;
                    width = mRightDrawableWidth;
                    height = mRightDrawableHeight;
                    radius = mRightDrawableColorCircleEnable ? width + height / 2 : mRightDrawableColorRadius;
                    break;
                case Gravity.BOTTOM:
                    index = 3;
                    width = mBottomDrawableWidth;
                    height = mBottomDrawableHeight;
                    radius = mBottomDrawableColorCircleEnable ? width + height / 2 : mBottomDrawableColorRadius;
                    break;
            }
            StateListDrawable stateDrawable = new StateListDrawable();
            stateDrawable.addState(new int[]{mStateChecked}, getStateDrawable(checked, radius, width, height));
            stateDrawable.addState(new int[]{mStateSelected}, getStateDrawable(selected, radius, width, height));
            stateDrawable.addState(new int[]{mStatePressed}, getStateDrawable(pressed, radius, width, height));
            stateDrawable.addState(new int[]{mStateDisabled}, getStateDrawable(disabled, radius, width, height));
            stateDrawable.addState(new int[]{}, getStateDrawable(normal, radius, width, height));
            DrawableUtil.setDrawableWidthHeight(stateDrawable, width, height);
            Drawable[] drawables = mTextView.getCompoundDrawables();
            drawables[index] = stateDrawable;
            mTextView.setCompoundDrawables(drawables[0], drawables[1], drawables[2], drawables[3]);
            Log.i("setButtonDrawable","normal:"+normal.getBounds()+";height:"+normal.getIntrinsicHeight()+";stateDrawable:"+stateDrawable.getBounds()+";height:"+stateDrawable.getIntrinsicHeight());

        }
    }

    /**
     * 获取不同状态下的Drawable信息
     *
     * @param drawable
     * @param radius
     * @param width
     * @param height
     * @return
     */
    protected Drawable getStateDrawable(Drawable drawable, float radius, int width, int height) {
        if (drawable instanceof ColorDrawable) {
            ColorDrawable colorDrawable = (ColorDrawable) drawable;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(colorDrawable.getColor());
            gradientDrawable.setCornerRadius(radius);
            gradientDrawable.setSize(width, height);
            drawable = gradientDrawable;
        }
        DrawableUtil.setDrawableWidthHeight(drawable, width, height);
        return drawable;
    }

    /**
     * 设置文本颜色
     */
    private void setTextSelector() {
        mTextView = (TextView) mView;
        mTextColor = (mTextColor == Integer.MAX_VALUE ? mTextView.getTextColors().getDefaultColor() : mTextColor);
        if (mTextColor != Integer.MAX_VALUE
                || mTextPressedColor != Integer.MAX_VALUE
                || mTextDisabledColor != Integer.MAX_VALUE
                || mTextSelectedColor != Integer.MAX_VALUE
                || mTextCheckedColor != Integer.MAX_VALUE) {
            ColorStateList colorStateList =
                    getColorSelector(mTextColor, mTextPressedColor, mTextDisabledColor, mTextSelectedColor, mTextCheckedColor);
            mTextView.setTextColor(colorStateList);
        }
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private ColorStateList getColorSelector(int normalColor, int pressedColor, int DisabledColor, int selectedColor, int checkedColor) {
        return new ColorStateList(
                new int[][]{
                        new int[]{mStateChecked},
                        new int[]{mStateSelected},
                        new int[]{mStatePressed},
                        new int[]{mStateDisabled},
                        new int[]{}
                },
                new int[]{
                        checkedColor,
                        selectedColor,
                        pressedColor,
                        DisabledColor,
                        normalColor
                }
        );
    }

    /**
     * 根据drawable资源id返回drawable对象
     *
     * @param resId
     * @return
     */
    protected Drawable getDrawable(int resId) {
        Drawable drawable = null;
        try {
            mView.getResources().getDrawable(resId);
        } catch (Exception e) {

        }
        return drawable;
    }
}
