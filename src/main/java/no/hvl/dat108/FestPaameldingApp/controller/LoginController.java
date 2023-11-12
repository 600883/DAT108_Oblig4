package no.hvl.dat108.FestPaameldingApp.controller;

import jakarta.servlet.http.HttpServletRequest;
import no.hvl.dat108.FestPaameldingApp.InputValidator;
import no.hvl.dat108.FestPaameldingApp.Utils.LoginUtil;
import no.hvl.dat108.FestPaameldingApp.model.Deltager;
import no.hvl.dat108.FestPaameldingApp.repository.DeltagerRepository;
import no.hvl.dat108.FestPaameldingApp.service.DeltagerService;
import no.hvl.dat108.FestPaameldingApp.service.PassordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/login")
public class LoginController {



    @Autowired
    public DeltagerService deltagerService;

    @Autowired
    public InputValidator inputValidator;
  
    @GetMapping
    public String getLoginView() {
        return "login";
    }

    @PostMapping
    public String Login(@RequestParam(name="mobil") String mobil, @RequestParam(name="passord") String passord,
                           RedirectAttributes ra,
                           HttpServletRequest request) {

        String salt = inputValidator.findSalt(mobil);
        String hashedPassword = inputValidator.findHashedPassword(mobil);


        if(!PassordService.validerMedSalt(passord, salt, hashedPassword)) {
            ra.addFlashAttribute("errorMessage", "Feil brukernavn/passord, prøv på nytt");
            return "redirect:login";
        } else {

            Deltager deltager = deltagerService.findUser(mobil);

            LoginUtil.loggInnBruker(request, mobil, passord);
            ra.addFlashAttribute("deltager", deltager);

            return "redirect:deltagerliste";
        }
    }
}
