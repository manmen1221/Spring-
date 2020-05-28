package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dao.container.SellX;
import com.example.demo.dao.container.SellKey;

public interface SellXRepository extends JpaRepository<SellX,SellKey>{
}
