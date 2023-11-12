package no.hvl.dat108.FestPaameldingApp.controller;


import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.FestPaameldingApp.Utils.LoginUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class LoggedInController {

    /*
    @GetMapping("paameldte")
    public String showPaameldte(HttpSession session, RedirectAttributes ra) {

        if(!LoginUtil.erBrukerInnlogget(session)) {
            ra.addFlashAttribute("redirectMessage", "Invalid Session");
            return "redirect:login";
        }
        return "deltagerlisteView";
    }

     */


}
