package no.hvl.dat108.FestPaameldingApp.testing;

import no.hvl.dat108.FestPaameldingApp.controller.LoginController;
import no.hvl.dat108.FestPaameldingApp.model.Deltager;
import no.hvl.dat108.FestPaameldingApp.repository.DeltagerRepository;
import no.hvl.dat108.FestPaameldingApp.service.PassordService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class LoginControllerTest {


   // DeltagerRepository mockDeltagerRepository;

    @Mock
    DeltagerRepository mockDeltagerRepository = Mockito.mock(DeltagerRepository.class);

    @Mock
    PassordService mockPassordService;
    @InjectMocks
    private LoginController loginController = new LoginController();

    static Deltager deltager;

    static String mobil = "88229444";
    static String passord = "Passordtest1";

    static void setup() {
        deltager = new Deltager();
        deltager.setMobil(mobil);
        deltager.setHash("J3G7K5H9R2P8L6I4N0U1V5S3F7Q9O2C8J6H5T2P8L6N4M1K5B3C7V9E2S8Y6U4H0");
        deltager.setSalt("A3K8Y5L2I4R9P6O1S5T3A7C9L2E8X6A4M1P5L3E7C9T2");
        deltager.setFornavn("Sivert");
        deltager.setEtternavn("Sæter");
        deltager.setKjonn("mann");
    }

    @Test
    void testLoginWrongMobil() {
        String mobil = "91761899";
        String passord = "Passordtest1";

        when(mockDeltagerRepository.findByMobil(mobil)).thenReturn(null);

        RedirectAttributes ra = new RedirectAttributesModelMap();

        String redirect = loginController.Login(mobil, passord, ra, new MockHttpServletRequest());

        assertEquals(
                "Ugyldig brukernavn og/eller passord",
                ra.getFlashAttributes()
                        .get("errorMessage"));
        assertEquals("redirect:login", redirect);
    }

    @Test
    void testLoginCorrectMobil() {
        when(mockDeltagerRepository.findById(mobil)).thenReturn(Optional.of(deltager));
        when(mockPassordService.erKorrektPassord(passord, deltager.getSalt(), deltager.getHash())).thenReturn(true);

        RedirectAttributes ra = new RedirectAttributesModelMap();

        String redirect = loginController.Login(mobil, passord, ra, new MockHttpServletRequest());

        assertNull(ra.getFlashAttributes()
                .get("errorMessage"));
        assertEquals("redirect:deltagerliste", redirect);
    }
}


