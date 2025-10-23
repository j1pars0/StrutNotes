/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.co.jamesrparsons.strutnotes.action;

import java.util.List;
import org.apache.struts2.ActionSupport;
import org.apache.struts2.Preparable;
import org.apache.struts2.interceptor.parameter.StrutsParameter;
import uk.co.jamesrparsons.strutnotes.model.NoteDTO;
import uk.co.jamesrparsons.strutnotes.repository.Notes;

/**
 *
 * @author james
 */
public class NoteMaintAction extends ActionSupport implements Preparable {
    private List<NoteDTO> notes;
    private NoteDTO note;

    @Override
    public void prepare() throws Exception {
        if (note != null && note.getId() != 0) {
            note = Notes.getNote(note.getId());
        }
    }
    
    public String save() {
        Notes.setNote(note);
        return SUCCESS;
    }
    
    public String list() {
        notes = Notes.getNotes();
        return SUCCESS;
    }
    
    public List<NoteDTO> getNotes() {
        return notes;
    }
    
    @StrutsParameter (depth=1)
    public NoteDTO getNote() {
        return note;
    }
    
    public void setNote(NoteDTO note) {
        this.note = note;
    }
    
}
