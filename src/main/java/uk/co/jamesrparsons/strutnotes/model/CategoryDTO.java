/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.co.jamesrparsons.strutnotes.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jimbob
 */

/**
 * CategoryDTO Class as a model used by the Struts view and as a transfer 
 * barrier to the Hibernate data Entity.
 */
public class CategoryDTO {
    private long id;
    private String categoryName;
    private String categoryDesc;

    private List<NoteDTO> notes;
    private Date CreateDate;
    private Date ModifyDate;
    
    private SimpleDateFormat formatter;

    /**
     * Default constructor. It ensures a date formatter is available to display
     * a date.
     */
    public CategoryDTO() {
        formatter = new SimpleDateFormat("HH:mm dd/MM/yy");
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
     * Getter for the categoryName property
     * 
     * @return the categoryName as a String
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
     * Getter for the categoryDesc property
     * 
     * @return A String containing the categoryDesc
     */
    public String getCategoryDesc() {
        return categoryDesc;
    }
    /**
     * Setter for the categoryDesc
     * 
     * @param categoryDesc a String containing the categoryDesc value
     */
    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }
    /**
     * Getter for the createDate property
     * 
     * @return a Date containing the createDate
     */
    public Date getCreateDate() {
        return CreateDate;
    }
    /**
     * Setter for the createDate
     * 
     * @param CreateDate a Date containing the new createDate
     */
    public void setCreateDate(Date CreateDate) {
        this.CreateDate = CreateDate;
    }
    /**
     * Getter for the modifyDate property
     * 
     * @return a Date containing the modifyDate
     */
    public Date getModifyDate() {
        return ModifyDate;
    }
    /**
     * Setter for the modifyDate
     * 
     * @param ModifyDate a Date containing the new modifyDate
     */
    public void setModifyDate(Date ModifyDate) {
        this.ModifyDate = ModifyDate;
    }
    /**
     * Getter for the associated Notes List
     * 
     * @return a List of Note(s) associated with the Category
     */
    public List<NoteDTO> getNotes() {
        return notes;
    }
    /**
     * Setter for the associated Notes List
     * 
     * @param notes the new List of Notes associated with the Category  
     */
    public void setNotes(List<NoteDTO> notes) {
        this.notes = notes;
    }
    /**
     * Method to return a formatted createDate
     * 
     * @return a String containing the createDate
     */
    public String getCreateDateFormatted() {
        return formatter.format(CreateDate);
    }
    /**
     * Method to return a formatted modifyDate
     * 
     * @return a String containing the modifyDate
     */
    public String getModifyDateFormatted() {
        return formatter.format(ModifyDate);
    }    
}
// End of file
