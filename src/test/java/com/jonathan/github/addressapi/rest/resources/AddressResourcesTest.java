package com.jonathan.github.addressapi.rest.resources;

import com.jonathan.github.addressapi.service.MapsService;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AddressResources.class)
class AddressResourcesTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private MapsService service;


    @Test
    public void shouldReturnBadRequestWithEmptyBody() throws Exception {
         mvc.perform(MockMvcRequestBuilders.get("/api/address").accept(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest())
                 .andExpect(MockMvcResultMatchers.jsonPath("$.errorMessage").exists());

    }

}