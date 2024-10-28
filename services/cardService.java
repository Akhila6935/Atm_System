package AtmSystem.services;

import AtmSystem.DAO.cardDAO;
import AtmSystem.Entity.card;
import java.util.List;

public class cardService {

	private cardDAO cardDAO;

    public cardService(cardDAO cardDAO) {
        this.cardDAO = cardDAO;
    }

    public void saveOrUpdateCard(card cardEntity) {
        cardDAO.saveOrUpdate(cardEntity);
    }

    public card getcardById(int id) {
        return cardDAO.getById(id);
    }

    public List<card> getAllCards() {
        return cardDAO.getAllCards();
    }

    public void deleteCardById(int id) {
        cardDAO.deleteCById(id);
    }
}