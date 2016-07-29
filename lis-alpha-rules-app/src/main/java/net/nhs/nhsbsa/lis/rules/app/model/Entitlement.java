package net.nhs.nhsbsa.lis.rules.app.model;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

public class Entitlement {

    private String cert;
    
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate from;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate until;
    
    /**
     * Default constructor.
     */
    public Entitlement() {
    }
    
    /**
     * Convenience constructor.
     * @param cert
     * @param from
     * @param until
     */
    public Entitlement(String cert, LocalDate from, LocalDate until) {
        super();
        this.cert = cert;
        this.from = from;
        this.until = until;
    }



    public String getCert() {
        return cert;
    }
    public void setCert(String cert) {
        this.cert = cert;
    }
    public LocalDate getFrom() {
        return from;
    }
    public void setFrom(LocalDate from) {
        this.from = from;
    }
    public LocalDate getUntil() {
        return until;
    }
    public void setUntil(LocalDate until) {
        this.until = until;
    }
}
