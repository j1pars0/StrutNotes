
package uk.co.jamesrparsons.strutnotes.action;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ActionSupport;
import org.apache.struts2.Preparable;
import org.apache.struts2.interceptor.parameter.StrutsParameter;
import uk.co.jamesrparsons.strutnotes.model.NoteDTO;
import uk.co.jamesrparsons.strutnotes.repository.Notes;

/**
* CRUD action Class for maintaining a Note entity
*/
public class NoteMaintAction extends ActionSupport implements Preparable {
    private static final Logger LOG = LogManager.getLogger(NoteMaintAction.class);
    private List<NoteDTO> notes;
    private NoteDTO note;

    /**
     * Obtain a fresh copy of a Note if the request contains a Note or a 
     * Note id.
     * 
     * @throws Exception 
     */
    @Override
    public void prepare() throws Exception {
        if (note != null && note.getId() != 0) {
            note = Notes.getNote(note.getId());
        }
    }
    /**
     * Save a Note in reaction to the mapped Save action.
     * 
     * @return 
     */
    public String save() {
        Notes.setNote(note);
        return SUCCESS;
    }
    /**
     * Cancel any changes in response to the mapped cancel action
     * 
     * @return 
     */
    public String cancel() {
        return SUCCESS;
    }
    /**
     * Delete a Note
     * 
     * @return 
     */
    public String delete() {
        LOG.debug("Delete Note");
        Notes.deleteNote(note);
        return SUCCESS;
    }
    /**
     * Obtain a list of Notes in response to the mapped list action
     * 
     * @return 
     */
    public String list() {
        notes = Notes.getNotes();
        return SUCCESS;
    }
    /**
     * Getter for the Notes list in the request
     * 
     * @return 
     */
    @StrutsParameter(depth=1)
    public List<NoteDTO> getNotes() {
        LOG.debug("Refresh Notes");
        return notes;
    }
    /**
     * Getter for the Notes in the request
     * 
     * @return 
     */
    @StrutsParameter (depth=1)
    public NoteDTO getNote() {
        if (note != null) {
            LOG.debug("Get Note: " + note);
        }
        return note;
    }
    /**
     * Setter for the Note in the request
     * 
     * @param note 
     */
    public void setNote(NoteDTO note) {
        this.note = note;
        LOG.debug("Set Note: " + note);
    }
    /**
     * Validate any input through the input action
     */
    @Override
    public void validate() {
        if (note != null) {
            LOG.debug("Validate " + note);
            if ((note.getNoteName().length() == 0) 
            || (note.getNoteName().equalsIgnoreCase("new note"))) {
                this.addFieldError("note.noteName", "Note must have a name");
            }
        }
    }
}
// End of file

