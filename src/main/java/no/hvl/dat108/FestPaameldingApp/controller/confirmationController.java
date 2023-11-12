package no.hvl.dat108.FestPaameldingApp.controller;


import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.FestPaameldingApp.Utils.LoginUtil;
import no.hvl.dat108.FestPaameldingApp.model.Deltager;
import no.hvl.dat108.FestPaameldingApp.service.DeltagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class confirmationController {

    @Autowired
    DeltagerService deltagerService;

    @GetMapping("/paameldt")
    public String getConfirmation(HttpSession session, RedirectAttributes ra, Model model) {
        if(!LoginUtil.erBrukerInnlogget(session)) {
            ra.addFlashAttribute("errorMessage", "Du må være logget inn for å se denne siden.");
            return "redirect:login";
        }

        Deltager deltager = (Deltager) session.getAttribute("deltager");

        return "paameldt";
    }
}
