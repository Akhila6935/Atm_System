package AtmSystem.DAO;

import AtmSystem.Entity.Card;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CardDAO {
    private SessionFactory sessionFactory;

    public CardDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Create Card
    @SuppressWarnings("deprecation")
	public void createCard(Card card) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(card);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.out.println("Error creating card: " + e.getMessage());
        }
    }

    // Read Card by ID
    public Card getCardById(int cardId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Card.class, cardId);
        } catch (Exception e) {
            System.out.println("Error retrieving card: " + e.getMessage());
            return null;
        }
    }

    // Update Card
    @SuppressWarnings("deprecation")
	public void updateCard(Card card) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(card);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.out.println("Error updating card: " + e.getMessage());
        }
    }

    // Delete Card by ID
    @SuppressWarnings("deprecation")
	public void deleteCard(int cardId) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Card card = session.get(Card.class, cardId);
            if (card != null) {
                session.delete(card);
                System.out.println("Card deleted successfully.");
            } else {
                System.out.println("Card not found with ID: " + cardId);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.out.println("Error deleting card: " + e.getMessage());
        }
    }

    // Get all Cards
    public List<Card> getAllCards() {
        try (Session session = sessionFactory.openSession()) {
            Query<Card> query = session.createQuery("FROM Card", Card.class);
            return query.list();
        } catch (Exception e) {
            System.out.println("Error retrieving cards: " + e.getMessage());
            return null;
        }
    }

    // Close SessionFactory resources when done
    public void close() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
