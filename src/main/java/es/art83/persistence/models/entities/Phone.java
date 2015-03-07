package es.art83.persistence.models.entities;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import es.art83.persistence.jpa.User9;
import es.art83.persistence.models.utils.PhoneType;

@Entity
public class Phone {
    public static final String TABLE = "phone";

    public static final String ID = "ID";

    @Id
    @GeneratedValue
    private Integer id;

    public static final String PHONE_TYPE = "PHONETYPE";

    @Enumerated(EnumType.STRING) // Opcional
    private PhoneType phoneType;

    public static final String NUMBER = "NUMBER";

    private int number;
    
    
    // le estamos diciendo que es una clave foránea "JoinColumn" y que tiene una relacion 1 a 1 con La entidad User9.
   // En este caso como no le hemos puesto MappeBy, si que se mostrara en nuestro modelo de datos este campo
    @OneToOne
    @JoinColumn
    private User9 user9;
    
    public Phone(PhoneType phoneType, int number) {
        this.phoneType = phoneType;
        this.number = number;
    }

    public Phone() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PhoneType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Phone [id=" + id + ", phoneType=" + phoneType + ", number=" + number + "]";
    }

	public User9 getUser9() {
		return user9;
	}

	public void setUser9(User9 user9) {
		this.user9 = user9;
	}

}
