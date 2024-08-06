package fintech.services.impl.dto;

import lombok.Data;

@Data
public class TranslationDto {
    private int clientId;
    private String receivedText;
    private String translatedText;
}
