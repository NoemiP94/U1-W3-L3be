package noemip.entities;

import javax.persistence.*;

@Entity
@Table (name= "attendance")
public class Partecipazione {
    @Id
    @GeneratedValue
    private long id;

    //one-to-many -> persona one, partecipazione -> many
    //aggiungere persona da classe Persona
    @ManyToOne
    @JoinColumn(name= "persona_id", nullable = false)
    private Persona persona;

    //one-to-many
    //partecipazione--> many
    //aggiungere evento da classe Evento
    @ManyToOne
    @JoinColumn(name= "event_id")
    private Evento event;

    @Column
    @Enumerated(EnumType.STRING)
    private TipoStato stato;

    //COSTRUTTORI
    public Partecipazione() {
    }

    public Partecipazione(Persona persona, Evento event, TipoStato stato) {
        this.persona = persona;
        this.event = event;
        this.stato = stato;
    }

    //GETTER E SETTER

    public long getId() {
        return id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Evento getEvent() {
        return event;
    }

    public void setEvent(Evento event) {
        this.event = event;
    }

    public TipoStato getStato() {
        return stato;
    }

    public void setStato(TipoStato stato) {
        this.stato = stato;
    }

    //METODI


    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", persona=" + persona +
                ", event=" + event +
                ", stato=" + stato +
                '}';
    }
}
