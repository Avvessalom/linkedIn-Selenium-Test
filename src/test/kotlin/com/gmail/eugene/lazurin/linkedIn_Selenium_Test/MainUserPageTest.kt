package com.gmail.eugene.lazurin.linkedIn_Selenium_Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.Select
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
        driver.findElement(By.xpath("//button[contains(@class,'guider-button-prompt__button share-suggested-hashtags-prompt__add-hashtag')]"))
            .click()
        driver.findElement(By.xpath("//div[@role='textbox']")).sendKeys("testHashtag1")
        val sendPost =
            driver.findElement(By.xpath("//div[@class='share-box_actions']//button[contains(@class,' artdeco-button')]"))
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
        driver.findElement(By.xpath("//input[@class='jobs-search-box__text-input jobs-search-box__keyboard-text-input']"))
            .sendKeys("developer")
        val citySearch =
            driver.findElement(By.xpath("//input[@class='jobs-search-box__text-input jobs-search-box__ghost-text-input']"))
        val builder = Actions(driver)
        builder.moveToElement(citySearch).click(citySearch)
        builder.sendKeys("St Petersburg" + Keys.ENTER)
        builder.perform()
        val post =
            driver.findElements(By.xpath("//li[@class='jobs-search-results__list-item occludable-update p0 relative ember-view']"))[0].text
        print(post)
        assertTrue(post.contains("developer") || post.contains("Developer"))
    }

    @Test
    fun makeMeeting() {
        loginPage.username.sendKeys(ConfProperties.getProperty("login"))
        loginPage.pass.sendKeys(ConfProperties.getProperty("pass"))
        loginPage.submit.click()
        mainUserPage.wide.click()
        driver.findElement(By.xpath("//a[@data-control-name='events']")).click()
        driver.findElement(By.xpath("//button[@data-control-name='curation_hub_create_event']")).click()
        driver.findElement(By.id("events-shared-creation-form__name")).sendKeys("testMeeting")
        driver.findElement(By.xpath("//div[contains(@class,'full-width t-14')]")).click()
        driver.findElement(By.xpath("//div[text()[normalize-space()='(UTC-02:00) Гренландия']]")).click()
        driver.findElement(By.id("date-time-picker__start-date")).sendKeys(Keys.BACK_SPACE)
        driver.findElement(By.id("date-time-picker__start-date")).sendKeys("2")
        driver.findElement(By.id("date-time-picker__end-date")).sendKeys(Keys.BACK_SPACE)
        driver.findElement(By.id("date-time-picker__end-date")).sendKeys("2")
        driver.findElement(By.id("date-time-picker__start-time")).sendKeys("1234")
        driver.findElement(By.id("date-time-picker__end-time")).sendKeys("1345")
        driver.findElement(By.id("events-shared-details-section__description")).sendKeys("test meeting text area")
        driver.findElement(By.xpath("(//div[contains(@class,'full-width t-14')])[2]")).click()
        driver.findElement(By.xpath("//div[contains(@class,'events-shared-event-visibility__dropdown-option artdeco-dropdown__item')]"))
            .click()
        driver.findElement(By.xpath("(//span[@class='artdeco-button__text'])[2]")).click()
        driver.findElement(By.xpath("//a[@data-control-name='event_share_card_cta']")).click()
        val testMeeting = driver.findElement(By.xpath("//div[@class='events-top-card__info-container']//h1"))
            .getAttribute("innerHTML")
        assertEquals(
            testMeeting, "\n      testMeeting\n    "
        )
    }

    @Test
    fun deleteMeeting() {
        loginPage.username.sendKeys(ConfProperties.getProperty("login"))
        loginPage.pass.sendKeys(ConfProperties.getProperty("pass"))
        loginPage.submit.click()
        mainUserPage.wide.click()
        driver.findElement(By.xpath("//a[@data-control-name='nav.mynetwork']")).click()
        driver.findElement(By.xpath("//a[@data-control-name='events']")).click()
        driver.findElement(By.xpath("//a[@class='app-aware-link']")).click()

        driver.findElement(By.xpath("/html/body/div[8]/div[3]/div[1]/section/div/div[1]/div[2]/button")).click()
        driver.findElement(By.cssSelector("html>body>div:nth-of-type(8)>div:nth-of-type(3)>div>section>div>div>div:nth-of-type(2)>div>div>ul>li:nth-of-type(4)>div>div"))
            .click()
        driver.findElement(By.xpath("//span[text()[normalize-space()='Удалить мероприятие']]")).click()
        mainUserPage.wide.click()
        driver.findElement(By.xpath("//a[@data-control-name='nav.mynetwork']")).click()
        val clear =
            driver.findElement(By.xpath("/html/body/div[8]/div[3]/div/div/div/div/div/div/div/main/div/div[2]/section/h1"))
                .getAttribute("innerHTML")
        assertEquals(clear, "\n    Мероприятий нет\n  ")
    }

    //TODO update scrolling
    @Test
    fun changeUniversity() {
        val jsExecutor = driver as JavascriptExecutor

        loginPage.username.sendKeys(ConfProperties.getProperty("login"))
        loginPage.pass.sendKeys(ConfProperties.getProperty("pass"))
        loginPage.submit.click()
        driver.findElement(By.xpath("//a//div[@data-control-name='identity_welcome_message']")).click()
        WebDriverWait(driver, 5).until(ExpectedConditions.titleContains("| LinkedIn"))
        jsExecutor.executeScript("window.scrollBy(0,1500);")
        val newEdu = driver.findElement(By.xpath("//a[@data-control-name='add_education']")).click()
        val university = driver.findElement(By.id("edu-school-typeahead")).sendKeys("test")
        val edu = driver.findElement(By.id("edu-degree-typeahead")).sendKeys("бакалавр")
        val fieldOfStudy = driver.findElement(By.id("edu-field-of-study-typeahead")).sendKeys("очень умный чел")
        val selectStartYear = Select(driver.findElement(By.id("pe-education-form__start-year"))).selectByValue("2000")
        val selectEndYear = Select(driver.findElement(By.id("pe-education-form__end-year"))).selectByValue("2005")
        val eduGrade = driver.findElement(By.id("edu-grade")).sendKeys("5.0")
        val eduActivityes = driver.findElement(By.id("edu-activities-societies")).sendKeys("отдыхал отдых, делал дела")
        val eduDescription = driver.findElement(By.id("edu-description"))
            .sendKeys("Тестовое описание тестового университета, получается")
        val send =
            driver.findElement(By.xpath("//footer//button[@type='submit']"))
                .click()
    }

    @Test
    fun `spy the guy`() {
        val jsExecutor = driver as JavascriptExecutor

        loginPage.login()
        mainUserPage.searchFIeld.sendKeys("Vitaliy Prikota" + Keys.ENTER)
        val guy = driver.findElement(By.xpath("//span/div//span/a")).click()
        jsExecutor.executeScript("window.scrollBy(0,1500);")
        assertTrue(driver.title.contains("Vitaliy Prikota"))
    }

    @Test
    fun watchNotification() {
        loginPage.login()
        mainUserPage.notifications.click()
        driver.findElements(By.xpath("//section[@class='nt-segment nt-segment--combined artdeco-card']/div/article/div/a"))[1].click()
        WebDriverWait(driver, 5).until { !driver.title.equals("Уведомления | LinkedIn") }
    }
}
