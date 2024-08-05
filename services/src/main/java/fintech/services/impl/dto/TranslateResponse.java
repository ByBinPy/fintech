package fintech.services.impl.dto;

import lombok.Data;

import java.util.List;

@Data
public class TranslateResponse {
    private List<Translation> translations;
    @Data
    public static class Translation {
        private String text;
    }
}