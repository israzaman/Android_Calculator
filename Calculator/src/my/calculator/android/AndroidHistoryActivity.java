package my.calculator.android;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import android.widget.Toast;

public class AndroidHistoryActivity extends Activity {

    TextView textviewhistory;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.history);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		textviewhistory=(TextView)findViewById(R.id.history_text_view);
		textviewhistory.setMovementMethod(new ScrollingMovementMethod());

		readfile();

	}
	public void readfile()
	{
		String filename="internalMemory";
		try {
            FileInputStream fin = openFileInput(filename);
            int c;
            String temp="";
            while( (c = fin.read()) != -1){
               temp = temp + Character.toString((char)c);
            }
            textviewhistory.setText(temp);
		}
		catch(Exception e){
        }
	}
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}

}
