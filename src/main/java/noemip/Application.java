package noemip;

import noemip.dao.EventoDAO;
import noemip.dao.LocationDAO;
import noemip.dao.PartecipazioneDAO;
import noemip.dao.PersonaDAO;
import noemip.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Application {
private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();

        EventoDAO evd = new EventoDAO(em);

        Evento compleanno = new Evento("Compleanno", LocalDate.of(2023,8,1), "Compleanno a tema cinema", TipoEvento.PRIVATO, 25 );
        Evento matrimonio = new Evento("Matrimonio", LocalDate.of(2023,10,15), "Matrimonio a tema fantasy", TipoEvento.PRIVATO, 180 );
        Evento sagra = new Evento("Sagra", LocalDate.of(2023,7,23), "Sagra delle patatine fritte", TipoEvento.PUBBLICO, 1000 );
        Evento concerto = new Evento("Concerto di Natale", LocalDate.of(2023,12,25), "Concerto di Natale con Michael Bublè", TipoEvento.PUBBLICO, 50000);

        //evd.save(compleanno);
        //evd.save(matrimonio);
        //evd.save(sagra);
        //evd.save(concerto);

        long id = 3;
        Evento eventoDB = evd.getById(id);
        if(eventoDB != null){
            System.out.println(eventoDB);
        }else{
            System.out.println("L'evento " + id + " non è stato trovato!");
        }

        //evd.delete(2);

        //---------------------------------------------------------------------------------------------
        System.out.println("-------------------------------------------------------------");

        PersonaDAO pDao = new PersonaDAO(em);
        PartecipazioneDAO parDAO = new PartecipazioneDAO(em);
        LocationDAO locDAO = new LocationDAO(em);

        Persona persona1 = new Persona("Michael", "Bublè","michael75@gmail.com", LocalDate.of(1975,9,9), TipoSesso.M);
        //pDao.save(persona1);


        Location location1 = new Location("Madison Square Garden", "New York");
        //locDAO.save(location1);

        Evento concertoDB = evd.getById(7);

        if(concertoDB != null){
            long idP = 5;
            Persona personaDB = pDao.getById(idP);
            if(personaDB != null){
                System.out.println(personaDB);
                Partecipazione partec1 = new Partecipazione(personaDB, concertoDB, TipoStato.CONFERMATA );
                System.out.println(partec1);
                parDAO.save(partec1);
        }else{
                System.out.println("La persona con id " + id + " non è stata trovato!");
        }
        }else{
            System.out.println("L'evento non è stato trovato");
        }






        em.close();
        emf.close();

    }
}
