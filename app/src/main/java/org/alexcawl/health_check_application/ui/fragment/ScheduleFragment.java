package org.alexcawl.health_check_application.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import org.alexcawl.health_check_application.databinding.FragmentScheduleBinding;


public class ScheduleFragment extends Fragment {
    private FragmentScheduleBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentScheduleBinding.inflate(inflater);
        return binding.getRoot();
    }
}