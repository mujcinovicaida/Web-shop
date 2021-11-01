package com.informacije.webShop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class informacije {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private String naziv;
    private String kratakopis;
    private String slika;
    private int kolicina;
    private String cijena;

    public informacije() {
    }

    public informacije(long ID, String naziv, String kratakopis, String slika, int kolicina, String cijena) {
        this.ID = ID;
        this.naziv = naziv;
        this.kratakopis = kratakopis;
        this.slika = slika;
        this.kolicina = kolicina;
        this.cijena = cijena;
    }

    public long getID() {
        return ID;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getKratakopis() {
        return kratakopis;
    }

    public String getSlika() {
        return slika;
    }

    public int getKolicina() {
        return kolicina;
    }

    public String getCijena() {
        return cijena;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setKratakopis(String kratakopis) {
        this.kratakopis = kratakopis;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public void setCijena(String cijena) {
        this.cijena = cijena;
    }
}
