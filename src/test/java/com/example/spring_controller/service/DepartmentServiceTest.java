package com.example.spring_controller.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentServiceTest {

    @Mock
    EmployeeService employeeService;
    DepartmentService departmentService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
        departmentService = new DepartmentService(employeeService);

        var e1 = new Employee("foo","baz", 1, 1000);
        var e2 = new Employee("foo1","baz2", 2, 1000);
        var e3 = new Employee("foo2","baz3", 3, 1000);
        var e4 = new Employee("foo3","baz4", 1, 1001);

        when(employeeService.getEmployess()).thenReturn(List.of(e1,e2,e3,e4));
    }

    @Test
    void testMax(){
        var actual = departmentService.max(1);
        var exepted = new Employee("foo3","baz4", 1, 1003)
        assertEqual(exepted, actual);
    }

    private static Collection<Arguments> parameters(){
        return List.of(
                Arguments.of(1,1000),
                Arguments.of(2,1001),
                Arguments.of(3,1002));
    }


    @Test
    @ParameterizedTest()
    @MethodSource("parameters")
    void testMin(int dept, int maxSalary){
        var maxSalaryActual = departmentService.max(dept);
        assertNotNull(maxSalaryActual);
        assertEquals(maxSalary, maxSalaryActual.getSelary());
    }
}