package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class ReadingListPageObject extends MainPageObject {
    public static final String
            GOT_IT_BUTTON = BY_ID + ":org.wikipedia:id/onboarding_button",
            CREATE_NEW_BUTTON = BY_ID + ":org.wikipedia:id/create_button",
            INPUT_READING_LIST_NAME = BY_ID + ":org.wikipedia:id/text_input",
            INPUT_READING_LIST_NAME_OK_BUTTON = BY_ID + ":android:id/button1",
            MY_LISTS_BUTTON = BY_ACCESSIBILITY_ID + ":My lists",
            EXISTING_READING_LIST_TEMPLATE = BY_XPATH + "://android.widget.TextView[@resource-id='org.wikipedia:id/item_title'][@text='{" +
                    REPLACEABLE_TEMPLATE_SUBSTRING + "}']",
            ARTICLE_IN_READING_LIST_TEMPLATE = BY_XPATH + "://android.widget.TextView[@resource-id='org.wikipedia:id/page_list_item_title'][@text='{" +
                    REPLACEABLE_TEMPLATE_SUBSTRING + "}']/..";

    public ReadingListPageObject(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    public void addArticleToNewReadingList(String readingListName) {
        // Если появилась форма с описанием возможностей Reading List - нажимаем кнопку "GOT IT", иначе - кнопку создания нового Reading List
        if (this.isElementPresent(GOT_IT_BUTTON)) {
            this.waitForElementAndClick(GOT_IT_BUTTON);
        } else {
            this.waitForElementAndClick(CREATE_NEW_BUTTON);
        }

        enterReadingListName(readingListName);
        clickInputReadingListOkButton();
    }

    public void addArticleToExistingReadingList(String readingListName) {
        final String existingReadingListXpath = getExistingReadingListXpath(readingListName);
        this.waitForElementAndClick(existingReadingListXpath);
    }

    public void removeArticleFromReadingList(String readingListName, String articleTitle) {
        openReadingList(readingListName);
        final String articleInReadingListXpath = getArticleInReadingListXpath(articleTitle);
        this.waitForElementAndSwipeLeft(articleInReadingListXpath);
    }

    public void openMyLists() {
        this.waitForElementAndClick(MY_LISTS_BUTTON);
    }

    public void openReadingList(String readingListName) {
        final String readingListXpath = getExistingReadingListXpath(readingListName);
        this.waitForElementAndClick(readingListXpath);
    }

    public void openArticleFromCurrentReadingList(String articleTitle) {
        final String articleXpath = getArticleInReadingListXpath(articleTitle);
        this.waitForElementAndClick(articleXpath);
    }

    public boolean isArticlePresentInCurrentReadingList(String articleTitle) {
        final String articleXpath = getArticleInReadingListXpath(articleTitle);
        return this.isElementPresent(articleXpath);
    }

    private void enterReadingListName(String readingListName) {
        this.waitForElementAndSendKeys(INPUT_READING_LIST_NAME, readingListName);
    }

    private void clickInputReadingListOkButton() {
        this.waitForElementAndClick(INPUT_READING_LIST_NAME_OK_BUTTON);
    }

    private String getExistingReadingListXpath(String readingListName) {
        return this.replaceSubstringInTemplate(EXISTING_READING_LIST_TEMPLATE, readingListName);
    }

    /* TEMPLATES METHODS */
    private String getArticleInReadingListXpath(String articleTitle) {
        return this.replaceSubstringInTemplate(ARTICLE_IN_READING_LIST_TEMPLATE, articleTitle);
    }
    /* TEMPLATES METHODS */
}
