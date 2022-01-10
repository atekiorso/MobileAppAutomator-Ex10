package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class SearchPageObject extends MainPageObject {
    private static final String
            SEARCH_INIT = BY_XPATH + "://android.widget.TextView[@text='Search Wikipedia']",
            SEARCH_INPUT = BY_ID + ":org.wikipedia:id/search_src_text",
            SEARCH_RESULTS = BY_ID + ":org.wikipedia:id/fragment_search_results",
            SEARCH_CLOSE_BUTTON = BY_ID + ":org.wikipedia:id/search_close_btn",
            SEARCH_RESULT_BY_TITLE_TEMPLATE = BY_XPATH + "://android.widget.TextView[@resource-id='org.wikipedia:id/page_list_item_title']" +
                    "[@text='{" + REPLACEABLE_TEMPLATE_SUBSTRING + "}']",
            SEARCH_RESULT_BY_TITLE_AND_DESCRIPTION_TEMPLATE = BY_XPATH + "://android.widget.LinearLayout" +
                    "[.//android.widget.TextView[@resource-id='org.wikipedia:id/page_list_item_title'][@text='{"+ REPLACEABLE_TEMPLATE_SUBSTRING + "1}']]" +
                    "[.//android.widget.TextView[@resource-id='org.wikipedia:id/page_list_item_description'][@text='{"+ REPLACEABLE_TEMPLATE_SUBSTRING + "2}']]",
            SEARCH_RESULTS_TITLES = BY_XPATH + "://android.widget.TextView[@resource-id='org.wikipedia:id/page_list_item_title']";

    public SearchPageObject(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    public void initializeSearch() {
        this.waitForElementAndClick(SEARCH_INIT);
        this.waitForElementPresent(SEARCH_INPUT);
    }

    public void enterSearchText(String searchText) {
        this.waitForElementAndSendKeys(SEARCH_INPUT, searchText);
    }

    public void closeSearch() {
        this.waitForElementAndClick(SEARCH_CLOSE_BUTTON);
    }

    public void waitForSearchResultsPresent() {
        this.waitForElementPresent(SEARCH_RESULTS);
    }

    public void waitForSearchResultsNotPresent() {
        this.waitForElementNotPresent(SEARCH_RESULTS);
    }

    public void openArticleFromSearchResults(String title) {
        final String searchResultXpath = getSearchResultXpath(title);
        waitForElementAndClick(searchResultXpath);
    }

    public void waitForElementByTitleAndDescription(String title, String description) {
        final String resultXpath = getSearchResultXpath(title, description);
        this.waitForElementPresent(resultXpath, LONG_WAITING_TIMEOUT_IN_SECONDS);
    }

    public List<WebElement> getResultsTitles() {
        return this.getElements(SEARCH_RESULTS_TITLES);
    }

    /* TEMPLATES METHODS */
    private String getSearchResultXpath(String title) {
        return this.replaceSubstringInTemplate(SEARCH_RESULT_BY_TITLE_TEMPLATE, title);
    }

    private String getSearchResultXpath(String title, String description) {
        List<String> replacements = Arrays.asList(title, description);
        return this.replaceSubstringsInTemplate(SEARCH_RESULT_BY_TITLE_AND_DESCRIPTION_TEMPLATE, replacements);
    }
    /* TEMPLATES METHODS */
}
