# JUnit Test Automation Base Framework

Bu framework, Java projelerinde hızlı bir şekilde test otomasyonu başlatmak için hazırlanmış kapsamlı bir base framework'üdür.

## Özellikler

- **JUnit 5** - Modern test framework
- **Selenium WebDriver** - Web UI testing
- **REST Assured** - API testing
- **Allure Reports** - Güzel raporlama
- **TestContainers** - Container-based testing
- **WireMock** - API mocking
- **Faker** - Test data generation
- **Awaitility** - Asenkron operasyonlar için wait utilities

## Kurulum

1. Projeyi klonlayın
2. Maven dependencies'leri yükleyin: `mvn clean install`
3. `src/test/resources/config.properties` dosyasını ihtiyacınıza göre düzenleyin

## Kullanım

### Web Testleri

```java
public class MyWebTest extends WebBaseTest {
    @Test
    void myTest() {
        WebDriverManager.getDriver().get("https://example.com");
        // Test kodunuz
    }
}
```

### API Testleri

```java
public class MyApiTest extends ApiBaseTest {
    private BaseApiClient apiClient = new BaseApiClient();
    
    @Test
    void myApiTest() {
        Response response = apiClient.get("/endpoint");
        // Assert kodlarınız
    }
}
```

## Testleri Çalıştırma

```bash
# Tüm testleri çalıştır
mvn test

# Belirli bir test sınıfını çalıştır
mvn test -Dtest=SampleWebTest

# Headless modda çalıştır
mvn test -Dheadless=true

# Farklı browser ile çalıştır
mvn test -Dbrowser=firefox
```

## Rapor Görüntüleme

```bash
# Allure raporu oluştur ve aç
mvn allure:serve
```

## Proje Yapısı

```
src/
├── main/java/com/qa/base/
│   ├── config/          # Konfigürasyon yönetimi
│   ├── web/            # Web testing utilities
│   ├── api/            # API testing utilities
│   └── utils/          # Yardımcı sınıflar
└── test/java/com/qa/
    ├── base/           # Base test sınıfları
    └── examples/       # Örnek testler
```

Bu framework ile hızlıca test yazmaya başlayabilirsiniz!