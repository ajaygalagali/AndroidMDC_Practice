package com.astro.mdc_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.nio.charset.CharacterCodingException;

public class MainActivity extends AppCompatActivity {

    Button snackBarbtn,dialogbtn,datePickerBtn,inputFieldsBtn,navDrawerBtn;

    FloatingActionButton fab_main,fab_one,fab_two;
    TextView t_one,t_two;
    Boolean isOpen;
    Animation fab_open,fab_close;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //NavDrawer
        navDrawerBtn = findViewById(R.id.buttonNavDrawer);
        navDrawerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goTonav = new Intent(MainActivity.this,NavDrawerActivity.class);
                startActivity(goTonav);
            }
        });
        //Input Fields
        inputFieldsBtn = findViewById(R.id.buttonInputFields);
        inputFieldsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goTOinput = new Intent(MainActivity.this,InputFieldsActivity.class);
                startActivity(goTOinput);
            }
        });

        // Date Picker
        datePickerBtn = findViewById(R.id.buttonDatePicker);
        MaterialDatePicker.Builder datepickerBuilder = MaterialDatePicker.Builder.datePicker();
        datepickerBuilder.setTitleText("Hello world");
        final MaterialDatePicker materialDatePicker = datepickerBuilder.build();

        datePickerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialDatePicker.show(getSupportFragmentManager(),"Date_picker");
            }
        });

        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @Override
            public void onPositiveButtonClick(Object selection) {

            }
        });







        // BottomAppBar
        Button bottomAppBarbtn = findViewById(R.id.buttonBottomAppBAr);
        bottomAppBarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToBAppBar = new Intent(MainActivity.this, BottomAppBarActivity.class);
                startActivity(goToBAppBar);
            }
        });

        // FloatingActionButton
        fab_main = findViewById(R.id.fab_main);
        fab_one = findViewById(R.id.fab_one);
        fab_two = findViewById(R.id.fab_two);

        t_one = findViewById(R.id.fabT_one);
        t_two = findViewById(R.id.fabT_two);

        fab_open = AnimationUtils.loadAnimation(MainActivity.this,R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(MainActivity.this,R.anim.fab_close);

        isOpen = false;


        fab_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isOpen){

                    /*fab_one.setAnimation(fab_close);
                    fab_two.setAnimation(fab_close);
                    t_one.setAnimation(fab_close);
                    t_two.setAnimation(fab_close);*/
                    fab_one.startAnimation(fab_close);
                    fab_two.startAnimation(fab_close);
                    t_one.startAnimation(fab_close);
                    t_two.startAnimation(fab_close);

                    fab_main.animate().rotation(0).setDuration(500);

                    isOpen = false;
                }else{
                    fab_one.startAnimation(fab_open);
                    fab_two.startAnimation(fab_open);
                    t_one.startAnimation(fab_open);
                    t_two.startAnimation(fab_open);

                    fab_main.animate().rotation(45).setDuration(500);

                    isOpen = true;

                }

            }
        });





        // SnackBar
        snackBarbtn = findViewById(R.id.snackbarClicked);
        snackBarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(v,"This is a snackbar",Snackbar.LENGTH_LONG);
                snackbar.setAction("Action", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "This is a Action", Toast.LENGTH_SHORT).show();
                    }
                });
                snackbar.show();
            }
        });

        // Dialog

        final CharSequence[] charSequence = new CharSequence[] {
            "zero","one","two","three"
        };
        dialogbtn = findViewById(R.id.dialogbutton);
        dialogbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialAlertDialogBuilder dialogBuilder = new MaterialAlertDialogBuilder(MainActivity.this);
                dialogBuilder.setTitle("I am dialog!");
//                dialogBuilder.setMessage("This is a message");
                dialogBuilder.setSingleChoiceItems(charSequence, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, charSequence[which], Toast.LENGTH_SHORT).show();
                    }
                });
                dialogBuilder.setBackground(getResources().getDrawable(R.drawable.dialog_bg,null));
                dialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Positive Button", Toast.LENGTH_SHORT).show();
                    }
                });
                dialogBuilder.show();
            }
        });


    }
}