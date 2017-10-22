import java.util.*;

public class sche
{
	// 3 rows for 3 diff hospitals
	// 7 columns for number of days a week
	ArrayList[][] scheduled = new ArrayList[3][7]; 
	
	
	//doctors
	person A = new person("A", "Dr. A");
	person Ace = new person("Ace", "Acevado");
	person C = new person("C", "Cindy");
	person DLH = new person("DLH", "De La Hoya");
	person Jen = new person("Jen", "Jen");
	person Ju  = new person ("Ju", "Julia");
	person Na =  new person ("Na", "Naef");
	
	
	//Array columns
	ArrayList<person> C00 = new ArrayList<person>();
	ArrayList<person> C01 = new ArrayList<person>();
	ArrayList<person> C02 = new ArrayList<person>();
	ArrayList<person> C03 = new ArrayList<person>();
	ArrayList<person> C04 = new ArrayList<person>();
	ArrayList<person> C05 = new ArrayList<person>();
	ArrayList<person> C06 = new ArrayList<person>();

	ArrayList<person> C10 = new ArrayList<person>();
	ArrayList<person> C11 = new ArrayList<person>();
	ArrayList<person> C12 = new ArrayList<person>();
	ArrayList<person> C13 = new ArrayList<person>();
	ArrayList<person> C14 = new ArrayList<person>();
	ArrayList<person> C15 = new ArrayList<person>();
	ArrayList<person> C16 = new ArrayList<person>();

	ArrayList<person> C20 = new ArrayList<person>();
	ArrayList<person> C21 = new ArrayList<person>();
	ArrayList<person> C22 = new ArrayList<person>();
	ArrayList<person> C23 = new ArrayList<person>();
	ArrayList<person> C24 = new ArrayList<person>();
	ArrayList<person> C25 = new ArrayList<person>();
	ArrayList<person> C26 = new ArrayList<person>();

	
	public sche()
	{
		setUpScheduled();
		mainWork();
	
		
	}
	
	public static void main(String[] args)
	{
		new sche();	
		
	}
	
	public void mainWork()
	{
		//Monday 
		//C00 - Bixby - Julia, Naef, Cindy 
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
					do{ //only need this when a day doesn't have a lock person
					person pc = null;
					if(c==0){pc = Ju;}
					if(c==1){pc = Na;}
					if(c==2){pc = C;}
					add(C02,pc);
					c++;
					}while(C02.size()<2);
					c--;
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
							printLog();
						}
					}
				}
			}
		}
		
		
	}
	
	public void printLog()
	{
		for(int i=0; i<1; i++)
		{
			for(int j=0; j<7; j++)
			{
				ArrayList<person> blah = scheduled[i][j];
				for(int z=0;z<blah.size();z++)
				{
					System.out.print(blah.get(z).getFullName() + " - ") ;
				}
				System.out.print(" | ");
			}
			System.out.println();
		}
		
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
					a.remove(0);
					rem = true;
				}
			}while(!rem);
			
		}
		//first check if it's already full (size 2)
		if(a.size()<2)
		{
			//doesn't contain
			if(!contains(a,n))
			{
				a.add(n);
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
		
		//Saturdays are fixed:
		C05.add(Ju);
		C05.add(C);	
		C15.add(Jen);
		C15.add(Na);
		C25.add(Ace);
	}
	
	


	class person
	{
		String name;
		int daysWorked;
		String fullName;
		boolean lock = false;
		
		public person(String n, String f)
		{
			this.name = n;
			this.daysWorked = 0;
			this.fullName = f;
			
			if(n.equals("A"))
			{
				lock = true;
			}
		}
		public boolean isLock()
		{
			return this.lock;
		}
		public String getFullName()
		{
			return this.fullName;
		}
		public boolean isWorkFull()
		{
			return daysWorked>3; //4 or more days is full
		}
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getDaysWorked() {
			return daysWorked;
		}

		public void setDaysWorked(int daysWorked) {
			this.daysWorked = daysWorked;
		}
		
		
	}

}