package com.gmail.eugene.lazurin.linkedIn_Selenium_Test

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.util.concurrent.TimeUnit

class GuestHomePageTest {
    private lateinit var driver: WebDriver
    private lateinit var mainPage: MainPage
    private lateinit var guestPage: GuestHomePage
    private val url = "https://ru.linkedin.com/?trk=guest_homepage-basic_nav-header-logo"

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
        guestPage = GuestHomePage(driver)
    }

    @AfterEach
    fun tearDown() {
        driver.quit()
    }

    @Test
    fun mainPage() {
        WebDriverWait(driver, 5).until(ExpectedConditions.titleIs("LinkedIn Россия: войти или зарегистрироваться"))
    }

    @Test
    fun searchJob() {
        mainPage.logo.click()
        guestPage.search.click()
        WebDriverWait(driver, 5).until(ExpectedConditions.titleContains("Вакансии"))
        val searchField = driver.findElement(By.xpath("//input[@type='search' and @placeholder='Поиск должностей или компаний']"))
        searchField.sendKeys("JetBrains" + Keys.ENTER)

        val searchedPageField = driver.findElement(By.xpath("//input[@type='search' and @placeholder='Поиск должностей или компаний']"))
        assertEquals("JetBrains", searchedPageField.getAttribute("value"))
    }

    @Test
    fun searchLearning() {
        mainPage.logo.click()
        guestPage.learning.click()
        WebDriverWait(driver,5).until(ExpectedConditions.titleContains("Онлайн-курсы"))
        val searchField = driver.findElement(By.xpath("//input[@data-tracking-control-name='learning-serp_learning-search-bar_keywords_dismissable-input']"))
        searchField.sendKeys("Selenium" + Keys.ENTER)

        val searchedPageField = driver.findElement(By.xpath("//input[@data-tracking-control-name='learning-serp_learning-search-bar_keywords_dismissable-input']"))
        assertEquals("Selenium", searchedPageField.getAttribute("value"))
    }
}