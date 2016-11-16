package org.apache.ws.axis2;

import java.rmi.RemoteException;

import org.apache.ws.axis2.OperatorStub;
import org.apache.ws.axis2.OperatorStub.Add;

public class Testing {

	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub

		OperatorStub classstub = new OperatorStub();
		
		Add a = new Add();
		
		a.setA(100);
		a.setB(14);
		
		System.out.println(classstub.add(a).get_return());
		
		}

}
