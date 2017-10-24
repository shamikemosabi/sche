
	public class person 
	{
		String name;
		int daysWorked;
		String fullName;
		boolean lock = false;
		int order = 0; // ABC order
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
	
	