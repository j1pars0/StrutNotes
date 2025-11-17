
package uk.co.jamesrparsons.strutnotes.hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A Category Hibernate entity */
@Entity
@Table(name="categories")
public class Category {
    @Id   
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name="category_name", nullable=false)
    private String categoryName;
    @Column(name="category_desc", nullable=false)
    private String categoryDesc;
    @ManyToMany(mappedBy = "categories")
    private List<Note> notes = new ArrayList<>();
    @Column(name="create_date", nullable=false)
    private Date createDate;
    @Column(name="modify_date", nullable=false)
    private Date modifyDate;
    
    public Category() {
        categoryName = "New category";
        categoryDesc = "";
    }
    /**
     * Getter for id property
     * 
     * @return a long containing the current id
     */
    public long getId() {
        return id;
    }
    /**
     * Setter for id property
     * 
     * @param id a long containing the new id
     */
    public void setId(long id) {
        this.id = id;
    }
    /**
     * Getter for categoryName property
     * 
     * @return a String containing the current categoryName value
     */
    public String getCategoryName() {
        return categoryName;
    }
    /**
     * Setter for the categoryName
     * 
     * @param categoryName a String containing the new categoryName value
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    /**
     * Getter for categoryDesc
     * 
     * @return a String containing the current categoryDesc value
     */
    public String getCategoryDesc() {
        return categoryDesc;
    }
    /**
     * Setter for categoryDesc
     * 
     * @param categoryDesc a String containing the new categoryDesc value 
     */
    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }
    /**
     * Getter for the list of notes associated with the Category
     * 
     * @return a current List of notes  associated with the Category
     */
    public List<Note> getNotes() {
        return notes;
    }
    /**
     * Setter for the list of categories associated with the Note
     * 
     * @param notes a new List of Notes to be associated with the Category 
     */
    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
    /**
     * Getter for the createDate
     * 
     * @return a Date containing the current createDate value
     */
    public Date getCreateDate() {
        return createDate;
    }
    /**
     * Setter for the createDate
     * 
     * @param createDate a Date containing the new createDate value 
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    /**
     * Getter for the modifyDate
     * 
     * @return a Date containing the current modifyDate value
     */
    public Date getModifyDate() {
        return modifyDate;
    }
    /**
     * Setter for the modifyDate
     * 
     * @param modifyDate a Date containing the new modifyDate value
     */
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
    /**
     * Represent the entity as a String
     * 
     * @return String representing the state of the object
     */
    @Override
    public String toString() {
        return "Category: " + this.id + " " + this.categoryName;
    }
}
