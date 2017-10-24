import java.io.*;
import java.util.*;

public class sche
{
	
	boolean debug =false;
	// 3 rows for 3 diff hospitals
	// 7 columns for number of days a week
	ArrayList[][] scheduled = new ArrayList[3][7]; 
	
	ArrayList<String> main = new ArrayList<String>();
	//doctors
	person A   = null;
	person Ace = null;
	person C   = null;
	person DLH = null;
	person Jen = null;
	person Ju  = null;
	person Na  = null;
	
	//Array columns
	ArrayList<person> C00 = null;
	ArrayList<person> C01 = null;
	ArrayList<person> C02 = null;
	ArrayList<person> C03 = null;
	ArrayList<person> C04 = null;
	ArrayList<person> C05 = null;
	ArrayList<person> C06 = null;
                          
	ArrayList<person> C10 = null;
	ArrayList<person> C11 = null;
	ArrayList<person> C12 = null;
	ArrayList<person> C13 = null;
	ArrayList<person> C14 = null;
	ArrayList<person> C15 = null;
	ArrayList<person> C16 = null;
                        
	ArrayList<person> C20 = null;
	ArrayList<person> C21 = null;
	ArrayList<person> C22 = null;
	ArrayList<person> C23 = null;
	ArrayList<person> C24 = null;
	ArrayList<person> C25 = null;
	ArrayList<person> C26 = null;

	FileWriter pw = null;
	public sche()
	{
		File f = new File("log.txt");
		if(f.exists()) { f.delete();}
				
		mainWork(true);		
		mainWork(false);
		
		print();
	}
	
	public static void main(String[] args)
	{
		new sche();	
		
	}
	
	//bool = true, wed is single
	public void mainWork(boolean bool)
	{
		setUpScheduled();
		//C00 - Bixby - Julia, Naef, Cindy 
		//Monday 
		for(int a=0; a<3; a++)
		{
			person pa = null;
			if(a==0){pa = Ju;}
			if(a==1){pa = Na;}
			if(a==2){pa = C;}
			add(C00,pa);
			
			//Tuesday
			for(int b = 0; b<3; b++)
			{
				person pb = null;
				if(b==0){pb = Ju;}
				if(b==1){pb = Na;}
				if(b==2){pb = C;}
				add(C01,pb);
				
				//Wednesday
				for(int c = 0; c<3; c++)
				{
					//screw it, since I know all the possible combo for 3 entry just set it manually
					person pc = null;
					person pc2=null;
					if(c==0){pc = Ju; pc2 = Na;}
					if(c==1){pc = Ju; pc2 = C;}
					if(c==2){pc = Na; pc2 = C;}
					addPair(C02,pc, pc2);
							
						//Thursday		
						for(int d = 0; d<3; d++)
						{
							person pd = null;
							if(d==0){pd = Ju;}
							if(d==1){pd = Na;}
							if(d==2){pd = C;}
							add(C03,pd);
							//Friday
							for(int e = 0; e<3; e++)
							{
								person pe = null;
								if(e==0){pe = Ju;}
								if(e==1){pe = Na;}
								if(e==2){pe = C;}
								add(C04,pe);

			//Lakewood - Jen, DLH, Naef 
			//Monday
			for(int f=0; f<3; f++)
			{
				if(f==0){pc = Jen; pc2 = DLH;}
				if(f==1){pc = Jen; pc2 = Na;}
				if(f==2){pc = DLH; pc2 = Na;}
				addPair(C10,pc, pc2);
				
				//Tuesday
				for(int g=0; g<3; g++)
				{
					if(g==0){pc = Jen; pc2 = DLH;}
					if(g==1){pc = Jen; pc2 = Na;}
					if(g==2){pc = DLH; pc2 = Na;}
					addPair(C11,pc, pc2);
					
					//Wednesday
					for(int h=0; h<3; h++)
					{
						if(bool) { //wed is single
							if(h==0){pc = Jen; }
							if(h==1){pc = DLH;}
							if(h==2){pc = Na;}
							addSingle(C12,pc);	
						}
						else{
							if(h==0){pc = Jen; pc2 = DLH;}
							if(h==1){pc = Jen; pc2 = Na;}
							if(h==2){pc = DLH; pc2 = Na;}
							addPair(C12,pc, pc2);
						}
					
						//Thursday
						for(int i=0; i<3; i++)
						{
							if(!bool) { 
								if(i==0){pc = Jen; }
								if(i==1){pc = DLH;}
								if(i==2){pc = Na;}
								addSingle(C13,pc);	
							}
							else{
								if(i==0){pc = Jen; pc2 = DLH;}
								if(i==1){pc = Jen; pc2 = Na;}
								if(i==2){pc = DLH; pc2 = Na;}
								addPair(C13,pc, pc2);
							}
							//Friday
							for(int j=0; j<3; j++)
							{
								if(j==0){pc = Jen; pc2 = DLH;}
								if(j==1){pc = Jen; pc2 = Na;}
								if(j==2){pc = DLH; pc2 = Na;}
								addPair(C14,pc, pc2);
				
				//Lincoln
				//Monday -  Ace, Cindy
				for(int k=0; k<2; k++)
				{
					if(k==0){pc = Ace; }
					if(k==1){pc = C;}					
					addSingle(C20,pc);	
					//Tuesday
					for(int l=0; l<2; l++)
					{
						if(l==0){pc = Ace; }
						if(l==1){pc = C;}					
						addSingle(C21,pc);
						//skip Wednesday, Dr A is fixed
						//Thursday
						for(int m=0; m<2; m++)
						{
							if(m==0){pc = Ace; }
							if(m==1){pc = C;}					
							addSingle(C23,pc);
							//Friday
							for(int n=0; n<2; n++)
							{
								if(n==0){pc = Ace; }
								if(n==1){pc = C;}					
								addSingle(C24,pc);
								printLog();
							}							
						}
					}
					
				}
							}	
						}
					}
					
				}
				
			}
							}
						}
				}
			}	
		}
		
		
	}

	public void print()
	{
		try{
			if(!debug)
				pw = new FileWriter("log.txt", true);
			
			Collections.sort(main);
			for(int i=0; i<main.size(); i++)
			{
				logln(main.get(i));
			}
			
			if(!debug)
				pw.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public boolean workedToomuch()
	{
		boolean ret;
		ret = (Ace.daysWorked>4) | (C.daysWorked>4) | (DLH.daysWorked>4) | (Jen.daysWorked>4) | (Ju.daysWorked>4) | (Na.daysWorked>4) ; 
		return ret;
	}
	public void clearDaysWorked()
	{		
		Ace.setDaysWorked(1);
		C.setDaysWorked(1);
		DLH.setDaysWorked(0);
		Jen.setDaysWorked(1);
		Ju.setDaysWorked(1);
		Na.setDaysWorked(1);
	}
	
	public void log(String n)
	{
		
		try
		{
			if(!debug)
			{
				pw.write(n);
				
			}
			else
			{
				System.out.print(n);
			}
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void logln(String n)
	{
		
		try
		{
			if(!debug)
			{
				pw.write(n+"\n");
				
			}
			else
			{
				System.out.println(n);
			}
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void printLog()
	{
		try{			
			
		if(!workedToomuch()) { // don't add this permutation if a person worked more then 4 days
			
			String s = "";
			for(int i=0; i<3; i++) 
			{
				for(int j=0; j<7; j++)
				{
					ArrayList<person> blah = scheduled[i][j];
					
					sortByOrder(blah);   
					for(int z=0;z<blah.size();z++)
					{
						
						//System.out.print(blah.get(z).getFullName() + " - ") ;
						s = s+blah.get(z).getFullName()+"- ";							
						setUpWorkDays(blah.get(z), j);
					}
					//System.out.print(" | ");
					s = s+"|";
				}
				
				s = s+",";
			}	
			
			//At this point I should know all Drs and what day they work.
			if(checkWorkSameDay() && twoDaysOff())
			{
				main.add(formatString(s));
			}
			
			clearAllWorkDays();
			
		}
						
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
	}
	
	public String formatString(String s)
	{
		String ret = "";
		StringTokenizer st = new StringTokenizer(s,",");
		while (st.hasMoreElements()) 
		{						
			StringTokenizer st2 = new StringTokenizer(st.nextToken(),"|");			
			while(st2.hasMoreElements())
			{
				String str = st2.nextToken();
				str =  String.format("%1$20s", str) + "|";
				ret = ret + str;
			}
			ret = ret+"\n";
		}
				
		return ret;
	}
	/**
	 * since it's the outcome of all permutation and doctors can work different hospital
	 * there's a chance the same doctor work in 2 different hospital on the same day.
	 * Need to ignore those.
	 * @return false if a dr is working at 2 hospitals on the same day
	 */
	public boolean checkWorkSameDay()
	{
		boolean ret=true;
		
		
		for(int j=0; j<7; j++)
		{
			ArrayList<String> temp = new ArrayList<String>();
			for(int i=0; i<3 ; i++)
			{
				ArrayList<person> blah = scheduled[i][j];					
				for(int z=0;z<blah.size();z++)
				{
					person p = blah.get(z);
					if(!temp.contains(p.getName()))
					{
						temp.add(p.getName());
					}
					else//Already exist
					{
						ret = false;
						return ret;
					}
				}
			}
					
		}
		return ret;
	}
	
	/**
	 * 
	 * @return - True if all DR have 2 days off, meaning this permutation is legit.
	 */
	public boolean twoDaysOff()
	{	
		return Ace.twoConsequtiveDaysOff()
		&& C.twoConsequtiveDaysOff()
		&& DLH.twoConsequtiveDaysOff()
		&& Jen.twoConsequtiveDaysOff()
		&& Ju.twoConsequtiveDaysOff()
		&& Na.twoConsequtiveDaysOff();
		
	}
	
	//Mark which days this person worked
	// parameter j will tell me what day of the week.. 0- monday, 6 - Sunday.
	public void setUpWorkDays(person p, int j)
	{
		p.getWorkDays()[j] = true;
	}
	public void clearAllWorkDays()
	{		
		A.clearWorkDays();
		Ace.clearWorkDays();
		C.clearWorkDays(); 
		DLH.clearWorkDays();
		Jen.clearWorkDays();
		Ju.clearWorkDays(); 
		Na.clearWorkDays();
	}
	public void sortByOrder(ArrayList<person> blah)
	{
		Collections.sort(blah, new Comparator<person>() {
	        @Override public int compare(person p1, person  p2) {
	            return p1.getOrder()- p2.getOrder();
	        }

	 });
		
	}
	
	public void addSingle(ArrayList<person> a, person n)
	{
		if(a.size()>0)
		{
			a.get(0).removeDaysWorked();
			a.remove(0);
		}

		
		a.add(n);
		a.get(0).addDaysWorked();
		
	}
	
	public void addPair(ArrayList<person> a, person n, person n2)
	{
		//Remove all elements
		int size = a.size();
		for(int i=0; i<size; i++)
		{
			if(!a.get(0).isLock())
			{
				a.get(0).removeDaysWorked();
				a.remove(0);				
			}			
		}
		
		a.add(n);
		a.get(a.size()-1).addDaysWorked();
		
		a.add(n2);
		a.get(a.size()-1).addDaysWorked();
		
	}
	public void add(ArrayList<person> a, person n)
	{
		//if full then we take out first one
		if(a.size()==2)
		{
			//if user is lock, we can't remove it, but I can't let it remain in index 0
			// So I will remove it but add it again.
			// Size will stay at 2
			//keep going until I removed 1.
			/*
			boolean rem = false;
			do{
				if(a.get(0).isLock())
				{
					person temp = a.get(0);
					a.remove(0);
					a.add(temp);
				}
				else
				{
					a.get(0).removeDaysWorked();
					a.remove(0);
					rem = true;
				}
			}while(!rem);
			*/
			
			//remove last
			a.get(a.size()-1).removeDaysWorked();
			a.remove(a.size()-1);
			
			
		}
		//first check if it's already full (size 2)
		if(a.size()<2)
		{
			//doesn't contain
			if(!contains(a,n))
			{
				a.add(n);
				a.get(a.size()-1).addDaysWorked();
			}
		}
		
	}
	
	public boolean contains(ArrayList<person> a, person n)
	{
		boolean ret = false;
		for(int i=0; i<a.size(); i++)
		{
			if(a.get(i).getName().equals(n.getName()))
			{
				ret = true;
			}
		}
		
		return ret;
		
	}
	/**
	 * populate scheuled with default values
	 */
	public void setUpScheduled()
	{
		A   = new person("A", "Dr. A", 1);
		Ace = new person("Ace", "Acevado", 2);
		C   = new person("C", "Cindy", 3);
		DLH = new person("DLH", "De La Hoya", 4);
		Jen = new person("Jen", "Jen", 5);
		Ju  = new person ("Ju", "Julia", 6);
		Na  =  new person ("Na", "Naef", 7 );		
		
		C00 = new ArrayList<person>();
		C01 = new ArrayList<person>();
		C02 = new ArrayList<person>();
		C03 = new ArrayList<person>();
		C04 = new ArrayList<person>();
		C05 = new ArrayList<person>();
		C06 = new ArrayList<person>();

		C10 = new ArrayList<person>();
		C11 = new ArrayList<person>();
		C12 = new ArrayList<person>();
		C13 = new ArrayList<person>();
		C14 = new ArrayList<person>();
		C15 = new ArrayList<person>();
		C16 = new ArrayList<person>();

		C20 = new ArrayList<person>();
		C21 = new ArrayList<person>();
		C22 = new ArrayList<person>();
		C23 = new ArrayList<person>();
		C24 = new ArrayList<person>();
		C25 = new ArrayList<person>();
		C26 = new ArrayList<person>();

		
		scheduled[0][0] = C00;
		scheduled[0][1] = C01;
		scheduled[0][2] = C02;
		scheduled[0][3] = C03;
		scheduled[0][4] = C04;
		scheduled[0][5] = C05;
		scheduled[0][6] = C06;
		scheduled[1][0] = C10;
		scheduled[1][1] = C11;
		scheduled[1][2] = C12;
		scheduled[1][3] = C13;
		scheduled[1][4] = C14;
		scheduled[1][5] = C15;
		scheduled[1][6] = C16;
		scheduled[2][0] = C20;
		scheduled[2][1] = C21;
		scheduled[2][2] = C22;
		scheduled[2][3] = C23;
		scheduled[2][4] = C24;
		scheduled[2][5] = C25;
		scheduled[2][6] = C26;
		
		// DR A has fixed scheudled:
		C00.add(A);				
		C01.add(A);
		C03.add(A);
		C04.add(A);
		C22.add(A);
		for(int i=0; i<5; i++)
		{
			A.addDaysWorked();
		}
		
		//Saturdays are fixed:
		C05.add(Ju); 			Ju.addDaysWorked();
		C05.add(C);				C.addDaysWorked();
		C15.add(Jen);			Jen.addDaysWorked();
		C15.add(Na);			Na.addDaysWorked();
		C25.add(Ace);			Ace.addDaysWorked();
	}

}