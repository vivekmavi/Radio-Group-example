package com.example.paras.radiogroupprogram;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup,radioGroup2;
    Button button1,clearButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    radioGroup= (RadioGroup) findViewById(R.id.radiogroup1);
    radioGroup2= (RadioGroup) findViewById(R.id.radiogroup2);

    radioGroup.setOnCheckedChangeListener(new MyClassToHandleRadioGroup(this));
    radioGroup2.setOnCheckedChangeListener(new MyClassToHandleRadioGroup(this));

    button1= (Button) findViewById(R.id.btn1);
    clearButton=(Button) findViewById(R.id.clrbtn);

    button1.setOnClickListener(new MyButtonClickHandler(this));
    clearButton.setOnClickListener(new MyButtonClickHandler(this));
    }
}

class MyClassToHandleRadioGroup implements RadioGroup.OnCheckedChangeListener
{
    MainActivity mainActivityReference;
    MyClassToHandleRadioGroup(Context c)
    {
        mainActivityReference = (MainActivity) c;
    }

    /*@Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked)
    {
        if(isChecked)
        {
            if(compoundButton.getId()==R.id.radiogroup1)
            {
                Toast.makeText(mainActivityReference,"item selected",Toast.LENGTH_SHORT).show();

            }
        }
    }*/
    //this did not worked bcs radiogroup implements RadioGroup.OnCheckedChangeListener
    //and not the CompuondButton.OnCheckedChangeListener

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int idOfRadioBtnSelected)
    {
        if (idOfRadioBtnSelected==R.id.radiobtn1)
        {
            Toast.makeText(mainActivityReference,"g1 item 1 selected",Toast.LENGTH_SHORT).show();
        }
        if (idOfRadioBtnSelected==R.id.radiobtn2)
        {
            Toast.makeText(mainActivityReference,"g1 item 2 selected",Toast.LENGTH_SHORT).show();
        }
        if (idOfRadioBtnSelected==R.id.radiobtn3)
        {
            Toast.makeText(mainActivityReference,"g1 item 3 selected",Toast.LENGTH_SHORT).show();
        }
        if (idOfRadioBtnSelected==R.id.radiobtn4)
        {
            Toast.makeText(mainActivityReference,"g1 item 4 selected",Toast.LENGTH_SHORT).show();
        }
        if (idOfRadioBtnSelected==R.id.radiobtn5)
        {
            Toast.makeText(mainActivityReference,"g2 item 1 selected",Toast.LENGTH_SHORT).show();
        }
        if (idOfRadioBtnSelected==R.id.radiobtn6)
        {
            Toast.makeText(mainActivityReference,"g2 item 2 selected",Toast.LENGTH_SHORT).show();
        }
        if (idOfRadioBtnSelected==R.id.radiobtn7)
        {
            Toast.makeText(mainActivityReference,"g2 item 3 selected",Toast.LENGTH_SHORT).show();
        }
        if (idOfRadioBtnSelected==R.id.radiobtn8)
        {
            Toast.makeText(mainActivityReference,"g2 item 4 selected",Toast.LENGTH_SHORT).show();
        }
    }
}
class MyButtonClickHandler implements View.OnClickListener
{   MainActivity mainActivityReference;
    MyButtonClickHandler(Context c)
    {
        mainActivityReference=(MainActivity) c;
    }

    @Override
    public void onClick(View view)
    {
        if (view.getId()==R.id.btn1)
        {
            mainActivityReference.radioGroup2.check(R.id.radiobtn6);
        }
        if (view.getId()==R.id.clrbtn)
        {
            mainActivityReference.radioGroup2.clearCheck();
            Toast.makeText(mainActivityReference,"grp 1 cleared",Toast.LENGTH_SHORT).show();
            mainActivityReference.radioGroup.clearCheck();
            Toast.makeText(mainActivityReference,"grp 2 cleared",Toast.LENGTH_SHORT).show();
        }
    }
}