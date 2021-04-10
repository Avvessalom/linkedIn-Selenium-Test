package com.gmail.eugene.lazurin.linkedIn_Selenium_Test

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class MainUserPage(driver: WebDriver) {
    @FindBy(xpath = "//input[@placeholder='Поиск']")
    lateinit var searchFIeld: WebElement

    @FindBy(xpath = "//span[text()[normalize-space()='Главная']]")
    lateinit var main: WebElement

    @FindBy(id = "ember23")
    lateinit var wide: WebElement

    @FindBy(xpath = "//span[text()[normalize-space()='Вакансии']]")
    lateinit var vacancy: WebElement

    @FindBy(xpath = "//span[text()[normalize-space()='Сообщения']]")
    lateinit var messages: WebElement

    @FindBy(xpath = "//span[text()[normalize-space()='Уведомления']]")
    lateinit var notifications: WebElement

    @FindBy(xpath = "//div[@class='share-box-feed-entry__wrapper artdeco-card']//button[@type='button']")
    lateinit var nawPost: WebElement

    @FindBy(xpath = "//div[@data-control-name='identity_welcome_message']")
    lateinit var profile: WebElement

    init {
        PageFactory.initElements(driver, this)
    }
}