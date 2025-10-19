/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.co.jamesrparsons.strutnotes.action;

import java.util.List;
import org.apache.struts2.ActionSupport;
import uk.co.jamesrparsons.strutnotes.model.NoteDTO;
import uk.co.jamesrparsons.strutnotes.repository.Notes;

/**
 *
 * @author james
 */
public class NotelistAction extends ActionSupport {
    private List<NoteDTO> notes;
    @Override
    public String execute() {
        notes = Notes.getNotes();
        return SUCCESS;
    }
    public List<NoteDTO> getNotes() {
        return notes;
    }
    
}
