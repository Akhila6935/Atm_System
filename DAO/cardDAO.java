package AtmSystem.DAO;

import AtmSystem.Entity.card;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class cardDAO {

    private SessionFactory sessionFactory;

    public cardDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	// Create or Update card
    @SuppressWarnings("deprecation")
	public void saveOrUpdate(card cardEntity) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(cardEntity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
            	transaction.rollback();
            }
            throw e;
        }
    }

    // Get card by card ID
    public card getCard(int cardId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(card.class, cardId);
        }
    }

    // Get all cards
    public List<card> getAllCards() {
        try (Session session = sessionFactory.openSession()) {
            Query<card> query = session.createQuery("FROM card", card.class);
            return query.list();
        }
    }

    // Delete card
    @SuppressWarnings("deprecation")
	public void deleteCById(int Id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            card cardEntity = session.get(card.class, Id);
            if (cardEntity != null) {
                session.delete(cardEntity);
            }
            
        } catch (Exception e) {
            if (transaction != null) {
            	transaction.rollback();
            }
             throw e;
        }
    }

	public card getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}

