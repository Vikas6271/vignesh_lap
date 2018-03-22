package HRM_Project_Website;

public class Java_Prgms {

	public void Reverse_Name()
	{
		String names = "Vignesh Chary";
		StringBuilder sbnames = new StringBuilder(names);
		System.out.println(sbnames.reverse());
	}
	
	public void Rever_Each_Names()
	{
		String names = "Vignesh Kranthi Chary";
		String[] arraynames = names.split(" ");
		StringBuilder sb = new StringBuilder();
			for(int i=0; i<arraynames.length;i++)
			{
				StringBuilder sb2 = new StringBuilder(arraynames[i]);
				sb.append(sb2.reverse());
				sb.append(" ");
			}
		System.out.println(sb);
	}
	
	public void Ascending_Order()
	{
		int[] numbers = {65,98,98,479,9,47,981,976,36,2};
		int temp;
			for(int i=0;i<numbers.length;i++)
			{
				for(int j=i+1;j<numbers.length;j++)
				{
					if(numbers[i]>numbers[j])
					{
						temp = numbers[i];
						numbers[i] = numbers[j];
						numbers[j] = temp;
					}
				}
			}
			for(int k=0;k<numbers.length;k++)
			{
				System.out.println(numbers[k]);
			}
	}
	public void duplicate()
	{
		String names = "vigneshvivivvignehsv";
		int count=0;
		for(int i=0;i<names.length();i++)
		{
			char ch = names.charAt(i);
			if(ch=='v')
			{
				count = count+1;
			}
		}
		System.out.println(count);
	}
	
	public static void main (String [] args)
	{
		Java_Prgms jp = new Java_Prgms();
		jp.Reverse_Name();
		jp.Rever_Each_Names();
		jp.Ascending_Order();
		jp.duplicate();
	}
}




















