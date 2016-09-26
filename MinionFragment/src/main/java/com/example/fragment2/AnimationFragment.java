package com.example.fragment2;


import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AnimationFragment extends Fragment {


    private static final String KEY_MINION =  "minion" ;

    public AnimationFragment() {
        // Required empty public constructor
    }

    public static AnimationFragment getInstance(int minion) {

        AnimationFragment fragment = new AnimationFragment();

        Bundle bundle = new Bundle();
        bundle.putInt(KEY_MINION,minion);
        fragment.setArguments(bundle);
        return fragment;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootview = inflater.inflate(R.layout.fragment_animation,container, false);

        changeminion(rootview, getArguments().getInt(KEY_MINION));

        return rootview;
    }

    public void changeminion(View rootview1,int minion) {

        ((ImageView)rootview1.findViewById(R.id.imageMinion)).setImageResource(R.drawable.bob);
    }

}
