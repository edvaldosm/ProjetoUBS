package ubs.com.br.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ConfigurationProperties(prefix = "spring.datasource")
public class DbConfigParam {

    private String username;
    private String password;
    private String url;
    private String driver_class_name;
}
