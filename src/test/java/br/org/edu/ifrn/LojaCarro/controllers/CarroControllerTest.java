package br.org.edu.ifrn.LojaCarro.controllers;

import br.org.edu.ifrn.LojaCarro.model.Carro;
import br.org.edu.ifrn.LojaCarro.services.CarroService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CarroControllerTest {

    @Mock
    private CarroService carroService;

    @InjectMocks
    private CarroController carroController;

    private Carro carro;

    @BeforeEach
    void setUp() {
        carro = new Carro();
        carro.setId(1L);
        carro.setModelo("Corolla");
        carro.setAno(2023);
    }

    @Test
    void deveRetornarStatusOkAoSalvarCarro() {
        when(carroService.save(any(Carro.class))).thenReturn(carro);
        ResponseEntity<Carro> response = carroController.salvarCarro(carro);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void deveRetornarCarroAoPesquisarPorId() {
        when(carroService.findById(1L)).thenReturn(Optional.of(carro));
        ResponseEntity<Carro> response = carroController.pesquisarCarroPorId(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Corolla", response.getBody().getModelo());
    }

    @Test
    void deveRetornarStatusOkAoAtualizarCarro() {
        when(carroService.update(any(Carro.class))).thenReturn(carro);
        ResponseEntity<Carro> response = carroController.atualizarCarro(1L, carro);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void deveRetornarStatusNoContentAoDeletarCarro() {
        ResponseEntity<Void> response = carroController.deletarCarro(1L);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}