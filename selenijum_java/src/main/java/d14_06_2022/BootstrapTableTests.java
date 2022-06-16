package d14_06_2022;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class BootstrapTableTests {
    private WebDriver driver;
    private String baseUrl = "https://s.bootsnipp.com";


    @BeforeClass
    public void beforeClass(){
            System.setProperty("webdriver.chrome.driver",
                    "src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @BeforeMethod
    public void beforeMethod(){
        driver.get(baseUrl);
    }
    @Test(priority = 10)
    public void editRow(){
       String firstName = "Milos";
       String lastName = "Milutinovic";
       String middleName = "Mile";

        driver.get(baseUrl + "/iframe/K5yrx");

        Assert.assertEquals(driver.getTitle(),
                "Table with Edit and Update Data - Bootsnipp.com",
                "Page title does not contain 'Table with Edit and Update Data - Bootsnipp.com'");

        driver.findElement(By.xpath("//button[contains(@data-target, 'edit')]")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .xpath("//input[@id='fn']")));

        driver.findElement(By.id("fn")).clear();
        driver.findElement(By.id("fn")).sendKeys(firstName);
        driver.findElement(By.id("ln")).clear();
        driver.findElement(By.id("ln")).sendKeys(lastName);
        driver.findElement(By.id("mn")).clear();
        driver.findElement(By.id("mn")).sendKeys(middleName);

        driver.findElement(By.id("up")).click();

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .xpath("//div[@aria-hidden='true']")));

        Assert.assertTrue(driver.findElement(By.id("f1")).getText().equals(firstName),
                "The first name does not contain 'Milos'");
        Assert.assertTrue(driver.findElement(By.id("l1")).getText().equals(lastName),
                "The last name does not contain 'Milutinovic'");
        Assert.assertTrue(driver.findElement(By.id("m1")).getText().equals(middleName),
                "The middle name does not contain 'Mile'");


    }
    @Test(priority = 20)
    public void deleteRow(){
        driver.get(baseUrl + "/iframe/K5yrx");

        Assert.assertEquals(driver.getTitle(),
                "Table with Edit and Update Data - Bootsnipp.com",
                "Page title does not contain 'Table with Edit and Update Data - Bootsnipp.com'");

        driver.findElement(By.xpath("//tr[@id='d1']//button[contains(@class,'delete')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions
                .presenceOfElementLocated(By.id("delete")));

        driver.findElement(By.id("del")).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("delete")));

        List<WebElement> deletedRows = driver.findElements(By.xpath("//table/tbody/tr[0]"));
        Assert.assertTrue(deletedRows.isEmpty(), "[ERROR] The row was not deleted");

    }
    @Test(priority = 30)
    public void TakeAScreenshot() throws IOException {
        driver.get(baseUrl + "/iframe/K5yrx");
        Assert.assertEquals(driver.getTitle(),
                "Table with Edit and Update Data - Bootsnipp.com",
                "Page title does not contain 'Table with Edit and Update Data - Bootsnipp.com'");
        TakesScreenshot screen = (TakesScreenshot) driver;
        File screenshot = screen.getScreenshotAs(OutputType.FILE);
        File image = new File("src/main/resources/Screenshot.png");
        FileHandler.copy(screenshot, image);

    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
//Kreirati BootstrapTableTests klasu koja ima:
//Base url: https://s.bootsnipp.com
//Test #1: Edit Row
//Podaci:
//First Name: ime polaznika
//Last Name: prezime polaznika
//Middle Name: srednje ime polanzika
//Koraci:
//Ucitati stranu /iframe/K5yrx
//Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//Klik na Edit dugme prvog reda
//Sacekati da dijalog za Editovanje bude vidljiv
//Popuniti formu podacima.
//Bice potrebno da pre unosa tekst pobrisete tekst koji vec postoji, za to se koristi metoda clear. Koristan link
//Klik na Update dugme
//Sacekati da dijalog za Editovanje postane nevidljiv
//Verifikovati da se u First Name celiji prvog reda tabele javlja uneto ime
//Verifikovati da se u Last Name celiji prvog reda tabele javlja uneto prezime
//Verifikovati da se u Middle Name celiji prvog reda tabele javlja uneto srednje ime
//Za sve validacije ispisati odgovarajuce poruke u slucaju greske
//
// Test #2: Delete Row
//Podaci:
//First Name: ime polaznika
//Last Name: prezime polaznika
//Middle Name: srednje ime polanzika
//Koraci:
//Ucitati stranu /iframe/K5yrx
//Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//Klik na Delete dugme prvog reda
//Sacekati da dijalog za brisanje bude vidljiv
//Klik na Delete dugme iz dijaloga
//Sacekati da dijalog za Editovanje postane nevidljiv
//Verifikovati da je broj redova u tabeli za jedan manji
//Za sve validacije ispisati odgovarajuce poruke u slucaju greske
//
//Test #3: Take a Screenshot
//Koraci:
//Ucitati stranu  /iframe/K5yrx
//Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//Kreirati screenshot stranice. Koristan link https://www.guru99.com/take-screenshot-selenium-webdriver.html
//Fajl cuvajte na putanji gde su vam bile slike od proslog domaceg. Na putanji: src/main/resources/nazivslike.png