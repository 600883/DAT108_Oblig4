package no.hvl.dat108.FestPaameldingApp.testing;

import no.hvl.dat108.FestPaameldingApp.InputValidator;
import no.hvl.dat108.FestPaameldingApp.controller.registreringController;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class inputTests {

    private String passord1 = "Tester";
    private String passord2 = "t";
    private String passord3 = "00000000";
    private String passord4 = "Passord0";
    private String passord5 = "";
    private String passord6 = "<passord=";
    private String passord7 = "<_: *#~'";
    private String passord8 = "0Passord";
    private String passord9 = "_231Passsordtest12222";

    @Test
    public void passordTest() {

        assertTrue(InputValidator.isValidPassword(passord4));
        assertTrue(InputValidator.isValidPassword(passord8));
        assertTrue(InputValidator.isValidPassword(passord9));


        assertFalse(InputValidator.isValidPassword(passord1));
        assertFalse(InputValidator.isValidPassword(passord2));
        assertFalse(InputValidator.isValidPassword(passord3));
        assertFalse(InputValidator.isValidPassword(passord5));
        assertFalse(InputValidator.isValidPassword(passord6));
        assertFalse(InputValidator.isValidPassword(passord7));

    }

    private String number1 = "00000000";
    private String number2 = "0000 00";
    private String number3 = "8992 93323";
    private String number4 = "89239922";
    private String number5 = "8923 9922";


    @Test
    public void mobilnummertest() {

        assertTrue((InputValidator.isValidPhoneNumber(number1)));
        assertTrue(InputValidator.isValidPhoneNumber(number4));

        assertFalse(InputValidator.isValidPhoneNumber(number2));
        assertFalse(InputValidator.isValidPhoneNumber(number3));
        assertFalse(InputValidator.isValidPhoneNumber(number5));
    }

    @Test
    public void test() {

    }

}
