package com.jonathan.github.addressapi.rest.resources;

import com.google.maps.errors.ApiException;
import com.jonathan.github.addressapi.rest.DTO.AddressDTO;
import com.jonathan.github.addressapi.rest.DTO.MapsApiResponseDTO;
import com.jonathan.github.addressapi.rest.DTO.PairOfAddressesLongestClosestDTO;
import com.jonathan.github.addressapi.rest.DTO.ResponseAddressDTO;
import com.jonathan.github.addressapi.service.MapsService;
import com.jonathan.github.addressapi.utils.StringMapsAddressBuilder;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Validated
@RestController
@RequestMapping("/api")
public class AddressResources {

    @Autowired
    private MapsService mapsService;

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @GetMapping("/address")
    public List<ResponseAddressDTO> getAddressInformation(@RequestBody List< @Valid AddressDTO> addressDTO) throws IOException, URISyntaxException {
        List<ResponseAddressDTO> responseAddressDTOS = new ArrayList<>();
        responseAddressDTOS = mapsService.getResponseAddressApiInfo(addressDTO, responseAddressDTOS);
        responseAddressDTOS = mapsService.getDistanceInformations(responseAddressDTOS);
        return responseAddressDTOS;
    }
}
