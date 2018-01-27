package by.vandr.vkpars.ui.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import by.vandr.vkpars.R;
import by.vandr.vkpars.ui.adapter.ViewPagerAdapter;
//import by.vandr.vkpars.ui.fragment.FragmentUser;
import by.vandr.vkpars.ui.fragment.PageFragment;
import by.vandr.vkpars.ui.fragment.SimpleFragment;

/**
 * Created by V on 06.11.2017.
 */
public class TestActivity extends AppCompatActivity  {



        private Toolbar toolbar;
        private TabLayout tabLayout;
        private ViewPager viewPager;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
           // setContentView(R.layout.test_act);


            toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            android.support.v7.app.ActionBar actionBar = getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(true);


            viewPager = (ViewPager) findViewById(R.id.viewpager);
            setupViewPager(viewPager);

            tabLayout = (TabLayout) findViewById(R.id.tablayout);
            tabLayout.setupWithViewPager(viewPager);


        }

        private void setupViewPager(ViewPager viewPager) {
            ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
            //adapter.addFragment(new FragmentUser(),"User");
            adapter.addFragment(new SimpleFragment(), "Group");
            adapter.addFragment(new PageFragment(), "Calls");
           // View view = new View(this);

            viewPager.setAdapter(adapter);
           // ViewPagerAdapter ad = new ViewPagerAdapter(getSupportFragmentManager());
            //adapter.addFragment();
            //viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        }





//
//TextView textView;
//    public void OnClick(View view) {
//        final VKRequest request = VKApi.users().get();
//        request.executeWithListener(new VKRequest.VKRequestListener() {
//                                        @Override
//                                        public void onComplete(VKResponse response) {
//                                            super.onComplete(response);
//                                            //textView = (TextView) findViewById(R.id.txt);
//                                            textView.setText(response.json.toString());
//                                        }
//                                    });
//    }

}
