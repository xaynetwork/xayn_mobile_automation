package android;

import base.AndroidTestBase;
import com.xayn.annotations.TMS;
import com.xayn.constants.Directions;
import com.xayn.screens.HomeScreen;
import com.xayn.screens.components.OnboardingComponent;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewsfeedTestAndroid extends AndroidTestBase {

    @Test(description = "Checking like")
    @TMS(id = 202)
    @Description("Liking an article by swiping it to the right")
    public void checkingLikeBySwipe() {
        OnboardingComponent onboarding = new OnboardingComponent().open();
        onboarding.gotItButtonClick();
        HomeScreen homeScreen = new HomeScreen().open();
        homeScreen.swipeScreen(Directions.RIGHT);
        Assert.assertTrue(homeScreen.isCardLiked(), "Card isn't liked");
    }

    @Test(description = "Checking dislike")
    @TMS(id = 203)
    @Description("Disliking an article by swiping it to the left")
    public void checkingDislikeBySwipe() {
        OnboardingComponent onboarding = new OnboardingComponent().open();
        onboarding.gotItButtonClick();
        HomeScreen homeScreen = new HomeScreen().open();
        homeScreen.swipeScreen(Directions.LEFT);
        Assert.assertTrue(homeScreen.isCardDisLiked(), "Card isn't disliked");
    }

    @Test(description = "Checking like")
    @TMS(id = 204)
    @Description("Liking an article by clicking on the like button")
    public void checkingLikeByButton() {
        OnboardingComponent onboarding = new OnboardingComponent().open();
        onboarding.gotItButtonClick();
        HomeScreen homeScreen = new HomeScreen().open();
        homeScreen.likeDiscoveryCard();
        Assert.assertTrue(homeScreen.isCardLiked(), "Card isn't liked");
    }

    @Test(description = "Checking dislike")
    @TMS(id = 205)
    @Description("Disliking an article by clicking on the dislike button")
    public void checkingDislikeByButton() {
        OnboardingComponent onboarding = new OnboardingComponent().open();
        onboarding.gotItButtonClick();
        HomeScreen homeScreen = new HomeScreen().open();
        homeScreen.dislikeDiscoveryCard();
        Assert.assertTrue(homeScreen.isCardDisLiked(), "Card isn't disliked");
    }

}
