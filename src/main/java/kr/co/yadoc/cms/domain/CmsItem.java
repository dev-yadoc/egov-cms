package kr.co.yadoc.cms.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="cms_item", indexes=@Index(name="idx_cms_item_feature", columnList="featureCode"))
public class CmsItem {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,length=80) private String featureCode;
 @Column(nullable=false,length=200) private String title;
 @Column(length=4000) private String content;
 @Column(nullable=false) private boolean enabled=true;
 @Column(nullable=false) private int sortOrder=0;
 @Column(nullable=false) private LocalDateTime createdAt;
 @Column(nullable=false) private LocalDateTime updatedAt;
 @PrePersist public void prePersist(){var now=LocalDateTime.now();createdAt=now;updatedAt=now;}
 @PreUpdate public void preUpdate(){updatedAt=LocalDateTime.now();}
 public Long getId(){return id;} public void setId(Long id){this.id=id;}
 public String getFeatureCode(){return featureCode;} public void setFeatureCode(String v){featureCode=v;}
 public String getTitle(){return title;} public void setTitle(String v){title=v;}
 public String getContent(){return content;} public void setContent(String v){content=v;}
 public boolean isEnabled(){return enabled;} public void setEnabled(boolean v){enabled=v;}
 public int getSortOrder(){return sortOrder;} public void setSortOrder(int v){sortOrder=v;}
 public LocalDateTime getCreatedAt(){return createdAt;} public LocalDateTime getUpdatedAt(){return updatedAt;}
}
