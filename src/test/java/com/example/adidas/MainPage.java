package com.example.adidas;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
 //   public SelenideElement seeDeveloperToolsButton = $x("//*[@data-test-marker='Developer Tools']");
    public SelenideElement elementTrends = $("a[data-pos='site_promotion|23'] div[class^='teaser-card-content']");

}