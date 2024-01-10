//: webstart.controller.MainController.java


package webstart.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import webstart.service.LoggedUserManagementService;
import webstart.service.LoginCountService;

import javax.servlet.http.HttpSession;


@Controller
@RequiredArgsConstructor
class MainController {

    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;

    @GetMapping("/main")
    public String webStartHome(
            HttpSession session,
            @RequestParam(required = false) final String logout,
            final Model model) {

        if (logout != null) {
            loggedUserManagementService.username(null);
        }

        String username = this.loggedUserManagementService.username();
        long count = loginCountService.count();

        if (username == null) {
            session.invalidate();
            return "redirect:/";
        }

        model.addAttribute("username",
                loggedUserManagementService.username());
        model.addAttribute("loginCount", count);

        return "main.html";
    }

}///:~