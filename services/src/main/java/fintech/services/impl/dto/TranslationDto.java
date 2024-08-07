package fintech.services.impl.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TranslationDto {
    private int clientId;
    private String receivedText;
    private String translatedText;
}
