package com.atguigu.cloud.mygateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author yanghe
 * @create 2024-10-12-15:33
 * @description: TODO
 */
@Component
@Slf4j
public class MyGlobalFilter implements GlobalFilter, Ordered {

    private static final String BEGIN_VISIT_TIME = "begin_visit_time";//开始访问时间

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // exchange相当于上下文环境
        exchange.getAttributes().put(BEGIN_VISIT_TIME,System.currentTimeMillis());
        return chain.filter(exchange).then(Mono.fromRunnable(()->{
            Long beginVisitTime = exchange.getAttribute(BEGIN_VISIT_TIME);
            if (beginVisitTime != null) {
                log.info("访问主机："+exchange.getRequest().getURI().getHost());
                log.info("访问端口："+exchange.getRequest().getURI().getPort());
                log.info("访问url："+exchange.getRequest().getURI().getPath());
                log.info("耗时："+(System.currentTimeMillis()-beginVisitTime)+"ms");
                log.info("===================================================");
                System.out.println();
            }
        }));
    }
    @Override
    public int getOrder() {
        return 0;  // 数字越小优先级越高
    }
}
