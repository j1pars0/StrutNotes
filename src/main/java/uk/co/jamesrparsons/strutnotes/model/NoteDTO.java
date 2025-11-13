
package uk.co.jamesrparsons.strutnotes.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jimbob
 */
public class NoteDTO {
    private long id;
    private String noteName;
    private String noteContent;
    private List<CategoryDTO> categories;
    private Date CreateDate;
    private Date ModifyDate;
    private SimpleDateFormat formatter;
    
    public NoteDTO() {
        categories = new ArrayList<>();
        formatter = new SimpleDateFormat("HH:mm dd/MM/yy");
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date CreateDate) {
        this.CreateDate = CreateDate;
    }

    public Date getModifyDate() {
        return ModifyDate;
    }

    public void setModifyDate(Date ModifyDate) {
        this.ModifyDate = ModifyDate;
    }

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

    public List<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDTO> categories) {
        this.categories = categories;
    }
    
    public String getCreateDateFormatted() {
        return formatter.format(CreateDate);
    }
    
    public String getModifyDateFormatted() {
        return formatter.format(ModifyDate);
    }
}
