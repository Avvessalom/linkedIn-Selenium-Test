package com.gmail.eugene.lazurin.linkedIn_Selenium_Test

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.util.concurrent.TimeUnit

class MainUserPageTest {
    private lateinit var driver: WebDriver
    private lateinit var mainUserPage: MainUserPage
    private lateinit var loginPage: LoginPage
    private val url = "https://www.linkedin.com/login/"

    @BeforeEach
    fun setUp() {
        System.setProperty(
            "webdriver.chrome.driver",
            "src/main/kotlin/com/gmail/eugene/lazurin/linkedIn_Selenium_Test/driver/chromedriver.exe"
        )
        driver = ChromeDriver()
        driver.manage().window().maximize()
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
        driver.get(url)
        mainUserPage = MainUserPage(driver)
        loginPage = LoginPage(driver)
    }

//    @AfterEach
//    fun tearDown() {
//        driver.quit()
//    }

    @Test
    fun search() {
        loginPage.username.sendKeys(ConfProperties.getProperty("login"))
        loginPage.pass.sendKeys(ConfProperties.getProperty("pass"))
        loginPage.submit.click()
        mainUserPage.searchFIeld.sendKeys("JetBrains" + Keys.ENTER)
        WebDriverWait(driver, 5).until(ExpectedConditions.titleContains("JetBrains"))
        val find = driver.findElement(By.xpath("//button[@aria-label='Отслеживать']")).click()
    }
}