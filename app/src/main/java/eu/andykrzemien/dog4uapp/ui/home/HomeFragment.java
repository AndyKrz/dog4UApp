package eu.andykrzemien.dog4uapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import eu.andykrzemien.dog4uapp.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.fragment.NavHostFragment;
import androidx.viewpager.widget.ViewPager;

public class HomeFragment extends Fragment {

  private HomeViewModel homeViewModel;
  ViewPager viewPager;

  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
    homeViewModel =
        ViewModelProviders.of(this).get(HomeViewModel.class);
    View root = inflater.inflate(R.layout.fragment_home, container, true);
//    final TextView textView = root.findViewById(R.id.text_home);
    homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
      @Override
      public void onChanged(@Nullable String s) {
//        textView.setText(s);
      }
    });
    return root;

    // Inflate the layout for this fragment
//    View rootView = inflater.inflate(R.layout.fragment_home, container, false);

//    Button button_home = (Button) rootView.findViewById(R.id.button_home);
//    button_home.setOnClickListener(new View.OnClickListener() {
//      @Override
//      public void onClick(View v) {
//        viewPager = (ViewPager) Objects.requireNonNull(getActivity()).findViewById(R.id.viewPager);
//        viewPager.setCurrentItem(-1);
//      }
//    });
//    return rootView;


  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    view.findViewById(R.id.button_home).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
//        HomeFragmentDirections.ActionHomeFragmentToHomeSecondFragment action =
//            HomeFragmentDirections.actionHomeFragmentToHomeSecondFragment
//                ("From HomeFragment");
//        NavHostFragment.findNavController(HomeFragment.this)
//            .navigate(action);
        NavHostFragment.findNavController(HomeFragment.this).navigate(R.id.action_navigation_home_to_mainActivity);


      }
    });
  }
}
