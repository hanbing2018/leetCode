package test;

/**
 * @author hanbing
 * @create 2020-01-14 16:27
 */
public class DefaultInterfaceImpl implements DefaultInterface1, DefaultInterface2 {

    @Override
    public void method() {
        //重写method函数，也可以使用  接口名.supper.method()的方式 使用已经定义的默认方法
//        DefaultInterface1.super.method();
    }
}
