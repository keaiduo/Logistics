package com.logistics.util;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;

import com.logistics.domain.Profit;

public class ProfitExportUtil {

	private SessionFactory sessionFactory;
	
	/**
	 * ���ݹ�˾������ʼ���ںͽ�������ɸѡ����
	 * @param companyName
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<Profit> getProfit(String companyName, String startDate,
			String endDate) {
		String hql = "select b.*,t.* from bizlist as b join transport as t on b.orderno=t.tgsdh";
		boolean judge = false;
		if (companyName != null && !companyName.trim().equals("")) {
			hql += " where bizlist.companyname = '" + companyName + "'";
			judge = true;
		}
		boolean judge2 = false;
		if (startDate != null && !startDate.trim().equals("")) {
			if (judge) {
				hql += " and bizlist.startdate >= '" + startDate + "'";
				judge = false;
				judge2 = true;
			} else {
				hql += " where bizlist.startdate >= '" + startDate + "'";
				judge = true;
				judge2 = true;
			}
		}
		if (endDate != null && !endDate.trim().equals("")) {
			if (judge || judge2) {
				hql += " and bizlist.startdate <= '" + endDate + "'";
				judge = false;
			} else {
				hql += " where bizlist.startdate <= '" + endDate + "'";
				judge = true;
			}
		}

		Session mySession = null;
		Query myQuery = null;
		try {
			mySession = sessionFactory.openSession();

			/*
			 * ���ڶ���ѯ���������ַ��� 1.���漰���Ķ�����ֱ�������Ȼ��ֱ�addEnity,Ȼ��Խ������ת����ת��Ϊ��Ӧ�Ķ��ʵ��(
			 * ��Щʵ������Ǿ���hibernate����ORMӳ���)
			 */

			/*
			 * List myProfitList=
			 * mySession.createSQLQuery(hql).addEntity("b",Bizlist
			 * .class).addEntity("t", Transport.class).list(); Iterator
			 * myIterator=myProfitList.iterator(); while(myIterator.hasNext()){
			 * Object[] myObjects=(Object[]) myIterator.next(); Bizlist
			 * myBizlit=(Bizlist) myObjects[0]; Transport myTrans=(Transport)
			 * myObjects[1]; System.out.println(myBizlit.toString());
			 * System.out.println(myTrans.toString()); }
			 */

			/**
			 * �ڶ��ַ�������ʹ��setResultTransformer�����������ݸ�ʽ��ת��,
			 * �������Խ����ӳ��Ϊδ��hibernate��ӳ�����ͨPOJO��
			 */
			List<Profit> myProfitList = mySession
					.createSQLQuery(hql)
					.setResultTransformer(
							Transformers.aliasToBean(Profit.class)).list();
		
			return myProfitList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (mySession != null)
				mySession.close();
		}
		return null;

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
