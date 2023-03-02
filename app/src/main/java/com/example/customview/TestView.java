package com.example.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

public class TestView extends View {
/*
    public TestView(Context context) {
        super(context);


    }*/

    private String mText = "Imooc";
    public TestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //获取自定义属性的值
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TestView);

        boolean booleanTest = ta.getBoolean(R.styleable.TestView_test_boolean, false);
        int integerTest = ta.getInteger(R.styleable.TestView_test_integer, 0);
        String dimensionTest = ta.getString(R.styleable.TestView_test_string);
        int enumTest = ta.getInt(R.styleable.TestView_test_emum, 1);


        //第二种方式获取值，这种方法会值获得用户赋值的属性
        int count = ta.getIndexCount();
        for (int i = 0; i < count; i++) {
            int index = ta.getIndex(i);
            switch (index)
            {
                //只有给匹配的属性赋时才能获取这个值
                case R.styleable.TestView_test_integer:
                    mText = ta.getString(R.styleable.TestView_test_string);
                    break;

            }
        }

        Log.e("TAG",booleanTest+","+integerTest+","+dimensionTest+","+enumTest);

        //回收
        ta.recycle();
    }

   //布局文件使用的话一定要复写，反射调用
    public TestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /*public TestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }*/
}
