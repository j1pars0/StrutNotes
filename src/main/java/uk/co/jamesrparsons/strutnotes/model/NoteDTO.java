
package uk.co.jamesrparsons.strutnotes.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * NoteDTO Class as a model used by the Struts view and as a transfer 
 * barrier to the Hibernate data Entity.
 */
public class NoteDTO {
    private long id;
    private String noteName;
    private String noteContent;
    private List<CategoryDTO> categories;
    private Date createDate;
    private Date modifyDate;
    private SimpleDateFormat formatter;
    
    /**
     * Default constructor. It ensures a date formatter is available to display
     * a date.
     */
    public NoteDTO() {
        categories = new ArrayList<>();
        formatter = new SimpleDateFormat("HH:mm dd/MM/yy");
    }
    /**
     * Getter for the createDate property
     * 
     * @return a Date containing the existing createDate
     */
    public Date getCreateDate() {
        return createDate;
    }
    /**
     * Setter for the createDate property
     * 
     * @param createDate a Date containing the new createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    /**
     * Getter for the modifyDate property
     * 
     * @return a Date containing the existing modifyDate  
     */
    public Date getModifyDate() {
        return modifyDate;
    }
    /**
     * Setter for the modifyDate property
     * 
     * @param modifyDate a Date containing the new modifyDate 
     */
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
    /**
     * Getter for the Id property
     * 
     * @return the Id as a long 
     */
    public long getId() {
        return id;
    }
    /**
     * Setter for the Id. 
     * 
     * @param id a long containing the new Id value
     */
    public void setId(long id) {
        this.id = id;
    }
    /**
     * Getter for the noteName property
     * 
     * @return the noteName as a String 
     */
    public String getNoteName() {
        return noteName;
    }
    /**
     * Setter for the noteName property
     * 
     * @param noteName a String containing the new noteName value 
     */
    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }
    /**
     * Getter for the noteContent property
     * 
     * @return a String containing the existing noteContent value  
     */
    public String getNoteContent() {
        return noteContent;
    }
    /** 
     * Setter for the noteContent property
     * 
     * @param noteContent a String containing the new noteContent value
     */
    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }
    /**
     * Getter for the categories property
     * 
     * @return a List of the existing CategoryDTO(s) associated 
     * with the NoteDTO
     */
    public List<CategoryDTO> getCategories() {
        return categories;
    }
    /**
     * Setter for the categories property
     * 
     * @param categories a new List of CategoryDTO(s) to associate with the 
     * NoteDTO  
     */
    public void setCategories(List<CategoryDTO> categories) {
        this.categories = categories;
    }
    /**
     * Method to return a formatted createDate
     * 
     * @return a String containing the createDate
     */
    public String getCreateDateFormatted() {
        return formatter.format(createDate);
    }
    /**
     * Method to return a formatted modifyDate
     * 
     * @return a String containing the modifyDate
     */
    public String getModifyDateFormatted() {
        return formatter.format(modifyDate);
    }
}
// End of file
