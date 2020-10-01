package sv.gob.mitur.application.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "tbl_forms" )
public class Form implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	private String attributes;
	private String comments;
	private Integer duration;
	private String interests;
	private Integer persons;
	private Double budget;

	@JoinColumn( referencedColumnName = "id" )
	@ManyToOne( optional = false )
	private User user;

	// #region Getters & setters
	public Long getId ()
	{
		return id;
	}

	public void setId ( Long id )
	{
		this.id = id;
	}

	public String getAttributes ()
	{
		return attributes;
	}

	public void setAttributes ( String attributes )
	{
		this.attributes = attributes;
	}

	public String getComments ()
	{
		return comments;
	}

	public void setComments ( String comments )
	{
		this.comments = comments;
	}

	public Integer getDuration ()
	{
		return duration;
	}

	public void setDuration ( Integer duration )
	{
		this.duration = duration;
	}

	public String getInterests ()
	{
		return interests;
	}

	public void setInterests ( String interests )
	{
		this.interests = interests;
	}

	public Integer getPersons ()
	{
		return persons;
	}

	public void setPersons ( Integer persons )
	{
		this.persons = persons;
	}

	public Double getBudget ()
	{
		return budget;
	}

	public void setBudget ( Double budget )
	{
		this.budget = budget;
	}

	public User getUser ()
	{
		return user;
	}

	public void setUser ( User user )
	{
		this.user = user;
	}
	// #endregion

	@Override
	public String toString ()
	{
		return "Form [ id=" + id + ", attributes=" + attributes + ", budget=" + budget + ", comments=" + comments + ", duration=" + duration + ", interests=" + interests + ", persons=" + persons + ", user=" + user + " ]";
	}
}