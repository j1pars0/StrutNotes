/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.co.jamesrparsons.strutnotes.mapping;

import java.util.ArrayList;
import java.util.List;
import uk.co.jamesrparsons.strutnotes.hibernate.Category;
import uk.co.jamesrparsons.strutnotes.hibernate.Note;
import uk.co.jamesrparsons.strutnotes.model.CategoryDTO;
import uk.co.jamesrparsons.strutnotes.model.NoteDTO;

/**
 *
 * @author james
 */
public class EntityMapping {
    public static NoteDTO mapNoteNoteDTO(Note note) {
        NoteDTO noteDTO = new NoteDTO();
        noteDTO.setId(note.getId());
        noteDTO.setNoteName(note.getNoteName());
        noteDTO.setNoteContent(note.getNoteContent());
        
        List<CategoryDTO> categoriesDTO = new ArrayList<>(); 
        for (Category category: note.getCategories()) {
            categoriesDTO.add(mapCategoryCategoryDTO(category));
        }
        noteDTO.setCategories(categoriesDTO);
        
        noteDTO.setCreateDate(note.getCreateDate());
        noteDTO.setModifyDate(note.getModifyDate());
        
        return noteDTO;
    }
    
    public static List<NoteDTO> mapNotesNotesDTO(List<Note> notes) {
        List<NoteDTO> notesDTO = new ArrayList<>();
                
        for (Note note: notes) {
            notesDTO.add(EntityMapping.mapNoteNoteDTO(note));
        }
        
        return notesDTO;
    }
    
    public static Note mapNoteDTONote(NoteDTO noteDTO) {
        Note note = new Note();
        note.setId(noteDTO.getId());
        note.setNoteName(noteDTO.getNoteName());
        note.setNoteContent(noteDTO.getNoteContent());
        
        List<Category> categories = new ArrayList<>(); 
        for (CategoryDTO categoryDTO: noteDTO.getCategories()) {
            categories.add(mapCategoryDTOCategory(categoryDTO));
        }
        note.setCategories(categories);
        
        note.setCreateDate(noteDTO.getCreateDate());
        note.setModifyDate(noteDTO.getModifyDate());
        
        return note;
    }
    
    public static List<Note> mapNotesDTONotes(List<NoteDTO> notesDTO) {
        List<Note> notes = new ArrayList<>();
                
        for (NoteDTO noteDTO: notesDTO) {
            notes.add(EntityMapping.mapNoteDTONote(noteDTO));
        }
        
        return notes;
    }
    
    public static CategoryDTO mapCategoryCategoryDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setCategoryName(category.getCategoryName());
        categoryDTO.setCategoryDesc(category.getCategoryDesc());
        categoryDTO.setCreateDate(category.getCreateDate());
        categoryDTO.setModifyDate(category.getModifyDate());
        return categoryDTO;
    }
    public static Category mapCategoryDTOCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setCategoryName(categoryDTO.getCategoryName());
        category.setCategoryDesc(categoryDTO.getCategoryDesc());
        category.setCreateDate(categoryDTO.getCreateDate());
        category.setModifyDate(categoryDTO.getModifyDate());
        return category;
    }
}
