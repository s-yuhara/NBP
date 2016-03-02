package beans;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import javax.enterprise.context.Dependent;
import javax.interceptor.InvocationContext;
import org.omg.CORBA.DynAnyPackage.Invalid;

@Dependent
public class LoggingHandler implements Serializable{

   public String getClassName(InvocationContext ic){
       Method method = ic .getMethod();
       
       Class decClass = method.getDeclaringClass();
       return decClass.getName();
   }

   
   public String getConstructorName(InvocationContext ic){
       Constructor con = ic.getConstructor();
       return con.getName();
   }

   public String getMethodName(InvocationContext ic ){
       Method method = ic.getMethod();
       return method.getName();
   }



public String getParamList(InvocationContext ic){
    Object[] params = ic.getParameters();
    return Arrays.toString(params);
    
    
}



}
