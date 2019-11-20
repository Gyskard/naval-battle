package game_ressources;

public class Boat {

	private int healthPoint;
	private int size;
	private boolean state;
	private String title;
	private String img_path_vertical;
	private String img_path_horizontal;
	private String img_path_vertical_destroyed;
	private String img_path_horizontal_destroyed;
	
	
	private int direction;
	
	public Boat(int size, String title, String img_path_vertical, String img_path_horizontal,
			String img_path_vertical_destroyed, String img_path_horizontal_destroyed) {
		super();
		this.healthPoint = size;
		this.size = size;
		this.title = title;
		this.img_path_vertical = img_path_vertical;
		this.img_path_horizontal = img_path_horizontal;
		this.img_path_vertical_destroyed = img_path_vertical_destroyed;
		this.img_path_horizontal_destroyed = img_path_horizontal_destroyed;
		this.state=true;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getHealthPoint() {
		return healthPoint;
	}

	//public void setHealthPoint(int healthPoint) { this.healthPoint = healthPoint; }
	public void decreaseHealthPoint() {
		if (healthPoint == 1) {

		} else {
			this.healthPoint = healthPoint -1;
		}
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


	public String getImg_path_vertical() {
		return img_path_vertical;
	}

	public void setImg_path_vertical(String img_path_vertical) {
		this.img_path_vertical = img_path_vertical;
	}

	public String getImg_path_horizontal() {
		return img_path_horizontal;
	}

	public void setImg_path_horizontal(String img_path_horizontal) {
		this.img_path_horizontal = img_path_horizontal;
	}

	public String getImg_path_vertical_destroyed() {
		return img_path_vertical_destroyed;
	}

	public void setImg_path_vertical_destroyed(String img_path_vertical_destroyed) {
		this.img_path_vertical_destroyed = img_path_vertical_destroyed;
	}

	public String getImg_path_horizontal_destroyed() {
		return img_path_horizontal_destroyed;
	}

	public void setImg_path_horizontal_destroyed(String img_path_horizontal_destroyed) {
		this.img_path_horizontal_destroyed = img_path_horizontal_destroyed;
	}
}
