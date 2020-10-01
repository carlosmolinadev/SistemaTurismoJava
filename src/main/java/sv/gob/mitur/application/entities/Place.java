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
import javax.persistence.Transient;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table( name = "tbl_places" )
public class Place implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	private String name;
	private Date createdAt;
	private Boolean status;
	private String photo;

	@Transient
	private MultipartFile file;

	@JoinColumn( referencedColumnName = "id" )
	@ManyToOne( optional = false )
	private Type type;

	@JoinColumn( referencedColumnName = "id" )
	@ManyToOne( optional = false )
	private Route route;

	@JoinColumn( referencedColumnName = "id" )
	@ManyToOne( optional = false )
	private Location location;

	@OneToMany( cascade = CascadeType.ALL, mappedBy = "place" )
	private Set<Event> events;

	public Type getType ()
	{
		return type;
	}

	public void setType ( Type type )
	{
		this.type = type;
	}

	public Route getRoute ()
	{
		return route;
	}

	public void setRoute ( Route route )
	{
		this.route = route;
	}

	public Long getId ()
	{
		return id;
	}

	public void setId ( Long id )
	{
		this.id = id;
	}

	public Location getLocation ()
	{
		return location;
	}

	public void setLocation ( Location location )
	{
		this.location = location;
	}

	public String getName ()
	{
		return name;
	}

	public void setName ( String name )
	{
		this.name = name;
	}

	public String getCreatedAt() {
		return new SimpleDateFormat( "yyyy/MM/dd" ).format( createdAt != null ? createdAt : new Date() );
	}

	public void setCreatedAt ( Date createdAt )
	{
		this.createdAt = createdAt;
	}

	public Set<Event> getEvents ()
	{
		return events;
	}

	public void setEvents ( Set<Event> events )
	{
		this.events = events;
	}

	public Boolean getStatus ()
	{
		return status;
	}

	public void setStatus( Boolean status )
	{
		this.status = status;
	}

	public void setPhoto ( String photo )
	{
		this.photo = photo;
	}

	public String getPhoto ()
	{
		return "https://s3.us-east-2.amazonaws.com/hdp-115-s3/" + photo;
	}

	public void setFile ( MultipartFile file )
	{
		this.file = file;
	}

	public MultipartFile getFile ()
	{
		return this.file;
	}
}