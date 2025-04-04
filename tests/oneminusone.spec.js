// Generated by Selenium IDE
const { Builder, By, Key, until } = require('selenium-webdriver')
const assert = require('assert')
const chrome = require('selenium-webdriver/chrome');

describe('One minus one', function() {
  this.timeout(30000);
  let driver;
  let vars;

  beforeEach(async function() {
    const options = new chrome.Options()
      .addArguments('--headless') // Run without UI
      .addArguments('--no-sandbox') // Required for GitHub Actions
      .addArguments('--disable-dev-shm-usage'); // Prevent shared memory issues
    
    try {
      driver = await new Builder()
        .forBrowser('chrome')
        .setChromeOptions(options)
        .build();
      vars = {};
    } catch (error) {
      console.error("Failed to initialize WebDriver:", error);
      throw error;
    }
  });

  afterEach(async function() {
    if (driver) {  // Prevent "undefined" error
      await driver.quit();
    }
  });
  it('One minus one', async function() {
    await driver.get("http://localhost:8000/")
    await driver.manage().window().setRect(1552, 832)
    await driver.findElement(By.id("num1")).click()
    await driver.findElement(By.id("num1")).sendKeys("1")
    await driver.findElement(By.id("num2")).click()
    await driver.findElement(By.id("num2")).sendKeys("1")
    await driver.findElement(By.css("button:nth-child(2)")).click()
  })
  
})
