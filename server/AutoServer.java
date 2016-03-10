package server;
import java.io.*;
import exception.*;
import util.*;

public interface AutoServer {

	void userAutoProperties(Properties properties) throws IOException, ClassNotFoundException, FixProblems;
}
