package eu.andykrzemien.dog4uapp.ui;

import eu.andykrzemien.dog4uapp.ui.home.HomeFourthFragment;
import eu.andykrzemien.dog4uapp.ui.home.HomeFragment;
import eu.andykrzemien.dog4uapp.ui.home.HomeSecondFragment;
import eu.andykrzemien.dog4uapp.ui.home.HomeThirdFragment;
import eu.andykrzemien.dog4uapp.ui.home.ReturnToHome;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapt extends FragmentPagerAdapter{

  private int numOfTabs;

  public PagerAdapt(FragmentManager fm, int numOfTabs) {
    super(fm);
  this.numOfTabs = numOfTabs;
  }

  @NonNull
  @Override
  public Fragment getItem(int position) {
    switch (position) {
      case -1:
      return new HomeFragment();
      case 0:
        return new HomeSecondFragment();
      case 1:
        return new HomeThirdFragment();
      case 2:
        return new HomeFourthFragment();
//      case 3:
//        return new ReturnToHome();
      default:
        return null;
    }
  }

  @Override
  public int getCount() {
    return numOfTabs;
  }

}
