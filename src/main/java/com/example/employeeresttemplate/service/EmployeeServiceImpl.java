package com.example.employeeresttemplate.service;

import com.example.employeeresttemplate.entity.Employee;
import com.example.employeeresttemplate.entity.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final RestTemplate restTemplate;
    private List<Employee> employees;

    @Autowired
    public EmployeeServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostConstruct
    public void proConstruct(){
        String resourceUrl = "http://dummy.restapiexample.com/api/v1/employees";
        ResponseEntity<EmployeeDTO> response = restTemplate.getForEntity(resourceUrl, EmployeeDTO.class);
        EmployeeDTO responseDTO = response.getBody();
        employees = responseDTO.getList();
    }

    @Override
    public List<Employee> findEmployeesLagerThan(int age) {
        List<Employee> list = new ArrayList<>();
        for(Employee em:employees){
            if(em.getEmployee_age() > age){
                list.add(em);
            }
        }
        return list;
    }

    @Override
    public Map<Integer, List<Employee>> groupEmployeeByAge() {
        Map<Integer, List<Employee>> map = new HashMap<>();
        for(Employee em: employees){
            int age = em.getEmployee_age();
            if(!map.containsKey(age)){
                map.put(age, new ArrayList<>());
            }
            map.get(age).add(em);
        }
        System.out.println(map);
        return map;
    }
}
