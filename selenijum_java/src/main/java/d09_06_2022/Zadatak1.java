package d09_06_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Scanner;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        Scanner s = new Scanner(System.in);
        System.out.println("Unesite broj zvezdica: ");
        int t = s.nextInt();


        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.get("https://s.bootsnipp.com/iframe/WaXlr");
//	    WebElement element = drajver.findElement(By.xpath("//*[@id='rating-star-1']"));
//		element.click();

        if (t == 1) {
            WebElement element = driver.findElement(By.xpath("//*[@id='rating-star-1']"));
            element.click();
            Thread.sleep(3000);
        } else if (t == 2) {
            WebElement element1 = driver.findElement(By.xpath("//*[@id='rating-star-2']"));
            element1.click();
            Thread.sleep(3000);
        } else if (t == 3) {
            WebElement element2 = driver.findElement(By.xpath("//*[@id='rating-star-3']"));
            element2.click();
            Thread.sleep(3000);
        } else if (t == 4) {
            WebElement element3 = driver.findElement(By.xpath("//*[@id='rating-star-4']"));
            Thread.sleep(3000);
        } else {
            WebElement element4 = driver.findElement(By.xpath("//*[@id='rating-star-5']"));
            element4.click();
            Thread.sleep(3000);
        }

        driver.quit();
    }
}
//       Maksimizirati prozor
//        Ucitati stranicu https://s.bootsnipp.com/iframe/WaXlr
//        Dohvatite dugmice za rejting kao listu.
//        XPath za trazenje treba da bude preko id atributa
//        i za ovo trebace vam contains u xpath-u
//        Od korisnika ucitati broj (preko scannera)
//        na koju zvezdicu je potrebno kliknuti (u rasponu od 1 do 5)
//        I izvrsite akciju klik na odgovarajuci element preko indeksa
//        Na kraju programa ugasite pretrazivac.