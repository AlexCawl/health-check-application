package org.alexcawl.health_check_application.ui.fragment;

import static android.content.ContentValues.TAG;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.alexcawl.health_check_application.R;
import org.alexcawl.health_check_application.databinding.FragmentSettingsBinding;
import org.alexcawl.health_check_application.ui.activity.HomeActivity;

public class SettingsFragment extends Fragment {
    private FragmentSettingsBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSettingsBinding.inflate(inflater);
        initTitle();
        return binding.getRoot();
    }

    private void initTitle() {
        try {
            ((HomeActivity) this.getActivity()).getSupportActionBar().setTitle("Settings Fragment");
        } catch (NullPointerException exception) {
            Log.w(TAG, "initTitle: ", exception);
        }
    }
}