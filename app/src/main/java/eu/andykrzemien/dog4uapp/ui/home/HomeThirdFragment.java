package eu.andykrzemien.dog4uapp.ui.home;

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

public class HomeThirdFragment extends Fragment {

  SharedViewModel viewModel;
  ViewPager viewPager;
  TextView textView3;
  RadioGroup radioGroup;
  RadioButton miniature,small,medium,large,giant;
  RadioButton lazy, lightActive, veryActive;



  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState
  ) {
    // Inflate the layout for this fragment
    View rootView = inflater.inflate(R.layout.fragment_home_third, container, false);

    Button button_home_second2 = (Button) rootView.findViewById(R.id.button_home_second2);
    button_home_second2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        viewPager = (ViewPager) Objects.requireNonNull(getActivity()).findViewById(R.id.viewPager);
        viewPager.setCurrentItem(2);
        viewModel.getValue(radioGroup.getCheckedRadioButtonId());
      }
    });

    Button pButton1 = (Button) rootView.findViewById(R.id.pButton1);
    pButton1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        viewPager = (ViewPager) getActivity().findViewById(R.id.viewPager);
        viewPager.setCurrentItem(4);
      }
    });
    return rootView;


  }

  public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);


    textView3 = view.findViewById(R.id.textView3);
    radioGroup = view.findViewById(R.id.activityList);

    miniature = (RadioButton) view.findViewById(R.id.miniature);
    small = (RadioButton) view.findViewById(R.id.small);
    medium = (RadioButton) view.findViewById(R.id.medium);
    large = (RadioButton) view.findViewById(R.id.large);
    giant = (RadioButton) view.findViewById(R.id.giant);


    lazy = (RadioButton) view.findViewById(R.id.lazy);
    lightActive = (RadioButton) view.findViewById(R.id.lightActive);
    veryActive = (RadioButton) view.findViewById(R.id.veryActive);

    radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

      @Override
      public void onCheckedChanged(RadioGroup group, int checkedId) {
        // find which radio button is selected
        if(checkedId == R.id.lazy) {
          Toast.makeText(getContext(), "Your dog don't need long walks",
              Toast.LENGTH_SHORT).show();
        } else if(checkedId == R.id.lightActive) {
          Toast.makeText(getContext(), "Your dog need a regular walks",
              Toast.LENGTH_SHORT).show();
        } else {
          Toast.makeText(getContext(), "Your dog need long walks",
              Toast.LENGTH_SHORT).show();
        }
      }

    });



    View.OnClickListener optionOnClickListener = new View.OnClickListener()   {

      @Override
      public void onClick(View v) {
        textView3.setText("Null");

        if(lazy.isChecked()){
          textView3.setText("LAAAAAZYYY I'M SO LAAZY");
        } else if(lightActive.isChecked()) {
          textView3.setText("Light walking");
        } else if(veryActive.isChecked()){
          textView3.setText("RUNNER");
        }
      }


    };
    lazy.setOnClickListener(optionOnClickListener);
    lightActive.setOnClickListener(optionOnClickListener);
    veryActive.setOnClickListener(optionOnClickListener);

  }
  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    viewModel = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
    viewModel.getValue(R.id.activityList).observe(getViewLifecycleOwner(), new Observer<RadioButton>() {
      @Override
      public void onChanged(RadioButton radioButton) {
        radioGroup.getCheckedRadioButtonId();
      }
    });
  }
}
