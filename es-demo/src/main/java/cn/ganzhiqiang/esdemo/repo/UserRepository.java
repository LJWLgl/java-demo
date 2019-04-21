package cn.ganzhiqiang.esdemo.repo;

import cn.ganzhiqiang.esdemo.domain.UserDO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends ElasticsearchRepository<UserDO,String> {
    
    //按userName like查询
    List<UserDO> findByUserNameLike(String userName);
    
    //按role的name属性查询
    List<UserDO> findByRolesName(String name);
    
    //按role的name属性查询 两种方式都可以
    List<UserDO> findByRoles_Name(String name);
    
}