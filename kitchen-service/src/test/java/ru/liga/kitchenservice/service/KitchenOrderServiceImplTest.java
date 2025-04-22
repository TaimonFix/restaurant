package ru.liga.kitchenservice.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import ru.liga.kitchenservice.mapper.KitchenOrderMapper;
import ru.liga.kitchenservice.model.dto.KitchenOrderDto;
import ru.liga.kitchenservice.repository.KitchenOrderRepository;
import ru.liga.kitchenservice.service.impl.KitchenOrderServiceImpl;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class KitchenOrderServiceImplTest {

    @Mock
    private KitchenOrderRepository kitchenOrderRepository;

    @Mock
    private KitchenOrderMapper kitchenOrderMapper;

    @InjectMocks
    private KitchenOrderServiceImpl kitchenOrderService;

    @Test
    @DisplayName("getOrders: Возвращает список заказов")
    void getOrders_ReturnOrderDtoList() {
        // Подготовка
        List<KitchenOrderDto> expected = new ArrayList<>();
        Mockito.when(kitchenOrderRepository.findAll()).thenReturn(new ArrayList<>());

        // Действие
        List<KitchenOrderDto> actual = kitchenOrderService.getOrders();

        // Проверка
        Assertions.assertEquals(expected, actual);
    }
}
