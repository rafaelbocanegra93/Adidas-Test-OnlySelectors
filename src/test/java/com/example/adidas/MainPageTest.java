package com.example.adidas;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {
    MainPage mainPage = new MainPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        Configuration.browser = "chrome";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("https://www.adidas.co/");
    }

    @Test
    public void useWishlistBeforeLogin() {
        mainPage.elementTrends.click();
        if($("div[class='gl-modal__main-content']").shouldBe(visible).isDisplayed()){
            $("button[class$='close']").click();
        }

        $$("span[data-testid='wishlist-inactive']").filter(visible).first().click();
        //Modal login email and click continue
        $("input[id='login-register-auto-flow-input']").shouldBe(visible).sendKeys("rafaboca93@gmail.com");


        $("button[data-auto-id='login-auto-flow-form-button']").doubleClick();
        $("button[data-auto-id='login-auto-flow-form-button']").doubleClick();
        $("button[data-auto-id='login-auto-flow-form-button']").doubleClick();

        $("input[id='login-password']").shouldBe(visible).sendKeys("Rafa1207@");

        $("button[data-auto-id='login-form-login']").click();

    }
/*
    @Test
    public void toolsMenu() {
        mainPage.toolsMenu.click();

        $("div[data-test='main-submenu']").shouldBe(visible);
    }

    @Test
    public void navigationToAllTools() {
        mainPage.seeDeveloperToolsButton.click();
        mainPage.findYourToolsButton.click();

        $("#products-page").shouldBe(visible);

        assertEquals("All Developer Tools and Products by JetBrains", Selenide.title());
    }

 */
}
