package tn.esprit.tpfoyer.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.repository.FoyerRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class FoyerServiceImplTest {

    @Mock
    private FoyerRepository foyerRepository;

    @InjectMocks
    private FoyerServiceImpl foyerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRetrieveAllFoyers() {
        Foyer f1 = new Foyer();
        Foyer f2 = new Foyer();
        when(foyerRepository.findAll()).thenReturn(Arrays.asList(f1, f2));

        List<Foyer> result = foyerService.retrieveAllFoyers();

        assertEquals(2, result.size());
        verify(foyerRepository).findAll();
    }

    @Test
    void testRetrieveFoyer() {
        Foyer f = new Foyer();
        f.setIdFoyer(1L);
        when(foyerRepository.findById(1L)).thenReturn(Optional.of(f));

        Foyer result = foyerService.retrieveFoyer(1L);

        assertEquals(1L, result.getIdFoyer());
        verify(foyerRepository).findById(1L);
    }

    @Test
    void testAddFoyer() {
        Foyer f = new Foyer();
        when(foyerRepository.save(f)).thenReturn(f);

        Foyer result = foyerService.addFoyer(f);

        assertEquals(f, result);
        verify(foyerRepository).save(f);
    }

    @Test
    void testModifyFoyer() {
        Foyer f = new Foyer();
        when(foyerRepository.save(f)).thenReturn(f);

        Foyer result = foyerService.modifyFoyer(f);

        assertEquals(f, result);
        verify(foyerRepository).save(f);
    }

    @Test
    void testRemoveFoyer() {
        Long id = 1L;
        doNothing().when(foyerRepository).deleteById(id);

        foyerService.removeFoyer(id);

        verify(foyerRepository).deleteById(id);
    }
}
