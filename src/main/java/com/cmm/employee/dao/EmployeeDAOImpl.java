package com.cmm.employee.dao;

import java.util.List;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.TemporalType;

import org.apache.catalina.connector.Request;
import org.apache.tomcat.jni.Time;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.cmm.employee.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	public void saveEmployee(Employee theEmployee) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theEmployee);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {
		return sessionFactory.getCurrentSession().createQuery("from Employee").list();
	}

	public Employee getEmployee(int employee_id) {
		return (Employee) sessionFactory.getCurrentSession().get(Employee.class, employee_id);
	}

//	public void updateEmployee(Employee theEmployee) {
//		sessionFactory.getCurrentSession().saveOrUpdate(theEmployee);
//	}

	public void deleteEmployee(int id) {
		Employee employee = (Employee) sessionFactory.getCurrentSession().load(Employee.class, id);
		if (null != employee) {
			this.sessionFactory.getCurrentSession().delete(employee);
		}
	}

//	public Object getEmployeeName(String employee_name) {
//		String sql = "select employee_id,employee_name,date_of_birth,age,gender,note from Employee where employee_name like '%"
//				+ employee_name + "%'";
//		return (Employee) sessionFactory.getCurrentSession().get(sql, Employee.class);
//	}

	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeeNameForSearch(String employee_name, String gender){
		return sessionFactory.getCurrentSession().createQuery("from Employee where employee_name like '%"+employee_name+"%' or gender like '%"+gender+"%' ").list();
	}

	public boolean checkLogin(@RequestParam("employee_id")String employee_id, @RequestParam("password")String password) {
		System.out.println("In Check login");


		Session session = sessionFactory.openSession();
		boolean userFound = false;
		String SQL_QUERY ="select emp from Employee emp where emp.employee_id like :employee_id and emp.password like :password";
		Query query = sessionFactory.getCurrentSession().createQuery(SQL_QUERY);
		
		query.setParameter("employee_id", "%" + employee_id + "%");
		query.setParameter("password","%" + password + "%");
		List list = query.list();
		if ((list != null) && (list.size() > 0)) {
			userFound= true;
		}
		session.close();
		return userFound;   
	}

}
