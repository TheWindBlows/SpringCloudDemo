package com.yxf.ribbonRule;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

/**
 * @Description: 轮询5次Ribbon算法
 * @author yuanxiaofei
 * @date 2019年9月18日
 */
public class RoundFiveTimeRule extends AbstractLoadBalancerRule {

	// 调用次数
	private int num = 0;
	// 服务下标
	private int serverIndex = 0;
	
	public Server myChoose(ILoadBalancer lb, Object key) {
		// 如果未选择算法则返回空服务
        if (lb == null) {
            return null;
        }
        // 具体服务
        Server server = null;
        
        while (server == null) {
        	// 访问中断则返回空服务
            if (Thread.interrupted()) {
                return null;
            }
         // 所有已启动且可访问的服务
            List<Server> upList = lb.getReachableServers();
            
            int serverCount = upList.size();
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 */
                return null;
            }
            
            if (num < 5) {
            	server = upList.get(serverIndex);
            	num++;
            } else {
            	num = 0;
            	serverIndex++;
            	// 服务下标初始化
                if (serverIndex >= serverCount) {
                	serverIndex = 0;
                }
            	continue;
            }
            
            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
            	// 线程让行
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }
	
    public Server choose(ILoadBalancer lb, Object key) {
    	return myChoose(lb,key);
    	/** Ribbon 随机算法源码
    	// 如果未选择算法则返回空服务
        if (lb == null) {
            return null;
        }
        // 具体服务
        Server server = null;

        while (server == null) {
        	// 访问中断则返回空服务
            if (Thread.interrupted()) {
                return null;
            }
            // 所有已启动且可访问的服务
            List<Server> upList = lb.getReachableServers();
            // 所有服务
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                
                // No servers. End regardless of pass, because subsequent passes
                // only get more restrictive.
                
                return null;
            }

            int index = chooseRandomInt(serverCount);
            server = upList.get(index);

            if (server == null) {
                 // The only time this should happen is if the server list were
                 // somehow trimmed. This is a transient condition. Retry after
                 // yielding.
            	// 线程让行
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;
        **/
    }
    
    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

	@Override
	public Server choose(Object key) {
		return choose(getLoadBalancer(), key);
	}

	@Override
	public void initWithNiwsConfig(IClientConfig clientConfig) {
		// TODO Auto-generated method stub
		
	}
}
