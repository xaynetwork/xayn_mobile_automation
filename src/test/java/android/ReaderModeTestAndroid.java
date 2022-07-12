package android;

import base.AndroidTestBase;
import com.xayn.annotations.TMS;
import com.xayn.screens.HomeScreen;
import com.xayn.screens.ReaderModeScreen;
import com.xayn.screens.components.OnboardingComponent;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReaderModeTestAndroid extends AndroidTestBase {
    @Test(description = "Liking an article in reader mode")
    @TMS(id = 220)
    public void checkingLikeInReaderMode() {
        OnboardingComponent onboarding = new OnboardingComponent().open();
        onboarding.gotItButtonClick();
        HomeScreen homeScreen = new HomeScreen().open();
        ReaderModeScreen readerModeScreen = homeScreen.clickOnDiscoveryCard().open();
        readerModeScreen.clickLikeButton();
        Assert.assertTrue(readerModeScreen.isArticleLiked());
    }

    @Test(description = "Disliking an article in reader mode")
    @TMS(id = 221)
    public void checkingDislikeInReaderMode() {
        OnboardingComponent onboarding = new OnboardingComponent().open();
        onboarding.gotItButtonClick();
        HomeScreen homeScreen = new HomeScreen().open();
        ReaderModeScreen readerModeScreen = homeScreen.clickOnDiscoveryCard().open();
        readerModeScreen.clickDislikeButton();
        Assert.assertTrue(readerModeScreen.isArticleDisliked());
    }

    @Test(description = "Navigating back from reader mode")
    @TMS(id = 224)
    public void checkingNavigatingBackFromReaderMode() {
        OnboardingComponent onboarding = new OnboardingComponent().open();
        onboarding.gotItButtonClick();
        HomeScreen homeScreen = new HomeScreen().open();
        ReaderModeScreen readerModeScreen = homeScreen.clickOnDiscoveryCard().open();
        readerModeScreen.clickDislikeButton();
        Assert.assertTrue(readerModeScreen.isArticleDisliked());
    }
}
