package hxari.spring.server;

import hxari.spring.server.Product;
import hxari.spring.server.ProductRepository;

import java.util.concurrent.atomic.AtomicLong;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/" )
public class Controller
{
	
	final private AtomicLong iter = new AtomicLong();
	final private ProductRepository repos;
	
	@Autowired
	public Controller( ProductRepository repository )
	{
		this.repos = repository;
	}
	
	/**
	 * Mengembalikan objek Greeting dengan pesan selamat datang.
	 * 
	 * @param name Nama yang akan dimasukkan dalam pesan.
	 * @return Objek Greeting dengan pesan selamat datang.
	 */
	@GetMapping
	public Greeting greeting( @RequestParam( value = "name", defaultValue = "world" ) String name )
	{
		return( new Greeting( this.iter.incrementAndGet(), String.format( "Hello, %s!", name ) ) );
	}
	
	/**
	 * Mengembalikan daftar semua produk.
	 * 
	 * @return Daftar semua produk.
	 */
	@GetMapping( "/product" )
	public List<Product> products()
	{
		return( this ).repos.findAll();
	}
	
	/**
	 * Mengembalikan produk berdasarkan ID yang diberikan.
	 * 
	 * @param id ID produk yang akan dicari.
	 * @return Produk dengan ID yang sesuai.
	 * @throws IllegalArgumentException Jika produk dengan ID yang diberikan tidak ditemukan.
	 */
	@GetMapping( "/product/{id}" )
	public Product selectProductById( @PathVariable( "id" ) long id )
	{
		return( this ).repos.findById( id ).orElseThrow( () -> new IllegalArgumentException( "No product with id \"" + id + "\"" ) );
	}
	
	/**
	 * Memasukkan produk baru ke dalam database.
	 * 
	 * @param product Produk yang akan dimasukkan.
	 * @return Produk yang berhasil dimasukkan.
	 */
	@PostMapping( "/product" )
	public Product insertProduct( @RequestBody Product product )
	{
		return( this ).repos.save( product );
	}
	
	/**
	 * Memperbarui produk berdasarkan ID yang diberikan.
	 * 
	 * @param id ID produk yang akan diperbarui.
	 * @param data Data baru yang akan diterapkan pada produk.
	 * @return Produk yang berhasil diperbarui.
	 * @throws IllegalArgumentException Jika produk dengan ID yang diberikan tidak ditemukan.
	 */
	@PutMapping( "/product/{id}" )
	public Product updateProductById( @PathVariable( "id" ) long id, @RequestBody Product data )
	{
		Product product;
		
		product = this.repos.findById( id ).orElseThrow( () -> new IllegalArgumentException( "No product with id \"" + id + "\"" ) );
		product.setName( data.getName() );
		product.setPrice( data.getPrice() );
		product.setAmount( data.getAmount() );
		
		return( this ).repos.save( product );
	}
	
	/**
	 * Menghapus produk berdasarkan ID yang diberikan.
	 * 
	 * @param id ID produk yang akan dihapus.
	 * @throws IllegalArgumentException Jika produk dengan ID yang diberikan tidak ditemukan.
	 */
	@DeleteMapping( "/product/{id}" )
	public void deleteProduct( @RequestBody Product product )
	{
		this.repos.delete( this.repos.findById( product.getId() ).orElseThrow( () -> new IllegalArgumentException( "No product with id \"" + product.getId() + "\"" ) ) );
	}
	
}