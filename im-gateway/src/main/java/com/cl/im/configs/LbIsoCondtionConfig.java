package com.cl.im.configs;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Configuration;

/**
 * 隔离开关
 */
@Configuration
@ConditionalOnProperty(value = "lb.enabled",havingValue = "true")//条件装配
@RibbonClients(defaultConfiguration = {RuleConfig.class})
public class LbIsoCondtionConfig {
}
