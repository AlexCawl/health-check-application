package org.alexcawl.health_check_application.ui.login.fragment;

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
import org.alexcawl.health_check_application.databinding.FragmentRegisterBinding;

public class RegisterFragment extends Fragment {
    private FragmentRegisterBinding binding;
    private NavController navController;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentRegisterBinding.inflate(inflater, container, false);
        initUsernameOptionHidingAction(binding.imageButtonUsernameField);
        initEmailOptionHidingAction(binding.imageButtonEmailField);
        initNavigateToLoginButton(binding.loginButton);
        initPasswordHidingAction(binding.imageButtonPasswordField1, binding.editTextPasswordField1);
        initPasswordHidingAction(binding.imageButtonPasswordField2, binding.editTextPasswordField2);
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

    public void initEmailOptionHidingAction(ImageButton button) {
        button.setOnClickListener(listener -> {
            ViewGroup.LayoutParams hiddenTextParams = binding.hiddenEmailOptions.getLayoutParams();

            if (binding.hiddenEmailOptions.getHeight() == 0) {
                hiddenTextParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
            } else {
                hiddenTextParams.height = 0;
            }

            binding.hiddenEmailOptions.setLayoutParams(hiddenTextParams);
        });
    }

    private void initNavigateToLoginButton(Button button) {
        button.setOnClickListener(listener -> navController.navigate(R.id.nav_login));
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
}
