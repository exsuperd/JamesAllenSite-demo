package pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class DiamondsPage {
    public final Page page;
    public final Locator roundDiamondsLink;
    public final Locator minPriceRange;
    public final Locator maxPriceRange;
    public final Locator pushedModal;
    public final Locator closeModalButton;

    public DiamondsPage(Page page) {
        this.page = page;

        roundDiamondsLink = page.locator("a[data-qa='round_loose_diamonds']");
        minPriceRange = page.locator("input[data-qa='price-min-input']");
        maxPriceRange = page.locator("input[data-qa='price-max-input']");
        pushedModal = page.locator("div.portalModal");
        closeModalButton = page.locator("div.portalModal button");//refer to second and las element
    }
}