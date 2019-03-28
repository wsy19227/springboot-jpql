package com.example.springbootjpql.repository;

import com.example.springbootjpql.entity.Address;
import com.example.springbootjpql.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface AddressRepository extends JpaRepository<Address, Integer> {

     //基于detail查询全部address
    @Query("select a FROM Address a WHERE a.detail=:detail")
    List<Address> getAddressesByDetail(@Param("detail") String detail);
}



