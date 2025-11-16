
package uk.co.jamesrparsons.strutnotes.repository;

import jakarta.persistence.EntityManager;
import java.util.Date;

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
        LOG.debug("Getting Note: " + id);
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
    
    /**
     * Save the supplied Note Entity
     * 
     * @param noteDTO - The supplied note Entity 
     */
    public static void setNote(NoteDTO noteDTO) {
        
        Note note;
        Date now = new Date();
        
        try (EntityManager em = StrutNotesDB.getInstance()
                    .getEntityManagerFactory().createEntityManager()) {
            
            em.getTransaction().begin();

            note = EntityMapping.mapNoteDTONote(noteDTO);
            
            note.setModifyDate(now);
            if (note.getId() > 0) {
                LOG.debug("Modify Note: " + note);
                em.merge(note);
            } else {
                note.setCreateDate(now);
                LOG.debug("Create Note: " + note);
                em.persist(note);
                LOG.debug("Created Note: " + note);
            }
            em.getTransaction().commit();
        }
        catch (Exception e) {
            LOG.error("Error setting a note: " + e);
        }        
    }
    /**
     * Delete the supplied Note Entity
     * 
     * @param noteDTO - The supplied note Entity 
     */
    public static void deleteNote(NoteDTO noteDTO) {
        Note note;
        
        try (EntityManager em = StrutNotesDB.getInstance()
                    .getEntityManagerFactory().createEntityManager()) {
            
            em.getTransaction().begin();
            
            note = em.find(Note.class, noteDTO.getId());

            em.remove(note);
            
            em.getTransaction().commit();
        }
        catch (Exception e) {
            LOG.error("Error setting a note: " + e);
        }        
    }
}
//End of file
