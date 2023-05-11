package com.example.musique;

import android.os.Bundle;
import android.R.drawable;
import androidx.fragment.app.Fragment;
import android.widget.Button;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Player#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Player extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Player() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Player.
     */
    // TODO: Rename and change types and number of parameters
    public static Player newInstance(String param1, String param2) {
        Player fragment = new Player();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_player, container, false);
        FloatingActionButton play;
        Button prev, next;
        play = view.findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                MainActivity.playButton();
                if (MainActivity.isPlaying) {
                    // Do this
                    play.setImageResource(17301539);
                } else {
                    // Do that
                    play.setImageResource(17301540);
                }
            }
        });
        return view;
    }
}