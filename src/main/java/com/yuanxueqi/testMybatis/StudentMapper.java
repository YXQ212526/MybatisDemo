package com.yuanxueqi.testMybatis;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface StudentMapper {

  @Select("select * from student where id = #{id}")
  @Results({
      @Result(column = "id", property = "id"),
      @Result(column = "name", property = "name")
  })
  Student getStudent(int id);

  @Insert("insert into student(name) values(#{name})")
  @Options(useGeneratedKeys = true, keyColumn = "id")
  int insertStudent(Student student);

  @Update("update student set name=#{name} where id=#{id}")
  int updateStudent(Student student);

  @Delete("delete from student where id=#{id}")
  int deleteStudent(int id);
}
