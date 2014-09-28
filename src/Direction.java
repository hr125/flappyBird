
public enum Direction
{
	UP(-2),DOWN(1),LEFT(-1),RIGHT(1);
	
	int num;
	
	private Direction(int num)
	{
		this.num = num;
	}
	
	public int getDirection()
	{
		return num;
	}
}
