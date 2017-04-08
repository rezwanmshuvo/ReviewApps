package com.example.asus.reviewapps;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et1,et2,et3;
    TextView tv1,tv2,tv3;
    Button bt1,bt2,bt3,bt4,bt5,bt6;
    CheckBox cb1,cb2;
    RadioGroup rbg;
    RadioButton rb1,rb2;
    RatingBar rtb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        et3=(EditText)findViewById(R.id.et3);


        tv1=(TextView)findViewById(R.id.tv1);
        tv2=(TextView)findViewById(R.id.tv2);
        tv3=(TextView)findViewById(R.id.tv3);

        bt1=(Button)findViewById(R.id.bt1);
        bt2=(Button)findViewById(R.id.bt2);
        bt3=(Button)findViewById(R.id.bt3);
        bt4=(Button)findViewById(R.id.bt4);
        bt5=(Button)findViewById(R.id.bt5);
        bt6=(Button)findViewById(R.id.bt6);


        rtb=(RatingBar)findViewById(R.id.rtb);



        cb1=(CheckBox)findViewById(R.id.cb1);
        cb2=(CheckBox)findViewById(R.id.cb2);

        rbg=(RadioGroup)findViewById(R.id.rbg);



        rb1=(RadioButton)findViewById(R.id.rb1);
        rb2=(RadioButton)findViewById(R.id.rb2);

        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder obj=new AlertDialog.Builder(MainActivity.this);
                obj.setMessage("").setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"Please wait",Toast.LENGTH_LONG).show();
                        finish();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog=obj.create();
                alertDialog.setTitle("Want to Exit ?");
                alertDialog.show();



            }

        });

        rtb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {


                Toast.makeText(MainActivity.this,"Assess: "+String.valueOf(rating)+" Stars" , Toast.LENGTH_SHORT).show();
            }
        });

        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv3.setText("Assess: "+String.valueOf(rtb.getRating()));
                Toast.makeText(MainActivity.this,String.valueOf(rtb.getRating())+" Stars",Toast.LENGTH_LONG).show();
            }
        });

        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                et2.setText(rb1.getText());
            }
        });


        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                et2.setText(rb2.getText());
            }
        });


        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cnt=rbg.getCheckedRadioButtonId();
                RadioButton rb=(RadioButton)findViewById(cnt);

                Toast.makeText(MainActivity.this,rb.getText().toString()+" is selected",Toast.LENGTH_LONG).show();

                tv1.setText(rb.getText());
                et1.setText(rb.getText());
            }
        });

        cb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText(cb1.getText());
                Toast.makeText(MainActivity.this,"Nokia is selected",Toast.LENGTH_LONG).show();
            }
        });
        cb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText(cb2.getText());
                Toast.makeText(MainActivity.this,"Samsung is selected",Toast.LENGTH_LONG).show();
            }
        });


        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer chs=new StringBuffer();
                chs.append("Nokia :").append(cb1.isChecked());
                chs.append("\nSamsung:").append(cb2.isChecked());

                Toast.makeText(MainActivity.this,chs,Toast.LENGTH_LONG).show();

            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Float n1,n2,sm;
                n1=Float.parseFloat(et1.getText().toString());
                n2=Float.parseFloat(et2.getText().toString());
                sm=n1+n2;

                tv1.setText(Float.toString(sm));

            }
        });



        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv2.setText(et3.getText());
            }
        });



    }
}
