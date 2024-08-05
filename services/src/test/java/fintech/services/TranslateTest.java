package fintech.services;

import fintech.services.impl.TranslateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TranslateTest {
    @Autowired
    private TranslateService translateService;

    @Test
    public void Test1() {
    }
}
