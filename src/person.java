
	public class person 
	{
		String name;
		int daysWorked;
		String fullName;
		boolean lock = false;
		int order = 0; // ABC order
		
		boolean [] workDays = new boolean[7]; // Each index is a day. True means this dr is working. false means day off.
		
		public person(String n, String f, int o)
		{
			this.name = n;
			this.daysWorked = 0;
			this.fullName = f;
			
			if(n.equals("A"))
			{
				lock = true;
			}
			
			this.order = o; 			
		}
	
		
		/**
		 * 
		 * @return - return true if there are 2 consecutive days off
		 */
		public boolean twoConsequtiveDaysOff()
		{
			boolean ret=true;
			
			//Sunday - workDays[6] should always be false.
			//Meaning if monday [0], or Saturday[5] is false then there's 2 consecutive days off
			
			if(workDays[0]==false || workDays[5]==false)
			{
				return ret;
			}
			
			boolean lastBool =false;
			//FALSE is day off
			for(int i = 0; i< workDays.length; i++)
			{							
				ret = (!workDays[i]) && lastBool;
				lastBool = (!workDays[i]);
				
				if(ret)
				{
					break;
				}
			}
			
			return ret;
			
		}
		
		public boolean[] getWorkDays()
		{
			return workDays;
		}
		
		public void clearWorkDays()
		{
			workDays = new boolean[7];
		}
		
		public int getOrder()
		{
			return this.order;
		}
		public boolean isLock()
		{
			return this.lock;
		}
		public String getFullName()
		{
			return this.fullName;
		}
		
		public String getName() {
			return name;
		}

		public void setName(String 	name) {
			this.name = name;
		}

		public int getDaysWorked() {
			return daysWorked;
		}

		public void setDaysWorked(int daysWorked) {
			this.daysWorked = daysWorked;
		}
		public void addDaysWorked()
		{
			this.daysWorked = this.daysWorked+1;
		}
		public void removeDaysWorked()
		{
			this.daysWorked = this.daysWorked-1;
		}
	
		
	}
	
	