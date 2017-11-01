package PageFactory;

/**
 * Created by Hashantha on 4/6/2017.
 */
import net.continuumsecurity.proxy.ScanningProxy;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;



public class Browser_SetUp {
    public ScanningProxy zapScanner;
    int currentScanID;
    public  static String[] policyNames = {};
    public static String MEDIUM = "MEDIUM";
    public static String HIGH = "HIGH";

    public WebDriver driver;
    public String site = "https://www.flip.net/";



    public void setUp() throws Exception {

        Proxy proxy = new Proxy();
        proxy.setHttpProxy("localhost:8888");
        proxy.setFtpProxy("localhost:8888");
        proxy.setSslProxy("localhost:8888");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, proxy);
        driver = new FirefoxDriver(capabilities);
        this.setDriver(driver);
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }


    public void scanWithZap() {
        zapScanner.setEnablePassiveScan(false);
        System.out.println("Scanning...");
        zapScanner.scan(site);
        currentScanID = zapScanner.getLastScannerScanId();
        int complete = 0;
        while (complete < 100) {
            complete = zapScanner.getScanProgress(currentScanID);
            System.out.println("Scan is " + complete + "% complete.");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Scanning done.");
    }

    public String enableZapPolicy(String policyName) {
        String scannerIds = null;
        switch (policyName.toLowerCase()) {
            case "SQL":
                scannerIds = "40018";
                break;
            default : throw new RuntimeException("No policy found for: "+policyName);
        }
        if (scannerIds == null) throw new RuntimeException("No matching policy found for: " + policyName);
        zapScanner.setEnableScanners(scannerIds, true);
        return scannerIds;

    }

    public void setAlertAndAttackStrength() {
        for (String policyName : policyNames) {
            String ids = enableZapPolicy(policyName);
            for (String id : ids.split(",")) {
                zapScanner.setScannerAlertThreshold(id,MEDIUM);
                zapScanner.setScannerAttackStrength(id,HIGH);
            }
        }
    }


    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public String getSite(){
        return site;
    }


    public void setSite(String site) {
        this.site =site;
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void sleep()  {
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.getMessage();
        }
    }


}



