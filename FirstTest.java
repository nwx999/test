package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class FirstTest {
    public ChromeDriver driver;
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        System.out.println("test start");
    }

    @Test
    public void firstTest() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Открытие страницы входа
        driver.get("https://mail.yandex.ru/");
        // Вход в почту
        driver.findElement(By.id("header-login-button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".passp-add-account-page-title")));
        //нажимаем на кпопку "почта" и вводим данные от почты
        driver.findElement(By.cssSelector(".AuthLoginInputToggle-type"));
        driver.findElement(By.id("passp-field-login")).sendKeys("логин для почты");
        driver.findElement(By.id("passp-field-login")).sendKeys(Keys.ENTER);
        //вводим пароль
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passp:sign-in")));
        driver.findElement(By.id("passp-field-passwd")).sendKeys("пароль для почты");
        driver.findElement(By.id("passp:sign-in")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[href=\"#inbox\"]")));
        // Создание нового письма
        driver.findElement(By.cssSelector("[href=\"#compose\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".Button2.Button2_view_action.Button2_size_l")));
        // Заполнение полей письма
        driver.findElement(By.cssSelector(".composeYabbles")).sendKeys("dokuchaev_av@tkbbank.ru");
        driver.findElement(By.name("subject")).sendKeys("Тестовое задание для Русакова Павла");
        driver.findElement(By.cssSelector(".cke_wysiwyg_div.cke_reset.cke_enable_context_menu.cke_editable.cke_editable_themed.cke_contents_ltr.cke_htmlplaceholder")).sendKeys("Добрый день\n\nРусаков Павел Александрович, дата выполнения - 05.12.2023.\n\nАвтотест готов");
        // Отправка письма
        driver.findElement(By.cssSelector(".Button2.Button2_view_action.Button2_size_l")).click();
    }

    @After
    public void close() {
        System.out.println("test end");
        driver.quit();

    }
}
