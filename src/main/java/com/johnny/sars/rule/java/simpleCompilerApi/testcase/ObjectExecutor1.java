package com.johnny.sars.rule.java.simpleCompilerApi.testcase;

/**
 * Description:
 * <p>
 * Author: yang_tao
 * Date  : 2017-08-11 10:42
 */
public class ObjectExecutor1<M extends Object> implements Executor {

    private M object;

    public ObjectExecutor1(M mObject) {
        object = mObject;
    }

    @Override
    public void execute() {
        execute(object);
    }

    private void execute(M object) {
        System.out.println(object);
    }
}
