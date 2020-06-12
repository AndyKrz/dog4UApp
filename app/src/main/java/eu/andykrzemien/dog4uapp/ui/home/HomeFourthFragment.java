package eu.andykrzemien.dog4uapp.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import eu.andykrzemien.dog4uapp.R;
import eu.andykrzemien.dog4uapp.ui.SharedViewModel;

import java.util.Objects;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

public class HomeFourthFragment extends Fragment {

  SharedViewModel viewModel;
  ViewPager viewPager;
  TextView textView4;
  RadioGroup radioGroup;
  RadioButton like, noMatter;
  RadioButton small,medium,miniature,large,giant;
  RadioButton lazy,lightActive,veryActive;

  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState
  ) {
    // Inflate the layout for this fragment
    View rootView = inflater.inflate(R.layout.fragment_home_fourth, container, false);

    Button pButton2 = (Button) rootView.findViewById(R.id.pButton2);
    pButton2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        viewPager = (ViewPager) Objects.requireNonNull(getActivity()).findViewById(R.id.viewPager);
        viewPager.setCurrentItem(1);
      }
    });
    Button button_home_second3 = (Button) rootView.findViewById(R.id.button_home_second3);
    button_home_second3.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
//        NavHostFragment.findNavController(HomeFourthFragment.this).navigate(R.id.action_navigation_home_to_mainActivity);
        viewPager = (ViewPager) Objects.requireNonNull(getActivity()).findViewById(R.id.viewPager);
        viewPager.setCurrentItem(0);
      }
    });




    return rootView;


  }


  public void onClick1(View view) {
    boolean checked = ((RadioButton) view).isChecked();
    switch (view.getId()) {
      case R.id.like:
        if (checked) {
          Context context = getContext();
          int duration = Toast.LENGTH_SHORT;
          CharSequence text = "Like";
          Toast toast = Toast.makeText(context, text, duration);
          toast.show();
        }
        break;
      case R.id.noMatter:
        if (checked) {
          Context context = getContext();
          int duration = Toast.LENGTH_SHORT;
          CharSequence text = "No matter";
          Toast toast = Toast.makeText(context, text, duration);
          toast.show();
        }
        break;
    }
  }

  public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    radioGroup = view.findViewById(R.id.childrenList);

    textView4 = (TextView) view.findViewById(R.id.textView4);
    like = (RadioButton) view.findViewById(R.id.like);
    noMatter = (RadioButton) view.findViewById(R.id.noMatter);
    large = (RadioButton) view.findViewById(R.id.large);

    radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

      @Override
      public void onCheckedChanged(RadioGroup group, int checkedId) {
        // find which radio button is selected
        if(checkedId == R.id.like){
          Toast.makeText(getContext(), "Your dog like children",
              Toast.LENGTH_SHORT).show();
        }  else {
          Toast.makeText(getContext(), "Your dog don't bother",
              Toast.LENGTH_SHORT).show();
        }
      }

    });
    View.OnClickListener optionOnClickListener = new View.OnClickListener() {
      @Override
      public void onClick(View v) {
//    textView.setText("Null");

        if((like.isChecked()) || (large.isChecked())){
          textView4.setText("MINIATURE");
        }
        else if(noMatter.isChecked()){
          textView4.setText("SMALL");
        }
        else if(medium.isChecked())
        {
          textView4.setText("MEDIUM");
        }
//        else if(large.isChecked()) {
//          textView4.setText("LARGE");
//        }
//        else if(giant.isChecked()){
//          textView4.setText("GIANT");
//        }

      }
    };

    View.OnClickListener chihuahua = new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if((like.isChecked()) && (lazy.isChecked())) {
          textView4.setText("Chihuahua");
        }
      }


    };
    like.setOnClickListener(chihuahua);
//    chihuahua.onClick(chihuahua);
//
//like.setOnClickListener(optionOnClickListener);
//medium.setOnClickListener(optionOnClickListener);

//    button_home_second3 = (Button)view.findViewById(R.id.button_home_second3);
//    button_home_second3.setOnClickListener(new View.OnClickListener() {
//
//      @Override
//      public void onClick(View v) {
//        int selectedId = radioGroup.getCheckedRadioButtonId();
//
//        // find which radioButton is checked by id
//        if(selectedId == like.getId()) {
//          textView.setText("You chose 'Sound' option");
//        } else if(selectedId == noMatter.getId()) {
//          textView.setText("You chose 'Vibration' option");
//        } else {
//          textView.setText("You chose 'Silent' option");
//        }
//      }
//    });
//
//    view.findViewById(R.id.button_home_second3).setOnClickListener(new View.OnClickListener() {
//      @Override
//      public void onClick(View view) {
////        NavHostFragment.findNavController(HomeFourthFragment.this)
////            .navigate(R.id.action_homeFourthFragment_to_returnToHome);
//      }
//    });
  }
  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    viewModel = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
    viewModel.getValue(R.id.childrenList).observe(getViewLifecycleOwner(), new Observer<RadioButton>() {
      @Override
      public void onChanged(RadioButton radioButton) {
        radioGroup.getCheckedRadioButtonId();
      }
    });
  }
}
