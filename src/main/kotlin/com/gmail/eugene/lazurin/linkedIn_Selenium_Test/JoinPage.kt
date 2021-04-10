package com.gmail.eugene.lazurin.linkedIn_Selenium_Test

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class JoinPage(driver: WebDriver) {
    @FindBy(id = "email-address")
    lateinit var email: WebElement

    @FindBy(id = "password")
    lateinit var pass: WebElement

    @FindBy(id = "join-form-submit")
    lateinit var submit: WebElement

    @FindBy(xpath = "//button[@class='third-party-join__btn third-party-join__google-btn']")
    lateinit var google: WebElement

    @FindBy(className = "main__sign-in-link")
    lateinit var sign_in: WebElement

    @FindBy(id = "first-name")
    lateinit var firstName: WebElement

    @FindBy(id = "last-name")
    lateinit var lastName: WebElement

    @FindBy(id = "join-form-submit")
    lateinit var joinForm: WebElement

    @FindBy(id = "register-verification-phone-number")
    lateinit var phone: WebElement

    init {
        PageFactory.initElements(driver, this)
    }
}