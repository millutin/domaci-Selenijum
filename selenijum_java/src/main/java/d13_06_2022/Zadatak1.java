package d13_06_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        driver.manage().window().maximize();

        driver.get("https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you");

        File front = new File("src/main/resources/front_Milos_Milutinovic.jpg");
        File left = new File("src/main/resources/left_Milos_MIlutinovic.jpg");
        File back = new File("src/main/resources/back_Milos_Milutinovic.jpg");
        File right = new File("src/main/resources/right_Milos_Milutinovic.jpg");
//********************************************************************************************
        //Front photo

        driver
                .findElement(By.xpath("//img[@alt='image 1']"))
                .click();
        driver
                .findElement(By.xpath("//div[contains(@class,'sc-eXBvqI dFCiIg')]/div[2]"))
                .click();
        driver
                .findElement(By.xpath("//input[@type ='file']"))
                .sendKeys(front.getAbsolutePath());
        wait.until(ExpectedConditions
                .numberOfElementsToBe(By
                        .className("kAzmBp"), 1));
        driver
                .findElement(By
                        .xpath("//div[contains(@class, 'gmXCBU')]/img"))
                .click();
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .xpath("//div[contains(@class, 'dxCajp')]")));
        driver
                .findElement(By
                        .xpath("//button[text() ='Use One Side Only']"))
                .click();
//**************************************************************************************************
        //Left photo

        driver
                .findElement(By.xpath("//img[@alt='image 2']"))
                        .click();
        driver
                .findElement(By.xpath("//div[contains(@class,'sc-eXBvqI dFCiIg')]/div[2]"))
                .click();
        driver
                .findElement(By.xpath("//input[@type ='file']"))
                .sendKeys(left.getAbsolutePath());
        wait.until(ExpectedConditions
                .numberOfElementsToBe(By
                        .className("haLJiC"), 2));
        driver
                .findElement(By
                        .xpath("//div[contains(@class, 'kAzmBp')]//div[2]"))
                .click();
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .xpath("//div[contains(@class, 'dxCajp')]")));
        driver
                .findElement(By
                        .xpath("//button[text() ='Use One Side Only']"))
                .click();
//*******************************************************************************************
        //Back photo

        driver
                .findElement(By.xpath("//img[@alt='image 3']"))
                .click();
        driver
                .findElement(By.xpath("//div[contains(@class,'sc-eXBvqI dFCiIg')]/div[2]"))
                .click();
        driver
                .findElement(By.xpath("//input[@type ='file']"))
                .sendKeys(back.getAbsolutePath());
        wait.until(ExpectedConditions
                .numberOfElementsToBe(By
                        .className("haLJiC"), 3));
        driver
                .findElement(By
                        .xpath("//div[contains(@class, 'kAzmBp')]//div[3]"))
                .click();
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .xpath("//div[contains(@class, 'dxCajp')]")));
        driver
                .findElement(By
                        .xpath("//button[text() ='Use One Side Only']"))
                .click();
//************************************************************************************************
        //Right photo

        driver
                .findElement(By.xpath("//img[@alt='image 4']"))
                .click();
        driver
                .findElement(By.xpath("//div[contains(@class,'sc-eXBvqI dFCiIg')]/div[2]"))
                .click();
        driver
                .findElement(By.xpath("//input[@type ='file']"))
                .sendKeys(right.getAbsolutePath());
        wait.until(ExpectedConditions
                .numberOfElementsToBe(By
                        .className("haLJiC"), 4));
        driver
                .findElement(By
                        .xpath("//div[contains(@class, 'kAzmBp')]//div[4]"))
                .click();
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .xpath("//div[contains(@class, 'dxCajp')]")));
        driver
                .findElement(By
                        .xpath("//button[text() ='Use One Side Only']"))
                .click();
        Thread.sleep(3000);
//****************************************************************************************************
        List<WebElement> konfete = driver
                .findElements(By.xpath("//*[contains(@class, 'fajlzv')]/div"));

        Random r = new Random();


        int randomKonfeta = r.nextInt(5);
        konfete
                .get(randomKonfeta)
                .click();
        Thread.sleep(3000);
//*****************************************************************************************************
        if (elementExist(driver, By.xpath("//*[@action='error']"))){
            System.out.println("Error text is show up");
        } else {
            System.out.println("Error text does not show up");
        }
        
        
        
        

        Thread.sleep(3000);
        driver.quit();
    }

    private static boolean elementExist(WebDriver driver, By by) {

        boolean elementExist = true;
        try {

            driver.findElement(by);
        } catch (Exception e) {
            elementExist = false;
        }
        return  elementExist;

    }
}
//      Ucitava stranicu https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you
//        Maksimizuje prozor
//        Selektuje Image - Front klikom na tu karticu u dnu ekrana
//        Klik na add photo iz levog navigacionog menia
//        Upload slike. Upload preko File objekta koristeci getAbsolutePath
//        Sacekati da broj prikazanih slika u donjem uglu navigacije bude za 1 veca
//        Kliknuti na poslednje dodatu sliku kako bi bila izabrana za postavljenje
//        Ceka da dijalog bude vidljiv
//        Klik na Use One Side Only dugme
//        Ponoviti proces za Left, Right i Back
//        Zatim iz desnog gornjeg ugla izabrati random jedan od ponudjenih konfeta
//        Kliknuti na Add To Cart dugme
//        Verifikovati postojanje greske Oops! It looks like you`ve not added an text to this field, please add one before continuing.
//        Xpath: //*[@action='error']
//        Zatvorite pretrazivac
