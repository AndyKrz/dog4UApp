package eu.andykrzemien.dog4uapp.ui;

import android.widget.RadioButton;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
  private MutableLiveData<RadioButton> buttons = new MutableLiveData<>();

  public void setButtons(RadioButton value) {
    buttons.setValue(value);
  }
  public LiveData<RadioButton> getValue(int checkedRadioButtonId) {
    return buttons;
  }


}
