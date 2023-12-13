package noemip.dao;

import noemip.entities.Evento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EventoDAO {

    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    //metodo save
    public void save(Evento evento){
        EntityTransaction transaction = em.getTransaction(); //transazione
        transaction.begin(); //inizio transazione
        em.persist(evento); //aggiungo evento al Persistence Context
        transaction.commit(); //salvataggio in una nuova riga
        System.out.println("L'evento " + evento.getTitolo() + " aggiunto correttamente!");
    }

    //metodo getById
    public Evento getById(long id){
        return em.find(Evento.class, id);
    }

    //metodo delete
    public void delete(long id){
        Evento foundId  = this.getById(id);
        if(foundId != null){
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(foundId);
            transaction.commit();
            System.out.println("L'evento " + foundId.getTitolo() + " eliminato correttamente!");
        }else {
            System.out.println("L'evento " + id + " non è stato trovato!");
        }
    }
}
