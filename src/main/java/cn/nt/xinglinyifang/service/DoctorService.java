package cn.nt.xinglinyifang.service;


import cn.nt.xinglinyifang.model.Doctor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

/**
 * @author 74123
 */
public class DoctorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DoctorService.class);

    private DoctorService() {}

    /**
     * 私有构造方法，使用getInstance()方法创建对象
     * @return Doctor的对象
     */
    public static DoctorService getInstance() {
        return new DoctorService();
    }

    /**
     * 向表中插入一条医生记录
     * @param name 姓名
     * @param nation 民族
     * @param birthday 生日
     * @param sex 性别 男true；女 false
     * @param age 年龄
     * @param company 从业单位
     * @param position 职位
     * @param address 家庭地址
     * @param tel 联系电话
     * @param numDay 日接诊量
     * @param numYear 年接诊量
     * @param influence 影响力
     * @param glory 所获荣誉
     * @param field 擅长领域
     * @param education 学历
     * @param mqc 存放从医资格证的图片地址
     */
    public void insertDoctor(String name, String nation, LocalDate birthday, boolean sex, int age, String company,
                              String position, String address, String tel, int numDay, int numYear, String influence,
                              String glory, String field, String education, String mqc) {

        Doctor doc = new Doctor().set("birthday", birthday).set("num_day", numDay).set("education", education)
                .set("nation", nation).set("sex", sex).set("addres", address).set("medical_qualification_certificate", mqc)
                .set("influence", influence).set("glory", glory).set("field", field).set("name", name).set("company", company)
                .set("tel", tel).set("position", position).set("num_year", numYear).set("age", age);

        doc.save();
    }

    /**
     * 根据id获取医师的记录
     * @param id id
     * @return Doctor对象
     */
    public Doctor getById(int id) {
        return Doctor.dao.findById(id);
    }

}
