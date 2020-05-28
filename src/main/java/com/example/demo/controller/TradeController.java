package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.container.Time;
import com.example.demo.controller.container.TradeSize;
import com.example.demo.controller.parameter.PSellerTimeBuyerTime2Us;
import com.example.demo.controller.parameter.PSellerTimeUs;
import com.example.demo.controller.parameter.PShowPageUs;
import com.example.demo.controller.parameter.PUs;
import com.example.demo.dao.BuyRepository;
import com.example.demo.dao.BuyXRepository;
import com.example.demo.dao.SellRepository;
import com.example.demo.dao.SellXRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.dao.container.Buy;
import com.example.demo.dao.container.BuyKey;
import com.example.demo.dao.container.BuyX;
import com.example.demo.dao.container.SellKey;
import com.example.demo.dao.container.SellX;

@RestController
@CrossOrigin("http://localhost:8081")
public class TradeController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private SellRepository sellRepository;
	@Autowired
	private SellXRepository sellXRepository;
	@Autowired
	private BuyRepository buyRepository;
	@Autowired
	private BuyXRepository buyXRepository;
	@RequestMapping("/getTradeSize")
	public TradeSize getTradeSize(@RequestBody PUs p) {
		String us=p.getUs();
		try {
			userRepository.findById(us).get().toString();
			TradeSize temp=new TradeSize();
			temp.setZ1(sellRepository.countBy交易状态("公开"));
			temp.setZ2(sellRepository.countBy交易状态And用户Or交易状态And用户("公开",us,"审核",us));
			temp.setZ3(sellRepository.countBy交易状态And用户("打回",us));
			temp.setZ4(buyRepository.countBy申请状态And买家("申请",us));
			temp.setZ5(buyRepository.countBy申请状态And买家("失效",us));
			temp.setZ6(buyRepository.countBy买家And申请状态Or卖家And申请状态(us,"完成",us,"完成"));
			return temp;
		}catch(Exception e) {
			return null;
		}
	}
	@RequestMapping("/getTradeTable1")
	public List<?> getTradeTable1(@RequestBody PShowPageUs p) {
		int show=p.getShow();
		int page=p.getPage();
		String us=p.getUs();
		try {
			userRepository.findById(us).get().toString();
			return sellRepository.findBy交易状态OrderBy创建时间Desc("公开", PageRequest.of(show, page));
		}catch(Exception e) {
			return null;
		}
	}
	@RequestMapping("/getTradeTable2")
	public List<?> getTradeTable2(@RequestBody PShowPageUs p) {
		int show=p.getShow();
		int page=p.getPage();
		String us=p.getUs();
		try {
			userRepository.findById(us).get().toString();
			return sellRepository.findBy交易状态And用户Or交易状态And用户OrderBy创建时间Desc("公开", us, "审核", us, PageRequest.of(show, page));
		}catch(Exception e) {
			return null;
		}
	}
	@RequestMapping("/getTradeTable3")
	public List<?> getTradeTable3(@RequestBody PShowPageUs p) {
		int show=p.getShow();
		int page=p.getPage();
		String us=p.getUs();
		try {
			userRepository.findById(us).get().toString();
			return sellRepository.findBy交易状态And用户OrderBy创建时间Desc("打回", us, PageRequest.of(show, page));
		}catch(Exception e) {
			return null;
		}
	}
	@RequestMapping("/getTradeTable4")
	public List<?> getTradeTable4(@RequestBody PShowPageUs p) {
		int show=p.getShow();
		int page=p.getPage();
		String us=p.getUs();
		try {
			userRepository.findById(us).get().toString();
			List<Buy> temp=buyRepository.findBy申请状态And买家OrderBy申请时间Desc("申请", us, PageRequest.of(show, page));
			for(int i=0;i<temp.size();i++) {
				temp.get(i).set交易标题(sellRepository.findById(new SellKey(temp.get(i).get卖家(),temp.get(i).get创建时间())).get().get交易标题());
			}
			return temp;
		}catch(Exception e) {
			return null;
		}
	}
	@RequestMapping("/getTradeTable5")
	public List<?> getTradeTable5(@RequestBody PShowPageUs p) {
		int show=p.getShow();
		int page=p.getPage();
		String us=p.getUs();
		try {
			userRepository.findById(us).get().toString();
			List<Buy> temp=buyRepository.findBy申请状态And买家OrderBy申请时间Desc("失效", us, PageRequest.of(show, page));
			for(int i=0;i<temp.size();i++) {
				temp.get(i).set交易标题(sellRepository.findById(new SellKey(temp.get(i).get卖家(),temp.get(i).get创建时间())).get().get交易标题());
			}
			return temp;
		}catch(Exception e) {
			return null;
		}
	}
	@RequestMapping("/getTradeTable6")
	public List<?> getTradeTable6(@RequestBody PShowPageUs p) {
		int show=p.getShow();
		int page=p.getPage();
		String us=p.getUs();
		try {
			userRepository.findById(us).get().toString();
			List<Buy> temp=buyRepository.findBy买家And申请状态Or卖家And申请状态OrderBy申请时间Desc(us, "完成", us, "完成", PageRequest.of(show, page));
			for(int i=0;i<temp.size();i++) {
				temp.get(i).set交易标题(sellRepository.findById(new SellKey(temp.get(i).get卖家(),temp.get(i).get创建时间())).get().get交易标题());
			}
			return temp;
		}catch(Exception e) {
			return null;
		}
	}
	@RequestMapping("/getSellItem")
	public SellX getSellItem(@RequestBody PSellerTimeUs p) {
		String seller=p.getSeller();
		String time=p.getTime();
		String us=p.getUs();
		try {
			userRepository.findById(us).get().toString();
			return sellXRepository.findById(new SellKey(seller,time)).get();
		}catch(Exception e) {
			return null;
		}
	}
	@RequestMapping("/getBuyItemList1")
	public List<?> getBuyItemList1(@RequestBody PSellerTimeUs p) {
		String seller=p.getSeller();
		String time=p.getTime();
		String us=p.getUs();
		try {
			userRepository.findById(us).get().toString();
			return buyXRepository.findBy创建时间And卖家And申请状态OrderBy申请时间Desc(time, seller, "完成");
		}catch(Exception e) {
			return null;
		}
	}
	@RequestMapping("/getBuyItemList2")
	public List<?> getBuyItemList2(@RequestBody PSellerTimeUs p) {
		String seller=p.getSeller();
		String time=p.getTime();
		String us=p.getUs();
		try {
			userRepository.findById(us).get().toString();
			List temp=buyXRepository.findBy创建时间And卖家And申请状态OrderBy申请时间Desc(time, seller, "申请");
			temp.addAll(buyXRepository.findBy创建时间And卖家And申请状态OrderBy申请时间Desc(time, seller, "完成"));
			return temp;
		}catch(Exception e) {
			return null;
		}
	}
	@RequestMapping("/getBuyItemList3")
	public List<?> getBuyItemList3(@RequestBody PSellerTimeUs p) {
		String seller=p.getSeller();
		String time=p.getTime();
		String us=p.getUs();
		try {
			userRepository.findById(us).get().toString();
			return buyXRepository.findBy创建时间And卖家OrderBy申请时间Desc(time, seller);
		}catch(Exception e) {
			return null;
		}
	}
	@RequestMapping("/getBuyItem")
	public List<?> getBuyItem(@RequestBody PSellerTimeBuyerTime2Us p) {
		String seller=p.getSeller();
		String time=p.getTime();
		String buyer=p.getBuyer();
		String time2=p.getTime2();
		String us=p.getUs();
		try {
			userRepository.findById(us).get().toString();
			List temp= new ArrayList();
			temp.add(buyXRepository.findById(new BuyKey(seller,time,buyer,time2)).get());
			return temp;
		}catch(Exception e) {
			return null;
		}
	}
	
	
	
	//以上为查
	
	
	
	
	
	//以下为改
	
	
	@RequestMapping("/addBuyItem")
	public boolean addBuyItem(@RequestBody BuyX p) {
		try {
			userRepository.findById(p.UserKey()).get().toString();
			if(!(p.UserKey()+"").equals(p.get买家()))throw new Exception();
			p.set申请时间(Time.getTime());
			p.set申请状态("申请");
			buyXRepository.save(p);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	@RequestMapping("/setBuyItem")
	public boolean setBuyItem(@RequestBody BuyX p) {
		try {
			userRepository.findById(p.UserKey()).get().toString();
			if(!((p.UserKey()+"").equals(p.get买家())||(p.UserKey()+"").equals(p.get卖家())))throw new Exception();
			buyXRepository.save(p);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	@RequestMapping("/rmvBuyItem")
	public boolean rmvBuyItem(@RequestBody BuyX p) {
		try {
			userRepository.findById(p.UserKey()).get().toString();
			if(!(p.UserKey()+"").equals(p.get买家()))throw new Exception();
			buyXRepository.delete(p);
			删除检测(p.get卖家(),p.get创建时间());
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	@RequestMapping("/addSellItem")
	public boolean addSellItem(@RequestBody SellX p) {
		p.set创建时间(Time.getTime());
		p.set交易状态("审核");
		return setSellItem(p);
	}
	@RequestMapping("/setSellItem")
	public boolean setSellItem(@RequestBody SellX p) {
		try {
			userRepository.findById(p.UserKey()).get().toString();
			if(!(p.UserKey()+"").equals(p.get用户()))throw new Exception();
			p.set交易状态("审核");
			sellXRepository.save(p);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	@RequestMapping("/rmvSellItem")
	public boolean rmvSellItem(@RequestBody SellX p) {
		try {
			userRepository.findById(p.UserKey()).get().toString();
			if(!(p.UserKey()+"").equals(p.get用户()))throw new Exception();
			删除检测2(p.get用户(),p.get创建时间());
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	//删除买
	private void 删除检测(String 用户,String 创建时间) {
		if(buyXRepository.countBy卖家And创建时间(用户,创建时间)==0)
			if("完成".equals(sellXRepository.findById(new SellKey(用户,创建时间)).get().get交易状态()))
				sellXRepository.deleteById(new SellKey(用户,创建时间));
			
	}
	//删除卖
	private void 删除检测2(String 用户,String 创建时间) {
		if(buyXRepository.countBy创建时间And卖家(创建时间,用户)==0) {
			sellXRepository.deleteById(new SellKey(用户,创建时间));
		}else {
			SellX temp2=sellXRepository.findById(new SellKey(用户,创建时间)).get();
			temp2.set交易状态("完成");
			sellXRepository.save(temp2);
			List<BuyX> temp=buyXRepository.findBy创建时间And卖家And申请状态(创建时间,用户,"申请");
			for(int i=0;i<temp.size();i++) {
				temp.get(i).set申请状态("失效");
			}
			buyXRepository.saveAll(temp);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	//审核
	@RequestMapping("/getShenHeTable")
	public List<?> getShenHeTable(@RequestBody PShowPageUs p) {
		int show=p.getShow();
		int page=p.getPage();
		String us=p.getUs();
		try {
			if(!((userRepository.findById(us).get().get权限()+"").equals("管理员")||(userRepository.findById(us).get().get权限()+"").equals("审核")))
				throw new Exception();
			return sellRepository.findBy交易状态OrderBy创建时间Desc("审核", PageRequest.of(show, page));
		}catch(Exception e) {
			return null;
		}
	}
	@RequestMapping("/setShenHeItem")
	public boolean setShenHeItem(@RequestBody SellX p) {
		String us=p.UserKey();
		try {
			if(!((userRepository.findById(us).get().get权限()+"").equals("管理员")||(userRepository.findById(us).get().get权限()+"").equals("审核")))
				throw new Exception();
			sellXRepository.save(p);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	@RequestMapping("/getShenHeSize")
	public int getShenHeSize(@RequestBody PUs p) {
		String us=p.getUs();
		try {
			userRepository.findById(us).get().toString();
			return sellRepository.countBy交易状态("审核");
		}catch(Exception e) {
			return 0;
		}
	}
	/*@RequestMapping("/getTable2")
	public List login2() {
		Sell s=new Sell();
		s.set用户("Admin");
		s.set创建时间("2020-05-22 17:00:02");
		s.set交易状态("公开");
		s.set交易标题("标题122");
		sellRepository.save(s);
		return sellRepository.findBy交易状态OrderBy创建时间("公开", PageRequest.of(1, 2));
	}*/
}
