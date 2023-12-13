package noemip.dao;

import noemip.entities.Evento;
import noemip.entities.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersonaDAO {
    private final EntityManager em;

    public PersonaDAO(EntityManager em){this.em = em;}

    //metodo save
    public void save(Persona persona){
        EntityTransaction transaction = em.getTransaction(); //transazione
        transaction.begin(); //inizio transazione
        em.persist(persona); //aggiungo persona al Persistence Context
        transaction.commit(); //salvataggio in una nuova riga
        System.out.println("Persona " + persona.getNome() + " " + persona.getCognome() +  " aggiunta correttamente!");
    }

    //metodo getById
    public Persona getById(long id){
        return em.find(Persona.class, id);
    }

    //metodo delete
    public void delete(long id){
        Persona foundId  = this.getById(id);
        if(foundId != null){
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(foundId);
            transaction.commit();
            System.out.println("Persona " + foundId.getNome() + foundId.getCognome() +  " eliminata correttamente!");
        }else {
            System.out.println("La persona " + id + " non è stata trovata!");
        }
    }
}
