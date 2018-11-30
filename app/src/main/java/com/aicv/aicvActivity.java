package com.aicv;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;

import com.aicv.R;

public class aicvActivity extends Activity {
	private static final String TAG = "aicv";

	public String Filename = "aatestFile.txt";
	FileWriter writer;
	BufferedWriter out;
	File root;
	public File testFile;

	@Override
	/** onCreate() is called at start of activity */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState); //Met super.onCreate wordt onderstaande code bovenop/naast de eerste onCreate uitgevoerd.
		setContentView(R.layout.main_layout);
		root = Environment.getExternalStorageDirectory();
		testFile = new File(root, Filename);

		try {
			writer = new FileWriter(testFile);
			out = new BufferedWriter(writer);
			out.write("<?xml version='1.0' encoding='ISO-8859-1' standalone='yes'?>\n");
			out.write("<gpx\n");
			out.write("xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'\n");
			out.write("xmlns='http://www.topografix.com/GPX/1/1' version='1.1' creator='AndroidGPSTrack'\n");
			out.write("xsi:schemaLocation='http://www.topografix.com/GPX/1/1 http://www.topografix.com/GPX/1/1/gpx.xsd'>\n");
			out.close();
		} catch (IOException e) {
			Toast.makeText(getBaseContext(), "SD card not available.",
					Toast.LENGTH_SHORT).show();
		}
	}
}

//mMediaPlayer = MediaPlayer.create(this,R.raw.beep8); //Alarm
//commandArduino(cv_server_url + "/?cmd=CVuit");// start met uitgeschakelde CV

/*
	Switch btnPlus = (Switch) findViewById(R.id.button_plus);
	//Set a CheckedChange Listener for Switch Button
	btnPlus.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
	 @Override
	 public void onCheckedChanged(CompoundButton cb, boolean on){
	 if(on)
	  {
	   //Do something when Switch button is on/checked
		if (CVSTATE == true)
		 {
		  commandArduino(cv_server_url + "/?cmd=CVaan");
		  commandArduinoStatus(cv_server_url);
		  mMediaPlayer.start();
		  Long tsLong = System.currentTimeMillis()/1000;
		  String ts = tsLong.toString();
		  dataLog('1' + ';' + ts + ';' + '\n');
		  CVSTATE = false;
		 }
	  }
	  else
	  {
	   //Do something when Switch is off/unchecked
	   if (CVSTATE == false)
	    {
		  commandArduino(cv_server_url + "/?cmd=CVuit");
		  commandArduinoStatus(cv_server_url);
		  mMediaPlayer.start();
		  Long tsLong = System.currentTimeMillis()/1000;
		  String ts = tsLong.toString();
		  dataLog('0' + ';' + ts + ';' + '\n');
		  CVSTATE = true;
	     }
	  }
    }
  });
		  }
}

	//Scan naar connected BlueTooth devices
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	//Connect button van ander submenu kan vervallen
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle presses on the action bar items
		Intent serverIntent = null;
		switch (item.getItemId()) {
		case R.id.secure_connect_scan:
				// Launch the DeviceListActivity to see devices and do scan
				return true;
			case R.id.menu_settings:
		    		//startActivity(new Intent(this, Prefs.class));
		    		break;
		    case R.id.menu_exit:

				onDestroy();
		    		break;
			default: break;
		}
	 return super.onOptionsItemSelected(item);
	}

	//Start programma
	//@Override
	public void onStart(){
		super.onStart();

		//Intent data = null;
		SharedPreferences myPreference=PreferenceManager.getDefaultSharedPreferences(this);
	    SharedPreferences.Editor myPreferenceEditor = myPreference.edit();
        //commandArduino(cv_server_url + "/?cmd=CVuit");
        //Toast.makeText(this, " CV status: " + commandArduinoStatus(cv_server_url), Toast.LENGTH_LONG).show();
 	}

 /*
	@Override
	public void onResume() {
		super.onResume();
		autoUpdate = new Timer();
		autoUpdate.schedule(new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					public void run() {
						//if (commandArduino(cv_server_url)) CVSERVER = true;
						//else CVSERVER = false;
						//if ( (System.currentTimeMillis() >= noMoveTimer+cvOnTimer) && CVSTATE==true) cvOff();
					}
				});
			}
		}, 0, 1000); // updates each 1 secs
	}
*/
/*
	//@Override
	public void onPause() {
	super.onPause();
		Toast.makeText(this, " BT Pause Service Started", Toast.LENGTH_LONG).show();
	}
*/

/*
	@Override
	public void onStop() {
		super.onStop();
        commandArduino(cv_server_url + "/?cmd=CVuit");
		Toast.makeText(this, " CV uit", Toast.LENGTH_LONG).show();
	}
*/
/*
	@Override
	public void onDestroy() {
		super.onDestroy();
		//autoUpdate.cancel();
		finish();
		System.exit(0);
	}
*/

/*
	private final void setStatus(int resId) {
		final ActionBar actionBar = getActionBar();
		actionBar.setSubtitle(resId);
	}

	private final void setStatus(CharSequence subTitle) {
		final ActionBar actionBar = getActionBar();
		actionBar.setSubtitle(subTitle);
	}
*/

/*
	public String commandArduinoStatus(String url) {
		try {
			HttpClient httpclient = new DefaultHttpClient();
			//httpclient.execute(new HttpPost(url)); // was
			HttpPost method = new HttpPost(url);
			HttpResponse response = httpclient.execute(method);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				Toast.makeText(getApplicationContext(), "Response Arduino" + EntityUtils.toString(entity), Toast.LENGTH_SHORT).show();
				return EntityUtils.toString(entity);
			} else {
				Toast.makeText(getApplicationContext(), "No Response Arduino", Toast.LENGTH_SHORT).show();
				return "No string.";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return url;
	}
*/

/*
	//Functie om te communieren met arduino serv er die aan CV hangt
	public boolean commandArduino(String url) {
		try {
			HttpClient httpclient = new DefaultHttpClient();
			httpclient.execute(new HttpGet(url)); // was
			CVSERVER = true;
			Toast.makeText(getApplicationContext(), "CV OK", Toast.LENGTH_SHORT).show();
            commandArduinoStatus(cv_server_url);
			return true;
		 } catch (Exception e) {
			Toast.makeText(getApplicationContext(), "No Server available", Toast.LENGTH_SHORT).show();
			CVSERVER = false;
			return false;
		 }
	}
}//Mainactivity End
*/
