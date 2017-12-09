package at.htl.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jakob
 */
@Entity
@XmlRootElement
public class Calendar {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String name;
    
    
}
