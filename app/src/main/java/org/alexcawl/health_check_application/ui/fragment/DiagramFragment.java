package org.alexcawl.health_check_application.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.alexcawl.health_check_application.databinding.FragmentDiagramBinding;

public class DiagramFragment extends Fragment {
    private FragmentDiagramBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDiagramBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}