package com.gmail.eugene.lazurin.linkedIn_Selenium_Test

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class MainPage(driver: WebDriver) {
    @FindBy(css = "nav__button-secondary")
    lateinit var navButtonEnter: WebElement

    @FindBy(css = "nav__button-tertiary")
    lateinit var navButtonJoin: WebElement

    @FindBy(id = "session_key")
    lateinit var mailOrNumber: WebElement

    @FindBy(id = "session_password")
    lateinit var pass: WebElement

    @FindBy(className = "sign-in-form__submit-button")
    lateinit var bigEnterButton: WebElement

    @FindBy(className = "google-sign-in-cta__button")
    lateinit var googleEnterButton: WebElement

    @FindBy(xpath = "//a[@class='pill pill--transparent']")
    lateinit var makeVacancy: WebElement

    @FindBy(xpath = "//a[contains(@class,'pill pill--blue')]")
    lateinit var startBigButton: WebElement

    @FindBy(xpath = "(//a[@class='pill pill--transparent'])[2]")
    lateinit var findGuys: WebElement

    init {
        PageFactory.initElements(driver, this)
    }
}
