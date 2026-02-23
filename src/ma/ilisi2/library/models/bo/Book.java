package ma.ilisi2.library.models.bo;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "isbn", nullable = false, unique = true)
    private String isbn;

    private String img;
    private int nb;
    private int year;
    private String genre;
    private float price;
    private String description;
    private String title;
    private String author;

    public Book() {
    }

    public Book(Integer id, int year, String isbn, String genre, float price, String description, String title, String author, String img) {
        this.id = id;
        this.year = year;
        this.isbn = isbn;
        this.genre = genre;
        this.price = price;
        this.description = description;
        this.title = title;
        this.author = author;
        this.img = img;
    }

    public Book(int year, String isbn, String genre, float price, String description, String title, String author, String img) {
        this.year = year;
        this.isbn = isbn;
        this.genre = genre;
        this.price = price;
        this.description = description;
        this.title = title;
        this.author = author;
        this.img = img;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    public int getNb() {
        return nb;
    }
    public void setNb(int nb) {
        this.nb = nb;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
