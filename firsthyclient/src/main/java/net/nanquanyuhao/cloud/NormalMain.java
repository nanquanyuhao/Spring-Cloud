package net.nanquanyuhao.cloud;

/**
 * Created by nanquanyuhao on 2017/10/29.
 */
public class NormalMain {

    public static void main(String[] args){
        HelloCommand command = new HelloCommand();
        String result = command.execute();
        System.out.println(result);
    }
}
