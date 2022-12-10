import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.ArrayList;

public class huang_lab13 
{
	private ArrayList<Integer> numbers = new ArrayList<>();
	
	public void readData(String filename) 
	{
		try {
			BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
			String inn;
			while( (inn = input.readLine()) != null )
			{
				numbers.add(Integer.parseInt(inn));
			}
			input.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.exit(0);
		}
	
	}
	
	public long getTotalCount() 
	{
		return numbers.stream().count();
	}
	
	public long getOddCount() 
	{
		return numbers.stream().filter(x -> x % 2 != 0).count();
	}
	
	public long getEvenCount() 
	{
		return numbers.stream().filter(x -> x % 2 == 0).count();
	}

	public long getDistinctGreaterThanFiveCount() 
	{
		return numbers.stream().filter(x -> x > 5).distinct().count();
	}
	
	public Integer[] getResult1() 
	{
		return numbers.stream().filter(x -> x % 2 == 0).filter(x -> x > 5).filter(x -> x < 50).sorted().toArray(Integer[] :: new);
	}

	public Integer[] getResult2() 
	{
		return numbers.stream().map(i -> i * i * 3).limit(50).toArray(Integer[] :: new);
	}
	
	public Integer[] getResult3() 
	{
		return numbers.stream().filter(x -> x % 2 != 0).map(i -> i * 2).sorted().skip(20).distinct().toArray(Integer[] :: new);
	}

}
