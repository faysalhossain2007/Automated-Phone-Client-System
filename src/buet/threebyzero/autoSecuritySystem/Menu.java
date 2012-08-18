package buet.threebyzero.autoSecuritySystem;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;



public class Menu extends ListActivity{
	
	
	String classes[] = { "Control", "Observation", "History", "Settings" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		// fullscreen
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setListAdapter(new ArrayAdapter<String>(Menu.this,
				android.R.layout.simple_list_item_1, classes));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String cheese = classes[position];
		try {

			Class ourClass = Class.forName("buet.threebyzero.autoSecuritySystem." + cheese);
			Intent ourIntent = new Intent(Menu.this, ourClass);
			startActivity(ourIntent);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}



	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.btnCon:
			Intent i = new Intent("buet.threebyzero.autoSecuritySystem.Control");
			startActivity(i);

			break;
		case R.id.btnHis:
			Intent p = new Intent("buet.threebyzero.autoSecuritySystem.History");
			startActivity(p);
			break;
		
		case R.id.btnObs:
			Intent q = new Intent("buet.threebyzero.autoSecuritySystem.Observation");
			startActivity(q);
			break;
		case R.id.btnSet:
			Intent r = new Intent("buet.threebyzero.autoSecuritySystem.Settings");
			startActivity(r);
		}
		return false;
	}

}
