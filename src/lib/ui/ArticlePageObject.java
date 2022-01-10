package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject {
    public static final String
            TITLE = BY_ID + ":org.wikipedia:id/view_page_title_text",
            MORE_OPTIONS_BUTTON = BY_XPATH + "://android.widget.ImageView[@content-desc='More options']",
            ADD_TO_READING_LIST_MENU_ITEM = BY_XPATH + "://android.widget.TextView[@resource-id='org.wikipedia:id/title'][@text='Add to reading list']",
            NAVIGATE_UP_BUTTON = BY_XPATH + "://android.widget.ImageButton[@content-desc='Navigate up']";

    public ArticlePageObject(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    @SuppressWarnings("UnusedReturnValue")
    public WebElement findArticleTitleWithoutWaiting() {
        return this.findElementWithoutWaiting(TITLE);
    }

    public void callMoreOptionsMenu() {
        this.waitForElementAndClick(MORE_OPTIONS_BUTTON, LONG_WAITING_TIMEOUT_IN_SECONDS);
    }

    public void callAddToReadingListAction() {
        this.waitForElementAndClick(ADD_TO_READING_LIST_MENU_ITEM, LONG_WAITING_TIMEOUT_IN_SECONDS);
    }

    public void closeArticle() {
        this.waitForElementAndClick(NAVIGATE_UP_BUTTON);
    }

    public String getOpenArticleTitle() {
        WebElement articleTitle = this.waitForElementPresent(TITLE);
        return articleTitle.getText();
    }
}
