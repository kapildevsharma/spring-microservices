package com.kapil.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kapil.user.VO.Department;
import com.kapil.user.VO.ResponseTemplateVO;
import com.kapil.user.entity.User;
import com.kapil.user.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	private static final Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		log.info("Inside saveUser of UserService");
		return userRepository.save(user);
	}

	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		log.info("Inside getUserWithDepartment of UserService");
		ResponseTemplateVO vo = new ResponseTemplateVO();
		User user = userRepository.findByUserId(userId);

		// after register eureka server
        Department department = null;
        try {
            department = restTemplate.getForObject("http://API-GATEWAY/departments/id/" + user.getDepartmentId(), Department.class);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error occurred while calling Department Service: " + e.getMessage());
        }
		/*
		 * Department department =
		 * restTemplate.getForObject("http://localhost:9001/departments/" +
		 * user.getDepartmentId() ,Department.class);
		 */
		vo.setUser(user);
		vo.setDepartment(department);

		return vo;
	}
}
