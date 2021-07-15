/*MIT License
Copyright (c) 2021 Lazurin Eugene
Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/


package com.gmail.eugene.lazurin.linkedIn_Selenium_Test

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
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
        val searchField =
            driver.findElement(By.xpath("//input[@type='search' and @placeholder='Поиск должностей или компаний']"))
        searchField.sendKeys("JetBrains" + Keys.ENTER)

        val searchedPageField =
            driver.findElement(By.xpath("//input[@type='search' and @placeholder='Поиск должностей или компаний']"))
        assertEquals("JetBrains", searchedPageField.getAttribute("value"))
    }

    @Test
    fun `search typo job`() {
        mainPage.logo.click()
        guestPage.search.click()
        WebDriverWait(driver, 5).until(ExpectedConditions.titleContains("Вакансии"))
        val searchField =
            driver.findElement(By.xpath("//input[@type='search' and @placeholder='Поиск должностей или компаний']"))
        searchField.sendKeys("JetBraiis" + Keys.ENTER)

        val searchedPageField =
            driver.findElement(By.xpath("//input[@type='search' and @placeholder='Поиск должностей или компаний']"))
        assertEquals("JetBrains", searchedPageField.getAttribute("value"))
    }

    @Test
    fun `search bad words`() {
        mainPage.logo.click()
        guestPage.search.click()
        WebDriverWait(driver, 5).until(ExpectedConditions.titleContains("Вакансии"))
        val searchField =
            driver.findElement(By.xpath("//input[@type='search' and @placeholder='Поиск должностей или компаний']"))
        searchField.sendKeys("!@#$%^&*(" + Keys.ENTER)

        val searchedPageField =
            driver.findElement(By.xpath("//input[@type='search' and @placeholder='Поиск должностей или компаний']"))
        assertEquals("!@#$%^&*(", searchedPageField.getAttribute("value"))
    }

    @Test
    fun `search numbers`() {
        mainPage.logo.click()
        guestPage.search.click()
        WebDriverWait(driver, 5).until(ExpectedConditions.titleContains("Вакансии"))
        val searchField =
            driver.findElement(By.xpath("//input[@type='search' and @placeholder='Поиск должностей или компаний']"))
        searchField.sendKeys(
            "111111111111111111111111111111111111111111111111111111111111111111111111111111111"
                    + "111111111111111111111111111111111111111111111111111111111111111111111111111111111"
                    + "111111111111111111111111111111111111111111111111111111111111111111111111111111111"
                    + "111111111111111111111111111111111111111111111111111111111111111111111111111111111"
                    + Keys.ENTER
        )

        val searchedPageField =
            driver.findElement(By.xpath("//input[@type='search' and @placeholder='Поиск должностей или компаний']"))
        assertEquals(
            "111111111111111111111111111111111111111111111111111111111111111111111111111111111"
                    + "111111111111111111111111111111111111111111111111111111111111111111111111111111111"
                    + "111111111111111111111111111111111111111111111111111111111111111111111111111111111"
                    + "111111111111111111111111111111111111111111111111111111111111111111111111111111111",
            searchedPageField.getAttribute("value")
        )
    }

    @Test
    fun `search 小米 job`() {
        mainPage.logo.click()
        guestPage.search.click()
        WebDriverWait(driver, 5).until(ExpectedConditions.titleContains("Вакансии"))
        val searchField =
            driver.findElement(By.xpath("//input[@type='search' and @placeholder='Поиск должностей или компаний']"))
        searchField.sendKeys("小米" + Keys.ENTER)

        val searchedPageField =
            driver.findElement(By.xpath("//input[@type='search' and @placeholder='Поиск должностей или компаний']"))
        assertTrue(driver.pageSource.contains("Xiaomi"))
    }

    @Test
    fun `search no company `() {
        mainPage.logo.click()
        guestPage.search.click()
        WebDriverWait(driver, 5).until(ExpectedConditions.titleContains("Вакансии"))
        val searchField =
            driver.findElement(By.xpath("//input[@type='search' and @placeholder='Поиск должностей или компаний']"))
        searchField.sendKeys("asadwqdwqasdsadasdasaas" + Keys.ENTER)

        val searchedPageField =
            driver.findElement(By.xpath("//input[@type='search' and @placeholder='Поиск должностей или компаний']"))
        val field = driver.findElement(By.xpath("//main")).text
        assertFalse(field.contains("asadwqdwqasdsadasdasaas"))
    }

    @Test
    fun searchLearning() {
        mainPage.logo.click()
        guestPage.learning.click()
        WebDriverWait(driver, 5).until(ExpectedConditions.titleContains("Онлайн-курсы"))
        val searchField =
            driver.findElement(By.xpath("//input[@data-tracking-control-name='learning-serp_learning-search-bar_keywords_dismissable-input']"))
        searchField.sendKeys("Selenium" + Keys.ENTER)

        val searchedPageField =
            driver.findElement(By.xpath("//input[@data-tracking-control-name='learning-serp_learning-search-bar_keywords_dismissable-input']"))
        assertEquals("Selenium", searchedPageField.getAttribute("value"))
    }
}
