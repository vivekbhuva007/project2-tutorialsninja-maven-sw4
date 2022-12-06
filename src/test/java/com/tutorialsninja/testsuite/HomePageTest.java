package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.ComponentsPage;
import com.tutorialsninja.pages.DesktopPage;
import com.tutorialsninja.pages.LaptopAndNoteBookPageTest;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    ComponentsPage componentsPage = new ComponentsPage();
    DesktopPage desktopPage = new DesktopPage();
    LaptopAndNoteBookPageTest laptopAndNoteBookPageTest = new LaptopAndNoteBookPageTest();


@Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
    desktopPage.userMouseHoverOnDesktopPage();
    String expectedText = "Desktops";
    desktopPage.selectMenu("Show All Desktops");
    Assert.assertEquals(desktopPage.userVerifyDesktopText(),expectedText,"Not Nevigate to DesktopPage");

}
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
    laptopAndNoteBookPageTest.userShouldMouseHoverOnLaptopAndBookPageTest();
        laptopAndNoteBookPageTest.selectMenu("Show All Laptops & Notebooks");
        String expectedMessage = "Laptops & Notebooks";
    Assert.assertEquals(laptopAndNoteBookPageTest.verifyNotebookAndLaptop(),expectedMessage,"no message displayed");


    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
    componentsPage.userMouseHoverOnComponent();
    componentsPage.selectMenu("Show All Components");
    String  expectedMessage = "Components";
    Assert.assertEquals(componentsPage.userVerifyComponentText(),expectedMessage,"No Element Found");



    }
    }

