/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritanceorm;

import inheritanceorm.Employee;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 *
 * @author aomms
 */
    @Entity
@DiscriminatorValue("PARTTIME") 
public class ParttimeEmployee extends Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private int hourworks;

    public Integer getHourworks() {
        return hourworks;
    }

    public void setHourworks(Integer hourworks) {
        this.hourworks = hourworks;
    }
}
