
import java.util.*;
class Professor{
    private String name;
    public Professor(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
class Department{
    private String name;
    private List<Professor> professors;
    public Department(String name, List<Professor> professors){
        this.name = name;
        this.professors = professors;
    }
    public void printProfessor(){
        System.out.println("Professors in "+name+"Department");
        for(Professor p : professors){
            System.out.println("- "+p.getName());
        }
    }
}
public class Aggregation {
    public static void main(String[] args) {
        Professor p1 = new Professor("Dr. Jones");
        Professor p2 = new Professor("Dr. Lee");

        List<Professor> profs = List.of(p1, p2);
        Department csDept = new Department("CSE", profs);
        csDept.printProfessor();
    }
}
