package com.zxl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zxl.entity.SysRole;

public interface RoleMapper {
	
	@Select("SELECT * FROM sys_role")
	/*@Results({
		@Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
		@Result(property = "nickName", column = "nick_name")
	})*/
	List<SysRole> getAll();
	
	@Select("SELECT * FROM sys_role WHERE id = #{id}")
	/*@Results({
		@Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
		@Result(property = "nickName", column = "nick_name")
	})*/
	SysRole getOne(Long id);

	@Insert("INSERT INTO sys_role(available,description,role) VALUES(#{available}, #{description}, #{role})")
	void insert(SysRole role);

	@Update("UPDATE sys_role SET role=#{role},description=#{description},available=#{available} WHERE id =#{id}")
	void update(SysRole role);

	@Delete("DELETE FROM sys_role WHERE id =#{id}")
	void delete(Long id);
	
}
