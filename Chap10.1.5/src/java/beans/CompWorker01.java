package beans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CompWorker01 {

    @PersistenceContext
            private EntityManager em;
    public void register(CompEntity01 ue) {
       em.persist(ue);
    }

    public List<CompEntity01> getData() {
        return em.createQuery("SELECT r FROM CompEntity01 r").getResultList();
    }

}
