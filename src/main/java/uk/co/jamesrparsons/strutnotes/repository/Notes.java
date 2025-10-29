/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.co.jamesrparsons.strutnotes.repository;

import jakarta.persistence.EntityManager;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import uk.co.jamesrparsons.strutnotes.hibernate.Note;
import uk.co.jamesrparsons.strutnotes.mapping.EntityMapping;
import uk.co.jamesrparsons.strutnotes.model.NoteDTO;

/**
 *
 * @author james
 */
public class Notes {
    private static final Logger LOG = LogManager.getLogger(Notes.class);
    /*
    private static List<NoteDTO> notes;
    
    public static List<NoteDTO> getNotes() {
        NoteDTO note;
        Date now;
        if (notes == null) {
            notes = new ArrayList<>();
            for (long i = 1; i <= 13; i++) {
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
            note.setId((long)notes.size());
            notes.add(note);
        } else {
            notes.set(note.getId()-1, note);
        }
    }
    */
    
    public static List<NoteDTO> getNotes() {
        List<NoteDTO> notesDTO = null;
        List<Note> notes;
        try (EntityManager em = StrutNotesDB.getInstance()
                    .getEntityManagerFactory().createEntityManager()) {
            notes = em.createQuery("FROM Note", Note.class).getResultList();
            notesDTO = EntityMapping.mapNotesNotesDTO(notes);
        }
        catch (Exception e) {
            LOG.error("Error getting notes: " + e);
        }
        return notesDTO;
    }
    
    public static NoteDTO getNote(long id) {
        NoteDTO noteDTO = null;
        Note note;
        try (EntityManager em = StrutNotesDB.getInstance()
                    .getEntityManagerFactory().createEntityManager()) {
            note = em.find(Note.class, id);
            noteDTO = EntityMapping.mapNoteNoteDTO(note);
        }
        catch (Exception e) {
            LOG.error("Error getting a note: " + e);
        }
        
        return noteDTO;
    }
    
    public static void setNote(NoteDTO noteDTO) {
        
        Note note = EntityMapping.mapNoteDTONote(noteDTO);
        
        try (EntityManager em = StrutNotesDB.getInstance()
                    .getEntityManagerFactory().createEntityManager()) {
            em.getTransaction().begin();
            if (note.getId() > 0) {
                em.merge(note);
            } else {
                em.persist(note);
            }
            em.getTransaction().commit();
        }
        catch (Exception e) {
            LOG.error("Error getting a note: " + e);
        }
        
    }
}
