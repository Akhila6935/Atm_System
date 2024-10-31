package AtmSystem.Service;

import AtmSystem.DAO.CardDAO;
import AtmSystem.Entity.Card;
import org.hibernate.SessionFactory;

import java.util.List;

public class CardService {
    private CardDAO cardDAO;

    public CardService(SessionFactory sessionFactory) {
        this.cardDAO = new CardDAO(sessionFactory);
    }

    // Create a new card
    public void createCard(Card card) {
        cardDAO.createCard(card);
    }

    // Get card by ID
    public Card getCardById(int cardId) {
        return cardDAO.getCardById(cardId);
    }

    // Update existing card
    public void updateCard(Card card) {
        cardDAO.updateCard(card);
    }

    // Delete card by ID
    public void deleteCard(int cardId) {
        cardDAO.deleteCard(cardId);
    }

    // Get all cards
    public List<Card> getAllCards() {
        return cardDAO.getAllCards();
    }

    // Close resources
    public void close() {
        cardDAO.close();
    }
}
