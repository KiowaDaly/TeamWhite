
public class SplashScreenDriver {
	private TeamWhiteSplashScreen screen;
	
	public SplashScreenDriver() {
		screen = new TeamWhiteSplashScreen();
		screen.setLocationRelativeTo(null);
		screen.setMaxProgress(1000);
		screen.setVisible(true);
		
		for(int i=0;i<=1000;i++) {
			for(int j=0;j<=100000;j++) {
				String t = "ewf"+(i+j);
			}
			screen.setprogress(i);
		}
		screen.setVisible(false);
	}
}
