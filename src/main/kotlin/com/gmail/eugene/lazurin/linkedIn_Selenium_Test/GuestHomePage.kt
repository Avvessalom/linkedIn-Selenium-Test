package com.gmail.eugene.lazurin.linkedIn_Selenium_Test

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class GuestHomePage(driver: WebDriver) {
    @FindBy(xpath = "//a[@data-tracking-control-name='homepage-basic_intent-module-jobs']")
    lateinit var search: WebElement

    @FindBy(xpath = "//a[@data-tracking-control-name='homepage-basic_intent-module-learning']")
    lateinit var learning: WebElement

    init {
        PageFactory.initElements(driver, this)
    }
}