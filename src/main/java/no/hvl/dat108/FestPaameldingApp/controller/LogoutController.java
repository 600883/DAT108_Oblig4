package no.hvl.dat108.FestPaameldingApp.controller;

import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.FestPaameldingApp.Utils.LoginUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class LogoutController {

    @PostMapping("/logout")
    public String getLoginView(HttpSession session, RedirectAttributes ra) {
        LoginUtil.loggUtBruker(session);
        return "redirect:login";
    }

}
