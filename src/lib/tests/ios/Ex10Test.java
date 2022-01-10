package lib.tests.ios;

import lib.CoreTestCase;
import lib.ui.WelcomePageObject;

public class Ex10Test extends CoreTestCase {
    public void testThroughWelcome() {
        new WelcomePageObject(this.driver) {{
            goNextAfterLearnMoreAboutWikipedia();
            goNextAfterNewLearnToWay();
            goNextAfterPreferredLanguages();
            goBeginAtDataCollection();
        }};
    }
}
