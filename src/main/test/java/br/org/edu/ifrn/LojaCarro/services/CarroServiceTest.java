package br.org.edu.ifrn.LojaCarro.services;

import br.org.edu.ifrn.LojaCarro.model.Carro;
import br.org.edu.ifrn.LojaCarro.repository.CarroRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CarroServiceTest {

    @Mock
    private CarroRepository carroRepository;

    @InjectMocks
    private CarroService carroService;

    private Carro carro;

    @BeforeEach
    void setUp() {
        carro = new Carro();
        carro.setId(1L);
        carro.setModelo("Civic");
        carro.setAno(2022);
    }

    @Test
    void deveSalvarCarroComSucesso() {
        when(carroRepository.save(any(Carro.class))).thenReturn(carro);
        Carro carroSalvo = carroService.save(carro);
        assertNotNull(carroSalvo);
        assertEquals("Civic", carroSalvo.getModelo());
    }

    @Test
    void deveBuscarCarroPorId() {
        when(carroRepository.findById(1L)).thenReturn(Optional.of(carro));
        Optional<Carro> carroEncontrado = carroService.findById(1L);
        assertTrue(carroEncontrado.isPresent());
        assertEquals(2022, carroEncontrado.get().getAno());
    }
}