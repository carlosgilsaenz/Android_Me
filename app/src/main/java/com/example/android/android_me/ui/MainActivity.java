/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.android_me.R;

// This activity is responsible for displaying the master list of all images
// Implement the MasterListFragment callback, OnImageClickListener
public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener{

    public static final String HEAD_INDEX = "HEAD";
    public static final String BODY_INDEX = "BODY";
    public static final String LEG_INDEX = "LEG";

    private int mHead_image = 0;
    private int mBody_image = 0;
    private int mLeg_image = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    // Define the behavior for onImageSelected
    public void onImageSelected(int position) {

        // complete (2) Based on where a user has clicked, store the selected list index for the head, body, and leg BodyPartFragments
        Toast.makeText(this,"Selected item in position " + position, Toast.LENGTH_SHORT).show();

        if(isBetween(position,0,11)){
            mHead_image = position;
        }else if(isBetween(position,12,22)){
            mBody_image = position - 12;
        } else if (isBetween(position,23, 35)){
            mLeg_image = position - 24;
        }

        // complete (3) Put this information in a Bundle and attach it to an Intent that will launch an AndroidMeActivity
        final Intent i = new Intent(this, AndroidMeActivity.class);
        i.putExtra(HEAD_INDEX,mHead_image);
        i.putExtra(BODY_INDEX,mBody_image);
        i.putExtra(LEG_INDEX,mLeg_image);

        // complete (4) Get a reference to the "Next" button and launch the intent when this button is clicked
        Button button = (Button) findViewById(R.id.next_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });
    }

    // helper method
    private static boolean isBetween(int x, int lower, int upper) {
        return lower <= x && x <= upper;
    }
}
