package org.example.valbyunitedbackendv1.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Articles {
    @Id
    private int id;
    private String header;
    private String beskrivelse;
    private String billede;

    public Articles(int id, String header, String beskrivelse, String billede) {
        this.id = id;
        this.header = header;
        this.beskrivelse = beskrivelse;
        this.billede = billede;
    }

    public Articles() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getHeader() {
        return header;
    }
    public void setHeader(String header){
        this.header = header;
    }
    public String getBeskrivelse() {
        return beskrivelse;
    }
    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }
    public String getBillede() {
        return billede;
    }
    public void setBillede(String billede) {
        this.billede = billede;
    }
}
