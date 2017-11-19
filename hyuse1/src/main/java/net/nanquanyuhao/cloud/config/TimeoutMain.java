package net.nanquanyuhao.cloud.config;

import com.netflix.config.ConfigurationManager;

/**
 * Created by nanquanyuhao on 2017/10/29.
 */
public class TimeoutMain {

    public static void main(String[] args){
        TimeoutCommand c = new TimeoutCommand();
        String result = c.execute();
        System.out.println(result);
    }
}
