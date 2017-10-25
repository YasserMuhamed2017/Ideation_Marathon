package com.example.yassermuhamed.ideationmarathon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.yassermuhamed.ideationmarathon.data.PetEntry;

public class NewActivity extends AppCompatActivity {

    private boolean mPetHasChanged = false;
    Spinner  mGenderSpinner;
    private int mGender =0;
    private View.OnTouchListener mTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            mPetHasChanged = true;
            return false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        mGenderSpinner = (Spinner) findViewById(R.id.spinner_gender);

        mGenderSpinner.setOnTouchListener(mTouchListener);

        setupSpinner();
    }

    private void setupSpinner(){
        // Create adapter for spinner. The list options are from the String array it will use
        // the spinner will use the default layout
        ArrayAdapter genderSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_gender_options, android.R.layout.simple_spinner_item);

        // Specify dropdown layout style - simple list view with 1 item per line
        genderSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // Apply the adapter to the spinner
        mGenderSpinner.setAdapter(genderSpinnerAdapter);

        // Set the integer mSelected to the constant values
        mGenderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(getString(R.string.ABS))) {
                        mGender = PetEntry.ABS; // Male
                    } else if (selection.equals(getString(R.string.PLA))) {
                        mGender = PetEntry.PLA; // Female
                    } else if(selection.equals(getString(R.string.PLA_WOOD))){
                        mGender = PetEntry.PLA_WOOD; // Unknown
                    } else if (selection.equals(getString(R.string.BET))){
                        mGender = PetEntry.BET;
                    }else if (selection.equals(getString(R.string.ALUMINUM_PLA))){
                        mGender = PetEntry.ALUMINUM_PLA;
                    }else if (selection.equals(getString(R.string.NILON))){
                        mGender = PetEntry.NILON;
                    }


                }
            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
             // Unknown
            }
        });
    }

}
