package net.nanquanyuhao.cloud.contract;

/**
 * Created by nanquanyuhao on 2017/10/27.
 */
public interface ContractClient {

    @MyUrl(url = "/hello", method = "GET")
    String hello();
}
