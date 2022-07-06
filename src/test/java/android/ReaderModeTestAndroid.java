package android;

import base.AndroidTestBase;
import com.xayn.annotations.TMS;
import com.xayn.screens.HomeScreen;
import com.xayn.screens.ReaderModeScreen;
import com.xayn.screens.components.OnboardingComponent;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReaderModeTestAndroid extends AndroidTestBase {
    @Test(description = "Checking like")
    @TMS(id = 220)
    @Description("Liking an article in reader mode")
    public void checkingLikeInReaderMode() {
        OnboardingComponent onboarding = new OnboardingComponent().open();
        onboarding.gotItButtonClick();
        HomeScreen homeScreen = new HomeScreen().open();
        ReaderModeScreen readerModeScreen = homeScreen.clickOnDiscoveryCard().open();
        readerModeScreen.clickLikeButton();
        Assert.assertTrue(readerModeScreen.isArticleLiked());
    }

    @Test(description = "Checking dislike")
    @TMS(id = 221)
    @Description("Disliking an article in reader mode")
    public void checkingDislikeInReaderMode() {
        OnboardingComponent onboarding = new OnboardingComponent().open();
        onboarding.gotItButtonClick();
        HomeScreen homeScreen = new HomeScreen().open();
        ReaderModeScreen readerModeScreen = homeScreen.clickOnDiscoveryCard().open();
        readerModeScreen.clickDislikeButton();
        Assert.assertTrue(readerModeScreen.isArticleDisliked());
    }

    @Test(description = "Navigating back")
    @TMS(id = 224)
    @Description("Navigating back from reader mode")
    public void checkingNavigatingBackFromReaderMode() {
        OnboardingComponent onboarding = new OnboardingComponent().open();
        onboarding.gotItButtonClick();
        HomeScreen homeScreen = new HomeScreen().open();
        ReaderModeScreen readerModeScreen = homeScreen.clickOnDiscoveryCard().open();
        readerModeScreen.clickDislikeButton();
        Assert.assertTrue(readerModeScreen.isArticleDisliked());
    }
}
