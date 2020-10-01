package sv.gob.mitur.application.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "tbl_travels" )
public class Travel implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	private Date startDate;
	private Date endDate;
	private Integer rate;
	

	private Boolean status;
	private Date createdAt;

	@JoinColumn( referencedColumnName = "id" )
	@ManyToOne( optional = false )
	private User user;

	@JoinColumn( referencedColumnName = "id" )
	@ManyToOne( optional = false )
	private Route route;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public Boolean getStatus() {
		return status;
	}
	
	public void setStatus ( Boolean status )
	{
		this.status = status;
	}

	public String getCreatedAt ()
	{
		return new SimpleDateFormat( "yyyy/MM/dd" ).format( createdAt != null ? createdAt : new Date() );
	}

	public void setCreatedAt ( Date createdAt )
	{
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Travel [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", rate=" + rate + ", status="
				+ status + ", createdAt=" + createdAt + ", user=" + user + ", route=" + route + "]";
	}
	
	
	
}