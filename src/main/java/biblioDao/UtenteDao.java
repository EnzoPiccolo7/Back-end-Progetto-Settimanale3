package biblioDao;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import biblio.Libro;
import biblio.Prestito;
import biblio.Utenti;
import jpautilPACK.JpaUtil;

public class UtenteDao {

	private static final Logger logger = LoggerFactory.getLogger(UtenteDao.class);

	public void save(Utenti object) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			EntityTransaction transaction = em.getTransaction();
			transaction.begin();

			em.persist(object);

			transaction.commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();

			logger.error("Error saving object: " + object.getClass().getSimpleName(), ex);
			throw ex;

		} finally {
			em.close();
		}


	}
	public void delete(Utenti object) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            em.remove(em.contains(object) ? object : em.merge(object));

            transaction.commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            logger.error("Error deleting object: " + object.getClass().getSimpleName(), ex);
            throw ex;

        } finally {
            em.close();
        }

    }
	
//	public Set<Prestito> checkPrestitibyUser(String NumT) {
//        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
//        try {
//
//           
//            User lol = em.find(User.class, NumT);
//            Set<Prestito> setPrestiti = lol.getPrestiti();
//            for (Prestito prestito : setPrestiti) {
//            	System.out.println(prestito);
//            	System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
//			
//            }
//           return setPrestiti;
//            
//            
//        } catch (Exception ex) {
//            em.getTransaction().rollback();
//            logger.error("Error deleting object: " + NumT.getClass().getSimpleName(), ex);
//            throw ex;
//
//        } finally {
//            em.close();
//        }
//
//    }
//	
	
	}


