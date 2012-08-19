package buet.threebyzero.autoSecuritySystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.os.Environment;
import android.util.Log;

public class SaveImage {

	String state;
	boolean Write, Read;
	File file = null;
	File path = null;
	private String dateForPic;
	private String timeForPic;
	private InputStream is;
	private String hostname="10.0.2.2";
	private Socket client;
	private int port=5554;

	public SaveImage() {
		// TODO Auto-generated constructor stub
		try {
			client = new Socket(hostname, port);
			is = client.getInputStream();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		path = Environment
				.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
		checkState();		
		save_Image();
		Log.d("message", is.toString());
	}

	private void checkState() {
		// TODO Auto-generated method stub
		state = Environment.getExternalStorageState();
		if (state.equals(Environment.MEDIA_MOUNTED)) {
			// read and write
			Write = Read = true;

		} else if (state.equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {
			// read but can't write

			Write = false;
			Read = true;

		} else {

			Write = Read = false;
		}
	}

	public void save_Image() {

		dateForPic = new SimpleDateFormat("yyyyMMdd").format(new Date());
		timeForPic = new SimpleDateFormat("HHmmss").format(new Date());

		String f = dateForPic + '_' + timeForPic;

		file = new File(path, f + ".JPG");

		checkState();
		if (Write == Read == true) {

			path.mkdirs();

			try {
				// is = getResources().openRawResource(
				// R.drawable.ic_launcher);
				OutputStream os = new FileOutputStream(file);
				byte[] data = new byte[is.available()];
				is.read(data);
				os.write(data);
				is.close();
				os.close();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
			} catch (IOException e) {
				// TODO Auto-generated catch block

			}
		}
	}

}
