package com.coder520.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * Created by JackWangon[www.coder520.com] 2017/10/19.
 */
public class DataSourceAspect {

    public void before(JoinPoint point) throws NoSuchMethodException {
        Object target = point.getTarget();
        String method = point.getSignature().getName();
        Class classz = target.getClass();
        Class<?>[] parameterTypes = ((MethodSignature)point.getSignature()).getMethod().getParameterTypes();
        Method m = classz.getMethod(method,parameterTypes);
        if(m!=null&&m.isAnnotationPresent(DataSource.class)){
            DataSource dataSource = m.getAnnotation(DataSource.class);
            DynamicDataSourceHolder.setDataSource(dataSource.value());
        }

    }
}
