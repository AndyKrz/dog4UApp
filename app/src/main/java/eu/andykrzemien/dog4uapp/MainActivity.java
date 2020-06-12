package eu.andykrzemien.dog4uapp;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import eu.andykrzemien.dog4uapp.ui.PagerAdapt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.fragment_home_final);

    TabLayout tabLayout = findViewById(R.id.tabLayout);
//    TabItem homeSecondFragment = findViewById(R.id.sizeDog);
//    TabItem homeThirdFragment = findViewById(R.id.activityDog);
//    TabItem homeFourthFragment = findViewById(R.id.childrenDog);
    final ViewPager viewPager = findViewById(R.id.viewPager);


//
//    viewModel = ViewModelProvider.class.getClasses(viewModel.class);
//    viewModel.getAllNotes();

    PagerAdapt pagerAdapter = new PagerAdapt(getSupportFragmentManager(),tabLayout.getTabCount());
    viewPager.setAdapter(pagerAdapter);

    tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
      @Override
      public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
      }

      @Override
      public void onTabUnselected(TabLayout.Tab tab) {

      }

      @Override
      public void onTabReselected(TabLayout.Tab tab) {

      }
    });
    viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));




  }

  @Override
  public boolean onNavigationItemSelected(@NonNull MenuItem item) {
    if(item.getItemId() == R.id.miniature){
      Toast.makeText(this,"Btn is clicked",Toast.LENGTH_SHORT).show();
    }
    return false;
  }



}
