package com.github.code.aqiu202.config;

import com.github.code.aqiu202.captcha.CaptchaProducer;
import com.github.code.aqiu202.captcha.impl.DefaultCaptcha;
import com.github.code.aqiu202.props.CaptchaProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class CaptchaAutoConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "captcha")
    public CaptchaProperties captchaProperties() {
        return new CaptchaProperties();
    }

    @Bean
    @ConditionalOnMissingBean
    public CaptchaProducer producer(CaptchaProperties captchaProperties) {
        return new DefaultCaptcha(captchaProperties);
    }
}
