package com.eva.dao;

import com.eva.entity.Permission;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by 01348085 on 2017/7/12.
 */
public interface PermissionDao extends CrudRepository<Permission,Long> {
}
