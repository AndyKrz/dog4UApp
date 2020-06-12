package eu.andykrzemien.dog4uapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import eu.andykrzemien.dog4uapp.R;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class ReturnToHome extends Fragment {

  Button button_home_second3, button_home_second,button_home_second4;
  RadioGroup radioGroup;
  RadioButton like, noMatter;
  RadioButton miniature,small,medium,large,giant;
  RadioButton lazy, lightActive, veryActive;
  TextView textView6;


  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState
  ) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_home_result, container, false);
  }

  public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    button_home_second4 = view.findViewById(R.id.button_home_second4);
    button_home_second4.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        int selectedId = radioGroup.getCheckedRadioButtonId();

        // find which radioButton is checked by id
        if(selectedId == miniature.getId() &&
           selectedId == lightActive.getId() &&
           selectedId == like.getId()) {
          textView6.setText("You chose 'Sound' option");
        } else if(selectedId == small.getId()) {
          textView6.setText("You chose 'Vibration' option");
        } else {
          textView6.setText("You chose 'Silent' option");
        }
      }
    });


    view.findViewById(R.id.button_home_second4).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
//        NavHostFragment.findNavController(ReturnToHome.this)
//            .navigate(R.id.action_returnToHome_to_navigation_home);
      }
    });
  }
}
