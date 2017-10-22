package net.nanquanyuhao.cloud;

import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.ArrayList;
import java.util.List;

public class TestMyRule {

	public static void main(String[] args) {
		BaseLoadBalancer lb = new BaseLoadBalancer();
		MyRule rule = new MyRule();
		rule.setLoadBalancer(lb);
		lb.setRule(rule);
		
		List<Server> servers = new ArrayList<Server>();
		servers.add(new Server("localhost", 8080));
		servers.add(new Server("localhost", 8081));
		lb.addServers(servers);
		for(int i = 0; i < 10; i++) {
			Server s = lb.chooseServer(null);
			System.out.println(s);
		}
	}

}
