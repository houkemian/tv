package org.hkm.tv.anchor;

import org.hkm.config.AppProperties;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication(scanBasePackages = {"org.hkm"})
@EnableConfigurationProperties({AppProperties.class})
public class AnchorStarter {

    public static void main(String[] args) {
        run(AnchorStarter.class, args);
    }

}
