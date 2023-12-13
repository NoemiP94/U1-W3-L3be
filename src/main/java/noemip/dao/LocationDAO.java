package noemip.dao;

import noemip.entities.Evento;
import noemip.entities.Location;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LocationDAO {
    private final EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    //metodo save
    public void save(Location location){
        EntityTransaction transaction = em.getTransaction(); //transazione
        transaction.begin(); //inizio transazione
        em.persist(location); //aggiungo location al Persistence Context
        transaction.commit(); //salvataggio in una nuova riga
        System.out.println("Location " + location.getNome() + " aggiunta correttamente!");
    }

    //metodo getById
    public Location getById(long id){
        return em.find(Location.class, id);
    }

    //metodo delete
    public void delete(long id){
        Location foundId  = this.getById(id);
        if(foundId != null){
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(foundId);
            transaction.commit();
            System.out.println("Location " + foundId.getNome() + " eliminata correttamente!");
        }else {
            System.out.println("Location " + id + " non è stata trovato!");
        }
    }
}
