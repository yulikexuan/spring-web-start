//: webstart.service.LoginService


package webstart.service;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import webstart.domain.model.UserCredential;


public interface LoginService {

    String VIP = "yul";
    String VIP_PW = "montreal";

    String VIP_2 = "berry";
    String PW_2 = "vancouver";

    boolean login(UserCredential userCredential);

    static LoginService of(
            @NonNull final LoginCountService loginCountService,
            @NonNull final LoggedUserManagementService loggedUserManagementService) {

        return LoginServiceImpl.of(loginCountService, loggedUserManagementService);
    }
}

@RequiredArgsConstructor(staticName = "of")
final class LoginServiceImpl implements LoginService {

    private final LoginCountService loginCountService;
    private final LoggedUserManagementService loggedUserManagementService;

    @Override
    public boolean login(UserCredential userCredential) {

        this.loginCountService.increment();

        boolean loggedIn = UserCredential.of(VIP, VIP_PW).equals(userCredential)
                || UserCredential.of(VIP_2, PW_2).equals(userCredential);

        if (loggedIn) {
            this.loggedUserManagementService.username(userCredential.username());
        }

        return loggedIn;
    }

}

///:~