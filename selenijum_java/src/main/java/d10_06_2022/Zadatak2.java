package d10_06_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://geodata.solutions/");

        Select country = new Select(driver.findElement(By.id("countryId")));
        Select state = new Select(driver.findElement(By.id("stateId")));
        Select city = new Select(driver.findElement(By.id("cityId")));

        country.selectByVisibleText("Serbia");
        state.selectByVisibleText("Central Serbia");
        city.selectByVisibleText("Nis");

        driver.quit();
    }
}
//      Napisati program koji ucitava stranicu https://geodata.solutions/
//        Bira proizvoljan Country, State i City
//        Pritom potrebno je izvrsiti cekanje da se povaje State-ovi nakon izbora Country-a
//        I takodje je potrebno izvrsiti cekanje da se ucitaju gradovi nakon izbora State-a
//        Izabrerit Country, State i City tako da imate podatke da selektujete!
//

