package ru.liga.waiterservice.controller;

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
 * в модуле waiter-service
 */
@SpringBootTest
@AutoConfigureMockMvc
public class WaiterOrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName(value = "saveOrder: Сохранить заказ")
    void saveOrder_ReturnOrderNo() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                            {
                                "waiterId": 1,
                                "tableNo" : "столик №1",
                                "positions" : [
                                {
                                    "menuPositionId" : 1,
                                    "dishNum" : 1
                                }]
                            }"""))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName(value = "getOrder: получить заказ по id, если он есть в БД")
    void getOrder_ReturnWaiterOrderDto_IfOrderFound() throws Exception {
        Long orderId = 1L; // Существующий ID заказа в БД
        mockMvc.perform(MockMvcRequestBuilders.get("/order/" + orderId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    @DisplayName(value = "getOrder: получить сообщение об ошибке, если id заказа нет в БД")
    void getOrder_ThrowException_IfOrderNotFound() throws Exception {
        Long orderId = -1L; // Несуществующий ID заказа
        mockMvc.perform(MockMvcRequestBuilders.get("/order/" + orderId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}
