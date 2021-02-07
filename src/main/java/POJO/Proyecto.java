package POJO;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Set;

@Entity
@Table(name = "PROYECTOS")
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column (name="ID", nullable = false)
    private BigInteger id;

    @Column (name="NOMBRE")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "ID_DEPARTAMENTO", nullable = false)

    private Departamento departamento;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Trabaja> trabajas;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString(){
        return "Proyecto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
