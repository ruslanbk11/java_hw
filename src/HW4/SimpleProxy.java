import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SimpleProxy implements InvocationHandler {
    private final Object delegate;

    public SimpleProxy(Object delegate) {
        this.delegate = delegate;
    }

    public static <T> T cache(T delegate){
        return (T) Proxy.newProxyInstance(
                ClassLoader.getSystemClassLoader(),
                delegate.getClass().getInterfaces(),
                new SimpleProxy(delegate)
        );
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        long l1 = System.currentTimeMillis();
        Object result = method.invoke(delegate, args);
        System.out.println(System.currentTimeMillis() - l1);
        return result;
    }
}
