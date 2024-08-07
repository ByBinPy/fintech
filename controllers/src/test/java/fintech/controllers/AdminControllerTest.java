package fintech.controllers;

import fintech.services.impl.DataService;
import fintech.services.impl.dto.ClientDto;
import fintech.services.impl.dto.TranslationDto;
import fintech.services.impl.exceptions.NotFoundException;
import fintech.data.impl.exceptions.GetRepositoryException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class AdminControllerTest {

    @Mock
    private DataService dataService;

    @InjectMocks
    private AdminController adminController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetClientById() throws GetRepositoryException, NotFoundException {
        int clientId = 1;
        ClientDto clientData = ClientDto.builder().id(1).ip("127.0.0.1").build();
        when(dataService.getClientById(clientId)).thenReturn(clientData);

        ResponseEntity<?> response = adminController.getClientById(clientId);

        assertEquals(ResponseEntity.ok(clientData), response);
    }

    @Test
    public void testGetClientByIp() throws GetRepositoryException, NotFoundException {
        String ip = "127.0.0.1";
        ClientDto clientData = ClientDto.builder().id(1).ip("127.0.0.1").build();
        when(dataService.getClientByIp(ip)).thenReturn(clientData);

        ResponseEntity<?> response = adminController.getClientByIp(ip);

        assertEquals(ResponseEntity.ok(clientData), response);
    }

    @Test
    public void testGetTranslationsById() throws NotFoundException, GetRepositoryException {
        int translationId = 1;
        TranslationDto translationData = TranslationDto.builder().receivedText("Hi").translatedText("Здравствуйте").build();
        when(dataService.getTranslationById(translationId)).thenReturn(translationData);

        ResponseEntity<?> response = adminController.getTranslationsById(translationId);

        assertEquals(ResponseEntity.ok(translationData), response);
    }
}
