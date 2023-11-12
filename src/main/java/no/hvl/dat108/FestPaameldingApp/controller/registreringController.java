package no.hvl.dat108.FestPaameldingApp.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.FestPaameldingApp.InputValidator;
import no.hvl.dat108.FestPaameldingApp.Utils.LoginUtil;
import no.hvl.dat108.FestPaameldingApp.model.Deltager;
import no.hvl.dat108.FestPaameldingApp.service.DeltagerService;
import no.hvl.dat108.FestPaameldingApp.service.PassordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class registreringController {

    @Autowired
    DeltagerService deltagerService;
    @Autowired
    public InputValidator inputValidator;

    @GetMapping("/paamelding")
    public String getPaameldingView() {
        return "paamelding";
    }

    @PostMapping("/paamelding")
    public String registrerDeltager(HttpServletRequest rq, RedirectAttributes ra, Model model,
                                    @RequestParam(name = "fornavn") String fornavn,
                                    @RequestParam(name = "etternavn") String etternavn,
                                    @RequestParam(name = "mobil") String mobil,
                                    @RequestParam(name = "kjonn") String kjonn,
                                    @RequestParam(name = "passord") String passord,
                                    @RequestParam(name = "passordRepetert") String passordRepetert, HttpSession session) {

        if (deltagerService.exists(mobil)) {
            ra.addFlashAttribute("errorMessage", "Dette mobilnummeret er allerede blitt registert");
            return "redirect:login";
        } else if (!passord.equals(passordRepetert)) {
            ra.addFlashAttribute("errorMessage", "Passordene er ikke like, prøv på nytt");
            return "redirect:paamelding";
        } else if (!InputValidator.isValidUsername(fornavn)) {
                ra.addFlashAttribute("errorMessage", "Ugyldig input for fornavn");
                return "redirect:paamelding";
        } else if (!InputValidator.isValidLastname(etternavn)) {
                ra.addFlashAttribute("errorMessage", "Ugyldig input for etternavn");
                return "redirect:paamelding";
        } else if (!InputValidator.isValidPhoneNumber(mobil)) {
                ra.addFlashAttribute("errorMessage", "Ugyldig input for mobilnummer");
                return "redirect:paamelding";
        } else if (!InputValidator.isValidGender(kjonn)) {
            ra.addFlashAttribute("errorMessage", "Ugyldig input for kjønn, velg kjønn");
            return "redirect:paamelding";
        } else if (!InputValidator.isValidPassword(passord)) {
            ra.addFlashAttribute("errorMessage", "Passordet må ha minst 8 tegn, 1 stor bokstav og 1 tall");
            return "redirect:paamelding";
        }

            String salt = PassordService.genererTilfeldigSalt();
            passord = PassordService.hashMedSalt(passord, salt);


            Deltager nyDeltager = new Deltager(mobil, fornavn, etternavn, kjonn, salt, passord);
            nyDeltager = deltagerService.saveUser(nyDeltager);
            ra.addFlashAttribute("deltager", nyDeltager);
            model.addAttribute("deltager", nyDeltager);
            session.setAttribute("deltager", nyDeltager);
            LoginUtil.loggInnBrukerRegistrering(rq, mobil, passord);


            return "redirect:paameldt";

    }
}