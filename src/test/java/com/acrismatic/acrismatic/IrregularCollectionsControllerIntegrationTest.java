package com.acrismatic.acrismatic;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class IrregularCollectionsControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetIrregularCollections() throws Exception {
        // Perform the request and validate the response
        mockMvc.perform(get("/api/irregular-collections")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].maquina").value("Supermáquina"))
                .andExpect(jsonPath("$[0].cliente").value("Bar Pepe"))
                .andExpect(jsonPath("$[0].recaudacionesIrregulares[0].idRecaudacion").value(1))
                .andExpect(jsonPath("$[0].recaudacionesIrregulares[0].idManual").value(1))
                .andExpect(jsonPath("$[0].recaudacionesIrregulares[0].idAutomatico").value(3))
                .andExpect(jsonPath("$[0].recaudacionesIrregulares[0].manuales.entradasManuales").value(100))
                .andExpect(jsonPath("$[0].recaudacionesIrregulares[0].manuales.salidasManuales").value(99))
                .andExpect(jsonPath("$[0].recaudacionesIrregulares[0].manuales.fecha").value("2023-01-21T10:00:00"))
                .andExpect(jsonPath("$[0].recaudacionesIrregulares[0].automaticos.entradasAutomaticas").value(100))
                .andExpect(jsonPath("$[0].recaudacionesIrregulares[0].automaticos.salidasAutomaticas").value(98))
                .andExpect(jsonPath("$[0].recaudacionesIrregulares[0].automaticos.fecha").value("2023-01-21T09:56:00"));
    }
}
