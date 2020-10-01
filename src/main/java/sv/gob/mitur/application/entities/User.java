package sv.gob.mitur.application.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.multipart.MultipartFile;

@Entity
@DynamicUpdate
@Table( name = "tbl_users" )
public class User implements UserDetails
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	private String firstName;
	private String lastName;
	private String email;

	@Column( updatable = false )
	private String password;
	private Date birthdate;
	private String phone;
	private Boolean status;
	private Date createdAt;
	private String photo;

	@Transient
	private List<GrantedAuthority> authorities;
	
	@Transient
	private MultipartFile file;

	@Enumerated( EnumType.STRING )
	private Genders gender;

	@Enumerated( EnumType.STRING )
	private Roles role;

	@JoinColumn( referencedColumnName = "id" )
	@ManyToOne( optional = false )
	private Location placeOfBirth;

	@ManyToMany
	@JoinTable(
		name = "tbl_preferences",
		joinColumns = @JoinColumn( name = "user_id" ),
		inverseJoinColumns = @JoinColumn( name = "type_id" ) )
	private Set<Type> types;

	@OneToMany( cascade = CascadeType.ALL, mappedBy = "user" )
	private Set<Travel> travels;

	@OneToMany( cascade = CascadeType.ALL, mappedBy = "guide" )
	private Set<Route> routes;

	@OneToMany( cascade = CascadeType.ALL, mappedBy = "user" )
	private Set<Form> forms;

	// #region Getters & setters
	public Long getId ()
	{
		return id;
	}

	public void setId ( Long id )
	{
		this.id = id;
	}

	public String getEmail ()
	{
		return email;
	}

	public void setEmail ( String email )
	{
		this.email = email;
	}

	@Override
	public String getPassword ()
	{
		return password;
	}

	public void setPassword ( String password )
	{
		this.password = password;
	}

	public String getBirthdate ()
	{
		return new SimpleDateFormat( "yyyy/MM/dd" ).format( birthdate != null ? birthdate : new Date() );
	}

	public void setBirthdate ( Date birthdate )
	{
		this.birthdate = birthdate;
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
		return new SimpleDateFormat( "yyyy/MM/dd" ).format( createdAt != null ? createdAt : new Date() );
	}

	public void setCreatedAt ( Date createdAt )
	{
		this.createdAt = createdAt;
	}

	public Genders getGender ()
	{
		return gender;
	}

	public void setGender ( Genders gender )
	{
		this.gender = gender;
	}

	public Roles getRole ()
	{
		return role;
	}

	public void setRole ( Roles role )
	{
		this.role = role;
	}

	public Location getPlaceOfBirth ()
	{
		return placeOfBirth;
	}

	public void setPlaceOfBirth ( Location placeOfBirth )
	{
		this.placeOfBirth = placeOfBirth;
	}

	public Set<Type> getTypes ()
	{
		return types;
	}

	public void setTypes(Set<Type> types) {
		this.types = types;
	}

	public Set<Travel> getTravels ()
	{
		return travels;
	}

	public void setTravels ( Set<Travel> travels )
	{
		this.travels = travels;
	}

	public String getPhone ()
	{
		return phone;
	}

	public void setPhone ( String phone )
	{
		this.phone = phone;
	}

	public String getFirstName ()
	{
		return firstName;
	}

	public void setFirstName ( String firstName )
	{
		this.firstName = firstName;
	}

	public String getLastName ()
	{
		return lastName;
	}

	public void setLastName ( String lastName )
	{
		this.lastName = lastName;
	}

	public Set<Route> getRoutes ()
	{
		return routes;
	}

	public void setRoutes ( Set<Route> routes )
	{
		this.routes = routes;
	}

	public Set<Form> getForms ()
	{
		return forms;
	}

	public void setForms ( Set<Form> forms )
	{
		this.forms = forms;
	}

	public String getFullName ()
	{
		return firstName + ' ' + lastName;
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
	// #endregion

	// #region Login
	@Override
	public String getUsername ()
	{
		return email;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities ()
	{
		authorities = new ArrayList<>();
		authorities.add( new SimpleGrantedAuthority( role.toString() ) );
		return authorities;
	}
	
	@Override
	public boolean isAccountNonExpired ()
	{
		return true;
	}

	@Override
	public boolean isAccountNonLocked ()
	{
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired ()
	{
		return true;
	}

	@Override
	public boolean isEnabled ()
	{
		return status;
	}
	// #endregion

	@Override
	public String toString ()
	{
		return "User [ id=" + id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", role=" + role + ", status=" + status + " ]";
	}
}