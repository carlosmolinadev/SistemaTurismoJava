package sv.gob.mitur.application.entities;

import java.io.Serializable;
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
@Table( name = "tbl_routes" )
public class Route implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	private String name;
	private String description;
	private Double duration;
	private Double importe;
	private Boolean status;

	@JoinColumn( referencedColumnName = "id" )
	@ManyToOne( optional = false )
	private Type type;

	@JoinColumn( referencedColumnName = "id" )
	@ManyToOne( optional = false )
	private User guide;

	@OneToMany( cascade = CascadeType.ALL, mappedBy = "route" )
	private Set<Place> places;

	@OneToMany( cascade = CascadeType.ALL, mappedBy = "route" )
	private Set<Travel> travels;
	
	public Long getId ()
	{
		return id;
	}
	
	public void setId ( Long id )
	{
		this.id = id;
	}

	public Type getType ()
	{
		return type;
	}
	
	public void setType ( Type type )
	{
		this.type = type;
	}

	public Set<Place> getPlaces ()
	{
		return places;
	}

	public void setPlaces ( Set<Place> places )
	{
		this.places = places;
	}

	public String getName ()
	{
		return name;
	}

	public void setName ( String name )
	{
		this.name = name;
	}

	public Boolean getStatus ()
	{
		return status;
	}

	public void setStatus ( Boolean status )
	{
		this.status = status;
	}

	public Set<Travel> getTravels ()
	{
		return travels;
	}

	public void setTravels ( Set<Travel> travels )
	{
		this.travels = travels;
	}

	public User getGuide ()
	{
		return guide;
	}

	public void setGuide ( User guide )
	{
		this.guide = guide;
	}

	public Double getDuration ()
	{
		return duration;
	}

	public void setDuration ( Double duration )
	{
		this.duration = duration;
	}

	public Double getImporte ()
	{
		return importe;
	}

	public void setImporte ( Double importe )
	{
		this.importe = importe;
	}

	public String getDescription ()
	{
		return description;
	}

	public void setDescription ( String description )
	{
		this.description = description;
	}
}