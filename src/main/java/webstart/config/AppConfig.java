//: webstart.config.AppConfig.java


package webstart.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;
import webstart.repository.ProductRepository;
import webstart.service.LoggedUserManagementService;
import webstart.service.LoginCountService;
import webstart.service.LoginService;


@Configuration
@ComponentScan(basePackages = {"webstart.controller", "webstart.service"})
class AppConfig {

    @Bean
    @SessionScope
    LoggedUserManagementService loggedUserManagementService() {
        return LoggedUserManagementService.of();
    }

    @Bean
    @RequestScope
    LoginService loginService(
            LoginCountService loginCountService,
            LoggedUserManagementService loggedUserManagementService) {

        return LoginService.of(loginCountService, loggedUserManagementService);
    }

    @Bean
    @ApplicationScope
    LoginCountService loginCountService() {
        return LoginCountService.of();
    }

    @Bean
    ProductRepository productRepository() {
        return ProductRepository.of();
    }

}///:~