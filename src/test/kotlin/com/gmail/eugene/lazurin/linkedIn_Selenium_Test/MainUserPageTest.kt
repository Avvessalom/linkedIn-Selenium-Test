package com.gmail.eugene.lazurin.linkedIn_Selenium_Test

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertTrue
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.util.concurrent.TimeUnit
import javax.security.auth.login.Configuration

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
        mainUserPage.wide.click()
        driver.findElement(By.xpath("//a[@data-control-name='companies']")).click()
        assertTrue(driver.pageSource.contains("JetBrains"))
    }

    @Test
    fun newPost() {
        loginPage.username.sendKeys(ConfProperties.getProperty("login"))
        loginPage.pass.sendKeys(ConfProperties.getProperty("pass"))
        loginPage.submit.click()
        mainUserPage.nawPost.click()
        driver.findElement(By.xpath("//div[@role='textbox']")).sendKeys("Test Post 1")
        driver.findElement(By.xpath("//button[contains(@class,'guider-button-prompt__button share-suggested-hashtags-prompt__add-hashtag')]")).click()
        driver.findElement(By.xpath("//div[@role='textbox']")).sendKeys("testHashtag1")
        val sendPost = driver.findElement(By.xpath("//div[@class='share-box_actions']//button[contains(@class,' artdeco-button')]"))
        val builder = Actions(driver)
        builder.moveToElement(sendPost).click(sendPost)
        builder.perform()
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS)
        val post = driver.findElements(By.xpath("//div[contains(@class,'feed-shared-text relative')]"))[0].text
        println(post)
        assertTrue(post.contains("Test Post 1 #testHashtag1"))
    }

    @Test
    fun findNewJob() {
        loginPage.username.sendKeys(ConfProperties.getProperty("login"))
        loginPage.pass.sendKeys(ConfProperties.getProperty("pass"))
        loginPage.submit.click()
        mainUserPage.vacancy.click()
        driver.findElement(By.xpath("//input[@class='jobs-search-box__text-input jobs-search-box__keyboard-text-input']")).sendKeys("developer")
        val citySearch = driver.findElement(By.xpath("//input[@class='jobs-search-box__text-input jobs-search-box__ghost-text-input']"))
        val builder = Actions(driver)
        builder.moveToElement(citySearch).click(citySearch)
        builder.sendKeys("St Petersburg" + Keys.ENTER)
        builder.perform()
        val post = driver.findElements(By.xpath("//li[@class='jobs-search-results__list-item occludable-update p0 relative ember-view']"))[0].text
        print(post)
        assertTrue(post.contains("developer") || post.contains("Developer"))
    }
}