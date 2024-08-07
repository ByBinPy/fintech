package fintech.controllers.dto;

import lombok.Data;

@Data
public class TranslationDto {
    private String text;
    private String originalLanguage;
    private String translatedLanguage;
}
