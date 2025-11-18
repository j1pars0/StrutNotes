
package uk.co.jamesrparsons.strutnotes.action;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ActionSupport;
import org.apache.struts2.Preparable;
import static org.apache.struts2.action.Action.SUCCESS;
import org.apache.struts2.interceptor.parameter.StrutsParameter;
import uk.co.jamesrparsons.strutnotes.model.CategoryDTO;
import uk.co.jamesrparsons.strutnotes.repository.Categories;

/**
* CRUD action Class for maintaining a Category entity
*/
public class CategoryMaintAction extends ActionSupport implements Preparable {
    private static final Logger LOG = LogManager.getLogger(CategoryMaintAction.class);
    private List<CategoryDTO> categories;
    private CategoryDTO category;

    /**
     * Obtain a fresh copy of a Category if the request contains a Category or a 
     * Category id.
     * 
     * @throws Exception 
     */
    @Override
    public void prepare() throws Exception {
        if (category != null && category.getId() != 0) {
            category = Categories.getCategory(category.getId());
        }
    }
    /**
     * Save a Category in reaction to the mapped Save action.
     * 
     * @return 
     */
    public String save() {
        Categories.setCategory(category);
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
     * Delete a Category
     * 
     * @return 
     */
    public String delete() {
        LOG.debug("Delete Category");
        Categories.deleteCategory(category);
        return SUCCESS;
    }
    /**
     * Obtain a list of Categories in response to the mapped list action
     * 
     * @return 
     */
    public String list() {
        categories = Categories.getCategories();
        return SUCCESS;
    }
    /**
     * Getter for the Categories list in the request
     * 
     * @return 
     */
    @StrutsParameter(depth=1)
    public List<CategoryDTO> getCategories() {
        LOG.debug("Refresh Categories");
        return categories;
    }
    /**
     * Getter for the Category in the request
     * 
     * @return 
     */
    @StrutsParameter (depth=1)
    public CategoryDTO getCategory() {
        if (category != null) {
            LOG.debug("Get Category: " + category);
        }
        return category;
    }
    /**
     * Setter for the Category in the request
     * 
     * @param category 
     */
    public void setCategory(CategoryDTO category) {
        this.category = category;
        LOG.debug("Set Category: " + category);
    }
    /**
     * Validate any input through the input action
     */
    @Override
    public void validate() {
        if (category != null) {
            LOG.debug("Validate " + category);
            if ((category.getCategoryName().length() == 0) 
            || (category.getCategoryName().equalsIgnoreCase("new category"))) {
                this.addFieldError("category.categoryName", "Category must have a name");
            }
        }
    }
}
// End of file

