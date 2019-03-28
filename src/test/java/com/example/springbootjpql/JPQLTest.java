package com.example.springbootjpql;

import com.example.springbootjpql.entity.Address;
import com.example.springbootjpql.entity.User;
import com.example.springbootjpql.entity.UserAddress;
import com.example.springbootjpql.repository.AddressRepository;
import com.example.springbootjpql.repository.UserAddressRepository;
import com.example.springbootjpql.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class JPQLTest {

    @Autowired
    UserRepository ur;

    @Autowired
    AddressRepository ar;

    @Autowired
    UserAddressRepository uar;

    @Test
    public void initData(){
        //添加user
        User u1=new User("李逵");
        ur.save(u1);
        User u2=new User("宋江");
        ur.save(u2);
        User u3=new User("吴用");
        ur.save(u3);
        User u4=new User("西门庆");
        ur.save(u4);

        //添加address
        Address a1=new Address("深圳");
        ar.save(a1);
        Address a2=new Address("沈阳");
        ar.save(a2);
        Address a3=new Address("北京");
        ar.save(a3);
        Address a4=new Address("哈尔滨");
        ar.save(a4);

        //添加useraddress
        UserAddress ua1=new UserAddress(u1,a1);
        uar.save(ua1);
        UserAddress ua2=new UserAddress(u1,a2);
        uar.save(ua2);
        UserAddress ua3=new UserAddress(u2,a3);
        uar.save(ua3);
        UserAddress ua4=new UserAddress(u3,a3);
        uar.save(ua4);
        UserAddress ua5=new UserAddress(u1,a1);
        uar.save(ua5);
    }

    @Test
    public void userRepositoryTest(){
        User user=ur.getUserById(1);
        log.debug("id："+user.getId()+"；姓名:"+user.getName()+";插入时间："+user.getInsertTime());
    }

    @Test
    public void addressRepositoryTest(){
        ar.getAddressesByDetail("深圳").
                forEach(address -> log.debug("id:"+address.getId()+";detail:"+address.getDetail()));
    }

    @Test
    public void userAddressRepositoryTest(){
        UserAddress ua=uar.getUserAddress("李逵","深圳");
        log.debug("id:"+ua.getId()+";user:"+ua.getUser().getName()+";address:"+ua.getAddress().getDetail()+";插入时间:"+ua.getInsertTime());
    }
}
