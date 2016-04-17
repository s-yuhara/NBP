package beans;

import java.awt.print.Book;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Named
@ViewScoped
public class BackingBook02 {

    @NotNull
    private String isbn;
    @NotNull
    private String genre;
    @Size(min=1,max=60)
    private String title;
    @Min(500)@Max(9999) @NotNull
    private Integer price;
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date date;
    @Size(max=200)
    private String exp;
    private static final Map<String,String> item;
    static{
        item = new LinkedHashMap<>();
        item.put("IT","IT");
        item.put("趣味","趣味");
        item.put("SF","SF");
    }
    
    @EJB
    Worker02 wk;
    @Inject
    transient Logger log;
    
    public String register(){
        BookEntity02 entity = new BookEntity02(
        isbn,genre,title,price,date,exp);
        try{
            wk.register(entity);
            clear();
        }catch(Exception e){
            log.log(Level.SEVERE,"ISBN番号{0}を登録できません。",isbn);
        }
        return null;
    }

    public String edit(BookEntity02 entity){
        this.isbn = entity.getIsbn();
        this.genre = entity.getGenre();
        this.title = entity.getTitle();
        this.price = entity.getPrice();
        this.date = entity.getDate();
        this.exp = entity.getExp();
        return null;
    }
    
    public String update(){
        BookEntity02 entity = new BookEntity02(isbn,genre,title,price,date,exp);
        try{
            wk.update(entity);
            clear();
        }catch(Exception e){
            log.log(Level.SEVERE,"ISBN番号{0}を登録できません。",isbn);
        }
        return null;
    }
    
    public String find(){
        BookEntity02 result = wk.find(isbn);
        if(result != null){
        this.isbn = result.getIsbn();
        this.genre = result.getGenre();
        this.title = result.getTitle();
        this.price = result.getPrice();
        this.date = result.getDate();
        this.exp = result.getExp();
        }
        return null;
    }
    public String delete(BookEntity02 entity){
        wk.delete(entity);
        return null;
    }
    public void clear(){
        isbn=genre=title=exp = null;
        price = null;
        date = null;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }
    public List<BookEntity02> detData(){
        return wk.getData();
    }
    public Map<String,String>getItem(){
        return item;
    }


}
