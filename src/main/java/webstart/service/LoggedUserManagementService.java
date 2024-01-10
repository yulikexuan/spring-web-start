//: webstart.service.LoggedUserManagementService.java


package webstart.service;


import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;


public interface LoggedUserManagementService {

    String username();

    LoggedUserManagementService username(String username);

    static LoggedUserManagementService of() {
        return LoggedUserManagementServiceImpl.of();
    }

}


@Slf4j
@Accessors(fluent = true)
@NoArgsConstructor(staticName = "of")
final class LoggedUserManagementServiceImpl implements LoggedUserManagementService {

    private String username;

    @Override
    public String username() {

        log.info(">>> Fetching username from {}", this.toString());

        return this.username;
    }

    @Override
    public LoggedUserManagementService username(String username) {

        log.info(">>> Setting up username {} in {}", username, this.toString());

        this.username = username;

        return this;
    }
}

///:~