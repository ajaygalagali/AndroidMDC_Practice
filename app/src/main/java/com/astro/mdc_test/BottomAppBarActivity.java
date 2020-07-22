package com.astro.mdc_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class BottomAppBarActivity extends AppCompatActivity {

    BottomAppBar bottomAppBar;
    Boolean isCenter;
    Switch aSwitch;

    // BottomSheet
    ConstraintLayout bottomSheet;
    BottomSheetBehavior bottomSheetBehavior;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_app_bar);

        bottomSheet = findViewById(R.id.bottomSheetCL);
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
        floatingActionButton = findViewById(R.id.floatingAB);


        bottomAppBar = findViewById(R.id.bottomAppBar);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });








        // Flaoting bar animation
        aSwitch = findViewById(R.id.switchAnimationMode);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    bottomAppBar.setFabAnimationMode(BottomAppBar.FAB_ANIMATION_MODE_SCALE);
                }else{
                    bottomAppBar.setFabAnimationMode(BottomAppBar.FAB_ANIMATION_MODE_SLIDE);
                }
            }
        });
        setSupportActionBar(bottomAppBar);

        isCenter = true;

        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isCenter){
                    bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_END);
                    isCenter = false;
                }else{
                    bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_CENTER);
                    isCenter = true;
                }

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.bottom_app_bar_menu,menu);


        return true;
    }
}