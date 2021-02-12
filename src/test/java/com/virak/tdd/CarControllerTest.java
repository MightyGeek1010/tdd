package com.virak.tdd;

import com.virak.tdd.controller.CarController;
import com.virak.tdd.domain.Car;
import com.virak.tdd.exception.CarNotFoundException;
import com.virak.tdd.service.CarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CarController.class)
public class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CarService carService;

    @Test
    public void getCar_ShouldReturnCar() throws Exception {

        //arrange
        given(carService.getCarDetails(anyString())).willReturn(new Car("toyota", "hybrid"));

        //act and assert
        mockMvc.perform(get("/cars/toyota"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("toyota"))
                .andExpect(jsonPath("type").value("hybrid"));
    }

    @Test
    public void getCar_notFound() throws Exception {
        given(carService.getCarDetails(anyString())).willThrow(new CarNotFoundException());

        mockMvc.perform(get("/cars/toyota")).andExpect(status().isNotFound());

    }

}
