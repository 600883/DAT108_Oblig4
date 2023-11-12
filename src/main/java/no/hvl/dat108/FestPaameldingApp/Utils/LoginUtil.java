package no.hvl.dat108.FestPaameldingApp.Utils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LoginUtil {

    public static void loggUtBruker(HttpSession session) {
        session.invalidate();
    }

    public static void loggInnBruker(HttpServletRequest request, String mobil, String passord) {
        // Logger ut bruker før den logger inn igjen slik at vi ikke får problemer med
        // autentisering
        loggUtBruker(request.getSession());

        HttpSession session = request.getSession();
        session.setAttribute("mobil", mobil);
        session.setAttribute("passord", passord);

        // Setter tiden man maks kan være inaktiv i sekunder.
        session.setMaxInactiveInterval(120);

    }

    // Metode for å logge inn bruker etter en har registrert seg, tidligere metode logger kallet på loggInnBruker
    // som invalidatet session når en blei registrert og session attributesene var ikke gyldig videre til neste
    // sider, redirects osv..
    public static void loggInnBrukerRegistrering(HttpServletRequest request, String mobil, String passord) {

        HttpSession session = request.getSession();
        session.setAttribute("mobil", mobil);
        session.setAttribute("passord", passord);

        session.setMaxInactiveInterval(120);

    }

    public static boolean erBrukerInnlogget(HttpSession session) {
        return session != null && session.getAttribute("passord") != null;
    }
}