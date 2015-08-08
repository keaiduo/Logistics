package com.logistics.action;

import java.util.List;

import com.logistics.domain.Transport;
import com.logistics.service.ITransportService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class TransportAction extends BaseAction implements
		ModelDriven<Transport> {
	
	private Transport transport;
	private ITransportService transportService;

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

	public void setTransportService(ITransportService transportService) {
		this.transportService = transportService;
	}


	@Override
	public Transport getModel() {
		// TODO Auto-generated method stub
		return this.transport;
	}
	
	public String add() throws Exception{
		boolean flag = this.transportService.add(transport);
		return flag ? Action.SUCCESS : Action.ERROR;		
	}
	
	public String findAll() throws Exception{
		List<Transport> lstTransports = this.transportService.findAll();
		System.out.println("lstTransports>>=="+lstTransports.toString());
		this.getRequest().setAttribute("lstTransports", lstTransports);
		return Action.SUCCESS;
		
	}
	
	public String search() throws Exception{
		//获取页面参数
		String str1 = this.getRequest().getParameter("tno");
		String str2 = this.getRequest().getParameter("tgsdh");	
		String str3 = this.getRequest().getParameter("tthch");
		System.out.println("str1>>"+str1+" str2>>"+str2+" str3>>"+str3);
		List<Transport> lstTransports = this.transportService.search(str1, str2, str3);
		this.getRequest().setAttribute("lstTransports", lstTransports);
		return Action.SUCCESS;		
	}
	
	public String transport_delete() throws Exception{
		System.out.println("delete method invoke");
		int tid = Integer.parseInt(this.getRequest().getParameter("tid"));
		System.out.println("tid>>>"+tid);
		boolean flag = this.transportService.del(tid);
		return flag? Action.SUCCESS : Action.ERROR;		
	}

	public String  transport_edit() throws Exception
	{
		System.out.println("edit method invoke");
		int tid = Integer.parseInt(this.getRequest().getParameter("tid"));
		System.out.println("tid>>"+tid);
		Transport transport = this.transportService.findById(tid);
		this.getRequest().setAttribute("transport", transport);
		boolean flag = this.transportService.edit(tid);
		return flag? Action.SUCCESS : Action.ERROR;
	}
	
	public String  transport_update() throws Exception
	{
		System.out.println("update method invoke");
		int tid = Integer.parseInt(this.getRequest().getParameter("tid"));
		transport.setTid(tid);
		boolean flag = this.transportService.update(transport);
		return flag? Action.SUCCESS : Action.ERROR;
	}
	
	public void setBizlist(Transport transport) {
		this.transport = transport;
	}

	
}
