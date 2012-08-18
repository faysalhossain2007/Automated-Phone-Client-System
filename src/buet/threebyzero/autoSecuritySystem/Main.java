package buet.threebyzero.autoSecuritySystem;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Main extends Activity {
	private Button bObs;
	private Button bHistory;
	private Button bControl;
	private Button bSettings;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		dialog();
		initialize();
	}

	private void initialize() {
		// TODO Auto-generated method stub

		bObs = (Button) findViewById(R.id.btnObs);
		bControl = (Button) findViewById(R.id.btnCon);
		bHistory = (Button) findViewById(R.id.btnHis);
		bSettings = (Button) findViewById(R.id.btnSet);

		MouseClickListener l = new MouseClickListener();
		bObs.setOnClickListener(l);
		bControl.setOnClickListener(l);
		bHistory.setOnClickListener(l);
		bSettings.setOnClickListener(l);

	}

	private void dialog() {
		// TODO Auto-generated method stub
		AlertDialog.Builder newDialog = new AlertDialog.Builder(this);
		newDialog.setTitle(R.string.userDialog);

		newDialog.setItems(R.array.modes,
				new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int choice) {

						Intent startLogIntent = null;
						switch (choice) {
						case 0:
							startLogIntent = new Intent(getBaseContext(),
									Observation.class);
							break;
						case 1:
							startLogIntent = new Intent(getBaseContext(),
									Control.class);
							break;
						case 2:
							startLogIntent = new Intent(getBaseContext(),
									History.class);
							break;
						case 3:
							startLogIntent = new Intent(getBaseContext(),
									Settings.class);
							break;
						}
						if (startLogIntent != null)
							startActivity(startLogIntent);
					}
				});
		newDialog.show();

	}

	private class MouseClickListener implements OnClickListener {

		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btnCon:
				dialog();
				break;

			case R.id.btnHis:
				Intent two;
				two=new Intent();
				startActivity(two);
				break;

			case R.id.btnObs:
				Intent three;
				three=new Intent();
				startActivity(three);
				break;

			case R.id.btnSet:
				Intent four;
				four=new Intent();
				startActivity(four);
				break;

				
			}
		}
	}
}