package model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usergameslist")
public class ListDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LIST_ID")
	private int listID;
	@Column(name="LIST_NAME")
	private String listName;
	@ManyToOne (cascade = CascadeType.PERSIST)
	@JoinColumn(name="USER_ID")
	private User user;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
		@JoinTable
			(
					name="gamesonlist",
					joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="USER_ID") },
					inverseJoinColumns= {@JoinColumn(name="GAME_ID",referencedColumnName="GAME_ID", unique=true) }
			)
	private List<Games> listOfGames;
	
	public ListDetails () {
		super();
	}
	public ListDetails(int listID, String listName, User user, List<Games> listOfGames) {
		this.listID = listID;
		this.listName = listName;
		this.user = user;
		this.listOfGames = listOfGames;
	}
	public ListDetails(String listName, User user, List<Games> listOfGames) {
		this.listName = listName;
		this.user = user;
		this.listOfGames = listOfGames;
	}
	public ListDetails(String listName, User user) {
		this.listName = listName;
		this.user = user;
	}
	@Override
	public String toString() {
		return "ListDetails [listID=" + listID + ", listName=" + listName + ", user=" + user
				+ ", listOfGames=" + listOfGames + "]";
	}
	public int getId() {
		return listID;
	}
	public void setId(int listID) {
		this.listID = listID;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Games> getListOfGames() {
		return listOfGames;
	}
	public void setListOfGames(List<Games> listOfGames) {
		this.listOfGames= listOfGames;
	}
}