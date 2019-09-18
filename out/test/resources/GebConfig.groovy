

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

//Default browser to run on local machine
environments {
    chrome {
        WebDriverManager.chromedriver().setup()
        def options = new ChromeOptions()
        options.setAcceptInsecureCerts(true)
        driver = { new ChromeDriver(options) }
    }

}

