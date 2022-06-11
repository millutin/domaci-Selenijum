package d10_06_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://s.bootsnipp.com/iframe/Dq2X");

        List<WebElement> elements = driver
                .findElements(By.xpath("//div[contains(@class,'col-md-12')]/div/button"));


        for (int i = 0; i < elements.size(); i++) {
            driver.findElement(By.xpath("//div[contains(@class,'col-md-12')]/div[last()]/button"))
                    .click();
            Thread.sleep(1000);
            try {
                driver.findElement(By.xpath("//div[contains(@class,'col-md-12')]/div[last()]/button"));
                System.out.println("Obrisan red");
            }catch (Exception e){
                System.out.println("Nije obrisan");
            }

        }
        driver.quit();
    }
}
//        Napisati program koji:
//        Ucitava stranicu https://s.bootsnipp.com/iframe/Dq2X
//        Klikce na svaki iks da ugasi obavestenje i proverava da li se nakon klika element obrisao
//        sa stranice i ispisuje odgovarajuce poruke (OVO JE POTREBNO RESITI KORISCENJEM PETLJE)
//        POMOC: Brisite elemente odozdo.
//        (ZA VEZBANJE)Probajte da resite da se elemementi brisu i odozgo


