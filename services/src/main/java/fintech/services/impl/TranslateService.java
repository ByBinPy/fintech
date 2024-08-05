package fintech.services.impl;

import fintech.services.impl.dto.TranslateResponse;
import fintech.services.impl.exceptions.TranslateException;
import fintech.services.impl.exceptions.TranslateRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class TranslateService {
    private final ExecutorService pool = Executors.newFixedThreadPool(10);
    @Value("${yandex.api.key}")
    private String YANDEX_API_KEY;
    @Value("${yandex.translate.url}")
    private String YANDEX_TRANSLATE_URL;
    @Value("${yandex.folder.id}}")
    private String YANDEX_FOLDER_ID;
    private String translateWord(String word, String requestLanguage, String responseLanguage) throws TranslateRequestException {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Api-Key " + YANDEX_API_KEY);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("folderId", YANDEX_FOLDER_ID);
        requestBody.put("texts", word);
        requestBody.put("targetLanguageCode", responseLanguage);
        requestBody.put("sourceLanguageCode", requestLanguage);

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

        try {
            ResponseEntity<TranslateResponse> response = restTemplate.exchange(
                    YANDEX_TRANSLATE_URL,
                    HttpMethod.POST,
                    requestEntity,
                    TranslateResponse.class
            );
            return Objects.requireNonNull(response.getBody()).getTranslations().getFirst().getText();
        } catch (RestClientException e) {
            throw new TranslateRequestException(e.getMessage());
        }
    }
    public String translate(String text, String requestLanguage, String responseLanguage) throws TranslateException {
        String[] words = text.split(" "); // delimiter - all characters except digits,letters and underscore
        int count_words = words.length;
        StringBuilder translatedWords = new StringBuilder();
        Future<?>[] tasks = new Future<?>[count_words];
        for (int i = 0; i < count_words; i++) {
            int finalI = i;
            tasks[i] = pool.submit(() -> translateWord(words[finalI], requestLanguage, responseLanguage));
        }

        for (int i = 0; i < count_words; i++) {
            try {
                translatedWords.append((String) tasks[i].get());
                translatedWords.append(" ");
            } catch (ExecutionException e) {
                throw new TranslateException(String.format(e.getMessage()));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return translatedWords.toString();
    }
}
