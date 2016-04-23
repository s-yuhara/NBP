package beans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserWorker01 {

    @PersistenceContext
            private EntityManager em;
    public void register(UserEntity01 entity) {
        em.persist(entity);
    }

    public List<UserEntity01> getData() {
        return em.createQuery("SELECT r from UserEntity01 r").getResultList();
    }

}
