package teste;

import io.github.bonigarcia.wdm.OperatingSystem;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TesteWaits {

    public static WebDriver driver;

    public static void main(String[] args) {
        TesteWaitImplicito();

    }

    public static void TesteWaitImplicito(){

        WebDriverManager.chromedriver().operatingSystem(OperatingSystem.LINUX).setup();

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        driver.get("https://the-internet.herokuapp.com/dynamic_loading");

        driver.manage().window().maximize();

        driver.findElement(By.linkText("Example 2: Element rendered after the fact")).click();

        driver.findElement(By.xpath("//button")).click();

        WebElement textHelloWorld = (WebElement) driver.findElements(By.xpath("//div[@id='finish']/h4"));

        System.out.println(textHelloWorld.getAttribute("innerText").toString());

    }
}
