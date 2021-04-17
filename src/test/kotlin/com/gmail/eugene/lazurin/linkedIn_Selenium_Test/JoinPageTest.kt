package com.gmail.eugene.lazurin.linkedIn_Selenium_Test

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import java.util.concurrent.TimeUnit

class JoinPageTest {
    private lateinit var driver: WebDriver
    private lateinit var joinPage: JoinPage
    private val url = "https://www.linkedin.com/signup/"

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

        joinPage = JoinPage(driver)
    }

    @AfterEach
    fun tearDown() {
        driver.quit()
    }

    @Test
    fun reg() {
        joinPage.email.sendKeys(ConfProperties.getProperty("reglog"))
        joinPage.pass.sendKeys(ConfProperties.getProperty("regpass"))
        joinPage.submit.click()
        joinPage.firstName.sendKeys("testname")
        joinPage.lastName.sendKeys("testlast")
        joinPage.joinForm.click()
        joinPage.phone.sendKeys(ConfProperties.getProperty("gerphone"))
    }

    @Test
    fun sign_in() {
        joinPage.sign_in.click()
        val loginPage = LoginPageTest()
        loginPage.login()
    }
}