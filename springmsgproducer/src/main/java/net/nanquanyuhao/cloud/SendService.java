package net.nanquanyuhao.cloud;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by nanquanyuhao on 2017/11/19.
 */
public interface SendService {

    @Output("myInput")
    SubscribableChannel sendOrder();
}
