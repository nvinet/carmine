import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.chrome.ChromeDriver

driver = 'firefox'

environments {
    'chrome' {
        driver = 'chrome'
    }
}

