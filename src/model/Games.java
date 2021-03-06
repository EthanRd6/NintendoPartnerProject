package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* @author Ethan Dorenkamp - edorenkamp
* CIS175 - Spring 2021
* Mar 5, 2021
*/
@Entity
@Table(name="GAMES")
public class Games {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="YEAR")
	private int year;
	@Column(name="NAME")
	private String name;
	@Column(name="TYPE")
	private String type;
	@Column(name="NUMPLAYERS")
	private int numPlayers;
	
	public Games() {
		super();
	}

	public Games(String name) {
		super();
		this.name = name;
	}

	public Games(int year, String name) {
		super();
		this.year = year;
		this.name = name;
	}

	public Games(int year, String name, int numPlayers) {
		super();
		this.year = year;
		this.name = name;
		this.numPlayers = numPlayers;
	}

	public Games(int year, String name, String type, int numPlayers) {
		super();
		this.year = year;
		this.name = name;
		this.type = type;
		this.numPlayers = numPlayers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumPlayers() {
		return numPlayers;
	}

	public void setNumPlayers(int numPlayers) {
		this.numPlayers = numPlayers;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Games [id=" + id + ", year=" + year + ", name=" + name + ", type=" + type + ", numPlayers=" + numPlayers
				+ "]";
	}
	
}
