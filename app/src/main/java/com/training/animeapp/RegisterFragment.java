package com.training.animeapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterFragment extends Fragment {

    private TextInputLayout firstNameLayout, secondNameLayout, emailLayout, passwordLayout;
    private TextInputEditText firstNameEditText, secondNameEditText, emailEditText, passwordEditText;
    private MaterialButton registerButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        firstNameLayout = view.findViewById(R.id.textInputLayout);
        secondNameLayout = view.findViewById(R.id.textInputLayout2);
        emailLayout = view.findViewById(R.id.textInputLayout3);
        passwordLayout = view.findViewById(R.id.textInputLayout4);

        firstNameEditText = view.findViewById(R.id.register_firstname);
        secondNameEditText = view.findViewById(R.id.register_secondname);
        emailEditText = view.findViewById(R.id.register_email);
        passwordEditText = view.findViewById(R.id.login_password);

        registerButton = view.findViewById(R.id.loginButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateInput();
            }
        });

        return view;
    }

    private void validateInput() {
        boolean isValid = true;

        // Validate First Name
        if (TextUtils.isEmpty(firstNameEditText.getText())) {
            firstNameLayout.setError("First name is required");
            isValid = false;
        } else {
            firstNameLayout.setError(null);
        }

        // Validate Second Name
        if (TextUtils.isEmpty(secondNameEditText.getText())) {
            secondNameLayout.setError("Second name is required");
            isValid = false;
        } else {
            secondNameLayout.setError(null);
        }

        // Validate Email
        String email = emailEditText.getText().toString();
        if (TextUtils.isEmpty(email)) {
            emailLayout.setError("Email is required");
            isValid = false;
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailLayout.setError("Enter a valid email");
            isValid = false;
        } else {
            emailLayout.setError(null);
        }

        // Validate Password
        if (TextUtils.isEmpty(passwordEditText.getText())) {
            passwordLayout.setError("Password is required");
            isValid = false;
        } else if (passwordEditText.getText().length() < 6) {
            passwordLayout.setError("Password must be at least 6 characters long");
            isValid = false;
        } else {
            passwordLayout.setError(null);
        }

        // If everything is valid
        if (isValid) {
            Toast.makeText(getActivity(), "Registration Successful", Toast.LENGTH_SHORT).show();
            // Create Intent and pass the first name
            Intent intent = new Intent(getActivity(), NavDrawerActivity.class);
            intent.putExtra("firstName", firstNameEditText.getText().toString());
            startActivity(intent);


            // Optional: Clear the form fields after successful registration
            clearFormFields();
        }
    }

    private void clearFormFields() {
        firstNameEditText.setText("");
        secondNameEditText.setText("");
        emailEditText.setText("");
        passwordEditText.setText("");
    }
}
