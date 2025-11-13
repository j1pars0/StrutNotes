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
 * EntiyMapping class
 * A set of static methods to map the Note / NoteDTO and 
 * Category / CategoryDTO objects 
 */
public class EntityMapping {
    /**
     * Map a given Note to a new NoteDTO
     * 
     * @param note a given Note
     * @return a new NoteDTO constructed from the Note
     */
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
    /**
     * Map a given List of Note(s) to a new List of NoteDTO(s)
     * this method uses mapNoteNoteDTO for each Note in the given List
     * 
     * @param notes a given List of Note
     * @return a new List of NoteDTO constructed from the List of Note
     */
    public static List<NoteDTO> mapNotesNotesDTO(List<Note> notes) {
        List<NoteDTO> notesDTO = new ArrayList<>();
                
        for (Note note: notes) {
            notesDTO.add(EntityMapping.mapNoteNoteDTO(note));
        }
        
        return notesDTO;
    }
    /**
     * Map a given NoteDTO to a new Note
     * 
     * @param noteDTO a given NoteDTO
     * @return a new Note constructed from the NoteDTO
     */
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
    /**
     * Map a given List of NoteDTO(s) to a new List of Note(s)
     * this method uses mapNoteDTONote for each NoteDTO in the given List
     * 
     * @param notesDTO a given List of NoteDTO
     * @return a new List of Note constructed from the List of NoteDTO
     */    
    public static List<Note> mapNotesDTONotes(List<NoteDTO> notesDTO) {
        List<Note> notes = new ArrayList<>();
                
        for (NoteDTO noteDTO: notesDTO) {
            notes.add(EntityMapping.mapNoteDTONote(noteDTO));
        }
        
        return notes;
    }
    /**
     * Map a given Category to a new CategoryDTO
     * 
     * @param category a given Category
     * @return a new CategoryDTO constructed from the Category
     */
    
    public static CategoryDTO mapCategoryCategoryDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setCategoryName(category.getCategoryName());
        categoryDTO.setCategoryDesc(category.getCategoryDesc());
        categoryDTO.setCreateDate(category.getCreateDate());
        categoryDTO.setModifyDate(category.getModifyDate());
        return categoryDTO;
    }
    /**
     * Map a given List of Category(s) to a new List of CategoryDTO(s)
     * this method uses mapCategoryCategoryDTO for each Category in the given List
     * 
     * @param categories a given List of Category
     * @return a new List of CategoryDTO constructed from the List of Category
     */
    public static List<CategoryDTO> mapCategoriesCategoriesDTO(List<Category> categories) {
        List<CategoryDTO> categoriesDTO = new ArrayList<>();
        for (Category category: categories) {
            categoriesDTO.add(mapCategoryCategoryDTO(category));
        }
        return categoriesDTO;
    }
    /**
     * Map a given CategoryDTO to a new Category
     * 
     * @param categoryDTO a given CategoryDTO
     * @return a new Category constructed from the CategoryDTO
     */    
    public static Category mapCategoryDTOCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setCategoryName(categoryDTO.getCategoryName());
        category.setCategoryDesc(categoryDTO.getCategoryDesc());
        category.setCreateDate(categoryDTO.getCreateDate());
        category.setModifyDate(categoryDTO.getModifyDate());
        return category;
    }
    /**
     * Map a given List of CategoryDTO(s) to a new List of Category(s)
     * this method uses mapCategoryDTOCategory for each CategoryDTO in the 
     * given List
     * 
     * @param categoriesDTO a given List of Category
     * @return a new List of Category constructed from the List of CategoryDTO
     */
    public static List<Category> mapCategoriesDTOCategories(List<CategoryDTO> categoriesDTO) {
        List<Category> categories = new ArrayList<>();
        for (CategoryDTO categoryDTO: categoriesDTO) {
            categories.add(mapCategoryDTOCategory(categoryDTO));
        }
        return categories;
    }
}
// End of file
