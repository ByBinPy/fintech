package fintech.controllers;

import fintech.controllers.dto.TranslationDto;
import fintech.data.impl.exceptions.GetRepositoryException;
import fintech.data.impl.exceptions.SaveRepositoryException;
import fintech.services.impl.DataService;
import fintech.services.impl.TranslateService;
import fintech.services.impl.exceptions.InvalidLanguageException;
import fintech.services.impl.exceptions.TranslateException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("api/v1")
public class TranslationController {

    private final DataService dataService;
    private final TranslateService translateService;

    @Autowired
    public TranslationController(DataService dataService, TranslateService translateService) {
        this.dataService = dataService;
        this.translateService = translateService;
    }
    @PostMapping("/translate")
    public ResponseEntity<?> translate(@RequestBody TranslationDto translationDto, HttpServletRequest servletRequest) throws GetRepositoryException, SaveRepositoryException, InvalidLanguageException {
        try {
            String translationText = translateService.translate(translationDto.getText(), translationDto.getOriginalLanguage(), translationDto.getTranslatedLanguage());
            dataService.saveTranslation(servletRequest.getRemoteAddr(),translationDto.getText(), translationText);
            return ResponseEntity.ok(translationText);
        } catch (TranslateException e) {
            throw new RuntimeException(e);
        }
    }
}
