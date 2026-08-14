package kr.co.yadoc.cms.service;

import kr.co.yadoc.cms.domain.CmsItem;
import kr.co.yadoc.cms.repo.CmsItemRepository;
import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class CmsItemService extends EgovAbstractServiceImpl {
    private final CmsItemRepository repository;
    public CmsItemService(CmsItemRepository repository){this.repository=repository;}
    @Transactional(readOnly=true) public List<CmsItem> list(String code){return repository.findByFeatureCodeOrderBySortOrderAscIdDesc(code);}
    public CmsItem create(String code,String title,String content,boolean enabled,int sortOrder){CmsItem item=new CmsItem();item.setFeatureCode(code);apply(item,title,content,enabled,sortOrder);return repository.save(item);}
    public CmsItem update(Long id,String code,String title,String content,boolean enabled,int sortOrder){CmsItem item=repository.findById(id).orElseThrow();if(!item.getFeatureCode().equals(code))throw new IllegalArgumentException("feature mismatch");apply(item,title,content,enabled,sortOrder);return repository.save(item);}
    public void delete(Long id,String code){CmsItem item=repository.findById(id).orElseThrow();if(!item.getFeatureCode().equals(code))throw new IllegalArgumentException("feature mismatch");repository.delete(item);}
    @Transactional(readOnly=true) public long count(String code){return repository.countByFeatureCode(code);}
    private void apply(CmsItem item,String title,String content,boolean enabled,int sortOrder){item.setTitle(title==null?"":title.trim());item.setContent(content==null?"":content.trim());item.setEnabled(enabled);item.setSortOrder(sortOrder);}
}
