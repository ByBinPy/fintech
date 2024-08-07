package fintech.controllers;

import fintech.controllers.dto.TranslationDto;
import fintech.data.impl.exceptions.GetRepositoryException;
import fintech.data.impl.exceptions.SaveRepositoryException;
import fintech.services.impl.DataService;
import fintech.services.impl.TranslateService;
import fintech.services.impl.exceptions.InvalidLanguageException;
import fintech.services.impl.exceptions.TranslateException;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TranslationControllerTest {

    @Mock
    private DataService dataService;

    @Mock
    private TranslateService translateService;

    @Mock
    private HttpServletRequest servletRequest;

    @InjectMocks
    private TranslationController translationController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testTranslate() throws GetRepositoryException, SaveRepositoryException, InvalidLanguageException, TranslateException {
        TranslationDto translationDto = new TranslationDto();
        translationDto.setText("Hello");
        translationDto.setOriginalLanguage("en");
        translationDto.setTranslatedLanguage("es");

        String translatedText = "Hola";
        when(translateService.translate(translationDto.getText(), translationDto.getOriginalLanguage(), translationDto.getTranslatedLanguage())).thenReturn(translatedText);
        when(servletRequest.getRemoteAddr()).thenReturn("127.0.0.1");

        ResponseEntity<?> response = translationController.translate(translationDto, servletRequest);

        verify(dataService, times(1)).saveTranslation("127.0.0.1", translationDto.getText(), translatedText);
        assertEquals(ResponseEntity.ok(translatedText), response);
    }
}
