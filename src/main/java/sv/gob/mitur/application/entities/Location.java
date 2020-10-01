package sv.gob.mitur.application.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name = "tbl_locations" )
public class Location implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	private String name;
	private String description;
	private Double latitude;
	private Double longitude;
	private Boolean status;
	private Date createdAt;
	
	@OneToMany( cascade = CascadeType.ALL, mappedBy = "placeOfBirth" )
	private Set<User> users;

	@OneToMany( cascade = CascadeType.ALL, mappedBy = "location" )
	private Set<Place> places;

	@JoinColumn( referencedColumnName = "id" )
	@ManyToOne( optional = false )
	private Region region;

	public Long getId ()
	{
		return id;
	}

	public void setId ( Long id )
	{
		this.id = id;
	}

	public String getName ()
	{
		return name;
	}

	public void setName ( String name )
	{
		this.name = name;
	}

	public String getDescription ()
	{
		return description;
	}

	public void setDescription ( String description )
	{
		this.description = description;
	}

	public Double getLatitude ()
	{
		return latitude;
	}

	public void setLatitude ( Double latitude )
	{
		this.latitude = latitude;
	}

	public Double getLongitude ()
	{
		return longitude;
	}

	public void setLongitude ( Double longitude )
	{
		this.longitude = longitude;
	}

	public Boolean getStatus ()
	{
		return status;
	}

	public void setStatus ( Boolean status )
	{
		this.status = status;
	}

	public String getCreatedAt ()
	{
		return new SimpleDateFormat("yyyy/MM/dd").format(createdAt != null ? createdAt : new Date());
	}

	public void setCreatedAt ( Date createdAt )
	{
		this.createdAt = createdAt;
	}

	public Set<User> getUsers ()
	{
		return users;
	}

	public void setUsers ( Set<User> users )
	{
		this.users = users;
	}

	public Set<Place> getPlaces() {
		return places;
	}

	public void setPlaces(Set<Place> places) {
		this.places = places;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}
	
	
}