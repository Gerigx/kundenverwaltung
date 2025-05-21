package de.hsos.swa.Entity;

import jakarta.persistence.Embeddable;

//@Embeddable
public class Adresse {

    private String plz;
    private String ort;
    private String strasse;
    private String hausnummer;
    public Adresse() {
    }
    public Adresse(String plz, String ort, String strasse, String hausnummer) {
        this.plz = plz;
        this.ort = ort;
        this.strasse = strasse;
        this.hausnummer = hausnummer;
    }
    public String getPlz() {
        return plz;
    }
    public void setPlz(String plz) {
        this.plz = plz;
    }
    public String getOrt() {
        return ort;
    }
    public void setOrt(String ort) {
        this.ort = ort;
    }
    public String getStrasse() {
        return strasse;
    }
    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }
    public String getHausnummer() {
        return hausnummer;
    }
    public void setHausnummer(String hausnummer) {
        this.hausnummer = hausnummer;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((plz == null) ? 0 : plz.hashCode());
        result = prime * result + ((ort == null) ? 0 : ort.hashCode());
        result = prime * result + ((strasse == null) ? 0 : strasse.hashCode());
        result = prime * result + ((hausnummer == null) ? 0 : hausnummer.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Adresse other = (Adresse) obj;
        if (plz == null) {
            if (other.plz != null)
                return false;
        } else if (!plz.equals(other.plz))
            return false;
        if (ort == null) {
            if (other.ort != null)
                return false;
        } else if (!ort.equals(other.ort))
            return false;
        if (strasse == null) {
            if (other.strasse != null)
                return false;
        } else if (!strasse.equals(other.strasse))
            return false;
        if (hausnummer == null) {
            if (other.hausnummer != null)
                return false;
        } else if (!hausnummer.equals(other.hausnummer))
            return false;
        return true;
    }

    // todo: schöner machen
    @Override
    public String toString() {
        return "Adresse [plz=" + plz + ", ort=" + ort + ", strasse=" + strasse + ", hausnummer=" + hausnummer + "]";
    }

    

}
