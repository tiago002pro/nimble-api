package br.com.nimble.nimbleapi.repository.Finance;

import br.com.nimble.nimbleapi.model.Finance.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {

    @Query(nativeQuery = true,
     value = " SELECT " +
             "  s.* " +
             " FROM subcategory s " +
             "  INNER JOIN category c ON c.id = s.category_id " +
             " WHERE c.type = :type")
    List<SubCategory> findSubCategoryByType(@Param("type") String type);
}
