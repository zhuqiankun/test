package process.pack.ns;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.app.Activity;
import android.os.Bundle;

public class ProcesstestActivity extends Activity {
    /** Called when the activity is first created. */

    private static List<RunningAppProcessInfo> procList;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        procList = new ArrayList<RunningAppProcessInfo>();
        ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        procList = activityManager.getRunningAppProcesses();
        EditText et = (EditText)findViewById(R.id.editText1);
        EditText et2 = (EditText)findViewById(R.id.editText2);
        for (Iterator<RunningAppProcessInfo> iterator = procList.iterator(); iterator.hasNext();) { 
        	RunningAppProcessInfo procInfo = iterator.next();
        	et.setText(procInfo.processName);
        	et2.setText("pid: "+procInfo.pid);
        	/*try {
        		Thread.sleep(100);
        	} catch (InterruptedException e) {
        		// TODO Auto-generated catch block
        		e.printStackTrace();
        	}*/
        }
        
    }
}