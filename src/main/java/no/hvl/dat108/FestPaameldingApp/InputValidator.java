package no.hvl.dat108.FestPaameldingApp;

import no.hvl.dat108.FestPaameldingApp.model.Deltager;
import no.hvl.dat108.FestPaameldingApp.service.DeltagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InputValidator {

    @Autowired
    DeltagerService deltagerService;

    public static final String ANY_LETTER = "[a-zA-ZæøåÆØÅ]";
    public static final String ANY_LETTER_OR_DIGIT = "[a-zA-ZæøåÆØÅ0-9]";
    public static final String THREE_OR_MORE_TIMES = "{3,}";

    // This regex has the following password rules, min 8 characters, min 1 uppercase, min 1 lowercase, min 1 digit
    public static final String PASSWORD_EXP = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}$";
    public static final String PHONE_NUMBER = "^[0-9]{8}$";


    /**
     *
     * @param username Brukernavnet som skal valideres
     * @return Om brukenavnet er gyldig eller ikke
     *
     * Et gyldig brukernavn består av 4 eller flere tegn. Lovlige tegn
     * er bokstaver (små og store) inkl. de norske bokstavene og tall.
     * Brukernavnet kan ikke begynne med et tall.
     */
    public static boolean isValidUsername(String username) {
        return username != null && username.matches("^" + ANY_LETTER
                + ANY_LETTER_OR_DIGIT + THREE_OR_MORE_TIMES + "$");
    }

    public static boolean isValidLastname(String lastname) {
        return lastname != null && lastname.matches("^" + ANY_LETTER
                + ANY_LETTER_OR_DIGIT + THREE_OR_MORE_TIMES + "$");
    }

    public static boolean isValidGender(String gender) {
        return gender != null && gender.equals("mann") || gender.equals("kvinne");
    }


    public static boolean isValidName(String navn) {
        return navn != null && navn.matches("^" + ANY_LETTER + "$");
    }

    public static boolean isValidPhoneNumber(String mobil) {
        return mobil != null && mobil.matches(PHONE_NUMBER);
    }

    public static boolean isValidPassword(String passord) {
        return passord != null && passord.matches(PASSWORD_EXP);
    }



    public boolean checkLogin(String mobil, String passord) {
        for(Deltager deltager : deltagerService.findAllDeltagere()) {
            if(deltager.getMobil().equals(mobil)) {
                return deltager.getPassord().equals(passord);
            }
        }
        return false;
    }



    public String findSalt(String mobil) {
        for(Deltager deltager : deltagerService.findAllDeltagere()) {
            if(deltager.getMobil().equals(mobil)) {
                return deltager.getSalt();
            }
        }
        return null;
    }


    public String findHashedPassword(String mobil) {
        for(Deltager deltager : deltagerService.findAllDeltagere()) {
            if(deltager.getMobil().equals(mobil)) {
                return deltager.getHash();
            }
        }
        return null;
    }

}