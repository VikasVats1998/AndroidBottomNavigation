package com.example.village;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class MainActivity extends AppCompatActivity {

    MeowBottomNavigation bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

//        Assigning Variable
        bottomNavigation = findViewById(R.id.bottomnavigation);

//        Add menu items
        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_menu));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_notifiction));


        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
//                Initiallize fragment
                Fragment fragment = null;

//                Check Condition
                switch(item.getId()){
                    case 1:
                        fragment = new MenuFragment();
                        break;
                    case 2:
                        fragment = new HomeFragment();
                        break;
                    case 3:
                        fragment = new NotificationFragment();
                        break;

                }
//                Load fragment
                loadFrgment(fragment);
            }
        });
//        Set notification count
        bottomNavigation.setCount(3,"5");

//        Set home fragment initially selected
        bottomNavigation.show(2,true);

        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
//                Toast.makeText(getApplicationContext(),"you clicked" + item.getId(),Toast.LENGTH_SHORT).show();
            }
        });

        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
//                Toast.makeText(getApplicationContext(),"you Reselected" + item.getId(),Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void loadFrgment(Fragment fragment) {
//        Replace Fragement
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.framelayout,fragment)
                .commit();

    }
}
