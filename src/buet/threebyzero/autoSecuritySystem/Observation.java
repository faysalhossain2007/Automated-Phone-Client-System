package buet.threebyzero.autoSecuritySystem;

import android.app.Activity;
import android.os.Bundle;

public class Observation extends Activity{
	
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.observation);
	        new FileReceive();
	    }
}
