package no.hvl.dat108.FestPaameldingApp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.web.bind.annotation.CookieValue;

@Entity
@Table(name = "deltager", schema = "deltager_new")
public class Deltager implements Comparable<Deltager> {

    @Id
    @Column(name = "mobil")
    @Pattern(regexp = "^\\d{8}$", message = "Phonenumber must be exactly 8 digits.")
    private String mobil;

    @Column(name = "fornavn")
    @Size(min = 2, max = 25, message = "Firstname must have minimun 2 letters.")
    @NotNull(message = "Firstname is mandatory.")
    private String fornavn;

    @Column(name = "etternavn")
    @Size(min = 2, max = 30, message = "Lastname must have minimum 2 letters.")
    @NotNull(message = "Lastname is mandatory")
    private String etternavn;

    @Column(name = "kjonn")
    @NotNull(message = "Gender must be either male or female.")
    private String kjonn;


    @Column(name = "salt")
    private String salt;

    @Column(name = "hash")
    private String hash;

    @Transient
    private String passord;

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Deltager() {}

    public Deltager(String mobil, String fornavn, String etternavn, String kjonn, String salt, String hash) {
        this.mobil = mobil;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.kjonn = kjonn;
        this.salt = salt;
        this.hash = hash;
        //this.passord = passord;
    }

    public String getMobil() {
        return mobil;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    public String getFornavn() {
        return fornavn;
    }
    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getKjonn() {
        return kjonn;
    }

    public void setKjonn(String kjonn) {
        this.kjonn = kjonn;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }


    public String getPassord() { return passord; }

    public void setPassord(String passord) {
        this.passord = passord;
     }


    @Override
    public int compareTo(Deltager other) {
        return this.fornavn.compareTo(other.fornavn);
    }
}
