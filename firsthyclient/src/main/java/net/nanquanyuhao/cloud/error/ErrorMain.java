package net.nanquanyuhao.cloud.error;

import net.nanquanyuhao.cloud.HelloCommand;

/**
 * Created by nanquanyuhao on 2017/10/29.
 */
public class ErrorMain {

    public static void main(String[] args){
        ErrorCommand command = new ErrorCommand();
        String result = command.execute();
        System.out.println(result);
    }
}
