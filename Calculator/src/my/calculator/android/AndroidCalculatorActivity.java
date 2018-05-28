package my.calculator.android;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Selection;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AndroidCalculatorActivity extends Activity {
	/** Called when the activity is first created. */
	
	public int numlength=0;
	public int dotnumlength=0;
    public int dot=0;
    public String operator="";
    public int clickequal=0;
    public int clickmplus=0;
    public int clickmminus=0;
    public boolean clickmr=false;
	public String equalstring="";
	double result=0.0;
	public String Sharedpfmemory="";
	String operation="";
	float memoryval;
	String filename="internalMemory";
	FileOutputStream fos=null;
	
	SharedPreferences preference;
	
    TextView textview;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
        setContentView(R.layout.main);
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM, WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);

		final EditText edittext=(EditText)findViewById(R.id.edit_text_id);
        textview=(TextView)findViewById(R.id.text_View_id);

		final Button button0=(Button)findViewById(R.id.button_id0);
        button0.setOnClickListener(new View.OnClickListener() {
				
			public void onClick(View v) {
				// TODO Auto-generated method stub
				numlength=numlength+1;
				/*if(dot==1)
				{
					String text=edittext.getText().toString();
					String decimalnum=text.substring(text.indexOf(".")+1, text.length());
					dotnumlength=decimalnum.length();
					dotnumlength++;
					if(dotnumlength>10)
					{
						Toast.makeText(getApplicationContext(), R.string.decimalerror, Toast.LENGTH_SHORT).show();
					}
					else
					{
						edittext.append(getString(R.string.calcZero));
					}
				}
				else
				{*/
					if(numlength>15)
					{
						Toast.makeText(getApplicationContext(),R.string.numlengtherror, Toast.LENGTH_SHORT).show();
					}
					else
					{
						edittext.append(getString(R.string.calcZero));
					}
				//}
			}
		});
        
	    final Button button1=(Button)findViewById(R.id.button_id1);
        button1.setOnClickListener(new View.OnClickListener() {
				
			public void onClick(View v) {
				// TODO Auto-generated method stub

				numlength=numlength+1;
				/*if(dot==1)
				{
					String text=edittext.getText().toString();
					String decimalnum=text.substring(text.indexOf(".")+1, text.length());
                    dotnumlength=decimalnum.length();
					dotnumlength++;
					if(dotnumlength>10)
					{
						Toast.makeText(getApplicationContext(), R.string.decimalerror, Toast.LENGTH_SHORT).show();
					}
					else
					{
						edittext.append(getString(R.string.calcOne));
					}
				}
				else
				{*/
					if(numlength>15)
					{
						Toast.makeText(getApplicationContext(),R.string.numlengtherror, Toast.LENGTH_SHORT).show();
					}
					else
					{
						edittext.append(getString(R.string.calcOne));
					}
				//}
			}
		});
        
        final Button button2=(Button)findViewById(R.id.button_id2);
        button2.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				numlength=numlength+1;
				/*if(dot==1)
				{
					String text=edittext.getText().toString();
					String decimalnum=text.substring(text.indexOf(".")+1, text.length());
                    dotnumlength=decimalnum.length();
					dotnumlength++;
					if(dotnumlength>10)
					{
						Toast.makeText(getApplicationContext(), R.string.decimalerror, Toast.LENGTH_SHORT).show();
					}
					else
					{
						edittext.append(getString(R.string.calcTwo));
					}
				}
				else
				{*/
					if(numlength>15)
					{
						Toast.makeText(getApplicationContext(),R.string.numlengtherror, Toast.LENGTH_SHORT).show();
					}
					else
					{
						edittext.append(getString(R.string.calcTwo));
				
					}
				//}
			}
		});
        
        
        final Button button3=(Button)findViewById(R.id.button_id3);
        button3.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				numlength=numlength+1;
				/*if(dot==1)
				{
					String text=edittext.getText().toString();
					String decimalnum=text.substring(text.indexOf(".")+1, text.length());
                    dotnumlength=decimalnum.length();
					dotnumlength++;
					if(dotnumlength>10)
					{
						Toast.makeText(getApplicationContext(), R.string.decimalerror, Toast.LENGTH_SHORT).show();
					}
					else
					{
						edittext.append(getString(R.string.calcThree));
					}
				}
				else
				{*/
					if(numlength>15)
					{
						Toast.makeText(getApplicationContext(),R.string.numlengtherror, Toast.LENGTH_SHORT).show();
					}
					else
					{
						edittext.append(getString(R.string.calcThree));
					}
				//}
			}
		});
        
        final Button button4=(Button)findViewById(R.id.button_id4);
        button4.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				numlength=numlength+1;
				/*if(dot==1)
				{
					String text=edittext.getText().toString();
					String decimalnum=text.substring(text.indexOf(".")+1, text.length());
                    dotnumlength=decimalnum.length();
					dotnumlength++;
					if(dotnumlength>10)
					{
						Toast.makeText(getApplicationContext(), R.string.decimalerror, Toast.LENGTH_SHORT).show();
					}
					else
					{
						edittext.append(getString(R.string.calcFour));
					}
				}
				else
				{*/
					if(numlength>15)
					{
						Toast.makeText(getApplicationContext(), R.string.numlengtherror, Toast.LENGTH_SHORT).show();
					}
					else
					{
						edittext.append(getString(R.string.calcFour));
					}
				//}
			}
		});
        
        final Button button5=(Button)findViewById(R.id.button_id5);
        button5.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				numlength=numlength+1;
				/*if(dot==1)
				{
					String text=edittext.getText().toString();
					String decimalnum=text.substring(text.indexOf(".")+1, text.length());
                    dotnumlength=decimalnum.length();
					dotnumlength++;
					if(dotnumlength>10)
					{
						Toast.makeText(getApplicationContext(), R.string.decimalerror, Toast.LENGTH_SHORT).show();
					}
					else
					{
						edittext.append(getString(R.string.calcFive));
					}
				}
				else
				{*/
					if(numlength>15)
					{
						Toast.makeText(getApplicationContext(), R.string.numlengtherror, Toast.LENGTH_SHORT).show();
					}
					else
					{
						edittext.append(getString(R.string.calcFive));
					}
				//}
			}
		});
        
        final Button button6=(Button)findViewById(R.id.button_id6);
        button6.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				numlength=numlength+1;
				/*if(dot==1)
				{
					String text=edittext.getText().toString();
					String decimalnum=text.substring(text.indexOf(".")+1, text.length());
                    dotnumlength=decimalnum.length();
					dotnumlength++;
					if(dotnumlength>10)
					{
						Toast.makeText(getApplicationContext(), R.string.decimalerror, Toast.LENGTH_SHORT).show();
					}
					else
					{
						edittext.append(getString(R.string.calcSix));
					}
				}
				else
				{*/
					if(numlength>15)
					{
						Toast.makeText(getApplicationContext(), R.string.numlengtherror, Toast.LENGTH_SHORT).show();
					}
					else
					{
						edittext.append(getString(R.string.calcSix));
					}
				//}
			}
		});
        
        final Button button7=(Button)findViewById(R.id.button_id7);
        button7.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				numlength=numlength+1;
				/*if(dot==1)
				{
					String text=edittext.getText().toString();
					String decimalnum=text.substring(text.indexOf(".")+1, text.length());
                    dotnumlength=decimalnum.length();
					dotnumlength++;
					if(dotnumlength>10)
					{
						Toast.makeText(getApplicationContext(), R.string.decimalerror, Toast.LENGTH_SHORT).show();
					}
					else
					{
						edittext.append(getString(R.string.calcSeven));
					}
				}
				else
				{*/
					if(numlength>15)
					{
						Toast.makeText(getApplicationContext(), R.string.numlengtherror, Toast.LENGTH_SHORT).show();
					}
					else
					{
						edittext.append(getString(R.string.calcSeven));
					}
				//}
			}
		});
        
        final Button button8=(Button)findViewById(R.id.button_id8);
        button8.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				numlength=numlength+1;
				/*if(dot==1)
				{
					String text=edittext.getText().toString();
					String decimalnum=text.substring(text.indexOf(".")+1, text.length());
                    dotnumlength=decimalnum.length();
					dotnumlength++;
					if(dotnumlength>10)
					{
						Toast.makeText(getApplicationContext(), R.string.decimalerror, Toast.LENGTH_SHORT).show();
					}
					else
					{
						edittext.append(getString(R.string.calcEight));
					}
				}
				else
				{*/
					if(numlength>15)
					{
						Toast.makeText(getApplicationContext(), R.string.numlengtherror, Toast.LENGTH_SHORT).show();
					}
					else
					{
						edittext.append(getString(R.string.calcEight));
					}
				//}
			}
		});
        
        final Button button9=(Button)findViewById(R.id.button_id9);
        button9.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				numlength=numlength+1;
				/*if(dot==1)
				{
					String text=edittext.getText().toString();
					String decimalnum=text.substring(text.indexOf(".")+1, text.length());
                    dotnumlength=decimalnum.length();
					dotnumlength++;
					if(dotnumlength>10)
					{
						Toast.makeText(getApplicationContext(), R.string.decimalerror, Toast.LENGTH_SHORT).show();
					}
					else
					{
						edittext.append(getString(R.string.calcNine));
					}
				}
				else
				{*/
					if(numlength>15)
					{
						Toast.makeText(getApplicationContext(), R.string.numlengtherror, Toast.LENGTH_SHORT).show();
					}
					else
					{
						edittext.append(getString(R.string.calcNine));
					}
				//}
			}
		});
        
        final Button buttondot=(Button)findViewById(R.id.button_iddot);
        buttondot.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				String dotstring=edittext.getText().toString();
				
				int length=dotstring.length();
				if(TextUtils.isEmpty(dotstring))
				{
					edittext.append(getString(R.string.calcZero));
					edittext.append(getString(R.string.calcDot));
				}
				if(length>0)
				{					
					String lastchar = dotstring.substring(dotstring.length() - 1);
					if(lastchar.contains("+") || lastchar.contains("-") || lastchar.contains("×") || lastchar.contains("÷"))
					{
						edittext.append(getString(R.string.calcZero));
						edittext.append(getString(R.string.calcDot));
					}
					else if(dot==0)
					{
						edittext.append(getString(R.string.calcDot));
						dot=1;
					}					
				}									
			}
		});
        
        final Button buttonplus=(Button)findViewById(R.id.button_idplus);
        buttonplus.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				dotnumlength=0;
				int length=edittext.getText().length();
				String str=edittext.getText().toString();
				if(length>0)
				{
					String lastchar = str.substring(str.length() - 1);

					if(lastchar.contains("+") || lastchar.contains("-") || lastchar.contains("×") || lastchar.contains("÷"))
					{
						edittext.getText().delete(length-1, length);
						edittext.append(getString(R.string.calcPlus));
					}
					else
					{
						edittext.append(getString(R.string.calcPlus));
						operator="+";
                        dot=0;
                        numlength=0;
					}
				}				
			}
		});
        
        final Button buttonminus=(Button)findViewById(R.id.button_idminus);
        buttonminus.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				dotnumlength=0;
				int length=edittext.getText().length();
				String str=edittext.getText().toString();
				if(length>0)
				{
					String lastchar = str.substring(str.length() - 1);

					if(lastchar.contains("+") || lastchar.contains("-") || lastchar.contains("×") || lastchar.contains("÷"))
					{
						edittext.getText().delete(length-1, length);
						edittext.append(getString(R.string.calcMinus));
					}
					else
					{
						edittext.append(getString(R.string.calcMinus));
						operator="-";
						dot=0;
						numlength=0;
					}
				}
				
			}
		});
        
        final Button buttonmult=(Button)findViewById(R.id.button_idmult);
        buttonmult.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				dotnumlength=0;
				int length=edittext.getText().length();
				String str=edittext.getText().toString();
				if(length>0)
				{
					String lastchar = str.substring(str.length() - 1);

					if(lastchar.contains("+") || lastchar.contains("-") || lastchar.contains("×") || lastchar.contains("÷"))
					{
						edittext.getText().delete(length-1, length);
						edittext.append(getString(R.string.calcMult));
					}
					else
					{
						edittext.append(getString(R.string.calcMult));
						operator="×";
						dot=0;
						numlength=0;
					}
				}
				
			}
		});
        
        final Button buttondiv=(Button)findViewById(R.id.button_iddiv);
        buttondiv.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				dotnumlength=0;
				int length=edittext.getText().length();
				String str=edittext.getText().toString();
				if(length>0)
				{
					String lastchar = str.substring(str.length() - 1);

					if(lastchar.contains("+") || lastchar.contains("-") || lastchar.contains("×") || lastchar.contains("÷"))
					{
						edittext.getText().delete(length-1, length);
						edittext.append(getString(R.string.calcDiv));
					}
					else
					{
						edittext.append(getString(R.string.calcDiv));
						operator="÷";
						dot=0;
						numlength=0;
					}
				}
				
			}
		});
        
        final Button buttonequal=(Button)findViewById(R.id.button_ide);
        buttonequal.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				clickequal++;
				String exp=edittext.getText().toString();
				boolean valid=checkExp(exp);
				if(valid)
				{
					dotnumlength=0;
					if(clickequal==1)
					{
					    result=calculate(exp);
					    String rslt=String.valueOf(result);
						textview.setText(rslt);
						edittext.setText(rslt);
						equalstring=exp;
						saveInInternalStorage();
						if(rslt.contains("."))
						{
							dot=1;
						}
					}
					else if(clickequal>1)
					{
						String regex = "-?\\d+(\\.\\d+)?(E\\-?\\d+)?";
						if (!edittext.getText().toString().matches(regex))
						{
							result=calculate(exp);
						    String rslt=String.valueOf(result);
							textview.setText(rslt);
							edittext.setText(rslt);
							equalstring=exp;
							saveInInternalStorage();
							if(rslt.contains("."))
							{
								dot=1;
							}
						}
						else
						{
							if(operator=="+")
							{
								String last = equalstring.substring(equalstring.lastIndexOf(operator) + 1);
								result=result+Double.valueOf(last);
								edittext.setText(String.valueOf(result));
								textview.setText("");
							}
							else if(operator=="-")
							{
								String last = equalstring.substring(equalstring.lastIndexOf(operator) + 1);
								result=result-Double.valueOf(last);
								edittext.setText(String.valueOf(result));
								textview.setText("");
							}
							else if(operator=="×")
							{
								String last = equalstring.substring(equalstring.lastIndexOf(operator) + 1);
								result=result*Double.valueOf(last);
								edittext.setText(String.valueOf(result));
								textview.setText("");
							}
							else if(operator=="÷")
							{
								String last = equalstring.substring(equalstring.lastIndexOf(operator) + 1);
								result=result/Double.valueOf(last);
								edittext.setText(String.valueOf(result));
								textview.setText("");
							}
							if(String.valueOf(result).contains("."))
							{
								dot=1;
							}
						}
					}			
					edittext.setSelection(edittext.getText().toString().length());
				}
				else
				{
					Toast.makeText(getApplicationContext(), R.string.invalid, Toast.LENGTH_SHORT).show();
				}
			}
		});
        
        final Button buttonclr=(Button)findViewById(R.id.button_clear);
        buttonclr.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				numlength=0;
				clickequal=0;
				result=0.0;
				dot=0;
				edittext.setText("");
				textview.setText("");
			}
		});
        
        final Button buttondel=(Button)findViewById(R.id.button_del);
        buttondel.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				int length=edittext.getText().length();
				if(length>0)
				{
					if(length==1)
					{
						edittext.setText("");
					}
					else
					{
						edittext.getText().delete(length-1, length);
						String str=edittext.getText().toString();
						String lastchar = str.substring(str.length() - 1);
						if(lastchar.contains("."))
						{
							dot=0;
						}
					}
				}				
				textview.setText("");
			}
		});
        
        final Button buttonms=(Button)findViewById(R.id.button_ms);
        buttonms.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(edittext.getText().toString().length()!=0)
				{
					clickmplus=0;
					clickmminus=0;
					preference=getSharedPreferences(Sharedpfmemory,Context.MODE_WORLD_READABLE);					
					SharedPreferences.Editor editor=preference.edit();
					String str=edittext.getText().toString();
					float val=Float.valueOf(str);
					editor.putFloat("memory", val);
					editor.commit();
					}
			}
		});
        
        final Button buttonmr=(Button)findViewById(R.id.button_mr);
        buttonmr.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				preference=getSharedPreferences(Sharedpfmemory,Context.MODE_WORLD_READABLE);				
				float memoryrtv=preference.getFloat("memory", 0.0f);
				edittext.setText(String.valueOf(memoryrtv));
				clickmr=true;
			}
		});
        
        final Button buttonmplus=(Button)findViewById(R.id.button_mplus);
        buttonmplus.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				preference=getSharedPreferences(Sharedpfmemory,Context.MODE_WORLD_READABLE);				
				float memoryrtv=preference.getFloat("memory", 0.0f);
				if(clickmr==true)
				{
					clickmplus++;
					if(clickmplus==1)
					{
						memoryval=memoryrtv;
						memoryrtv+=memoryrtv;
						preference=getSharedPreferences(Sharedpfmemory,Context.MODE_WORLD_READABLE);						
						SharedPreferences.Editor editor=preference.edit();
						editor.putFloat("memory", memoryrtv);
						editor.commit();
						edittext.setText(String.valueOf(memoryrtv));												
					}
					else
					{
						memoryrtv+=memoryval;
						SharedPreferences.Editor editor=preference.edit();
						editor.putFloat("memory", memoryrtv);
						editor.commit();
						edittext.setText(String.valueOf(memoryrtv));									
					}
				}
			}
		});
        
        final Button buttonmminus=(Button)findViewById(R.id.button_mminus);
        buttonmminus.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				preference=getSharedPreferences(Sharedpfmemory,Context.MODE_PRIVATE);				
				float memoryrtv=preference.getFloat("memory", 0.0f);
				if(edittext.getText().toString().length()!=0)
				{
					clickmminus++;
					if(clickmminus==1)
					{
						memoryval=memoryrtv;
						memoryrtv-=memoryrtv;
						preference=getSharedPreferences(Sharedpfmemory,Context.MODE_WORLD_READABLE);						
						SharedPreferences.Editor editor=preference.edit();
						editor.putFloat("memory", memoryrtv);
						editor.commit();
						edittext.setText(String.valueOf(memoryrtv));												
					}
					else
					{
						memoryrtv-=memoryval;
						SharedPreferences.Editor editor=preference.edit();
						editor.putFloat("memory", memoryrtv);
						editor.commit();
						edittext.setText(String.valueOf(memoryrtv));									
					}
				}
				
			}
		});
        
        final Button buttonmc=(Button)findViewById(R.id.button_mc);
        buttonmc.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				SharedPreferences preferences = getSharedPreferences(Sharedpfmemory, 0);
				preferences.edit().remove("memory").commit();
				edittext.setText("");
			}
		});
        
        final Button buttonhistory=(Button)findViewById(R.id.button_history);
        buttonhistory.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent(AndroidCalculatorActivity.this, AndroidHistoryActivity.class);
				startActivity(i);
				
			}
		});
	}
	
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}
	
	 @Override
	 protected void onDestroy() {
	    // TODO Auto-generated method stub
	    super.onDestroy();
	 }
	 
	 public static boolean checkExp(String str)
	 {
	    String expression = "\\s*-?\\d+(\\.\\d+)?(E\\-?\\d+)?(\\s*[-+×%÷]\\s*-?\\d+(\\.\\d+)?)*\\s*";
	    Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(str);
	    return matcher.matches();
	 }
	 
	 public double calculate(String expression)
	    {

	        //remove white space and add evaluation operator
		    expression=expression.replace('×', '*');
		    expression=expression.replace('÷', '/');
	        expression=expression.replaceAll("[\t\n ]", "")+"=";
	        String operator="*/+-=";
	        //split up the operators from the values
	        StringTokenizer tokenizer=new StringTokenizer(expression, operator, true);
	        Stack operatorStack=new Stack();
	        Stack valueStack=new Stack();
	        String firstchar=expression.substring(0, 1);			
	        while(tokenizer.hasMoreTokens())
	        {
	            //add the next token to the proper stack
	            String token=tokenizer.nextToken();
	            if(firstchar.contains("-"))
				{
	            	  token=tokenizer.nextToken();
	            	  valueStack.push("-"+token);
	            	  firstchar="";
				}
	            else
	            {
		            if(operator.indexOf(token)<0)
		                valueStack.push(token);
		            else
		                operatorStack.push(token);
	            }
	            //perform any pending operations
	            resolve(valueStack, operatorStack);
	        }
	        //return the top of the value stack
	        String lastOne=(String)valueStack.pop();
	        return Double.parseDouble(lastOne);   
	    }
	        
	    public int getPriority(String op)
	    {
	        if(op.equals("*") || op.equals("/"))
	            return 1;
	        else if(op.equals("+") || op.equals("-"))
	            return 2;
	        else if(op.equals("="))
	            return 3;
	        else
	            return Integer.MIN_VALUE;
	    }
	    
	    public void resolve(Stack values, 
	            Stack operators)
	    {
	        while(operators.size()>=2)
	        {
	            String first=(String)operators.pop();
	            String second=(String)operators.pop();
	            if(getPriority(first)<getPriority(second))
	            {
	                operators.push(second);
	                operators.push(first);
	                return;
	            }
	            else
	            {
	                String firstValue=(String)values.pop();
	                String secondValue=(String)values.pop();
	                values.push(getResults(secondValue, second, firstValue));
	                operators.push(first);
	            }
	        }
	    }
	    
	    public String getResults(String operand1, String operator, String operand2)
	    {
	        double op1=Double.parseDouble(operand1);
	        double op2=Double.parseDouble(operand2);
	        if(operator.equals("*"))
	            return ""+(op1*op2);
	        else if(operator.equals("/"))
	            return ""+(op1/op2);
	        else if(operator.equals("+"))
	            return ""+(op1+op2);
	        else if(operator.equals("-"))
	            return ""+(op1-op2);
	        else
	            return null;
	    }
	    
	    public void saveInInternalStorage()
	    {
	    	SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yy\t\t\tHH:mm:ss");
	    	String currentDateandTime=sdf.format(Calendar.getInstance().getTime());
	    	
	    	operation=equalstring;
			if(operation.contains("×"))
			{
				operation=operation.replace("×", "*");
			}
			if(operation.contains("÷"))
			{
				operation=operation.replace("÷", "/");
			}
			String result=textview.getText().toString();
			try{
				fos=openFileOutput(filename,Context.MODE_APPEND);
			}
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}
			try
			{
				fos.write("\n".getBytes());
				fos.write(currentDateandTime.getBytes());
				fos.write("\n".getBytes());
				fos.write(operation.getBytes());
				fos.write("\n".getBytes());
				fos.write("=".getBytes());
				fos.write(result.getBytes());
				fos.write("\n".getBytes());
				fos.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();						
			}
	    
	    }

}