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
	    
	   String provider_inp;// = intent.getStringExtra("provider_inp");//запасы
	   String consumer_inp;// = intent.getStringExtra("consumer_inp");//запросы
	    int n = intent.getIntExtra("n", 0 );
	    int m = intent.getIntExtra("m", 0);
	    int a = intent.getIntExtra("a", 0);
	    int b = intent.getIntExtra("b", 0);
	    int c = 0;
	    //int n = Integer.parseInt(intent.getStringExtra("n"));//кол-во поставщ
	   // int m = Integer.parseInt(intent.getStringExtra("m"));//кол-во потреб
	    
		if (a != b)
			{
			
			
			Toast.makeText(this, "Задача открытая", Toast.LENGTH_LONG).show();
			if (a<b)
			{	
				
				c = b-a;
				//intent.putExtra("provider_inp", ","+c);
				
				Toast.makeText(this, "Не хватает " + c + "\n запасов", Toast.LENGTH_SHORT).show();
				
				provider_inp = intent.getStringExtra("provider_inp");//запасы
				consumer_inp = intent.getStringExtra("consumer_inp");//запросы
				
				solution = (TextView) findViewById (R.id.textsolution2);
				solution.setText(provider_inp);
				
				solution.append(","+c);
				provider_inp = solution.getText().toString();
				
				n = n+1;//увеличим количество поставщиков на 1
				
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
			    test.setText("Количество поставщиков: " + n + "\n" 
			    		+ "Количество потребителей: " +m);
			    
			   
			    
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
			    clarification.setText("Так как задача является открытой, привели её к закрытому типу.\nБыл добавлен ещё один поставщик с фиктивным запасом = " + c );
			    
			}
			else if (b<a) //если запросов меньше запасов
			{
				c = a-b;
				//intent.putExtra("consumer_inp", ","+c);
				
				Toast.makeText(this, "Не хватает " + c + "\n запросов", Toast.LENGTH_SHORT).show();

				
				provider_inp = intent.getStringExtra("provider_inp");//запасы
				consumer_inp = intent.getStringExtra("consumer_inp");//запросы
				
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
			    test.setText("Количество поставщиков: " + n + "\n" 
			    		+ "Количество потребителей: " +m);
			    
			   
			    
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
		    clarification.setText("Так как задача является открытой, привели её к закрытому типу.\nБыл добавлен ещё один потребитель с фиктивным запросом = " + c );
				
				
			}
	else
		{
		
		Toast.makeText(this, "Задача закрытая", Toast.LENGTH_LONG).show();
			
		   provider_inp = intent.getStringExtra("provider_inp");//запасы
		   consumer_inp = intent.getStringExtra("consumer_inp");//запросы  
	    
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
	    test.setText("Количество поставщиков: " + n + "\n" 
	    		+ "Количество потребителей: " +m);
	    
	   
	    
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
	    
	    
	    
	    // средняя стоимость
	    
	    //int summ[][] = new int [n][m];
	    	
	   /*
	    		
	    for (i=n;i>0;i--)
	    {
	    	for (j=m;j>0;j--)
	    	{
	    		
	    		AlertDialog.Builder alert = new AlertDialog.Builder(this);
		
				alert.setTitle("Заполните данные");
				alert.setMessage("Введите стоимость перевозки груза для C" + i+j + " клетки");
		
				// Set an EditText view to get user input 
				final EditText input = new EditText(this);
				alert.setView(input);
		
				alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int whichButton) {
				 value = input.getText().toString();

				 
				 // делаем с данными что либо
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
