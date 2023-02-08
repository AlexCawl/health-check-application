package org.alexcawl.health_check_application.service;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.alexcawl.health_check_application.model.data.AccountData;
import org.alexcawl.health_check_application.model.exception.BadRequestException;
import org.alexcawl.health_check_application.model.exception.NotFoundException;

public class LoginService implements ILoginService {
    @Override
    public AccountData login(@NonNull String username, @NonNull String password) throws NotFoundException, BadRequestException {
        return null;
    }

    @Override
    public AccountData register(@NonNull String username, @NonNull String password, @Nullable String email) throws NotFoundException, BadRequestException {
        return null;
    }
}
