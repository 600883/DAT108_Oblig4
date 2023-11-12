package no.hvl.dat108.FestPaameldingApp.controller;


import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.FestPaameldingApp.Utils.LoginUtil;
import no.hvl.dat108.FestPaameldingApp.model.Deltager;
import no.hvl.dat108.FestPaameldingApp.service.DeltagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/")
public class DeltagerListController {

    @Autowired
    DeltagerService deltagerService;

    @GetMapping("/deltagerliste")
    public String getDeltagerList(HttpSession session, Model model, RedirectAttributes ra) {

        if(!LoginUtil.erBrukerInnlogget(session)) {
            ra.addFlashAttribute("errorMessage", "Du må være logget inn for å se deltagerlisten.");
            return "redirect:login";
        }

            List<Deltager> deltagerListe = deltagerService.findAllDeltagere();
            Collections.sort(deltagerListe);

            Deltager deltager = (Deltager) session.getAttribute("deltager");

            model.addAttribute("deltagerListe", deltagerListe);

            return "deltagerlisteView";

    }

}
