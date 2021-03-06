package beans;

import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@RequestScoped
public class Observer2 {
    @Inject
    transient private Logger logger;
    
    public void receive(@Observes User user) {
        logger.info(
        new StringBuilder()
        .append("Observer2-->")
        .append(user.toString())
        .toString());
    }
}
