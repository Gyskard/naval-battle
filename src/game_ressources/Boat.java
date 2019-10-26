package game_ressources;

public class Boat {

	private int healthPoint;
	private int size;
	private boolean state;
	private String title;
	
	public Boat(int size, String title) {
		super();
		this.healthPoint = size;
		this.size = size;
		this.state = true;
		this.title = title;
	}
	public int getHealthPoint() {
		return healthPoint;
	}
	public void setHealthPoint(int healthPoint) {
		this.healthPoint = healthPoint;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
