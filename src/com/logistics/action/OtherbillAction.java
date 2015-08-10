package com.logistics.action;

import java.util.List;

import com.logistics.domain.Otherbill;
import com.logistics.service.IOtherbillService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class OtherbillAction extends BaseAction implements
		ModelDriven<Otherbill> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Otherbill otherbill;
	private IOtherbillService otherbillService;
	
	public void setOtherbill(Otherbill otherbill) {
		this.otherbill = otherbill;
	}

	public void setOtherbillService(IOtherbillService otherbillService) {
		this.otherbillService = otherbillService;
	}

	@Override
	public Otherbill getModel() {
		// TODO Auto-generated method stub
		return this.otherbill;
	}
	public String otherbill_add() throws Exception{
		boolean flag = this.otherbillService.add(otherbill);
		return flag? Action.SUCCESS : Action.ERROR;
		
	}
	
	public String otherbill_findAll() throws Exception{
		List<Otherbill> lstOtherbills = this.otherbillService.findAll();
		System.out.println("lstOtherbills>>=="+lstOtherbills);
		this.getRequest().setAttribute("lstOtherbills", lstOtherbills);
		return Action.SUCCESS;
	}
	
	public String otherbill_search() throws Exception{
		String str1 = this.getRequest().getParameter("odate");
		String str2 = this.getRequest().getParameter("obiz");
		String str3 = this.getRequest().getParameter("obroker");
		System.out.println("str1>>"+str1+"str2"+str2+"str3"+str3);
		List<Otherbill> lstOtherbills = this.otherbillService.search(str1, str2, str3);
		this.getRequest().setAttribute("lstOtherbills", lstOtherbills);
		return Action.SUCCESS;
	}	
	
	public String otherbill_delete() throws Exception{
		System.out.println("delete method invoke");
		int oid = Integer.parseInt(this.getRequest().getParameter("oid"));
		System.out.println("oid>>>"+oid);
		boolean flag = this.otherbillService.del(oid);
		return flag ? Action.SUCCESS : Action.ERROR;		
	}
	
	public String otherbill_edit() throws Exception{
		System.out.println("edit method invoke");
		int oid = Integer.parseInt(this.getRequest().getParameter("oid"));
		System.out.println("oid>>>"+oid);
		Otherbill otherbill = this.otherbillService.findById(oid);
		this.getRequest().setAttribute("otherbill", otherbill);
		boolean flag = this.otherbillService.edit(oid);
		return flag ? Action.SUCCESS : Action.ERROR;
		
	}
	
	public String otherbill_update() throws Exception
	{
		System.out.println("update method invoke");
		int oid = Integer.parseInt(this.getRequest().getParameter("oid"));
		otherbill.setOid(oid);
		boolean flag = this.otherbillService.update(otherbill);
		return flag? Action.SUCCESS : Action.ERROR;
	}
	
	
	

}
