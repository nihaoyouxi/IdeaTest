package WeiBiinMyBatisTest.dao;

import WeiBiinMyBatisTest.bean.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author WeiBin
 * @Create 2020-11-13 18:39
 */
public interface StudentDao {

    public List<Student> selectStudentes();

    public int insertStudent(Student stu);

    public Student selectStudentById(@Param("studentId") int id);

    public List<Student> selectStudentByStuIdAndClaId(@Param("studentId") int sid,@Param("classId") int cId);

    public List<Student> testSelect(String value);

}
