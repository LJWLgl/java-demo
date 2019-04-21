package cn.ganzhiqiang.esdemo.service;

import cn.ganzhiqiang.esdemo.domain.RoleDO;
import cn.ganzhiqiang.esdemo.domain.UserDO;
import cn.ganzhiqiang.esdemo.repo.UserRepository;
import cn.ganzhiqiang.esdemo.util.FastJsonUtil;
import org.elasticsearch.action.update.UpdateRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.UpdateQuery;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserStandardServiceImpl implements UserStandardService {
    
    @Resource
    private UserRepository userRepository;
    
    @Resource
    private ElasticsearchTemplate elasticsearchTemplate;
    
    /**
     * 批量新增
     **/
    @Override
    public void batchAddUser(List<UserDO> users) {
        if(CollectionUtils.isEmpty(users)) {
	      return ;
	   }
	   List<IndexQuery> queries = new ArrayList<>();
	   IndexQuery indexItem  = null;
	   for(UserDO user :users) {
	       indexItem = new IndexQuery();
	       indexItem.setObject(user);
	       queries.add(indexItem);
	   }
	   elasticsearchTemplate.bulkIndex(queries);
    }
    
    @Override
    public void addUser(UserDO user) {
	   userRepository.save(user);
    }

    @Override
    public void deletedUserById(String id) {
	   userRepository.deleteById(id);
    }

    /**
     * 根据userId更新信息
     */
    @Override
    public void updateUser(UserDO user) {
	   UpdateQuery updateQuery = new UpdateQuery();
	   updateQuery.setId(user.getId());
	   updateQuery.setClazz(UserDO.class);
	   user.setId(null);
	   UpdateRequest request = new UpdateRequest();
	   request.doc(FastJsonUtil.toJsonString(user));
	   updateQuery.setUpdateRequest(request);
	   elasticsearchTemplate.update(updateQuery);
    }

    @Override
    public List<UserDO> queryByUserName(String userName) {
	   return userRepository.findByUserNameLike(userName);
    }

    @Override
    public List<UserDO> queryByRoleName(RoleDO role) {
	   return userRepository.findByRoles_Name(role.getName());
    }

}