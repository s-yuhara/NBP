package beans;

import java.io.Serializable;
import java.util.Date;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;


public class Intercepter implements Serializable{

    @Inject
    transient Logger logger;
    
    @Inject
    LoggingHandler lh;
    
    @AroundConstruct
    public void ConstructorLog(InvocationContext ic) throws Exception{
        Date now = new Date();
        logger.fine(
        new StringBuilder()
                .append(lh.getConstructorName(ic))
                .append("-->Constructor process start")
                .append(":[Parameter]-->")
                .append(lh.getParamList(ic))
                .append(now)
                .toString()
        );
        try{
            ic.proceed();
        }finally{
            logger.fine(
            new StringBuilder()
                    .append(lh.getConstructorName(ic))
                    .append("-->Exit")
                    .append(now)
                    .toString()
            );
        }
    }

@AroundInvoke
public Object MethodLog(InvocationContext ic) throws Exception{
        Date now = new Date();
    logger.fine(
    new StringBuilder()
    .append(lh.getClassName(ic))
    .append(".")
    .append(lh.getMethodName(ic))
    .append("-->Process Start")
    .append(":[parameter]")
    .append(now)
    .append(lh.getParamList(ic))
    .toString()
);
Object result = null;
try{
    result = ic.proceed();
    return result;
}finally{
    logger.fine(
    new StringBuilder()
        .append(lh.getClassName(ic))
        .append(".")
        .append(lh.getMethodName(ic))
        .append("-->Exit")
        .append("[result]")
        .append(result)
        .toString()
    );
}
}
}