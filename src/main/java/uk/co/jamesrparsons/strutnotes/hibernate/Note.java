/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
 *
 * @author james
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNoteName() {
        return noteName;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
    
    @Override
    public String toString() {
        return "Note: " + this.id + " " + this.noteName;
    }
}
