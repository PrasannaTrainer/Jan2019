package com.hexaware.FTP115.model;

 import com.hexaware.FTP115.persistence.EmployeeDAO;
// import com.hexaware.FTP115.persistence.LeaveDetails;
 import com.hexaware.FTP115.persistence.LeaveDetailsDAO;
// import com.hexaware.FTP115.model.LeaveType;
// import com.hexaware.FTP115.model.LeaveStatus;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;

import java.util.ArrayList;

/**
 * Test class for Employee.
 */
@RunWith(JMockit.class)
public class LeaveDetailsTest {

  /**
   * setup method.
   */
  @Before
  public void initInput() {

  }
  /**
  * Tests the default constructors methods of the Leave details class.
  */
   /**
  default Constructor.
  */
  @Test
  public final void testDefaultConstructor() {
    LeaveDetails l1 = new LeaveDetails();
    assertNotNull(l1);
    LeaveDetails l2 = null;
    assertNull(l2);
  }
   /**
  * Tests the Parameterized Constructors and Get/Set methods of the employee class.
  * @throws ParseException in case there is an error in converting data.
  */
  @Test
  public final void testParamConstructor() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String s1 = "1998-12-12";
    Date s = sdf.parse(s1);
    String s2 = "1998-12-12";
    Date e = sdf.parse(s2);
    String s3 = "1998-12-10";
    Date l = sdf.parse(s3);
    LeaveDetails l1 = new LeaveDetails(1, 4, s, e, LeaveType.EL, "sick", l, LeaveStatus.APPROVED, "Enjoy", 20);
    assertEquals(1, l1.getLeaId());
    assertEquals(4, l1.getLeaNoOfDays());
    assertEquals(s, l1.getLeaStDate());
    assertEquals(e, l1.getLeaEndDate());
    assertEquals(LeaveType.EL, l1.getLeaType());
    assertEquals("sick", l1.getLeaReas());
    assertEquals(l, l1.getLeaAppOn());
    assertEquals(LeaveStatus.APPROVED, l1.getLeaStatus());
    assertEquals("Enjoy", l1.getLeaMngCmts());
    assertEquals(20, l1.getLeaEmpId());
    LeaveDetails l2 = new LeaveDetails();
    l2.setLeaId(3);
    assertEquals(3, l2.getLeaId());
    l2.setLeaNoOfDays(3);
    assertEquals(3, l2.getLeaNoOfDays());
    l2.setLeaStDate(s);
    assertEquals(s, l2.getLeaStDate());
    l2.setLeaEndDate(e);
    assertEquals(e, l2.getLeaEndDate());
    l2.setLeaType(LeaveType.EL);
    assertEquals(LeaveType.EL, l2.getLeaType());
    l2.setLeaReas("sick");
    assertEquals("sick", l2.getLeaReas());
    l2.setLeaAppOn(l);
    assertEquals(l, l2.getLeaAppOn());
    l2.setLeaStatus(LeaveStatus.APPROVED);
    assertEquals(LeaveStatus.APPROVED, l2.getLeaStatus());
    l2.setLeaMngCmts("Enjoy");
    assertEquals("Enjoy", l2.getLeaMngCmts());
    l2.setLeaEmpId(24);
    assertEquals(24, l2.getLeaEmpId());
    LeaveDetails l4 = new LeaveDetails(1, 4, s, e, LeaveType.EL, "sick", l, LeaveStatus.APPROVED, "Enjoy", 20);
    LeaveDetails l5 = new LeaveDetails(1, 4, s, e, LeaveType.EL, "sick", l, LeaveStatus.APPROVED, "Enjoy", 20);
    assertEquals(l4.hashCode(), l5.hashCode());
    assertEquals(l4, l5);
    LeaveDetails l6 = null;
    assertNotEquals(l4, l6);
    Employee e108 = new Employee();
    assertNotEquals(l4, e108);
    assertNotEquals(l4, l2);
    String res = " LeaId:1 LeaNoOfDays: 4 LeaveStartDate: 1998-12-12"
        + "  leaEndDate: 1998-12-12 LeaType: EL LeaReason: sick"
        + " LeaAppOn: 1998-12-10 LeaStatus: APPROVED LeaMngCmt: Enjoy EmpLeaveID: 20";
    assertEquals(res, l4.toString());
    LeaveDetailsDAO ldao = LeaveDetails.dao();
    assertNotNull(ldao);

    EmployeeDAO ledao = LeaveDetails.edao();
    assertNotNull(ledao);
  }
  /**
  * tests that empty employee list is handled correctly.
  * @param dao mocking the dao class.
  * @throws ParseException for parsing Date to String.
  */
  @Test
  public final void testListAllSome(@Mocked final LeaveDetailsDAO dao) throws ParseException {
    final ArrayList<LeaveDetails> arLeaveHistory1 = new ArrayList<LeaveDetails>();
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final String s1 = "1998-12-12";
    final Date s = sdf.parse(s1);
    final String s2 = "1998-12-12";
    final Date e = sdf.parse(s2);
    final String s3 = "1998-12-10";
    final Date l = sdf.parse(s3);
    arLeaveHistory1.add(new LeaveDetails(1, 4, s, e, LeaveType.EL, "sick", l, LeaveStatus.APPROVED, "Enjoy", 1));
    arLeaveHistory1.add(new LeaveDetails(2, 4, s, e, LeaveType.EL, "sick", l, LeaveStatus.APPROVED, "Enjoy", 1));
    arLeaveHistory1.add(new LeaveDetails(3, 4, s, e, LeaveType.EL, "sick", l, LeaveStatus.APPROVED, "Enjoy", 1));
    final ArrayList<LeaveDetails> arLeaveHistory2 = new ArrayList<LeaveDetails>();
    arLeaveHistory2.add(new LeaveDetails(4, 4, s, e, LeaveType.EL, "sick", l, LeaveStatus.APPROVED, "Enjoy", 2));
    arLeaveHistory2.add(new LeaveDetails(5, 4, s, e, LeaveType.EL, "sick", l, LeaveStatus.APPROVED, "Enjoy", 2));
    new Expectations() {
      {
        dao.leaveHistory(1); result = arLeaveHistory1;
        dao.leaveHistory(2); result = arLeaveHistory2;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    LeaveDetails[] es1 = LeaveDetails.listAll(1);
    assertEquals(3, es1.length);
    LeaveDetails[] es2 = LeaveDetails.listAll(2);
    assertEquals(2, es2.length);
  }


  /**
  * tests that empty employee list is handled correctly.
  * @param dao mocking the dao class.
  * @throws ParseException for parsing Date to String.
  */
  @Test
  public final void testListPendingSome(@Mocked final LeaveDetailsDAO dao) throws ParseException {
    final ArrayList<LeaveDetails> arpending1 = new ArrayList<LeaveDetails>();
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final String s1 = "1998-12-12";
    final Date s = sdf.parse(s1);
    final String s2 = "1998-12-12";
    final Date e = sdf.parse(s2);
    final String s3 = "1998-12-10";
    final Date l = sdf.parse(s3);
    arpending1.add(new LeaveDetails(1, 4, s, e, LeaveType.EL, "sick", l, LeaveStatus.PENDING, "Enjoy", 1));
    arpending1.add(new LeaveDetails(2, 4, s, e, LeaveType.EL, "sick", l, LeaveStatus.PENDING, "Enjoy", 1));
    arpending1.add(new LeaveDetails(3, 4, s, e, LeaveType.EL, "sick", l, LeaveStatus.PENDING, "Enjoy", 1));
    final ArrayList<LeaveDetails> arpending2 = new ArrayList<LeaveDetails>();
    arpending2.add(new LeaveDetails(4, 4, s, e, LeaveType.EL, "sick", l, LeaveStatus.PENDING, "Enjoy", 2));
    arpending2.add(new LeaveDetails(5, 4, s, e, LeaveType.EL, "sick", l, LeaveStatus.PENDING, "Enjoy", 2));
    new Expectations() {
      {
        dao.pending(1); result = arpending1;
        dao.pending(2); result = arpending2;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    LeaveDetails[] es1 = LeaveDetails.listPending(1);
    assertEquals(3, es1.length);
    LeaveDetails[] es2 = LeaveDetails.listPending(2);
    assertEquals(2, es2.length);
  }
  /**
  * @param edao for mocking EmployeeDAO class.
  * @param ldao for mocking LeaveDetailsDAO class.
  * @throws ParseException for converting date to string.
   */
  @Test
  public final void testApplyLeave(@Mocked final EmployeeDAO edao, @Mocked final LeaveDetailsDAO ldao)
      throws ParseException {
     Employee e = new Employee(100, "Bhuvaneswari", "Bhuvi@gmail.com", "8872134444", doj, "FTP", 0, 12);
     Employee e2 = new Employee(200, "Omkar", "omkar@gmail.com", "8872134444", doj, "FTP", 100, 12);
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final String s1 = "1998-12-12";
    final Date doj = sdf.parse(s1);
    final Date today = new Date();
    final String strToday = sdf.format(today);
    new Expectations() {
      {
        ldao.count(100, "2020-04-16", "2020-04-17"); result = 1;
        ldao.count(100, "2020-04-30", "2020-04-30"); result = 0;
        ldao.count(200, "2020-04-30", "2020-04-30"); result = 0;
      }
    };
    new Expectations() {
      {
        ldao.insert(1, "2020-04-30", "2020-04-30", LeaveType.EL, "sick", strToday, LeaveStatus.APPROVED, 100);
        ldao.insert(1, "2020-04-30", "2020-04-30", LeaveType.EL, "sick", strToday, LeaveStatus.PENDING, 200);
      }
    };
    new Expectations() {
      {
        edao.find(100); result = e;
        edao.find(200); result = e2;
        edao.find(500); result = null;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return ldao;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return edao;
      }
    };
    String res1 = LeaveDetails.applyLeave(100, "2020-04-20", "2020-04-21", 2, LeaveType.EL, "sick");
    assertEquals(res1, "StartDate cannot be Saturday or sunday...");
    String res2 = LeaveDetails.applyLeave(100, "2020-04-16", "2020-04-17", 2, LeaveType.EL, "sick");
    assertEquals(res2, "Already Applied on Given Date...");
    String res3 = LeaveDetails.applyLeave(100, "2020-04-30", "2020-04-30", 1, LeaveType.EL, "sick");
    assertEquals(res3, "Leave Autoapproved...");
    String res4 = LeaveDetails.applyLeave(100, "2020-03-18", "2020-03-20", 2, LeaveType.EL, "sick");
    assertEquals(res4, "enter correct number of days as...3");
    String res5 = LeaveDetails.applyLeave(100, "2020-04-18", "2020-05-18", 3, LeaveType.EL, "sick");
    assertEquals(res5, "Insufficient Leave balance");
    String res6 = LeaveDetails.applyLeave(100, "2020-01-28", "2020-05-30", 2, LeaveType.EL, "sick");
    assertEquals(res6, "Insufficient Leave balance");
    String res7 = LeaveDetails.applyLeave(500, "2020-05-30", "2020-05-30", 2, LeaveType.EL, "sick");
    assertEquals(res7, "Employee ID not found");
    String res8 = LeaveDetails.applyLeave(200, "2020-04-30", "2020-04-30", 1, LeaveType.EL, "sick");
    assertEquals(res8, "Leave Applied successfully");
    String res9 = LeaveDetails.applyLeave(200, "2020-04-18", "2020-04-14", 1, LeaveType.EL, "sick");
    assertEquals(res9, "EndDate must be greater than StartDate..");
    String res10 = LeaveDetails.applyLeave(200, "2020-02-06", "2020-02-06", 1, LeaveType.EL, "sick");
    assertEquals(res10, "start date is less than current date");
  }
  /**
   * @param edao1 for mocking dao class.
   * @param ldao1 for mocking dao class.
   * @throws ParseException for null values.
   */

  @Test
  public final void testApproveDeny(@Mocked final EmployeeDAO edao1, @Mocked final LeaveDetailsDAO ldao1)
  throws ParseException {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final String s1 = "1998-12-12";
    final Date doj = sdf.parse(s1);
    final String s = "2020-08-08";
    final Date stdate = sdf.parse(s);
    final String endate = "2020-08-08";
    final Date edate = sdf.parse(endate);
    final Date today = new Date();
    final Employee ep = new Employee(100, "Bhuvaneswari", "Bhuvi@gmail.com", "8872134444", doj, "FTP", 200, 12);
    final LeaveDetails d = new LeaveDetails(1, 2, stdate, edate, LeaveType.EL,
                           "sick", today, LeaveStatus.PENDING, "good", 100);
    new Expectations() {
      {
        ldao1.listById(1); result = d;
        ldao1.listById(-1); result = null;
      }
    };
    new Expectations() {
      {
        edao1.find(100); result = ep;
      }
    };
    new Expectations() {
      {
        ldao1.approveDeny(1, "APPROVED", "good");
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return edao1;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return ldao1;
      }
    };
    String res1 = LeaveDetails.approveDeny(1, 200, "YES", "good");
    assertEquals(res1, "Leave Approved Successfully...");
    String res2 = LeaveDetails.approveDeny(1, 10, "YES", "good");
    String res3 = LeaveDetails.approveDeny(1, 200, "NO", "no");
    assertEquals(res2, "You are unauthorized to approve the Leave");
    assertEquals(res3, "Leave Rejected");
    String res4 = LeaveDetails.approveDeny(-1, 200, "YES", "good");
    assertEquals(res4, "Leave ID is not present!");
  }
}


