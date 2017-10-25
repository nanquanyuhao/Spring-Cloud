package net.nanquanyuhao.cloud;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

/**
 * 通过获取某控制器的属性值改变健康状态
 * Created by nanquanyuhao on 2017/10/22.
 */
@Component
public class MyHealthIndicator implements HealthIndicator {

    public Health health() {
        if (PoliceController.canVisitDb){
            return new Health.Builder(Status.UP).build();
        } else {
            return new Health.Builder(Status.DOWN).build();
        }
    }
}
