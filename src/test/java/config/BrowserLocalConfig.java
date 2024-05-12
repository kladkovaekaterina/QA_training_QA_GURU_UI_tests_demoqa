package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/local.properties"
})
public interface BrowserLocalConfig extends Config {

    @Key("browser.name")
    String getBrowserName();

    @Key("browser.version")
    String getBrowserVersion();

}