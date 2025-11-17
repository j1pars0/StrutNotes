
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
 * A class that handles the data access to the Category Entity
 * 
 */
public class Categories {
    private static final Logger LOG = LogManager.getLogger(Categories.class);

    /**
     * Get a list of the categories from the database
     * 
     * @return a List of CategoryDTO 
     */
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
    /**
     * Get a Category for a given id from the database
     * 
     * @param id a long containing the required id
     * 
     * @return required CategoryDTO 
     */
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
    /**
     * Delete the supplied Category Entity
     * 
     * @param categoryDTO - The supplied category Entity 
     */
    public static void deleteCategory(CategoryDTO categoryDTO) {
        Category category;
        
        try (EntityManager em = StrutNotesDB.getInstance()
                    .getEntityManagerFactory().createEntityManager()) {
            
            em.getTransaction().begin();
            
            category = em.find(Category.class, categoryDTO.getId());

            em.remove(category);
            
            em.getTransaction().commit();
        }
        catch (Exception e) {
            LOG.error("Error setting a category: " + e);
        }        
    }
}
// End of file
