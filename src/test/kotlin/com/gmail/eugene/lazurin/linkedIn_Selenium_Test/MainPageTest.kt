package com.gmail.eugene.lazurin.linkedIn_Selenium_Test

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.util.concurrent.TimeUnit

class MainPageTest {
    private lateinit var driver: WebDriver
    private lateinit var mainPage: MainPage
    private val url = "https://ru.linkedin.com/"

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

        mainPage = MainPage(driver)
    }

    @AfterEach
    fun tearDown() {
        driver.quit()
    }

    @Test
    fun mainPage() {
        WebDriverWait(driver, 5).until(ExpectedConditions.titleIs("lalala"))
    }

    @Test
    fun enterButton() {
        WebDriverWait(driver, 5).until(ExpectedConditions.titleIs("lalala"))
        mainPage.navButtonEnter.click()
        WebDriverWait(driver, 5).until(ExpectedConditions.titleIs("lalala"))
    }

    @Test
    fun joinButton() {
        WebDriverWait(driver, 5).until(ExpectedConditions.titleIs("lalala"))
        mainPage.navButtonJoin.click()
        WebDriverWait(driver, 5).until(ExpectedConditions.titleIs("lalala"))
    }

    @Test
    fun googleButton() {
        WebDriverWait(driver, 5).until(ExpectedConditions.titleIs("lalala"))
        mainPage.googleEnterButton.click()
        WebDriverWait(driver, 5).until(ExpectedConditions.titleIs("lalala"))
    }

    @Test
    fun makeVacancy() {
        WebDriverWait(driver, 5).until(ExpectedConditions.titleIs("lalala"))
        mainPage.makeVacancy.click()
        WebDriverWait(driver, 5).until(ExpectedConditions.titleIs("lalala"))
    }

    @Test
    fun startBigButton() {
        WebDriverWait(driver, 5).until(ExpectedConditions.titleIs("lalala"))
        mainPage.startBigButton.click()
        WebDriverWait(driver, 5).until(ExpectedConditions.titleIs("lalala"))
    }

    @Test
    fun findGuys() {
        WebDriverWait(driver, 5).until(ExpectedConditions.titleIs("lalala"))
        mainPage.findGuys.click()
        WebDriverWait(driver, 5).until(ExpectedConditions.titleIs("lalala"))
    }
}
