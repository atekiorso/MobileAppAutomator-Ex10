package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class WelcomePageObject extends MainPageObject {
    public static final String
            LEARN_MORE_ABOUT_WIKIPEDIA = BY_XPATH + "://XCUIElementTypeButton[@name='Узнать подробнее о Википедии']",
            NEW_WAYS_TO_LEARN = BY_XPATH + "://XCUIElementTypeStaticText[@name='Новые способы изучения']",
            PREFERRED_LANGUAGES = BY_XPATH + "://XCUIElementTypeButton[@name='Добавить или изменить предпочтительные языки']",
            DATA_COLLECTION = BY_XPATH + "://XCUIElementTypeButton[@name='Узнать подробнее о сборе данных']",
            NEXT_BUTTON = BY_XPATH + "://XCUIElementTypeButton[@name='Далее']",
            BEGIN_BUTTON = BY_XPATH + "://XCUIElementTypeButton[@name='Начать']";

    public WelcomePageObject(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    public void goNextAfterLearnMoreAboutWikipedia() {
        this.waitForElementPresent(LEARN_MORE_ABOUT_WIKIPEDIA);
        this.waitForElementAndClick(NEXT_BUTTON);
    }

    public void goNextAfterNewLearnToWay() {
        this.waitForElementPresent(NEW_WAYS_TO_LEARN);
        this.waitForElementAndClick(NEXT_BUTTON);
    }

    public void goNextAfterPreferredLanguages() {
        this.waitForElementPresent(PREFERRED_LANGUAGES);
        this.waitForElementAndClick(NEXT_BUTTON);
    }

    public void goBeginAtDataCollection() {
        this.waitForElementPresent(DATA_COLLECTION);
        this.waitForElementAndClick(BEGIN_BUTTON);
    }
}
