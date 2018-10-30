package handson.example.springshopsearch.model.item;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long>{
	List<Item> findByNameContainsOrderByIdAsc(String keyword);//pulldown = name
	List<Item> findByDescriptionContainsOrderByIdAsc(String keyword);//pulldown = explane
	List<Item> findByNameOrDescriptionContainsOrderByIdAsc(String keyword,String keyword2);//pulldown = both
}
