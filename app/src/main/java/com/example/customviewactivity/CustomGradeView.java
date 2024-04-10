package com.example.customviewactivity;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.io.Serializable;

public class CustomGradeView extends ConstraintLayout{

    private ProgressBar progressBar;
    private TextView textView;

    public CustomGradeView(@NonNull Context context) {
        super(context);
        init();
    }

    public CustomGradeView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomGradeView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public CustomGradeView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (widthMeasureSpec!=0 || heightMeasureSpec!=0){
            int size = Math.max(widthMeasureSpec, heightMeasureSpec);
            setMeasuredDimension(size,size);
        }
    }

    public void init(){
        View view = LayoutInflater.from(getContext())
                .inflate(R.layout.my_grade_view,this, true);
        progressBar = view.findViewById(R.id.puntuacionGraf);
        textView = view.findViewById(R.id.puntuacionNum);
    }

    public void init(AttributeSet attrs){
        init();

        if (attrs!=null){
            TypedArray attributeSet = getContext().obtainStyledAttributes(attrs, R.styleable.CustomGradeView);
            int grade = attributeSet.getInt(R.styleable.CustomGradeView_grade, 100);
            int barColor = attributeSet.getInt(R.styleable.CustomGradeView_barColor, getContext().getTheme().getResources()
                    .getColor(com.google.android.material.R.color.design_default_color_primary, getContext().getTheme()));
            int textColor = attributeSet.getInt(R.styleable.CustomGradeView_textColor, getContext().getTheme().getResources()
                    .getColor(com.google.android.material.R.color.design_default_color_primary, getContext().getTheme()));
            float textSize = attributeSet.getDimensionPixelSize(R.styleable.CustomGradeView_textSize, 0);

            setGrade(grade);
            progressBar.getProgressDrawable().setColorFilter(barColor, PorterDuff.Mode.SRC_IN);
            textView.setTextColor(textColor);
            if (textSize>0){
                textView.setTextSize(TypedValue.COMPLEX_UNIT_PX,textSize);
            }


        }
    }



    public void setGrade(int grade){
        if (grade<0) grade= 0;
        if (grade>100) grade = 100;
        progressBar.setProgress(grade);
        textView.setText(String.valueOf(grade));
    }

    public TextView getTextView() {
        return textView;
    }
    public ProgressBar getProgressBar() {
        return progressBar;
    }
}
