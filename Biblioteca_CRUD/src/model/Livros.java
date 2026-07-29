package model;

public class Livros {

    private int id;
    private String titulo;
    private String autor;
    private String genero;
    private String idioma;
    private int qtd;
    private double preco;
    

    public Livros() {
    }

    public Livros(String titulo, String autor, String genero, String idioma, int qtd, double preco) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.idioma = idioma;
        this.qtd = qtd;
        this.preco = preco; 
    }

    public Livros(int id, String titulo, String autor, String genero, String idioma, int qtd, double preco) {
        this.id = id;
    	this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.idioma = idioma;
        this.qtd = qtd;
        this.preco = preco;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

    
}
