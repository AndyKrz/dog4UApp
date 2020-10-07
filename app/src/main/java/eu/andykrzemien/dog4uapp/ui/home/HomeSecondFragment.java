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

public class HomeSecondFragment extends Fragment {

  SharedViewModel viewModel;
  ViewPager viewPager;
  TextView textView;
  RadioGroup radioGroup;
  RadioButton miniature,small,medium,large,giant;



  public void dogSize(View view) {

    boolean checked = ((RadioButton) view).isChecked();
    switch (view.getId()) {
      case R.id.miniature:
        if (checked) {
          Context context = getContext();
          int duration = Toast.LENGTH_SHORT;
          CharSequence text = "Chihuahua";
          Toast toast = Toast.makeText(context, text, duration);
          toast.show();
        }
        break;
      case R.id.small:
        if (checked) {
          Context context = getContext();
          int duration = Toast.LENGTH_SHORT;
          CharSequence text = "Yorkshire";
          Toast toast = Toast.makeText(context, text, duration);
          toast.show();
        }
        break;
      case R.id.medium:
        if (checked) {
          Context context = getContext();
          int duration = Toast.LENGTH_SHORT;
          CharSequence text = "Chow chow";
          Toast toast = Toast.makeText(context, text, duration);
          toast.show();
        }
        break;
      case R.id.large:
        if (checked) {
          Context context = getContext();
          int duration = Toast.LENGTH_SHORT;
          CharSequence text = "Labrador";
          Toast toast = Toast.makeText(context, text, duration);
          toast.show();
        }
        break;
      case R.id.giant:
        if (checked) {
          Context context = getContext();
          int duration = Toast.LENGTH_SHORT;
          CharSequence text = "Great Dane";
          Toast toast = Toast.makeText(context, text, duration);
          toast.show();
        }
        break;
    }

    radioGroup.getCheckedRadioButtonId();
  }


  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState
  ) {
    // Inflate the layout for this fragment
    View rootView = inflater.inflate(R.layout.fragment_home_second, container, false);

    Button button_home_second = (Button) rootView.findViewById(R.id.button_home_second);
    button_home_second.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        viewPager = (ViewPager) Objects.requireNonNull(getActivity()).findViewById(R.id.viewPager);
        viewPager.setCurrentItem(1);
//        viewModel.getValue(radioGroup.getCheckedRadioButtonId());
      }
    });
    return rootView;
}




  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    textView = view.findViewById(R.id.textView);
    RadioGroup sizeList =(RadioGroup) view.findViewById(R.id.sizeList);

    sizeList.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

      @Override
      public void onCheckedChanged(RadioGroup group, int checkedId) {
        // find which radio button is selected

        Context context = getContext();
        RadioButton thisButton = (RadioButton) Objects.requireNonNull(getView()).findViewById(checkedId);
        Toast toast = Toast.makeText(context, thisButton.getText(), Toast.LENGTH_SHORT);
        toast.show();
        }
    });

  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    viewModel = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
    viewModel.getValue(R.id.sizeList).observe(getViewLifecycleOwner(), new Observer<RadioButton>() {
      @Override
      public void onChanged(RadioButton radioButton) {
        radioGroup.getCheckedRadioButtonId();
      }
    });
  }
}
