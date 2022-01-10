package com.gismatullin.mailtestproject.testhelper;

import static com.codeborne.selenide.Selenide.open;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import com.codeborne.selenide.WebDriverRunner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestHelper {

    private static WebDriver driver;
    public static final int TIMEOUT = 10;
    public static final String SEARCH_QUERY = "папка:Входящие тема:";
    public static final String EMAIL_THEME = "Тестовое задание";
    private static String baseUrl;
    public static String login;
    public static String passw;
    public static boolean headless = false;
    private static final String propsPath = "./src/test/resources/config.properties";

    static {
        try (InputStream input = new FileInputStream(propsPath)) {
            Properties props = new Properties();
            props.load(input);
            baseUrl = props.getProperty("baseUrl");
            login = props.getProperty("login");
            passw = props.getProperty("passw");
            headless = Boolean.valueOf(props.getProperty("headless"));
        } catch (IOException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private TestHelper() {}

    public static void setup() {
        ChromeOptions options = new ChromeOptions();
        if (headless) {
            options.addArguments("--headless");
        }
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        URL url;
        try {
            url = new URL("http://127.0.01:4444/wd/hub");
        } catch (MalformedURLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
        System.setProperty("io.qameta.allure.CommandLine", "/opt/allure-commandline/allure-2.14.0/bin/allure");
        driver = new RemoteWebDriver(url, capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TIMEOUT));
        WebDriverRunner.setWebDriver(driver);
        open(baseUrl);
    }

    public static void clean() {
        driver.quit();
    }
    
}
