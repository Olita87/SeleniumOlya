package com.cyberteck.tests.Day1_Selenium_Intro;

import com.utility.util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GasMileageCalculatorTest {

    /*   Task #: Gas Mileage Calculator Automation Test

   1. Add a new class GasMileageCalculatorTest
   2. Go to https://www.calculator.net
   3. Search for “gas mileage” using search box
   4. Click on the “Gas Mileage Calculator” link

   5. On Next page verify:
       a. Title equals: “Gas Mileage Calculator”
       b. “Gas Mileage Calculator” label is displayed

   6. Locate, clear and type “7925” into “Current odometer” field
   7. Locate, clear and type “7550” into “Previous odometer” field
   8. Locate, clear and type “16” into “Gas added” field
   9. Locate, clear and type “3.55” into “Gas price” field
   10. Click on Calculate button
   11. Verify mpg value is as expected:
       Expected value: “23.44 mpg”


     */
    @Test
    public void tc01() {
        util.getDriver().get("https://www.calculator.net");
        WebElement searchBox = util.getDriver().findElement(By.xpath("//input[@id='calcSearchTerm']"));
        searchBox.sendKeys("Gas Mileage");
        WebElement gasMileageCalculator = util.getDriver().findElement(By.xpath("//a[@href='/gas-mileage-calculator.html']"));
        gasMileageCalculator.click();

        String expectedTitle = "Gas Mileage Calculator";
        String actualTitle = util.getDriver().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        WebElement label = util.getDriver().findElement(By.xpath("//h1[1]"));
        String expectedLabel = "Gas Mileage Calculator";
        String actualLabel = label.getText();
        Assert.assertEquals(expectedLabel, actualLabel);

        WebElement clearBtn = util.getDriver().findElement(By.xpath("(//img[@class='clearbtn'])[1]"));
        clearBtn.click();
        WebElement currentOdmtr = util.getDriver().findElement(By.xpath("//input[@id='uscodreading']"));
        currentOdmtr.sendKeys("7925");
        WebElement previousOdmtr = util.getDriver().findElement(By.xpath("//input[@id='uspodreading']"));
        previousOdmtr.sendKeys("7550");
        WebElement gasField = util.getDriver().findElement(By.xpath("//input[@id='usgasputin']"));
        gasField.sendKeys("16");
        WebElement gasPrice = util.getDriver().findElement(By.xpath("//input[@id='usgasprice']"));
        gasPrice.sendKeys("3.55");
        WebElement calculateBtn = util.getDriver().findElement(By.xpath("(//input[@value='Calculate'])[1]"));
        calculateBtn.click();

        WebElement mpg = util.getDriver().findElement(By.xpath("//p[@class='verybigtext']//b"));
        String expectedText = "23.44 mpg";
        String actualText = mpg.getText();
        Assert.assertEquals(expectedText,actualText);

util.closeDriver();
    }
}

