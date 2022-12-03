package com.driver;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
@Component
public class StudentRepository {

    HashMap<String, Student> studentHashMap = new HashMap<>();
    HashMap<String, Teacher> teacherHashMap = new HashMap<>();
    HashMap<String, String> studentTeacherPair = new HashMap<>();
    public void addStudent(Student student){
        studentHashMap.put(student.getName(), student);
    }
    public void addTeacher(Teacher teacher){
        teacherHashMap.put(teacher.getName(), teacher);
    }
    public void studentTeacherPair(String s, String t){
        studentTeacherPair.put(s, t);
    }
    public Student getStudentByName(String name){
        return studentHashMap.get(name);
    }
    public Teacher getTeacherByName(String name){
        return teacherHashMap.get(name);
    }
    public List<String> getStudentByTeacherName(String name){
        List<String> studentList = new ArrayList<>();
        for(String student : studentTeacherPair.keySet()){
            if(studentTeacherPair.get(student).equals(name)){
                studentList.add(student);
            }
        }
        return studentList;
    }
    public List<String> getAllStudents(){
        return new ArrayList<>(studentHashMap.keySet());
    }
    public void deleteTeacherByName(String name){
        List<String> students = getStudentByTeacherName(name);
        for(String student : students){
            studentHashMap.remove(student);
        }
        teacherHashMap.remove(name);
    }
    public void deleteAllTeachers(){
        for(String teacher : teacherHashMap.keySet()){
            deleteTeacherByName(teacher);
        }
    }
}
