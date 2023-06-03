package hxari.spring.server;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

/**
 * Representasi kelas entitas untuk produk.
 */
@Entity
@Table( name = "products" )
class Product
{
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private long id;
	
	@Column( nullable = false )
	private String name;
	
	@Column( nullable = false )
	private double price;
	
	@Column( nullable = false )
	private int amount;
	
	/**
	 * Konstruktor default untuk kelas Product.
	 */
	public Product()
	{}
	
	/**
	 * Konstruktor untuk kelas Product dengan parameter.
	 *
	 * @param name   Nama produk.
	 * @param price  Harga produk.
	 * @param amount Jumlah produk.
	 */
	public Product( String name, double price, int amount )
	{
		this.name = name;
		this.price = price;
		this.amount = amount;
	}
	
	/**
	 * Mendapatkan ID produk.
	 *
	 * @return ID produk.
	 */
	public Long getId()
	{
		return( this ).id;
	}
	
	/**
	 * Mengatur ID produk.
	 *
	 * @param id ID produk.
	 */
	public void setId( Long id )
	{
		this.id = id;
	}
	
	/**
	 * Mendapatkan nama produk.
	 *
	 * @return Nama produk.
	 */
	public String getName()
	{
		return( this ).name;
	}
	
	/**
	 * Mengatur nama produk.
	 *
	 * @param name Nama produk.
	 */
	public void setName( String name )
	{
		this.name = name;
	}
	
	/**
	 * Mendapatkan harga produk.
	 *
	 * @return Harga produk.
	 */
	public double getPrice()
	{
		return( this ).price;
	}
	
	/**
	 * Mengatur harga produk.
	 *
	 * @param price Harga produk.
	 */
	public void setPrice( double price )
	{
		this.price = price;
	}
	
	/**
	 * Mendapatkan jumlah produk.
	 *
	 * @return Jumlah produk.
	 */
	public int getAmount()
	{
		return( this ).amount;
	}
	
	/**
	 * Mengatur jumlah produk.
	 *
	 * @param amount Jumlah produk.
	 */
	public void setAmount( int amount )
	{
		this.amount = amount;
	}
	
}
