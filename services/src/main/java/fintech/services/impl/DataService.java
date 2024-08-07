package fintech.services.impl;

import fintech.data.impl.entities.Client;
import fintech.data.impl.entities.Translation;
import fintech.data.impl.exceptions.GetRepositoryException;
import fintech.data.impl.exceptions.SaveRepositoryException;
import fintech.data.impl.repos.ClientRepository;
import fintech.data.impl.repos.TranslationRepository;
import fintech.services.impl.dto.ClientDto;
import fintech.services.impl.dto.TranslationDto;
import fintech.services.impl.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {
    private final ClientRepository clientRepository;
    private final TranslationRepository translationRepository;
    private final MappingService mappingService;
    @Autowired
    public DataService(ClientRepository clientRepository, TranslationRepository translationRepository, MappingService mappingService) {
        this.clientRepository = clientRepository;
        this.translationRepository = translationRepository;
        this.mappingService = mappingService;
    }
    public void saveTranslation(String ip, String receivedText, String translatedText ) throws GetRepositoryException, SaveRepositoryException {
        Client client = clientRepository.getByIp(ip);
        int id = translationRepository.getCountTranslations() + 1;
        if (client != null && client.ip() != null) {
            translationRepository.save(new Translation(id, client.id(), receivedText, translatedText));
        }
        else {
            int clientId = clientRepository.getCountClients() + 1;
            clientRepository.save(new Client(clientId, ip));

            translationRepository.save(new Translation(id, clientId, receivedText, translatedText));
        }
    }

    public ClientDto getClientById(int id) throws GetRepositoryException, NotFoundException {
        Client client = clientRepository.getById(id);
        if (client == null) {
            throw new NotFoundException();
        }
        return mappingService.toClientDto(client);
    }

    public TranslationDto getTranslationById(int id) throws NotFoundException, GetRepositoryException {
        Translation translation = translationRepository.getById(id);
        if (translation == null) {
            throw new NotFoundException();
        }
        return mappingService.toTranslationDto(translation);
    }

    public ClientDto getClientByIp(String ip) throws GetRepositoryException, NotFoundException {
        Client client = clientRepository.getByIp(ip);
        if (client == null) {
            throw new NotFoundException();
        }
        return mappingService.toClientDto(client);
    }

}
