package com.example.village;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;


public class HomeFragment extends Fragment {

    // GridLayout
    GridLayout gridLayout;



//    public HomeFragment() {
//        // Required empty public constructor
//    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


//      typehere code

        gridLayout = getView().findViewById(R.id.mainGridLayout);

        //Set on click on Card items
        setSingleClickEvent(gridLayout);
    }

    private void setSingleClickEvent(GridLayout mainGridLayout) {
        for(int i=0;i<mainGridLayout.getChildCount();i++){
            CardView cardview = (CardView)gridLayout.getChildAt(i);
            final int finali = i;

            cardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (finali == 0){
                        Intent intent = new Intent(getActivity(), buyMilkActivity.class);
                        startActivity(intent);
                    }
                    else if(finali == 1){
                        Intent intent = new Intent(getActivity(), sellMilkActivity.class);
                        startActivity(intent);

                    }
                    else if(finali == 2){
                        Intent intent = new Intent(getActivity(), customerActivity.class);
                        startActivity(intent);

                    }
                    else if(finali == 3){
                        Intent intent = new Intent(getActivity(), registerActivity.class);
                        startActivity(intent);

                    }
                    else if(finali == 4){
                        Intent intent = new Intent(getActivity(), productsActivity.class);
                        startActivity(intent);

                    }
                    else if(finali == 5){
                        Intent intent = new Intent(getActivity(), membershipActivity.class);
                        startActivity(intent);

                    }
                    else if(finali == 6){
                        Intent intent = new Intent(getActivity(), bulkMilkActivity.class);
                        startActivity(intent);

                    }
                    else if(finali == 7){
                        Intent intent = new Intent(getActivity(), reportActivity.class);
                        startActivity(intent);

                    }

                }
            });
        }
    }
}