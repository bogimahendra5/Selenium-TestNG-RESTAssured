package testautomation.qaengineer.utils;

public class TestUtility {
	public static void hardWait(int second) {
		try {
			Thread.sleep(1000*second);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
