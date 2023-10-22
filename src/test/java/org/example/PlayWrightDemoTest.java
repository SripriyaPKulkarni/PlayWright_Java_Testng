package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class PlayWrightDemoTest {

    @Test
    public void testOnChrome() {

        final Playwright playwright = Playwright.create();
        final Browser browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setChannel("chrome"));
        final Page page = browser.newPage();
        page.navigate("https://www.google.com/");
        final String pageTitle = page.title();
        assertEquals(pageTitle, "Google");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot.png")));
        browser.close();
    }

}
