package leetcode_depth_first_search;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *Employee Importance
 */
public class Solution0690_EmployeeImportance {
    public static class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    };


    public static int getImportance(List<Employee> employees, int id) {
        int total_value = 0;
        if (employees.isEmpty()){
            return 0;
        }

        for(Employee employee : employees){
            if (employee.id == id){
                total_value += dfs(employees, employee);
            }
        }

       return total_value;
    }

    public static int dfs(List<Employee> employees, Employee employee){
        if (employee.subordinates.isEmpty()){
            return employee.importance;
        }
        int value_sum = 0;
        Stack<Employee> stack = new Stack<>();
        stack.push(employee);
        while (!stack.isEmpty()){
            Employee tmp = stack.pop();
            value_sum += tmp.importance;
            if (!tmp.subordinates.isEmpty()){
                for (Integer next_id: tmp.subordinates) {
                    for (Employee em : employees) {
                        if (em.id == next_id){
                            stack.push(em);
                        }
                    }
                }
            }
        }
        return value_sum;
    }

    public static void main(String[] args) {

        Employee e1 = new Employee();
        List<Integer> el1 = new ArrayList<>();
        el1.add(2);
        el1.add(3);
        e1.id = 1;
        e1.importance = 5;
        e1.subordinates = el1;

        Employee e2 = new Employee();
        List<Integer> el2 = new ArrayList<>();
        e2.id = 2;
        e2.importance = 3;
        e2.subordinates = el2;

        Employee e3 = new Employee();
        List<Integer> el3 = new ArrayList<>();
        e3.id = 3;
        e3.importance = 3;
        e3.subordinates = el3;

        ArrayList<Employee> list = new ArrayList<>();
        list.add(e1);
        list.add(e2);
        list.add(e3);

        System.out.println(getImportance(list,1));
    }

}
