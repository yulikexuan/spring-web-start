//: webstart.controller.LoginController.java


package webstart.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import webstart.domain.model.UserCredential;
import webstart.service.LoginService;


@Slf4j
@Controller
@RequiredArgsConstructor
class LoginController {

    private final LoginService loginService;

    @GetMapping("/")
    public String loginPage() {
        return "login.html";
    }

    @PostMapping("/")
    public String login(
            @RequestParam String username,
            @RequestParam String password,
            Model model) {

        log.info(">>> Show LoginService Instance: {}", this.loginService.toString());

        if (loginService.login(UserCredential.of(username, password))) {
            model.addAttribute("username");
            return "redirect:/main";
        }

        model.addAttribute("message", ">>> Login failed");

        return "login.html";
    }

}///:~