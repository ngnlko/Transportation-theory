package com.bgu.solutionof;

import android.R.bool;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Solution_out extends Activity {
	TextView test,textstart,solution,clarification;
	String value;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.solution);
	    
	    Intent intent = getIntent();
	    
	   String provider_inp;// = intent.getStringExtra("provider_inp");//������
	   String consumer_inp;// = intent.getStringExtra("consumer_inp");//�������
	    int n = intent.getIntExtra("n", 0 );
	    int m = intent.getIntExtra("m", 0);
	    int a = intent.getIntExtra("a", 0);
	    int b = intent.getIntExtra("b", 0);
	    int c = 0;
	    //int n = Integer.parseInt(intent.getStringExtra("n"));//���-�� �������
	   // int m = Integer.parseInt(intent.getStringExtra("m"));//���-�� ������
	    
		if (a != b)
			{
			
			
			Toast.makeText(this, "������ ��������", Toast.LENGTH_LONG).show();
			if (a<b)
			{	
				
				c = b-a;
				//intent.putExtra("provider_inp", ","+c);
				
				Toast.makeText(this, "�� ������� " + c + "\n �������", Toast.LENGTH_SHORT).show();
				
				provider_inp = intent.getStringExtra("provider_inp");//������
				consumer_inp = intent.getStringExtra("consumer_inp");//�������
				
				solution = (TextView) findViewById (R.id.textsolution2);
				solution.setText(provider_inp);
				
				solution.append(","+c);
				provider_inp = solution.getText().toString();
				
				n = n+1;//�������� ���������� ����������� �� 1
				
				String[] provider;
				String delimiter = ",";
				provider =new String[n];
				
				String[] consumer;
				consumer = new String[m];
				
				int i,j,sum=0,price,pc;;
				
				for (i=0;i<provider.length;i++)
					{
						provider = provider_inp.split(delimiter);
					}
				for (i=0;i<consumer.length;i++)
					{
						consumer = consumer_inp.split(delimiter);
					}
				
					
				
				textstart = (TextView) findViewById(R.id.textstart);
				
				
				
			    test = (TextView) findViewById(R.id.texttest);
			    test.setText("���������� �����������: " + n + "\n" 
			    		+ "���������� ������������: " +m);
			    
			   
			    
			    int mass[][] = new int[n][m];
			    
			    for(i=0;i<n;i++)
			    {
			    	for(j=0;j<m;j++)
			    	{
			    		if (Integer.parseInt(provider[i])>Integer.parseInt(consumer[j]))
			    			{
					    		mass[i][j]=Integer.parseInt(consumer[j]);
					    		int aa;
					    		aa = Integer.parseInt(provider[i])-Integer.parseInt(consumer[j]);
					    		provider[i]=""+aa;
					    		consumer[j]="0";
			    			}
			    		else
				    		{
				    			mass[i][j]=Integer.parseInt(provider[i]);
				    			int bb;
				    			bb = Integer.parseInt(consumer[j])-Integer.parseInt(provider[i]);
				    			consumer[j]=""+bb;
				    			provider[i]="0";
				    			
				    		}
			    	}
			    }
			    
			    

			    
			    for (i=0;i<n;i++)
			    {
			    	for (j=0;j<m;j++)
			    	{
			    		textstart.append(mass[i][j]+" ");
			
			    		//textstart.append("\n");
			    	}
			    	textstart.append("\n");
			    }
			    clarification = (TextView) findViewById(R.id.clarification);
			    clarification.setText("��� ��� ������ �������� ��������, ������� � � ��������� ����.\n��� �������� ��� ���� ��������� � ��������� ������� = " + c );
			    
			}
			else if (b<a) //���� �������� ������ �������
			{
				c = a-b;
				//intent.putExtra("consumer_inp", ","+c);
				
				Toast.makeText(this, "�� ������� " + c + "\n ��������", Toast.LENGTH_SHORT).show();

				
				provider_inp = intent.getStringExtra("provider_inp");//������
				consumer_inp = intent.getStringExtra("consumer_inp");//�������
				
				solution = (TextView) findViewById (R.id.textsolution2);
				solution.setText(consumer_inp);
				
				solution.append(","+c);
				consumer_inp = solution.getText().toString();
				
				String[] provider;
				String delimiter = ",";
				provider =new String[n];
				m=m+1;
				String[] consumer;
				consumer = new String[m];
				
				int i,j,sum=0,price,pc;;
				
				for (i=0;i<provider.length;i++)
					{
						provider = provider_inp.split(delimiter);
					}
				for (i=0;i<consumer.length;i++)
					{
						consumer = consumer_inp.split(delimiter);
					}
				

				
				textstart = (TextView) findViewById(R.id.textstart);
				
				solution = (TextView) findViewById (R.id.textsolution2);
				
			    test = (TextView) findViewById(R.id.texttest);
			    test.setText("���������� �����������: " + n + "\n" 
			    		+ "���������� ������������: " +m);
			    
			   
			    
			    int mass[][] = new int[n][m];
			    
			    for(i=0;i<n;i++)
			    {
			    	for(j=0;j<m;j++)
			    	{
			    		if (Integer.parseInt(provider[i])>Integer.parseInt(consumer[j]))
			    			{
					    		mass[i][j]=Integer.parseInt(consumer[j]);
					    		int aa;
					    		aa = Integer.parseInt(provider[i])-Integer.parseInt(consumer[j]);
					    		provider[i]=""+aa;
					    		consumer[j]="0";
			    			}
			    		else
				    		{
				    			mass[i][j]=Integer.parseInt(provider[i]);
				    			int bb;
				    			bb = Integer.parseInt(consumer[j])-Integer.parseInt(provider[i]);
				    			consumer[j]=""+bb;
				    			provider[i]="0";
				    			
				    		}
			    	}
			    }
			    
			    

			    
			    for (i=0;i<n;i++)
			    {
			    	for (j=0;j<m;j++)
			    	{
			    		textstart.append(mass[i][j]+" ");
			
			    		//textstart.append("\n");
			    	}
			    	textstart.append("\n");
			    }
				
				
			}
			
		    clarification = (TextView) findViewById(R.id.clarification);
		    clarification.setText("��� ��� ������ �������� ��������, ������� � � ��������� ����.\n��� �������� ��� ���� ����������� � ��������� �������� = " + c );
				
				
			}
	else
		{
		
		Toast.makeText(this, "������ ��������", Toast.LENGTH_LONG).show();
			
		   provider_inp = intent.getStringExtra("provider_inp");//������
		   consumer_inp = intent.getStringExtra("consumer_inp");//�������  
	    
		String[] provider;
		String delimiter = ",";
		provider =new String[n];
		
		String[] consumer;
		consumer = new String[m];
		
		int i,j,sum=0,price,pc;;
		
		for (i=0;i<provider.length;i++)
			{
				provider = provider_inp.split(delimiter);
			}
		for (i=0;i<consumer.length;i++)
			{
				consumer = consumer_inp.split(delimiter);
			}
		

		
		textstart = (TextView) findViewById(R.id.textstart);
		
		solution = (TextView) findViewById (R.id.textsolution2);
		
	    test = (TextView) findViewById(R.id.texttest);
	    test.setText("���������� �����������: " + n + "\n" 
	    		+ "���������� ������������: " +m);
	    
	   
	    
	    int mass[][] = new int[n][m];
	    
	    for(i=0;i<n;i++)
	    {
	    	for(j=0;j<m;j++)
	    	{
	    		if (Integer.parseInt(provider[i])>Integer.parseInt(consumer[j]))
	    			{
			    		mass[i][j]=Integer.parseInt(consumer[j]);
			    		int aa;
			    		aa = Integer.parseInt(provider[i])-Integer.parseInt(consumer[j]);
			    		provider[i]=""+aa;
			    		consumer[j]="0";
	    			}
	    		else
		    		{
		    			mass[i][j]=Integer.parseInt(provider[i]);
		    			int bb;
		    			bb = Integer.parseInt(consumer[j])-Integer.parseInt(provider[i]);
		    			consumer[j]=""+bb;
		    			provider[i]="0";
		    			
		    		}
	    	}
	    }
	    
	    

	    
	    for (i=0;i<n;i++)
	    {
	    	for (j=0;j<m;j++)
	    	{
	    		textstart.append(mass[i][j]+" ");
	
	    		//textstart.append("\n");
	    	}
	    	textstart.append("\n");
	    }
	    
	    
	    
	    // ������� ���������
	    
	    //int summ[][] = new int [n][m];
	    	
	   /*
	    		
	    for (i=n;i>0;i--)
	    {
	    	for (j=m;j>0;j--)
	    	{
	    		
	    		AlertDialog.Builder alert = new AlertDialog.Builder(this);
		
				alert.setTitle("��������� ������");
				alert.setMessage("������� ��������� ��������� ����� ��� C" + i+j + " ������");
		
				// Set an EditText view to get user input 
				final EditText input = new EditText(this);
				alert.setView(input);
		
				alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int whichButton) {
				 value = input.getText().toString();

				 
				 // ������ � ������� ��� ����
				 }
				
				});
				
				//mass[i][j]=value;

				alert.show();
				//summ [i][j] =  Integer.parseInt(input.getText().toString());
				
				
			    for (i=0;i<n;i++)
			    {
			    	for (j=0;j<m;j++)
			    	{	
			    		pc = Integer.parseInt(input.getText().toString());
			    		price = mass[i][j];
			    		sum = sum + price*pc;
			    		//textstart.append("\n");
			    	}
			    	
			    }
			    

	    		
		    }
		   
		 }
	   // solution.setText(sum);
	     //
	      
	      */
	    
	}
	
	}


}
