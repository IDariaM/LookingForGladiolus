package service;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");

    @Attachment
    public static byte[] getScreenshot(WebDriver driver, String packageName){
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            String fileName = "screen_" + simpleDateFormat.format(new Date());
            FileUtils.copyFile(screenshot,new File("src/main/resources/" + packageName +"/" + fileName));
            return Files.readAllBytes(Paths.get("src/main/resources/" + packageName +"/",fileName));
        }catch (Exception e){
            e.printStackTrace();
        }
        return new byte[0];
    }

    @Attachment
    public static byte[] getScreenshot (WebDriver driver, WebElement element, String packageName){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            String fileName = "screen_" + simpleDateFormat.format(new Date());
            FileUtils.copyFile(screenshot,new File("src/main/resources/" + packageName +"/" + fileName));
            return Files.readAllBytes(Paths.get("src/main/resources/" + packageName +"/",fileName));
        }catch (Exception e){
            e.printStackTrace();
        }
        return new byte[0];
    }

}
