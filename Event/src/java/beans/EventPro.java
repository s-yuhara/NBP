package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

@SessionScoped
public class EventPro implements  Serializable{
    @Inject
    private Event<User> event;

    List<User> list = new ArrayList<>();
    
    
    public void add(Integer id, String name){
        User user = new User(id,name);
        list.add(user);
        event.fire(user);
    }
}
