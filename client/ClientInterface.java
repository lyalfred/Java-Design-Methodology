package client;

import java.io.IOException;

public interface ClientInterface {

	
	boolean connection();
	void openSession();
	void closeSession() throws IOException;
}
