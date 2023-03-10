package org.alexcawl.health_check_application.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import org.alexcawl.health_check_application.R;
import org.alexcawl.health_check_application.databinding.FragmentLoginBinding;
import org.alexcawl.health_check_application.ui.activity.HomeActivity;

public class LoginFragment extends Fragment {
    private FragmentLoginBinding binding;
    private NavController navController;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        initUsernameOptionHidingAction(binding.imageButtonUsernameField);
        initPasswordHidingAction(binding.imageButtonPasswordField, binding.editTextPasswordField);
        initNavigateToRegisterButton(binding.registerButton);
        initNavigateToMainActivityButton(binding.loginButton);
        return binding.getRoot();
    }

    public void initUsernameOptionHidingAction(ImageButton button) {
        button.setOnClickListener(listener -> {
            ViewGroup.LayoutParams hiddenTextParams = binding.hiddenUsernameOptions.getLayoutParams();
            ViewGroup.LayoutParams dividerTopParams = binding.dividerTop.getLayoutParams();
            ViewGroup.LayoutParams dividerBottomParams = binding.dividerBottom.getLayoutParams();

            if (binding.hiddenUsernameOptions.getHeight() == 0) {
                hiddenTextParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                int dividerHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());
                dividerTopParams.height = dividerHeight;
                dividerBottomParams.height = dividerHeight;
            } else {
                hiddenTextParams.height = 0;
                int dividerHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5, getResources().getDisplayMetrics());
                dividerTopParams.height = dividerHeight;
                dividerBottomParams.height = dividerHeight;
            }

            binding.hiddenUsernameOptions.setLayoutParams(hiddenTextParams);
            binding.dividerTop.setLayoutParams(dividerTopParams);
            binding.dividerBottom.setLayoutParams(dividerBottomParams);
        });
    }

    private void initPasswordHidingAction(ImageButton button, EditText editText) {
        button.setOnClickListener(listener -> {
            if (editText.getTransformationMethod() == null) {
                editText.setTransformationMethod(new PasswordTransformationMethod());
            } else {
                editText.setTransformationMethod(null);
            }
        });
    }

    private void initNavigateToRegisterButton(Button button) {
        button.setOnClickListener(listener -> navController.navigate(R.id.destination_register));
    }

    private void initNavigateToMainActivityButton(Button button) {
        button.setOnClickListener(listener -> {
            Intent intent = new Intent(this.getContext(), HomeActivity.class);
            intent.putExtra("state", "successful_login");
            this.startActivity(intent);
        });
    }
}
