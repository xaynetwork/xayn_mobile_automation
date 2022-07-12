package android;

import base.AndroidTestBase;
import com.xayn.annotations.TMS;
import com.xayn.screens.HomeScreen;
import com.xayn.screens.ReaderModeScreen;
import com.xayn.screens.YourSpaceScreen;
import com.xayn.screens.components.CreateNewCollectionComponent;
import com.xayn.screens.components.OnboardingComponent;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CollectionsTestAndroid extends AndroidTestBase {
    @Test(description = "Adding a bookmark to Read Later collection")
    @TMS(id = 41)
    public void checkingBookmarking(){
        OnboardingComponent onboarding = new OnboardingComponent().open();
        onboarding.gotItButtonClick();
        HomeScreen homeScreen = new HomeScreen().open();
        YourSpaceScreen yourSpaceScreen = homeScreen.clickOnPersonalArea().open();
        yourSpaceScreen.clickOnCollection(0);
        Assert.assertTrue(yourSpaceScreen.isNoArticlesHeaderDisplayed(), "there is no \"No Articles\" header displayed");

        yourSpaceScreen.returnBack();
        homeScreen
                .clickOnHomeButton()
                .bookmark()
                .clickOnPersonalArea();
       yourSpaceScreen.clickOnCollection(0);
       onboarding.gotItButtonClick();
       Assert.assertEquals(yourSpaceScreen.getAmountOfBookmarks(), 1, "amount of bookmarks is different from expected");
    }

    @Test(description = "Adding a bookmark to Read Later collection from reading mode")
    @TMS(id = 42)
    public void checkingBookmarkingFromReaderMode(){
        OnboardingComponent onboarding = new OnboardingComponent().open();
        onboarding.gotItButtonClick();
        HomeScreen homeScreen = new HomeScreen().open();
        ReaderModeScreen readerModeScreen = homeScreen.clickOnDiscoveryCard().open();
        readerModeScreen.bookmark();
        readerModeScreen.clickLeftArrow();
        YourSpaceScreen yourSpaceScreen = homeScreen.clickOnPersonalArea().open();
        yourSpaceScreen.clickOnCollection(0);
        onboarding.gotItButtonClick();
        Assert.assertEquals(yourSpaceScreen.getAmountOfBookmarks(), 1, "amount of bookmarks is different from expected");
    }

    @Test(description = "Creating new collection")
    @TMS(id = 299)
    public void checkingCreatingNewCollection() {
        OnboardingComponent onboarding = new OnboardingComponent().open();
        onboarding.gotItButtonClick();
        HomeScreen homeScreen = new HomeScreen().open();
        YourSpaceScreen yourSpaceScreen = homeScreen.clickOnYourSpace().open();
        CreateNewCollectionComponent component = yourSpaceScreen.clickPlusIcon().open();
        String name =  RandomStringUtils.random(20, true, true);
        component
                .typeCollectionName(name)
                .clickCreateButton();
        yourSpaceScreen.clickOnCollection(1);
        Assert.assertTrue(yourSpaceScreen.isNameOfTheCollectionDisplayed(name), "Name of the collection is different");
    }

    @Test(description = "Giving new collection the name that exceeds character limit of 20")
    @TMS()
    public void checkingGivingCollectionLongName() {
        OnboardingComponent onboarding = new OnboardingComponent().open();
        onboarding.gotItButtonClick();
        HomeScreen homeScreen = new HomeScreen().open();
        YourSpaceScreen yourSpaceScreen = homeScreen.clickOnYourSpace().open();
        CreateNewCollectionComponent component = yourSpaceScreen.clickPlusIcon().open();
        String name = RandomStringUtils.random(21, true, true);
        component
                .typeCollectionName(name)
                .clickCreateButton();
        Assert.assertTrue(yourSpaceScreen.isCollectionNameExceed(), "No warning about collection name");
    }
}
