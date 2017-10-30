package net.nanquanyuhao.cloud.cache;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixRequestCache;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategyDefault;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

/**
 * Created by nanquanyuhao on 2017/10/30.
 */
public class CacheMain {

    public static void main(String[] args) {

        // 表明这是一次请求，必须在同一次请求的过程中才可用
        HystrixRequestContext ctx = HystrixRequestContext.initializeContext();
        // 定义缓存 Key，供多个命令使用
        String key = "cache-key";
        CacheCommand c1 = new CacheCommand(key);
        CacheCommand c2 = new CacheCommand(key);
        CacheCommand c3 = new CacheCommand(key);
        c1.execute();
        c2.execute();
        c3.execute();

        System.out.println("命令c1，是否读取缓存：" + c1.isResponseFromCache());
        System.out.println("命令c2，是否读取缓存：" + c2.isResponseFromCache());
        System.out.println("命令c3，是否读取缓存：" + c3.isResponseFromCache());

        // 清空缓存，首先取到缓存组，再清除对应缓存。清空后的第一次请求无法再走缓存，之后又可走缓存。
        HystrixRequestCache cache = HystrixRequestCache.getInstance(HystrixCommandKey.Factory.asKey("MyCommandKey"),
                HystrixConcurrencyStrategyDefault.getInstance());
        cache.clear(key);
        CacheCommand c4 = new CacheCommand(key);
        c4.execute();
        System.out.println("命令c4，是否读取缓存：" + c4.isResponseFromCache());

        // 关闭Context
        ctx.shutdown();
    }

    static class CacheCommand extends HystrixCommand<String> {

        /**
         * 缓存Key
         */
        private String cacheKey;

        public CacheCommand(String cacheKey) {
            super(HystrixCommand.Setter.withGroupKey(
                    HystrixCommandGroupKey.Factory.asKey("TestGroupKey"))
                    .andCommandKey(
                            HystrixCommandKey.Factory.asKey("MyCommandKey")));
            this.cacheKey = cacheKey;
        }
        @Override
        protected String run() throws Exception {
            System.out.println("执行方法");
            return "";
        }

        /**
         * 此方法可不提供，未用到
         * @return
         */
        @Override
        protected String getFallback() {
            System.out.println("执行回退");
            return "";
        }
        @Override
        protected String getCacheKey() {
            return this.cacheKey;
        }

    }
}
