package isep.web.sakila.webapi.service;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import isep.web.sakila.dao.repositories.CategoryRepository;
import isep.web.sakila.jpa.entities.Category;
import isep.web.sakila.webapi.model.CategoryWO;

@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository		categoryRepository;
	private static final Log	log	= LogFactory.getLog(CategoryServiceImpl.class);

	@Override
	public CategoryWO findById(int id) {
		log.debug(String.format("Looking for category by Id %s", id));
		Category category = categoryRepository.findOne((int)id);
		
		if(category != null){
			return new CategoryWO(category);
		}
		
		return null;
	}

	@Override
	public void saveCategory(CategoryWO categoryWO) {
		Category category = new Category();
		category.setName(categoryWO.getName());
		category.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		categoryRepository.save(category);
	}

	@Override
	public void updateCategory(CategoryWO categoryWO) {
		Category category2update = categoryRepository.findOne(categoryWO.getCategoryId());
		category2update.setName(categoryWO.getName());
		category2update.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		categoryRepository.save(category2update);
	}

	@Override
	public void deleteCategoryById(int id) {
		categoryRepository.delete(id);
	}

	@Override
	public List<CategoryWO> findAllCategories() {
		List<CategoryWO> categories = new LinkedList<CategoryWO>();

		for (Category category : categoryRepository.findAll())
		{
			categories.add(new CategoryWO(category));
			log.debug("Adding category " + category);
		}

		return categories;
	}

}
