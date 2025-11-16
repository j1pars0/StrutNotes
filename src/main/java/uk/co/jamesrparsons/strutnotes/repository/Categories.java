/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.co.jamesrparsons.strutnotes.repository;

import jakarta.persistence.EntityManager;
import java.util.Date;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import uk.co.jamesrparsons.strutnotes.hibernate.Category;
import uk.co.jamesrparsons.strutnotes.mapping.EntityMapping;
import uk.co.jamesrparsons.strutnotes.model.CategoryDTO;

/**
 *
 * @author james
 */
public class Categories {
    private static final Logger LOG = LogManager.getLogger(Categories.class);

    
    public static List<CategoryDTO> getCategories() {
        List<CategoryDTO> categoriesDTO = null;
        List<Category> categories;
        try (EntityManager em = StrutNotesDB.getInstance()
                    .getEntityManagerFactory().createEntityManager()) {
            categories = em.createQuery("FROM Category", Category.class).getResultList();
            categoriesDTO = EntityMapping.mapCategoriesCategoriesDTO(categories);
        }
        catch (Exception e) {
            LOG.error("Error getting categories: " + e);
        }
        return categoriesDTO;
    }
    
    public static CategoryDTO getCategory(long id) {
        CategoryDTO categoryDTO = null;
        Category category;
        LOG.debug("Getting Category: " + id);
        try (EntityManager em = StrutNotesDB.getInstance()
                    .getEntityManagerFactory().createEntityManager()) {
            category = em.find(Category.class, id);
            categoryDTO = EntityMapping.mapCategoryCategoryDTO(category);
        }
        catch (Exception e) {
            LOG.error("Error getting a category: " + e);
        }
        
        return categoryDTO;
    }
    
    /**
     * Save the supplied Category Entity
     * 
     * @param categoryDTO - The supplied category Entity 
     */
    public static void setCategory(CategoryDTO categoryDTO) {
        
        Category category;
        Date now = new Date();
        
        try (EntityManager em = StrutNotesDB.getInstance()
                    .getEntityManagerFactory().createEntityManager()) {
            
            em.getTransaction().begin();

            category = EntityMapping.mapCategoryDTOCategory(categoryDTO);
            
            category.setModifyDate(now);
            if (category.getId() > 0) {
                LOG.debug("Modify Category: " + category);
                em.merge(category);
            } else {
                category.setCreateDate(now);
                LOG.debug("Create Category: " + category);
                em.persist(category);
                LOG.debug("Created Category: " + category);
            }
            em.getTransaction().commit();
        }
        catch (Exception e) {
            LOG.error("Error setting a category: " + e);
        }        
    }
}

