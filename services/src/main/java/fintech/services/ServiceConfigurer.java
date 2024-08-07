package fintech.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class ServiceConfigurer {
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
    @Bean
    public Set<String> getLanguagesSet() {
        Set<String> languageCodes = new HashSet<>();
        languageCodes.add("az");
        languageCodes.add("sq");
        languageCodes.add("am");
        languageCodes.add("en");
        languageCodes.add("ar");
        languageCodes.add("hy");
        languageCodes.add("af");
        languageCodes.add("eu");
        languageCodes.add("ba");
        languageCodes.add("be");
        languageCodes.add("bn");
        languageCodes.add("my");
        languageCodes.add("bg");
        languageCodes.add("bs");
        languageCodes.add("cy");
        languageCodes.add("hu");
        languageCodes.add("vi");
        languageCodes.add("ht");
        languageCodes.add("gl");
        languageCodes.add("nl");
        languageCodes.add("el");
        languageCodes.add("ka");
        languageCodes.add("gu");
        languageCodes.add("da");
        languageCodes.add("he");
        languageCodes.add("yi");
        languageCodes.add("id");
        languageCodes.add("ga");
        languageCodes.add("it");
        languageCodes.add("is");
        languageCodes.add("es");
        languageCodes.add("kk");
        languageCodes.add("kn");
        languageCodes.add("ca");
        languageCodes.add("ky");
        languageCodes.add("zh");
        languageCodes.add("ko");
        languageCodes.add("xh");
        languageCodes.add("km");
        languageCodes.add("lo");
        languageCodes.add("la");
        languageCodes.add("lv");
        languageCodes.add("lt");
        languageCodes.add("lb");
        languageCodes.add("mg");
        languageCodes.add("ms");
        languageCodes.add("ml");
        languageCodes.add("mt");
        languageCodes.add("mk");
        languageCodes.add("mi");
        languageCodes.add("mr");
        languageCodes.add("mn");
        languageCodes.add("de");
        languageCodes.add("ne");
        languageCodes.add("no");
        languageCodes.add("pa");
        languageCodes.add("fa");
        languageCodes.add("pl");
        languageCodes.add("pt");
        languageCodes.add("ro");
        languageCodes.add("ru");
        languageCodes.add("sr");
        languageCodes.add("si");
        languageCodes.add("sk");
        languageCodes.add("sl");
        languageCodes.add("sw");
        languageCodes.add("su");
        languageCodes.add("tg");
        languageCodes.add("th");
        languageCodes.add("tl");
        languageCodes.add("ta");
        languageCodes.add("tt");
        languageCodes.add("te");
        languageCodes.add("tr");
        languageCodes.add("uz");
        languageCodes.add("uk");
        languageCodes.add("ur");
        languageCodes.add("fi");
        languageCodes.add("fr");
        languageCodes.add("hi");
        languageCodes.add("hr");
        languageCodes.add("cs");
        languageCodes.add("sv");
        languageCodes.add("gd");
        languageCodes.add("et");
        languageCodes.add("eo");
        languageCodes.add("jv");
        languageCodes.add("ja");
        languageCodes.add("cv");
        languageCodes.add("ceb");
        languageCodes.add("emj");
        languageCodes.add("kazlat");
        languageCodes.add("mhr");
        languageCodes.add("mrj");
        languageCodes.add("pap");
        languageCodes.add("pt-BR");
        languageCodes.add("sah");
        languageCodes.add("sr-Latn");
        languageCodes.add("udm");
        languageCodes.add("uzbcyr");
        languageCodes.add("zu");
        languageCodes.add("os");
        return languageCodes;
    }
}
