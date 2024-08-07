package fintech.services.impl;

import fintech.data.impl.entities.Client;
import fintech.data.impl.entities.Translation;
import fintech.services.impl.dto.ClientDto;
import fintech.services.impl.dto.TranslationDto;
import org.springframework.stereotype.Service;

@Service
public class MappingService {
    public ClientDto toClientDto(Client entity) {
        if (entity != null) {
            return ClientDto
                    .builder()
                    .id(entity.id())
                    .ip(entity.ip())
                    .build();
        }
        return null;
    }
    public TranslationDto toTranslationDto(Translation entity) {
        if (entity != null) {
            return TranslationDto
                    .builder()
                    .clientId(entity.id())
                    .receivedText(entity.receivedText())
                    .translatedText(entity.translatedText())
                    .build();
        }
        return null;
    }
}
