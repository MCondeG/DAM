package com.example.navlayout_viewpager2.ui.DifFragments;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DiferentesViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public DiferentesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Diferentes fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}