package no.hvl.dat108.FestPaameldingApp.testing;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.FestPaameldingApp.controller.registreringController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class RegistreringControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private registreringController registreringController = new registreringController();

    @Test
    public void testRegistrerDeltager() throws Exception {

            mockMvc.perform(MockMvcRequestBuilders.post("/paamelding")
                            .param("fornavn", "John")
                            .param("etternavn", "Doe")
                            .param("mobil", "12345678")
                            .param("kjonn", "M")
                            .param("passord", "password")
                            .param("passordRepetert", "password"))
                    .andExpect(MockMvcResultMatchers.status().is3xxRedirection());


    }
}
