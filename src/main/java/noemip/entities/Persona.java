package noemip.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name= "persone")
public class Persona {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String nome;

    @Column
    private String cognome;

    @Column
    private String email;

    @Column
    private LocalDate dataDiNascita;

    @Column
    @Enumerated(EnumType.STRING)
    private TipoSesso sesso;


    //one-to-many
    //persona-->one
    //partecipazione-->many
    //aggiungere lista partecipazioni
    @OneToMany(mappedBy = "persona" )
    private List<Partecipazione> listaPartecipazioni;

    //COSTRUTTORI
    public Persona() {
    }

    public Persona(String nome, String cognome, String email, LocalDate dataDiNascita, TipoSesso sesso) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
        this.sesso = sesso;
    }

    //GETTER E SETTER

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public TipoSesso getSesso() {
        return sesso;
    }

    public void setSesso(TipoSesso sesso) {
        this.sesso = sesso;
    }

    public List<Partecipazione> getListaPartecipazioni() {
        return listaPartecipazioni;
    }

    public void setListaPartecipazioni(List<Partecipazione> listaPartecipazioni) {
        this.listaPartecipazioni = listaPartecipazioni;
    }

    //METODI

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                ", sesso=" + sesso +
                ", listaPartecipazioni=" + listaPartecipazioni +
                '}';
    }
}
