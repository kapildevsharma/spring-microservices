package com.kapil.user.service;

import com.kapil.user.VO.Department;
import com.kapil.user.VO.ResponseTemplateVO;
import com.kapil.user.client.DepartmentClient;
import com.kapil.user.entity.User;
import com.kapil.user.exception.ResourceNotFoundException;
import com.kapil.user.exception.UserNotFoundException;
import com.kapil.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DepartmentClient departmentClient;

    public User saveUser(User user) {
        log.info("Inside saveUser of UserService");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment of UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user =userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found: "+userId));
        // after register eureka server
        Department department = null;
        try {
            department = restTemplate.getForObject("http://API-GATEWAY/departments/" + user.getDepartmentId(), Department.class);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error occurred while calling Department Service: {}" ,e.getMessage());
        }
        if (department == null) {
            throw new ResourceNotFoundException("Department not found with id: " + department.getDepartmentId());
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
    public ResponseTemplateVO getUserWithDepartmentWithFeignClient(Long userId) {
        log.info("Inside getUserWithDepartment of UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user =userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found: "+userId));
        // after register eureka server
        Department department = null;
        try {
            department = departmentClient.getDepartmentById(user.getDepartmentId());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error occurred while calling Department Service: {}" ,e.getMessage());
        }
        if (department == null) {
            throw new ResourceNotFoundException("Department not found with id: " + user.getDepartmentId());
        }

        vo.setUser(user);
        vo.setDepartment(department);

        return vo;
    }
    public void deleteUser(Long userId) {
        log.info("Inside deleteUser of UserService");
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found: " + userId));
        userRepository.delete(user);
    }

    public List<ResponseTemplateVO> getUserList() {
        log.info("Inside getUserList of UserService");
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> {
            ResponseTemplateVO vo = new ResponseTemplateVO();
            vo.setUser(user);
            Department department = null;
            try {
                department = restTemplate.getForObject("http://API-GATEWAY/departments/"
                        +     user.getDepartmentId(), Department.class);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Error occurred while calling Department Service {}", e.getMessage());
            }
            if (department == null) {
                log.warn("Department not found for user id: {}", user.getUserId());
            }
            vo.setDepartment(department);
            return vo;
        }).collect(Collectors.toList());

    }
}
