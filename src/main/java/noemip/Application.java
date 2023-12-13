package noemip;

import noemip.dao.EventoDAO;
import noemip.entities.Evento;
import noemip.entities.TipoEvento;

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

        //evd.save(compleanno);
        //evd.save(matrimonio);
        //evd.save(sagra);

        long id = 3;
        Evento eventoDB = evd.getById(id);
        if(eventoDB != null){
            System.out.println(eventoDB);
        }else{
            System.out.println("L'evento " + id + " non è stato trovato!");
        }

        evd.delete(2);

        em.close();
        emf.close();

    }
}
