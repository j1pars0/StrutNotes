
package uk.co.jamesrparsons.strutnotes.hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A Note Hibernate entity
 */
@Entity   
@Table(name = "notes")   
public class Note {
    // Becareful of using object like Long as key. If you do remember to 
    // test for other empty values that may signify a new entity.
    @Id   
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name="note_name", nullable=false)
    private String noteName;
    @Column(name="note_content", nullable=false)
    private String noteContent;
    @ManyToMany
    @JoinTable(name="notes_categories")
    private List<Category> categories = new ArrayList<>(); 
    @Column(name="create_date", nullable=false)
    private Date createDate;
    @Column(name="modify_date", nullable=false)
    private Date modifyDate;
    
    /**
     * Getter for id property
     * 
     * @return 
     */
    public long getId() {
        return id;
    }
    /**
     * Setter for id property
     * 
     * @param id 
     */
    public void setId(long id) {
        this.id = id;
    }
    /**
     * Getter for noteNAme property
     * 
     * @return 
     */
    public String getNoteName() {
        return noteName;
    }
    /**
     * Setter for the noteName
     * 
     * @param noteName 
     */
    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }
    /**
     * Getter for noteContent
     * 
     * @return 
     */
    public String getNoteContent() {
        return noteContent;
    }
    /**
     * Setter for noteContent
     * 
     * @param noteContent 
     */
    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }
    /**
     * Getter for the list of categories associated with the Note
     * 
     * @return 
     */
    public List<Category> getCategories() {
        return categories;
    }
    /**
     * Setter for the list of categories associated with the Note
     * @param categories 
     */
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
    /**
     * Getter for the createDate
     * 
     * @return 
     */
    public Date getCreateDate() {
        return createDate;
    }
    /**
     * Setter for the createDate
     * 
     * @param createDate 
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    /**
     * Getter for the modifyDate
     * 
     * @return 
     */
    public Date getModifyDate() {
        return modifyDate;
    }
    /**
     * Setter for the modifyDate
     * 
     * @param modifyDate 
     */
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
    /**
     * Represent the entity as a String
     * 
     * @return 
     */
    @Override
    public String toString() {
        return "Note: " + this.id + " " + this.noteName;
    }
}
// End of file
