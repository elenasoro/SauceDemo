package testdata;

import models.LoginModel;

public class PrepareLoginData {

    public static LoginModel getStandardUserCredentials() {
        return LoginModel
                .builder()
                .login("standard_user")
                .password("secret_sauce")
                .build();
    }

    public static LoginModel getLockedUserCredentials() {
        return LoginModel
                .builder()
                .login("locked_out_user")
                .password("secret_sauce")
                .build();
    }

    public static LoginModel getProblemUserCredentials() {
        return LoginModel
                .builder()
                .login("problem_user")
                .password("secret_sauce")
                .build();
    }

    public static LoginModel getPerformanceGlitchCredentials() {
        return LoginModel
                .builder()
                .login("performance_glitch_user")
                .password("secret_sauce")
                .build();
    }
}
