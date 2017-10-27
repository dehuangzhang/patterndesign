package com.sven.pattern;

/**
 * @author sven.zhang
 * @since 2017/10/27
 * @状态模式 允许对象在内部状态改变时改变它的行为，对象看起来好像修改了它的类
 * @特点 1.状态模式将与特定状态相关的行为局部化，并且将不同状态的行为分割开来。 　　　　 2. 所有状态相关的代码都存在于某个对应的状态中，所以通过定义新的子类很容易地增加新的状态和转换。 　　　　
 * 3.状态模式通过把各种状态转移逻辑分不到State的子类之间，来减少相互间的依赖。
 * @缺点 导致设计中类的数目大量增加
 * @适用场景： 一个对象的行为取决于它的状态，一个操作中含有庞大的分支结构，并且这些分支决定于对象的状态
 */
public class StatePattern {

    public static void main(String[] args) {
        Context context = new Context();
        context.work();
    }
}

class Context {

    private State state = new StartState();

    public void work() {
        while (state != null) {
            state.handle(this);
        }
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}

interface State {

    void handle(Context context);
}

class StartState implements State {

    @Override
    public void handle(Context context) {
        context.setState(new ProcessState());
        System.out.println("start");
    }
}

class ProcessState implements State {

    @Override
    public void handle(Context context) {
        context.setState(new EndState());
        System.out.println("process");
    }
}

class EndState implements State {

    @Override
    public void handle(Context context) {
        context.setState(null);
        System.out.println("end");
    }
}
