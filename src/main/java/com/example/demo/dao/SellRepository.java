package com.example.demo.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dao.container.Sell;
import com.example.demo.dao.container.SellKey;

public interface SellRepository extends JpaRepository<Sell,SellKey>{
	public List<Sell> findBy交易状态OrderBy创建时间Desc(String 交易状态,Pageable pageable);
	public int countBy交易状态(String 交易状态);
	public List<Sell> findBy交易状态And用户Or交易状态And用户OrderBy创建时间Desc(String 交易状态,String 用户,String 交易状态2,String 用户2,Pageable pageable);
	public int countBy交易状态And用户Or交易状态And用户(String 交易状态,String 用户,String 交易状态2,String 用户2);
	public List<Sell> findBy交易状态And用户OrderBy创建时间Desc(String 交易状态,String 用户,Pageable pageable);
	public int countBy交易状态And用户(String 交易状态,String 用户);
}
