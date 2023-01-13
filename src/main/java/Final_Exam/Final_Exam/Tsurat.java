/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Final_Exam.Final_Exam;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "tsurat")
@NamedQueries({
    @NamedQuery(name = "Tsurat.findAll", query = "SELECT t FROM Tsurat t"),
    @NamedQuery(name = "Tsurat.findById", query = "SELECT t FROM Tsurat t WHERE t.id = :id"),
    @NamedQuery(name = "Tsurat.findByNoSurat", query = "SELECT t FROM Tsurat t WHERE t.noSurat = :noSurat"),
    @NamedQuery(name = "Tsurat.findByJudul", query = "SELECT t FROM Tsurat t WHERE t.judul = :judul"),
    @NamedQuery(name = "Tsurat.findByTembusan", query = "SELECT t FROM Tsurat t WHERE t.tembusan = :tembusan"),
    @NamedQuery(name = "Tsurat.findByFile", query = "SELECT t FROM Tsurat t WHERE t.file = :file"),
    @NamedQuery(name = "Tsurat.findByTs", query = "SELECT t FROM Tsurat t WHERE t.ts = :ts")})
public class Tsurat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "no_surat")
    private String noSurat;
    @Basic(optional = false)
    @Column(name = "judul")
    private String judul;
    @Basic(optional = false)
    @Column(name = "tembusan")
    private String tembusan;
    @Basic(optional = false)
    @Column(name = "file")
    private int file;
    @Basic(optional = false)
    @Column(name = "ts")
    private int ts;

    public Tsurat() {
    }

    public Tsurat(Integer id) {
        this.id = id;
    }

    public Tsurat(Integer id, String noSurat, String judul, String tembusan, int file, int ts) {
        this.id = id;
        this.noSurat = noSurat;
        this.judul = judul;
        this.tembusan = tembusan;
        this.file = file;
        this.ts = ts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoSurat() {
        return noSurat;
    }

    public void setNoSurat(String noSurat) {
        this.noSurat = noSurat;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getTembusan() {
        return tembusan;
    }

    public void setTembusan(String tembusan) {
        this.tembusan = tembusan;
    }

    public int getFile() {
        return file;
    }

    public void setFile(int file) {
        this.file = file;
    }

    public int getTs() {
        return ts;
    }

    public void setTs(int ts) {
        this.ts = ts;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tsurat)) {
            return false;
        }
        Tsurat other = (Tsurat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Final_Exam.Final_Exam.Tsurat[ id=" + id + " ]";
    }
    
}
