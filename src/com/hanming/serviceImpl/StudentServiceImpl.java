package com.hanming.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hanming.mapper.ServiceMapper;
import com.hanming.po.Joinclublog;
import com.hanming.po.PageInfo;
import com.hanming.po.Student;
import com.hanming.service.StudentService;
import com.hanming.util.IDPool;

@Service
public class StudentServiceImpl implements StudentService {

	@Resource
	private ServiceMapper serviceMapper;

	@Override
	public Student login(Student stu) {

		return serviceMapper.login(stu);
	}

	@Override
	public boolean signup(Student stu) {

		return serviceMapper.signup(stu);
	}

	@Override
	synchronized public String getMaxID() {
		// TODO Auto-generated method stub
		String xh = IDPool.get();
		if ("".equals(xh)) {
			IDPool.remove("");
			String id = serviceMapper.getMaxID();
			int num = IDPool.xh2Int(id);
			IDPool.MAX = num + 1;
			IDPool.add2Pool(IDPool.xh2String(num + 1));
			xh = IDPool.get();
		}
		return xh;
	}

	@Override
	public List<Object> getAllStudent() {
		return serviceMapper.getAllStudent();
	}

	@Override
	public boolean deleteStu(String sno) {

		return false;
	}

	@Override
	public boolean updateStudent(Student stu) {

		return false;
	}

	@Override
	public boolean save(Student stu) {

		return false;
	}

	@Override
	public List<Object> getDept() {
		return serviceMapper.getAllDept();
	}

	@Override
	public boolean changepwd(Student stu) {
		return serviceMapper.changepwd(stu);
	}

	@Override
	public boolean join(String date, String sid, String cid) {
		// 申请可能成功，可能失败
		Joinclublog joinclublog = new Joinclublog();
		joinclublog.setCid(cid);
		joinclublog.setSid(sid);
		if (!serviceMapper.alreadyin(joinclublog).isEmpty()) {
			System.out.println("该学生已加入该俱乐部或者已经申请过了");// 仅做测试
			return false;
		}
		joinclublog.setDate(date);
		return serviceMapper.join(joinclublog);
	}

	@Override
	public List<Object> myapplication(String sid) {
		return serviceMapper.myapplication(sid);
	}

	@Override
	public Integer getAppCount(String id) {
		return serviceMapper.myApplicationCount(id);
	}

	@Override
	public List<Object> myApplication(PageInfo pageInfo) {
		return serviceMapper.myApplication(pageInfo.getInfo(), (pageInfo.getPage() - 1) * pageInfo.getCount(),
				pageInfo.getCount());
	}
}
