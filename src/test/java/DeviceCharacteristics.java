import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

//характеристики устройства
public class DeviceCharacteristics {
    public static DesiredCapabilities getAndroidCharacteristics() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 5X");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.APPLICATION_NAME, "com.miui.calculator");
        return capabilities;
    }
}
