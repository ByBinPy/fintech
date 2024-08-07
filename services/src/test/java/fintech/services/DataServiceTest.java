package fintech.services;

import fintech.data.impl.entities.Client;
import fintech.data.impl.entities.Translation;
import fintech.data.impl.exceptions.GetRepositoryException;
import fintech.data.impl.exceptions.SaveRepositoryException;
import fintech.data.impl.repos.ClientRepository;
import fintech.data.impl.repos.TranslationRepository;
import fintech.services.impl.DataService;
import fintech.services.impl.MappingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class DataServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private TranslationRepository translationRepository;

    @Mock
    private MappingService mappingService;

    @InjectMocks
    private DataService dataService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveTranslationWithExistingClient() throws GetRepositoryException, SaveRepositoryException {
        String ip = "127.0.0.1";
        String receivedText = "Hello";
        String translatedText = "Hola";
        Client client = new Client(1, ip);
        when(clientRepository.getByIp(ip)).thenReturn(client);
        when(translationRepository.getCountTranslations()).thenReturn(0);

        dataService.saveTranslation(ip, receivedText, translatedText);

        verify(translationRepository, times(1)).save(any(Translation.class));
        verify(clientRepository, never()).save(any(Client.class));
    }

    @Test
    public void testSaveTranslationWithNewClient() throws GetRepositoryException, SaveRepositoryException {
        String ip = "127.0.0.1";
        String receivedText = "Hello";
        String translatedText = "Hola";
        when(clientRepository.getByIp(ip)).thenReturn(null);
        when(translationRepository.getCountTranslations()).thenReturn(0);
        when(clientRepository.getCountClients()).thenReturn(0);

        dataService.saveTranslation(ip, receivedText, translatedText);

        verify(clientRepository, times(1)).save(any(Client.class));
        verify(translationRepository, times(1)).save(any(Translation.class));
    }
}