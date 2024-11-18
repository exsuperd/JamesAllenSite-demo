

import org.testng.annotations.*;
import org.testng.annotations.Listeners;
import utilities.Base;

@Listeners(utilities.Listeners.class)
public class JamesAllenWebAutomationDemo extends Base {

    private boolean setupComplete = false;

    private final String[] expectedHomepageTopHeadersTexts = {"ENGAGEMENT RINGS", "WEDDING RINGS", "DIAMONDS", "GEMSTONES",
            "FINE JEWELRY", "EDUCATION", "FAQ"};
    private final String[] expectedAvailableCurrencies = {"USD", "CAD", "EUR", "GBP", "HKD", "NZD", "SGD", "AUD", "CNY"};
    private final String minUSDollarPriceRange = "$200";
    private final String maxUSDollarPriceRange = "$5,000,000";
    private final String firstDesiredCurrencyIcon = "€";
    private final String firstDesiredCurrency = "Euro";
    private final String invalidCurrency = "NIS";
    private final String finalDesiredCurrency = "British Pound";


    @BeforeClass
    public void classSetup() {
        try {
            initCore();
            usefulMethods.deleteAllFilesInAGivenPath("test-output/screenshots");
            String url = usefulMethods.getData("baseURL");
            System.out.println("Navigating to: " + url);
            page.navigate(url);
            homePageFlows.closeIframePopups();
            homePageFlows.acceptCookies();
            homePageFlows.login();
            setupComplete = true;
        } catch (Exception e) {
            System.err.println("Test setup failed: " + e.getMessage());
            closePlaywright();
            throw new RuntimeException("Test setup failed", e);
        }
    }

    @Test
    public void test_01_verifyHomePageTopTabs() {
        homePageFlows.verifyHomePageTopHeaders(expectedHomepageTopHeadersTexts);
    }

    @Test
    public void test_02_verifyAvailableCurrencies() {
        homePageFlows.verifyCorrectAvailableCurrencies(expectedAvailableCurrencies);
    }

    @Test
    public void test_03_replaceCurrency() {
        homePageFlows.selectCurrency(firstDesiredCurrency);
        homePageFlows.selectCurrency(invalidCurrency);
        homePageFlows.selectCurrency(finalDesiredCurrency);
    }

    @Test
    public void test_04_replaceCurrencyAndVerifyPricesWereAffected() {
        diamondsPageFlows.changeCurrencyAndVerifyAffectOnPriceRanges(minUSDollarPriceRange, maxUSDollarPriceRange,
                firstDesiredCurrency, firstDesiredCurrencyIcon);
    }

    @AfterClass(alwaysRun = true)
    public void teardown() {
        if (hasPlaywrightResources()) {
            closePlaywright();
        }
    }
}


