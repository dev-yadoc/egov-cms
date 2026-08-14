package kr.co.yadoc.cms.repo;

import kr.co.yadoc.cms.domain.CmsItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CmsItemRepository extends JpaRepository<CmsItem,Long> {
    List<CmsItem> findByFeatureCodeOrderBySortOrderAscIdDesc(String featureCode);
    long countByFeatureCode(String featureCode);
}
