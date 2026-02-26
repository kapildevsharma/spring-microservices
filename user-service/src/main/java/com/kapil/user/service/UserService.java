package com.kapil.user.service;

import com.kapil.user.VO.ResponseTemplateVO;
import com.kapil.user.entity.User;

import java.util.List;

public interface UserService {
	User saveUser(User user) ;
	ResponseTemplateVO getUserWithDepartment(Long userId) ;
    void deleteUser(Long userId) ;
    List<ResponseTemplateVO> getUserList() ;

}
