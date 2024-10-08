package com.cl.im.configs;

import com.cl.im.LoadBanlanceRule.MetaDataLbRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RuleConfig {
    @Bean
    public IRule metadataLbRule(){
        return new MetaDataLbRule();
    }
}
