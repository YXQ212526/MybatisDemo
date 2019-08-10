package com.yuanxueqi.testMybatis;

import java.io.Reader;
import java.util.Map;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Main {

  private static SqlSessionFactory sqlSessionFactory;
  private static Reader reader;

  static {
    try {
      reader = Resources.getResourceAsReader("mybatis.xml");
      sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    } catch (Exception e) {
      e.getMessage();
    }

  }

  public static void findById(int id) {
    SqlSession sqlSession = null;
    sqlSession = sqlSessionFactory.openSession();
    // Student one = (Student) sqlSession.selectOne("com.yuanxueqi.testMybatis.StudentMapper.getStudent", id);
    StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
    Student one = studentMapper.getStudent(id);
    if (one == null) {
      System.out.println("null!!");

    } else {
      System.out.println(one);
    }
    sqlSession.commit();
    sqlSession.close();
  }

  public static void insertStudent(Student student) {
    SqlSession sqlSession = null;
    sqlSession = sqlSessionFactory.openSession();
    // int result = sqlSession.insert("com.yuanxueqi.testMybatis.StudentMapper.insertStudent", student);
    StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
    int result = studentMapper.insertStudent(student);
    if (result > 0) {
      System.out.println("insert success!");
    }
    sqlSession.commit();
    sqlSession.close();
  }

  public static void updateStudent(Student student) {
    SqlSession sqlSession = null;
    sqlSession = sqlSessionFactory.openSession();
    StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
    int result = studentMapper.updateStudent(student);

    // int result = sqlSession.update("com.yuanxueqi.testMybatis.StudentMapper.updateStudent", student);
    if (result > 0) {
      System.out.println("update success!");
    }
    sqlSession.commit();
    sqlSession.close();
  }

  public static void deleteStudent(int id) {
    SqlSession sqlSession = null;
    sqlSession = sqlSessionFactory.openSession();

    //int result = sqlSession.update("com.yuanxueqi.testMybatis.StudentMapper.deleteStudent", id);

    StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
    int result = studentMapper.deleteStudent(id);
    if (result > 0) {
      System.out.println("delete success!");
    }
    sqlSession.commit();
    sqlSession.close();
  }

  public static void main(String[] args) {
//    findById(2);
    Student student1 = new Student();
    student1.setName("yang");
    insertStudent(student1);
//    Student student2 = new Student();

//    student2.setId(24);
//    student2.setName("sun");
//    updateStudent(student2);
    //  deleteStudent(10);
    //  findById(2);
  }
}
