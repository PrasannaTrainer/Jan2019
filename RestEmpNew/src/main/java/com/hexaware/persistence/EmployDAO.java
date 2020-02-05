package com.hexaware.persistence;
import com.hexaware.model.Employ;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import com.hexaware.persistence.EmployMapper;
/**
 * EmployDAO class used to fetch data from data base.
 * @author hexware
 */
public interface EmployDAO {
     /**
     * @return the all the Employ record.
     */
    @SqlUpdate("Insert INTO EMPLOY(Empno, Name,Dept,"
    + " Desig, Basic) VALUES(:empno,:name,:dept,"
    + ":desig,:basic)")
    int addEmploy(@BindBean Employ employ);

     /**
     * @return the all the Employ record.
     */
    @SqlQuery("SELECT E.Empno, E.Name, E.Dept,"
    + " E.Desig, E.Basic FROM EMPLOY E;")
    @Mapper(EmployMapper.class)
    List<Employ> show();
    /**
     * @return the Employ record.
     * @param empno for employ No.
     */
    @SqlQuery("SELECT * FROM EMPLOY WHERE Empno=:empno")
    @Mapper(EmployMapper.class)
    Employ show(@Bind("empno") int empno);
}