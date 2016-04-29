package beans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ArrayListWorker {
    
    @PersistenceContext
    private EntityManager em;

    public void register(ArrayListEntity ue) {
        em.persist(ue);
    }

    public List<ArrayListEntity> getData() {
        return em.createQuery("SELECT r FROM ArrayListEntity r").getResultList();
    }
}