/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modeloDatos;

/**
 *
 * @author enrique
 */
public class Libro {
    
    private Integer idLibro;
    private String titulo;
    private String autor;
    private String comentario;

    /**
     * @return the titulo
     */

    public Libro(){}
    public Libro(String titulo, String autor){
        this.titulo=titulo;
        this.autor=autor;
    }
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return the comentarios
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * @param comentarios the comentarios to set
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * @return the idLibro
     */
    public Integer getIdLibro() {
        return idLibro;
    }

    /**
     * @param idLibro the idLibro to set
     */
    public void setIdLibro(Integer idLibro) {
        this.idLibro = idLibro;
    }

}
