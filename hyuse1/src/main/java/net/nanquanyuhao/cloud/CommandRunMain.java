package net.nanquanyuhao.cloud;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import rx.Observable;
import rx.Observer;

/**
 * 1.首次实现未成功：即 c1.observe() 的调用并未运行run() 打印 “observe method”。实际猜测为异步调用，需要主线程稍微等待结果返回
 * Created by nanquanyuhao on 2017/10/29.
 */
public class CommandRunMain {

    public static void main(String[] args) throws  Exception{

        RunCommand c1 = new RunCommand("observe method");
        c1.observe();

        RunCommand c2= new RunCommand("toObservable method");
        // toObservable() 方法必须设置一个订阅才可使用，以下代码的匿名类就是如此
        Observable ob  = c2.toObservable();

        ob.subscribe(new Observer<String>() {
            public void onCompleted() {
                System.out.println("command completed");
            }

            public void onError(Throwable throwable) {

            }

            /**
             *
             * @param t run() 方法的返回结果
             */
            public void onNext(String t) {
                System.out.println("####" + t);
            }
        });

        Thread.sleep(1000);
    }

    static class RunCommand extends HystrixCommand<String> {

        String msg;

        public RunCommand(String msg){
            super(HystrixCommandGroupKey.Factory.asKey("TestGroup"));
            this.msg = msg;
        }

        @Override
        protected String run() throws Exception {
            System.out.println(msg);
            return "success";
        }
    }
}
