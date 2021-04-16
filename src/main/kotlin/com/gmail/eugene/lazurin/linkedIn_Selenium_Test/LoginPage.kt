package com.gmail.eugene.lazurin.linkedIn_Selenium_Test

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class LoginPage(driver: WebDriver) {
    @FindBy(id = "username")
    lateinit var username: WebElement

    @FindBy(id = "password")
    lateinit var pass: WebElement

    @FindBy(xpath = "//button[@data-litms-control-urn='login-submit']")
    lateinit var submit: WebElement

    fun login() {
        username.sendKeys(ConfProperties.getProperty("login"))
        pass.sendKeys(ConfProperties.getProperty("pass"))
        submit.click()
    }
    init {
        PageFactory.initElements(driver, this)
    }
}