package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

/**
 * Created by Kuma-Licious on 8/13/2017.
 */

public class BodyPartFragment extends Fragment {
    //Empty Constructor
    public BodyPartFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //  Setup view with fragment xml
        View rootView = inflater.inflate(R.layout.fragment_body_part,container,false);

        //  Create instance of ImageView within Fragment
        ImageView im = (ImageView) rootView.findViewById(R.id.head_image_view);

        //  Set image resource using image utility
        im.setImageResource(AndroidImageAssets.getHeads().get(0));

        //  return view
        return rootView;
    }
}
