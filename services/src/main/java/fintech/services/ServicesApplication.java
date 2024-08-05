package fintech.services;

import fintech.services.impl.TranslateService;
import fintech.services.impl.exceptions.TranslateException;

//@SpringBootApplication
public class ServicesApplication {
	public static void main(String[] args) throws TranslateException {
        //SpringApplication.run(ServicesApplication.class, args);

        TranslateService translateService = new TranslateService();
        System.out.println(translateService.translate("Привет. Как у тебя дела?", "ru", ""));
	}

}
