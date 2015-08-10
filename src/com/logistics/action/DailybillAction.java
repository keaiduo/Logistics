package com.logistics.action;

import java.util.List;

import com.logistics.domain.Dailybill;
import com.logistics.service.IDailybillService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class DailybillAction extends BaseAction implements
		ModelDriven<Dailybill> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Dailybill dailybill;
	private IDailybillService dailybillService;	

	public Dailybill getDailybill() {
		return dailybill;
	}

	public void setDailybill(Dailybill dailybill) {
		this.dailybill = dailybill;
	}



	public IDailybillService getDailybillService() {
		return dailybillService;
	}

	public void setDailybillService(IDailybillService dailybillService) {
		this.dailybillService = dailybillService;
	}

	@Override
	public Dailybill getModel() {
		// TODO Auto-generated method stub		
		return this.dailybill;
	}
	
	public String dailybill_add() throws Exception{
		boolean flag = this.dailybillService.add(dailybill);
		return flag? Action.SUCCESS : Action.ERROR;
		
	}
	public String dailybill_findAll() throws Exception{
		List<Dailybill> lstDailybills = this.dailybillService.findAll();
		System.out.println("lstDailybills>>=="+lstDailybills);
		this.getRequest().setAttribute("lstDailybills", lstDailybills);
		return Action.SUCCESS;
	}
	
	public String dailybill_search() throws Exception{
		String str1 = this.getRequest().getParameter("ddate");
		String str2 = this.getRequest().getParameter("dorder");
		String str3 = this.getRequest().getParameter("dbroker");
		System.out.println("str1>>"+str1+"str2"+str2+"str3"+str3);
		List<Dailybill> lstDailybills = this.dailybillService.search(str1, str2, str3);
		this.getRequest().setAttribute("lstDailybills", lstDailybills);
		return Action.SUCCESS;
	}	
	
	public String dailybill_delete() throws Exception{
		System.out.println("delete method invoke");
		int did = Integer.parseInt(this.getRequest().getParameter("did"));
		System.out.println("did>>>"+did);
		boolean flag = this.dailybillService.del(did);
		return flag ? Action.SUCCESS : Action.ERROR;		
	}
	
	public String dailybill_edit() throws Exception{
		System.out.println("edit method invoke");
		int did = Integer.parseInt(this.getRequest().getParameter("did"));
		System.out.println("did>>>"+did);
		Dailybill dailybill = this.dailybillService.findById(did);
		this.getRequest().setAttribute("dailybill", dailybill);
		boolean flag = this.dailybillService.edit(did);
		return flag ? Action.SUCCESS : Action.ERROR;
		
	}
	
	public String  dailybill_update() throws Exception
	{
		System.out.println("update method invoke");
		int did = Integer.parseInt(this.getRequest().getParameter("did"));
		dailybill.setDid(did);
		boolean flag = this.dailybillService.update(dailybill);
		return flag? Action.SUCCESS : Action.ERROR;
	}
	

}
