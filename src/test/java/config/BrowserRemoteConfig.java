package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/remote.properties"
})
public interface BrowserRemoteConfig extends Config {

    @Key("browser.name")
    String getBrowserName();

    @Key("browser.version")
    String getBrowserVersion();

    @Key("remote.driver")
    String getRemoteDriver();

}