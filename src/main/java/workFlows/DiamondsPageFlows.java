package workFlows;

import com.microsoft.playwright.Page;
import extensions.UIActions;
import extensions.Verifications;
import pageObjects.DiamondsPage;
import pageObjects.HomePage;
import utilities.Base;
import utilities.UsefulMethods;


public class DiamondsPageFlows {

    private final DiamondsPage diamondsPage;
    private final HomePage homePage;
    private final HomePageFlows homePageFlows;
    public final Page page;
    public final UIActions uiActions;
    public final Verifications verifications;
    public final UsefulMethods usefulMethods;

    public DiamondsPageFlows(Base base, DiamondsPage diamondsPage, HomePage homePage) {
        this.diamondsPage = diamondsPage;
        this.homePage = homePage;
        this.homePageFlows = base.homePageFlows;
        this.page = base.getPageForFlow();
        this.uiActions = base.getUiActions();
        this.verifications = base.getVerifications();
        this.usefulMethods = base.getUsefulMethods();
    }

    //Understanding from "data-rate" value in the html that  the USD rate is a reference for all other coins.
    public void changeCurrencyAndVerifyAffectOnPriceRanges(String expectedUSDollarMinPrice, String expectedUSDollarMaxPrice,
                                                           String desiredCurrency, String desiredCurrencyIcon) {
        homePage.homePageTopHeadersList.all().get(2).hover();
        diamondsPage.roundDiamondsLink.hover();
        diamondsPage.roundDiamondsLink.click();
        page.waitForURL("https://www.jamesallen.com/loose-diamonds/round-cut/");
        if (!diamondsPage.pushedModal.all().isEmpty())
            diamondsPage.closeModalButton.last().click();
        homePageFlows.selectCurrency("USD");
        verifications.getAndVerifyCorrectElementAttributeValue(diamondsPage.minPriceRange, "value",
                expectedUSDollarMinPrice);
        verifications.getAndVerifyCorrectElementAttributeValue(diamondsPage.maxPriceRange, "value",
                expectedUSDollarMaxPrice);
        homePageFlows.selectCurrency(desiredCurrency);
        verifications.getAndVerifyElementAttributeContainsSpecificValue(diamondsPage.minPriceRange, "value",
                desiredCurrencyIcon);
        verifications.getAndVerifyElementAttributeContainsSpecificValue(diamondsPage.maxPriceRange, "value",
                desiredCurrencyIcon);
    }

}
