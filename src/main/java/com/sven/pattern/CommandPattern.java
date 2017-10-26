package com.sven.pattern;

/**
 * @note 命令模式 把一个请求或者操作封装到一个对象中
 * @note （1）命令模式使新的命令很容易地被加入到系统里。（2）允许接收请求的一方决定是否要否决请求。
 * @note （3）能较容易地设计一个命令队列。（4）可以容易地实现对请求的撤销和恢复。
 * @note （5）在需要的情况下，可以较容易地将命令记入日志。 　　
 * @note 应用场景:对请求排队或者记录请求日志，可以提供命令的撤销和恢复功能
 * @author sven.zhang
 * @since 2017/10/25
 */
public class CommandPattern {

    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command = new StopCommand(receiver);
        Invoker invoker = new Invoker(command);
        invoker.next();
    }
}

interface Command {

    void excute();
}

class StopCommand implements Command {

    private Receiver receiver;

    public StopCommand(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public void excute() {
        receiver.stop();
    }
}

class Receiver {

    public void stop() {
        System.out.println("暂停");
    }
}

class Invoker {

    private Command command;

    public Invoker(Command command){
        this.command = command;
    }

    public void next() {
        command.excute();
    }
}
