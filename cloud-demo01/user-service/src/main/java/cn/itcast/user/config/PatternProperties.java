package cn.itcast.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "logging.pattern")
@Component
public class PatternProperties {
    private String dateformat;
    private String envShareValue;
}
