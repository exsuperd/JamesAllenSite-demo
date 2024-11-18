package workFlows;


import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import extensions.UIActions;
import extensions.Verifications;
import pageObjects.HomePage;
import utilities.Base;
import utilities.UsefulMethods;

import java.util.List;


import static org.testng.AssertJUnit.assertTrue;


public class HomePageFlows {

    private final HomePage homePage;
    public final Page page;
    public final UIActions uiActions;
    public final Verifications verifications;
    public final UsefulMethods usefulMethods;

    public HomePageFlows(Base base, HomePage homePage) {
        this.homePage = homePage;
        this.page = base.getPageForFlow();
        this.uiActions = base.getUiActions();
        this.verifications = base.getVerifications();
        this.usefulMethods = base.getUsefulMethods();
    }

    public void closeIframePopups() {
        FrameLocator frame = page.frameLocator("iframe[id='attentive_creative']");
        frame.locator("#closeIconSvg").click();
        frame.locator("#closeIconContainer").click();
    }

    public void acceptCookies() {
        List<Locator> acceptCookiesDialogList = homePage.cookiesApprovalDialog.all();
        if (!acceptCookiesDialogList.isEmpty()) {
            homePage.cookieSettingsLink.click();
            homePage.confirmMyChoices.click();
        }
    }

    public void login() {
        homePage.loginIcon.hover();
        page.mouse().move(homePage.loginIcon.boundingBox().x + 5, homePage.loginIcon.boundingBox().y + 5);
        homePage.loginIcon.click();
        String email = usefulMethods.getData("loginEmail");
        for (char c : email.toCharArray()) {
            homePage.emailInputField.pressSequentially(String.valueOf(c),
                    new Locator.PressSequentiallyOptions().setDelay(50 + (Math.random() * 100)));
        }
        String password = usefulMethods.getData("loginPassword");
        for (char c : password.toCharArray()) {
            homePage.passwordInputField.pressSequentially(String.valueOf(c),
                    new Locator.PressSequentiallyOptions().setDelay(50 + (Math.random() * 100)));
        }
        homePage.loginButton.hover();
        homePage.loginButton.click();
        homePage.loggedInUserName.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
    }

    public void verifyHomePageTopHeaders(String[] expectedHomepageTopHeadersTexts) {
        List<String> allHeadersTexts = homePage.homePageTopHeadersList.allInnerTexts();
        System.out.println(allHeadersTexts);
        verifications.verifyCorrectTextInEachStringListIndex(allHeadersTexts, expectedHomepageTopHeadersTexts);
    }

    public void verifyCorrectAvailableCurrencies(String[] expectedOptionalCurrencies) {
        List<String> availableCurrencies = homePage.availableCurrenciesList.allInnerTexts();
        System.out.println("Available currencies are: " + availableCurrencies);
        verifications.verifyCorrectTextInEachStringListIndex(availableCurrencies, expectedOptionalCurrencies);
    }

    public void selectCurrency(String desiredCurrency) {
        homePage.currencySwitcher.hover();
        switch (desiredCurrency) {
            case ("USD"), ("usd"), ("US Dollar") -> {
                if (!homePage.availableCurrenciesList.all().get(0).innerText().equalsIgnoreCase("USD")) {
                    homePage.usDollar.click();
                    assertTrue(page.locator("li[data-qa='USD']").isVisible());
                } else System.out.println("US dollar is already the selected currency");
            }
            case ("CAD"), ("cad"), ("Canadian Dollar") -> {
                if (!homePage.availableCurrenciesList.all().get(0).innerText().equalsIgnoreCase("CAD")) {
                    homePage.canadianDollar.click();
                    assertTrue(page.locator("li[data-qa='CAD']").isVisible());
                } else System.out.println("Canadian dollar is already the selected currency");
            }
            case ("EURO"), ("euro"), ("Euro") -> {
                if (!homePage.availableCurrenciesList.all().get(0).innerText().equalsIgnoreCase("EUR")) {
                    homePage.euro.click();
                    assertTrue(page.locator("li[data-qa='EUR']").isVisible());
                } else System.out.println("Euro is already the selected currency");
            }
            case ("GBP"), ("gbp"), ("British Pound") -> {
                if (!homePage.availableCurrenciesList.all().get(0).innerText().equalsIgnoreCase("GBP")) {
                    homePage.britishPound.click();
                    assertTrue(page.locator("li[data-qa='GBP']").isVisible());
                } else System.out.println("British pound is already the selected currency");
            }
            case ("HKD"), ("hkd"), ("Honk Kong Dollar") -> {
                if (!homePage.availableCurrenciesList.all().get(0).innerText().equalsIgnoreCase("HKD")) {
                    homePage.honkKongDollar.click();
                    assertTrue(page.locator("li[data-qa='HKD']").isVisible());
                } else System.out.println("Honk kong dollar is already the selected currency");
            }
            case ("NZD"), ("nzd"), ("Zew Zealand Dollar") -> {
                if (!homePage.availableCurrenciesList.all().get(0).innerText().equalsIgnoreCase("NZD")) {
                    homePage.newZealandDollar.click();
                    assertTrue(page.locator("li[data-qa='NZD']").isVisible());
                } else System.out.println("New zealand dollar is already the selected currency");
            }
            case ("SGD"), ("sgd"), ("Singapore Dollar") -> {
                if (!homePage.availableCurrenciesList.all().get(0).innerText().equalsIgnoreCase("SGD")) {
                    homePage.singaporeDollar.click();
                    assertTrue(page.locator("li[data-qa='SGD']").isVisible());
                } else System.out.println("Singapore dollar is already the selected currency");
            }
            case ("AUD"), ("aud"), ("Australian Dollar") -> {
                if (!homePage.availableCurrenciesList.all().get(0).innerText().equalsIgnoreCase("AUD")) {
                    homePage.australianDollar.click();
                    assertTrue(page.locator("li[data-qa='AUD']").isVisible());
                } else System.out.println("Australian dollar is already the selected currency");
            }
            case ("CNY"), ("cny"), ("Chinese Yuan") -> {
                if (!homePage.availableCurrenciesList.all().get(0).innerText().equalsIgnoreCase("CNY")) {
                    homePage.chineseYuan.click();
                    assertTrue(page.locator("li[data-qa='CNY']").isVisible());
                } else System.out.println("Chinese Yuan is already the selected currency");
            }
            default -> {
                System.out.println("Invalid currency name");
            }
        }
    }
}



