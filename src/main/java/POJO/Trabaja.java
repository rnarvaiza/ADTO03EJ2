package POJO;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "TRABAJA")
public class Trabaja {

    @Basic
    @Column (name = "NUMERO_HORAS")
    private BigInteger numeroHoras;



    @ManyToOne
    @JoinColumn(name = "ID_EMPLEADO", nullable = false)
    private Empleado empleado;


    @ManyToOne
    @JoinColumn(name = "ID_PROYECTO", nullable = false)
    private Proyecto proyecto;
    @Id
    private Long id;


    public BigInteger getNumeroHoras() {
        return numeroHoras;
    }

    public void setNumeroHoras(BigInteger numeroHoras) {
        this.numeroHoras = numeroHoras;
    }

    @Override
    public String toString(){
        return "Trabaja{" +
                "Número de horas=" + numeroHoras +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
