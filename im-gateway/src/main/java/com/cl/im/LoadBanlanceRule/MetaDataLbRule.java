package com.cl.im.LoadBanlanceRule;

import com.alibaba.cloud.nacos.ribbon.NacosServer;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.Server;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 这个负载均衡规则一是为了测试自定义负载均衡规则，
 * 二是为了解决服务乱窜问题，当然我一个人开发碰不到这种问题
 */
public class MetaDataLbRule extends RoundRobinRule {
    private final String META_VERSION = "version";
    //从yaml配置中获取需要的版本信息
    @Value("${lb.version}")
    private String version;
    /**
     * Ribbon八股：IRule为Rbbion的
     *
     * 这里继承了轮询负载均衡规则
     */
    @Override
    public Server choose(ILoadBalancer lb, Object key){
        //参考简单轮询源码，对负载均衡器进行判空
        if (lb == null){
            return null;
        }
        List<Server> res = null;//记录结果
        //获取可达实例列表
        List<Server> upList = lb.getReachableServers();
        //如果需要根据version挑选对应实例
        if (StringUtils.isNotEmpty(version)){
            //过滤version为对应版本的可达实例
            res = upList.stream()
                .filter(
                    server -> version.equals(
                        ((NacosServer) server).getMetadata().get(META_VERSION)
                    )
                ).collect(Collectors.toList());
        }
        if (res!=null && res.size()>0){
            return getServer(res);
        }
        //如果不存在对应version的实例,则不根据version选择实例，调用父类方法
        return super.choose(lb,key);
    }

    /**
     * 随机选择
     * @param list
     * @return
     */
    private Server getServer(List<Server> list) {
        int randIdx = new Random().nextInt(list.size());
        return list.get(randIdx);
    }
}
