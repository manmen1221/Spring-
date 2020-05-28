package com.example.demo.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dao.container.Buy;
import com.example.demo.dao.container.BuyKey;

public interface BuyRepository extends JpaRepository<Buy,BuyKey> {
	public List<Buy> findBy申请状态And买家OrderBy申请时间Desc(String 交易状态,String 买家,Pageable pageable);
	public int countBy申请状态And买家(String 申请状态,String 买家);
	public List<Buy> findBy买家And申请状态Or卖家And申请状态OrderBy申请时间Desc(String 买家,String 申请状态,String 卖家,String 申请状态2,Pageable pageable);
	public int countBy买家And申请状态Or卖家And申请状态(String 买家,String 申请状态,String 卖家,String 申请状态2);
}
