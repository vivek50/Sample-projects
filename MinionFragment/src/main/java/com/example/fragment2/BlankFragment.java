package com.example.fragment2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    ImageView imageView;


    public BlankFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View rootview = inflater.inflate(R.layout.fragment_blank, container, false);

        rootview.findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(getUserName(rootview).equals("admin") && getPassword(rootview).equals("admin")) {
                    Toast.makeText(getActivity(), "Login Success", Toast.LENGTH_SHORT).show();
                    imageView = (ImageView) rootview.findViewById(R.id.imageMinion2);
                    imageView.setImageResource(R.drawable.dave);
                    imageView.setVisibility(View.VISIBLE);
                }
                else
                {
                    Toast.makeText(getActivity(), "Login Failed", Toast.LENGTH_SHORT).show();
                    imageView = (ImageView) rootview.findViewById(R.id.imageMinion2);
                    imageView.setImageResource(R.drawable.oops_minion);
                    imageView.setVisibility(View.VISIBLE);
                }
            }
        });

        rootview.findViewById(R.id.btnRegister).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loadRegistrationFragment();

            }
        });
        return rootview;
    }

    private String getUserName(View rootview) {

        return ((EditText)rootview.findViewById(R.id.edtUserName)).getText().toString();

    }

    private String getPassword(View rootview) {

        return  ((EditText)rootview.findViewById(R.id.edtPassword)).getText().toString();
    }

    private void loadRegistrationFragment() {

        imageView.setVisibility(View.GONE);
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.framefragment,new RegistrationFragment());
        transaction.commit();

    }

}
