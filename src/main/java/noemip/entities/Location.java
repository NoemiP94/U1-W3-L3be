package noemip.entities;

import javax.persistence.*;

@Entity
@Table (name= "location")
public class Location {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String nome;

    @Column
    private String citta;

    //COSTRUTTORI

    public Location() {
    }
    public Location(String nome, String citta) {
        this.nome = nome;
        this.citta = citta;
    }

    //GETTER E SETTER

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    //METODI

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", citta='" + citta + '\'' +
                '}';
    }
}
