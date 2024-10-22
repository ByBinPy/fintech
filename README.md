# Лабораторная финтех
Необходимо создать переводчик, который будет переводить предложение в разных потоках, используя внешенее апи(В моем случае исапользуется yandex translate)
## Как запустить

1. Нужно поднять базу данных. Она поднимается через docker-compose.yaml, который находится в директории data/src/main/resources (сервер докера должен тоже  работать, на windows нужно открыть docker desktop)
2. Нужно запустить само web приложение. Для этого необходимо запустить SpringBootApplication, который находится на пути java/fintech/controllers/ControllersApplication.java

## Как пользоваться

1. Сервер запускается на порту 9999
2. Для удобства добавлен swagger-ui по ссылке http://localhost:9999/swagger-ui/
3. Используемые языки для перевода
   {
   "languages": [
   {
   "code": "az",
   "name": "azərbaycan"
   },
   {
   "code": "sq",
   "name": "shqip"
   },
   {
   "code": "am",
   "name": "አማርኛ"
   },
   {
   "code": "en",
   "name": "English"
   },
   {
   "code": "ar",
   "name": "العربية"
   },
   {
   "code": "hy",
   "name": "հայերեն"
   },
   {
   "code": "af",
   "name": "Afrikaans"
   },
   {
   "code": "eu",
   "name": "euskara"
   },
   {
   "code": "ba"
   },
   {
   "code": "be",
   "name": "беларуская"
   },
   {
   "code": "bn",
   "name": "বাংলা"
   },
   {
   "code": "my",
   "name": "မြန်မာ"
   },
   {
   "code": "bg",
   "name": "български"
   },
   {
   "code": "bs",
   "name": "bosanski"
   },
   {
   "code": "cy",
   "name": "Cymraeg"
   },
   {
   "code": "hu",
   "name": "magyar"
   },
   {
   "code": "vi",
   "name": "Tiếng Việt"
   },
   {
   "code": "ht"
   },
   {
   "code": "gl",
   "name": "galego"
   },
   {
   "code": "nl",
   "name": "Nederlands"
   },
   {
   "code": "el",
   "name": "Ελληνικά"
   },
   {
   "code": "ka",
   "name": "ქართული"
   },
   {
   "code": "gu",
   "name": "ગુજરાતી"
   },
   {
   "code": "da",
   "name": "dansk"
   },
   {
   "code": "he",
   "name": "עברית"
   },
   {
   "code": "yi",
   "name": "ייִדיש"
   },
   {
   "code": "id",
   "name": "Indonesia"
   },
   {
   "code": "ga",
   "name": "Gaeilge"
   },
   {
   "code": "it",
   "name": "italiano"
   },
   {
   "code": "is",
   "name": "íslenska"
   },
   {
   "code": "es",
   "name": "español"
   },
   {
   "code": "kk",
   "name": "қазақ тілі"
   },
   {
   "code": "kn",
   "name": "ಕನ್ನಡ"
   },
   {
   "code": "ca",
   "name": "català"
   },
   {
   "code": "ky",
   "name": "кыргызча"
   },
   {
   "code": "zh",
   "name": "中文"
   },
   {
   "code": "ko",
   "name": "한국어"
   },
   {
   "code": "xh"
   },
   {
   "code": "km",
   "name": "ខ្មែរ"
   },
   {
   "code": "lo",
   "name": "ລາວ"
   },
   {
   "code": "la"
   },
   {
   "code": "lv",
   "name": "latviešu"
   },
   {
   "code": "lt",
   "name": "lietuvių"
   },
   {
   "code": "lb",
   "name": "Lëtzebuergesch"
   },
   {
   "code": "mg",
   "name": "Malagasy"
   },
   {
   "code": "ms",
   "name": "Melayu"
   },
   {
   "code": "ml",
   "name": "മലയാളം"
   },
   {
   "code": "mt",
   "name": "Malti"
   },
   {
   "code": "mk",
   "name": "македонски"
   },
   {
   "code": "mi"
   },
   {
   "code": "mr",
   "name": "मराठी"
   },
   {
   "code": "mn",
   "name": "монгол"
   },
   {
   "code": "de",
   "name": "Deutsch"
   },
   {
   "code": "ne",
   "name": "नेपाली"
   },
   {
   "code": "no",
   "name": "norsk bokmål"
   },
   {
   "code": "pa",
   "name": "ਪੰਜਾਬੀ"
   },
   {
   "code": "fa",
   "name": "فارسی"
   },
   {
   "code": "pl",
   "name": "polski"
   },
   {
   "code": "pt",
   "name": "português"
   },
   {
   "code": "ro",
   "name": "română"
   },
   {
   "code": "ru",
   "name": "русский"
   },
   {
   "code": "sr",
   "name": "српски"
   },
   {
   "code": "si",
   "name": "සිංහල"
   },
   {
   "code": "sk",
   "name": "slovenčina"
   },
   {
   "code": "sl",
   "name": "slovenščina"
   },
   {
   "code": "sw",
   "name": "Kiswahili"
   },
   {
   "code": "su"
   },
   {
   "code": "tg",
   "name": "тоҷикӣ"
   },
   {
   "code": "th",
   "name": "ไทย"
   },
   {
   "code": "tl",
   "name": "Filipino"
   },
   {
   "code": "ta",
   "name": "தமிழ்"
   },
   {
   "code": "tt",
   "name": "татар"
   },
   {
   "code": "te",
   "name": "తెలుగు"
   },
   {
   "code": "tr",
   "name": "Türkçe"
   },
   {
   "code": "uz",
   "name": "o‘zbek"
   },
   {
   "code": "uk",
   "name": "українська"
   },
   {
   "code": "ur",
   "name": "اردو"
   },
   {
   "code": "fi",
   "name": "suomi"
   },
   {
   "code": "fr",
   "name": "français"
   },
   {
   "code": "hi",
   "name": "हिन्दी"
   },
   {
   "code": "hr",
   "name": "hrvatski"
   },
   {
   "code": "cs",
   "name": "čeština"
   },
   {
   "code": "sv",
   "name": "svenska"
   },
   {
   "code": "gd",
   "name": "Gàidhlig"
   },
   {
   "code": "et",
   "name": "eesti"
   },
   {
   "code": "eo",
   "name": "esperanto"
   },
   {
   "code": "jv"
   },
   {
   "code": "ja",
   "name": "日本語"
   },
   {
   "code": "cv"
   },
   {
   "code": "ceb"
   },
   {
   "code": "emj"
   },
   {
   "code": "kazlat"
   },
   {
   "code": "mhr"
   },
   {
   "code": "mrj"
   },
   {
   "code": "pap"
   },
   {
   "code": "pt-BR",
   "name": "português"
   },
   {
   "code": "sah",
   "name": "саха тыла"
   },
   {
   "code": "sr-Latn",
   "name": "srpskohrvatski"
   },
   {
   "code": "udm"
   },
   {
   "code": "uzbcyr"
   },
   {
   "code": "zu",
   "name": "isiZulu"
   },
   {
   "code": "os",
   "name": "ирон"
   }
   ]
   }
