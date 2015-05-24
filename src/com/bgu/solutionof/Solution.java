package com.bgu.solutionof;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Solution extends Activity implements OnClickListener {
	Button next;
	EditText provider_inp,provider_n,consumer_n,consumer_inp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.solution_);
		
		
		next = (Button) findViewById(R.id.next);
		next.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.next:
			int n,m,i,a=0,b=0,c=0;
			provider_inp = (EditText) findViewById(R.id.provider); //������ �����������
			consumer_inp = (EditText) findViewById(R.id.consumer);	//������� �����������
			
			consumer_n = (EditText) findViewById(R.id.consumer_n); //���������� ������������
			provider_n = (EditText) findViewById(R.id.provider_n); //���������� ����������
			

			
			if(provider_inp.length()!=0 || consumer_inp.length()!=0 || consumer_n.length()!=0 || provider_n.length()!=0)
			{
				n = Integer.parseInt(provider_n.getText().toString());
				
				m = Integer.parseInt(consumer_n.getText().toString());
				
				String multiLines = provider_inp.getText().toString();
				String[] provider;
				String delimiter = ",";
				provider = new String[n];
				
				String multiLines_ = consumer_inp.getText().toString();
				String[] consumer;
				consumer = new String[m];
						
					for (i=0;i<provider.length;i++)
						{
							provider = multiLines.split(delimiter);
						}
					for (i=0;i<consumer.length;i++)
						{
						consumer = multiLines_.split(delimiter);
						}

				if (provider.length<n || provider.length>n || consumer.length<m || consumer.length>m)  //���������� �� ���������� ������� � ��������
				{	
					
					Toast.makeText(this, "������� �� ������ ���������� �������/" +
							"��������", Toast.LENGTH_LONG).show();
					break;
   
				}
				//����� ��� ������� ����� � ��������� ������
				else
				{
					//��� �������� ����������\���������� ������,��������� �������� ����������� � ������������,����� ����������
					for (i=0;i<provider.length;i++)
						{	
							
							a = a+Integer.parseInt(provider[i]);
							
						}
					
					for (i=0;i<consumer.length;i++)
						{
							b = b+Integer.parseInt(consumer[i]);
						}
					
				//Toast.makeText(this, "���������� ����������� " + n + " " +
					//	"������ �����������: " +a, Toast.LENGTH_LONG).show();
				

						
					
				      Intent intent = new Intent(this, Solution_out.class);
					
					
						intent.putExtra("provider_inp", multiLines);//������
						intent.putExtra("consumer_inp", multiLines_);//�������
						intent.putExtra("n", n); //���-�� �����������
						intent.putExtra("m", m); //���-�� ������
						intent.putExtra("a", a); //����� �������
						intent.putExtra("b", b); //����� �����������
						  
				      startActivity(intent);
				}
					
			}
			else
			{
				Toast.makeText(this, "��������� �� ��� ����", Toast.LENGTH_LONG).show();
				break;
			}
			break;
			
		}
	}

}
