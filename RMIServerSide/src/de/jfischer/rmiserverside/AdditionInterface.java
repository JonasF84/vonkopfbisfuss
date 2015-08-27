package de.jfischer.rmiserverside;

import java.rmi.*;

public interface AdditionInterface extends Remote {
	public int add(int a, int b) throws RemoteException;

}
