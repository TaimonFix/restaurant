package ru.liga.kitchenservice.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * Интеграционный тест, показывающий взаимодействие между контроллером-сервисом-репозиторием
 * в модуле kitchen-service
 */
@SpringBootTest
@AutoConfigureMockMvc
public class KitchenOrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName(value = "getOrders: получить список заказов")
    void getOrders_ReturnWaiterOrderDtoList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/order")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
