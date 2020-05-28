package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dao.container.BuyX;
import com.example.demo.dao.container.BuyKey;

public interface BuyXRepository extends JpaRepository<BuyX,BuyKey> {
	public List<BuyX> findBy创建时间And卖家OrderBy申请时间Desc(String 创建时间,String 卖家);
	public List<BuyX> findBy创建时间And卖家And申请状态OrderBy申请时间Desc(String 创建时间,String 卖家,String 申请状态);
	public int countBy卖家And创建时间(String 卖家,String 创建时间);
	public List<BuyX> findBy创建时间And卖家And申请状态(String 创建时间,String 卖家,String 申请状态);
	public int countBy创建时间And卖家(String 创建时间,String 卖家);
}
