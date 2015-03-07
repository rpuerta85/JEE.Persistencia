package es.art83.persistence.jpa;

import java.lang.String;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import es.art83.persistence.models.entities.Boat;
import es.art83.persistence.models.entities.Category;
import es.art83.persistence.models.entities.Phone;

@Entity
public class User9 {
	
	@Id
    private Integer id;

    private String name;
    
    private String password;
    
    @OneToOne
    @JoinColumn
    private Category category;
    
    //private Boat boat;
    //le estamos diciendo que este campo es una relacion 1 a 1 con otra tabla.Es un atributo que en un modelo relacional
    //no existe pero que lo mapeamos con el campo user9 de la entidad teléfono
    @OneToOne(mappedBy="user9")
    private Phone phone;
    
    
    @Transient //No persistente
    private String volatil;

    public User9(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public User9() {
        this(0,"");
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVolatil() {
        return volatil;
    }

    public void setVolatil(String volatil) {
        this.volatil = volatil;
    }

    @Override
    public String toString() {
        return "User[" + id + ":" + name + "]";
    }

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

}
