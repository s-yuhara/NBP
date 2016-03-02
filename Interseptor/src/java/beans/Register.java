package beans;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.interceptor.Interceptors;

@Interceptors(Intercepter.class)
@SessionScoped
public class Register implements Serializable{

    private final Map<Integer,String> user;
    public Register(){
        user = new LinkedHashMap<>();
        
    }
    public String add(Integer id,String name){
        return user.put(id,name);
    }
}
