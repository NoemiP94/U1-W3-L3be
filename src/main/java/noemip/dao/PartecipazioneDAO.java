package noemip.dao;

import noemip.entities.Evento;
import noemip.entities.Partecipazione;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PartecipazioneDAO {
    private final EntityManager em;

    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }

    //metodo save
    public void save(Partecipazione partecipazione){
        EntityTransaction transaction = em.getTransaction(); //transazione
        transaction.begin(); //inizio transazione
        em.persist(partecipazione); //aggiungo partecipazione al Persistence Context
        transaction.commit(); //salvataggio in una nuova riga
        System.out.println("Partecipazione con id " + partecipazione.getId() + " aggiunta correttamente!");
    }

    //metodo getById
    public Partecipazione getById(long id){
        return em.find(Partecipazione.class, id);
    }

    //metodo delete
    public void delete(long id){
        Partecipazione foundId  = this.getById(id);
        if(foundId != null){
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(foundId);
            transaction.commit();
            System.out.println("Partecipazione con id " + foundId.getId() + " eliminata correttamente!");
        }else {
            System.out.println("Partecipazione con id  " + id + " non trovata!");
        }
    }
}
