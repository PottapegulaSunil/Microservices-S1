package com.payroll.attendance.respository;



import java.util.List;


import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.payroll.attendance.entity.Attendance;



@Repository(value="attendanceRepository")
@Scope(value="singleton")
public interface AttendanceRespository extends JpaRepository<Attendance,Integer>
{
	List<Attendance> findByEmpid (Integer empid);

}
