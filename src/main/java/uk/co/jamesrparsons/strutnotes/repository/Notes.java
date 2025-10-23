/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.co.jamesrparsons.strutnotes.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uk.co.jamesrparsons.strutnotes.model.NoteDTO;

/**
 *
 * @author james
 */
public class Notes {
    private static List<NoteDTO> notes;
    
    public static List<NoteDTO> getNotes() {
        NoteDTO note;
        Date now;
        if (notes == null) {
            notes = new ArrayList<>();
            for (int i = 1; i <= 13; i++) {
                now = new Date();
                note = new NoteDTO();
                note.setId(i);
                note.setNoteName("Note " + i);
                note.setNoteContent("Content " + i);
                note.setCreateDate(now);
                note.setModifyDate(now);
                notes.add(note);
            }
        }
        return notes;
    }
    
    public static NoteDTO getNote(int id) {
        NoteDTO noteDto = new NoteDTO();
        NoteDTO note = notes.get(id - 1);
        noteDto.setId(note.getId());
        noteDto.setNoteName(note.getNoteName());
        noteDto.setNoteContent(note.getNoteContent());
        noteDto.setCreateDate(note.getCreateDate());
        noteDto.setModifyDate(note.getModifyDate());
        return noteDto;
    }
    
    public static void setNote(NoteDTO note) {
        if (note.getId() == 0) {
            note.setId(notes.size());
            notes.add(note);
        } else {
            notes.set(note.getId()-1, note);
        }
    }
    
}
