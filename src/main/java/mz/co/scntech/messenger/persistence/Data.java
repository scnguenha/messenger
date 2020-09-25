
package mz.co.scntech.messenger.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Sidónio Goenha on Sep 24, 2020
 *
 */

public abstract class Data {

	protected static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Messenger");
	protected static EntityManager entityManager = entityManagerFactory.createEntityManager();

	public static <T> T save(T object) {

		try {
			entityManager.getTransaction().begin();

			entityManager.persist(object);

			entityManager.getTransaction().commit();

			return object;

		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		return null;
	}

	public static <T> T update(T object) {

		try {
			entityManager.getTransaction().begin();

			entityManager.merge(object);

			entityManager.getTransaction().commit();

			return object;

		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}

		return null;
	}

	public static <T> T delete(T object) {

		try {
			entityManager.getTransaction().begin();

			entityManager.remove(object);

			entityManager.getTransaction().commit();

			return object;

		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}

		return null;

	}

	public static <T> T findById(Class<T> entityClass, Object id) {

		try {
			entityManager.getTransaction().begin();

			T object = entityManager.find(entityClass, id);

			entityManager.getTransaction().commit();

			return object;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	@SuppressWarnings("unchecked")
	public static <T> List<T> findAll(Class<T> entityClass) {

		try {

			entityManager.getTransaction().begin();

			List<T> object = entityManager.createNativeQuery("SELECT * FROM " + entityClass.getSimpleName()).getResultList();

			entityManager.getTransaction().commit();

			return object;

		} catch (Exception e) {
			e.printStackTrace();
			//entityManager.getTransaction().rollback();
		}

		return null;
	}

}
