package cn.ganzhiqiang.esdemo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * @author zqgan
 * @since 2019/4/20
 **/

@Document(indexName = "test-role", type = "role",replicas=0,shards=3)
public class RoleDO {

    @Id
    private String id;

    @Field(type= FieldType.keyword)
    private String name;

    @Field(type=FieldType.Date)
    private Date createTime;

    @Field(searchAnalyzer="ik_smart",analyzer="ik_smart",type=FieldType.text)
    private String description;

    public RoleDO() {}

    public RoleDO(String name, String description, Date createTime) {
        this.name = name;
        this.description = description;
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public Date getCreateTime() {
        return createTime;
    }


    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }

}