package ClientWorker;
import GUI.GUILogic;
import config.Configurations;

public class Main {
	//Starts public main method.
	
	public static void main(String[] args) {
		Configurations cf = new Configurations();
		
		cf.ReadFile();
		
		new GUILogic().run();
	}

}
