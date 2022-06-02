package com.example.employeeresttemplate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private String status;
    private String message;
    private List<Employee> list;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Employee> getList() {
        return list;
    }

    public void setList(List<Employee> list) {
        this.list = list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDTO that = (EmployeeDTO) o;
        return Objects.equals(status, that.status) && Objects.equals(message, that.message) && Objects.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, message, list);
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", list=" + list +
                '}';
    }

}
