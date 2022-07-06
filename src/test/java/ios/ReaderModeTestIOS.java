package ios;

import base.IOSTestBase;
import com.xayn.annotations.TMS;
import com.xayn.screens.HomeScreen;
import com.xayn.screens.ReaderModeScreen;
import com.xayn.screens.components.OnboardingComponent;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReaderModeTestIOS extends IOSTestBase {
    @Test(description = "Checking like")
    @TMS(id = 22)
    @Description("Liking an article in reader mode")
    public void checkingLikeInReaderMode() {
        OnboardingComponent onboarding = new OnboardingComponent().open();
        onboarding.gotItButtonClick();
        HomeScreen homeScreen = new HomeScreen().open();
        homeScreen.clickOnScreenCenter();
        ReaderModeScreen readerModeScreen = new ReaderModeScreen().open();
        readerModeScreen.clickLikeButton();
        Assert.assertTrue(readerModeScreen.isArticleLiked());
    }

    @Test(description = "Checking dislike")
    @TMS(id = 23)
    @Description("Disliking an article in reader mode")
    public void checkingDislikeInReaderMode() {
        OnboardingComponent onboarding = new OnboardingComponent().open();
        onboarding.gotItButtonClick();
        HomeScreen homeScreen = new HomeScreen().open();
        homeScreen.clickOnScreenCenter();
        ReaderModeScreen readerModeScreen = new ReaderModeScreen().open();
        readerModeScreen.clickDislikeButton();
        Assert.assertTrue(readerModeScreen.isArticleDisliked());
    }

    @Test(description = "Navigating back")
    @TMS(id = 26)
    @Description("Navigating back from reader mode")
    public void checkingNavigatingBackFromReaderMode() {
        OnboardingComponent onboarding = new OnboardingComponent().open();
        onboarding.gotItButtonClick();
        HomeScreen homeScreen = new HomeScreen().open();
        homeScreen.clickOnScreenCenter();
        ReaderModeScreen readerModeScreen = new ReaderModeScreen().open();
        readerModeScreen.clickLeftArrow();
        Assert.assertTrue(homeScreen.isNavBarDisplayed());
    }
}
