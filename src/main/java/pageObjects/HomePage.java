package pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {

    public final Page page;
    public final Locator onTopPage;
    public final Locator closeOnTopPageButton;
    public final Locator bubbleAnnouncer;
    public final Locator closeBubbleAnnouncerButton;
    public final Locator cookiesApprovalDialog;
    public final Locator cookieSettingsLink;
    public final Locator confirmMyChoices;
    public final Locator loginIcon;
    public final Locator emailInputField;
    public final Locator passwordInputField;
    public final Locator loginButton;
    public final Locator loggedInUserName;
    public final Locator homePageTopHeadersList;
    public final Locator currencySwitcher;
    public final Locator availableCurrenciesList;
    public final Locator matchingFlagsImagesList;
    public final Locator usDollar;
    public final Locator canadianDollar;
    public final Locator euro;
    public final Locator britishPound;
    public final Locator honkKongDollar;
    public final Locator newZealandDollar;
    public final Locator singaporeDollar;
    public final Locator australianDollar;
    public final Locator chineseYuan;
    public final Locator backToHomePageLink;

    public HomePage(Page page) {
        this.page = page;

        onTopPage = page.locator("#page1");
        bubbleAnnouncer = page.locator("#bubbleAnnouncer");
        closeOnTopPageButton = page.locator("#closeIconSvg");
        closeBubbleAnnouncerButton = page.locator("#closeIconContainer");
        cookiesApprovalDialog = page.locator("div[aria-label='Cookie banner']");
        cookieSettingsLink = page.locator("button.cookie-setting-link");
        confirmMyChoices = page.locator("button.save-preference-btn-handler");
        loginIcon = page.locator("div[data-qa='login-menu-item']");
        emailInputField = page.locator("#email");
        passwordInputField = page.locator("#password");
        loginButton = page.locator("button[name='submitLoginForm']");
        loggedInUserName = page.locator("div[data-qa='username']");
        homePageTopHeadersList = page.locator("//ul[starts-with(@class,'centerNavigation')]/li/a");
        currencySwitcher = page.locator("//div[contains(@class,' ECCurrencyMain')]");
        availableCurrenciesList = page.locator("ul.ECCurrencyList li span.label");
        matchingFlagsImagesList = page.locator("ul.ECCurrencyList li span:nth-child(1)");
        usDollar = page.locator("ul.ECCurrencyList li[data-qa='USD']");
        canadianDollar = page.locator("ul.ECCurrencyList li[data-qa='CAD']");
        euro = page.locator("ul.ECCurrencyList li[data-qa='EUR']");
        britishPound = page.locator("ul.ECCurrencyList li[data-qa='GBP']");
        honkKongDollar = page.locator("ul.ECCurrencyList li[data-qa='HKD']");
        newZealandDollar = page.locator("ul.ECCurrencyList li[data-qa='ZND']");
        singaporeDollar = page.locator("ul.ECCurrencyList li[data-qa='SGD']");
        australianDollar = page.locator("ul.ECCurrencyList li[data-qa='AUD']");
        chineseYuan = page.locator("ul.ECCurrencyList li[data-qa='CNY']");
        backToHomePageLink = page.locator("a[title='James Allen Logo']");
    }
}