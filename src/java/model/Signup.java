/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author chadani
 */
@Entity
@Table(name = "signup", catalog = "colzproj", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Signup.findAll", query = "SELECT s FROM Signup s"),
    @NamedQuery(name = "Signup.findById", query = "SELECT s FROM Signup s WHERE s.id = :id"),
    @NamedQuery(name = "Signup.findByUsername", query = "SELECT s FROM Signup s WHERE s.username = :username"),
    @NamedQuery(name = "Signup.findByPassword", query = "SELECT s FROM Signup s WHERE s.password = :password"),
    @NamedQuery(name = "Signup.findByEmail", query = "SELECT s FROM Signup s WHERE s.email = :email"),
    @NamedQuery(name = "Signup.findBySession", query = "SELECT s FROM Signup s WHERE s.session = :session")})
public class Signup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password")
    private String password=UUID.randomUUID().toString();
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "session")
    private int session;

    public Signup() {
    }
    
    public Signup(String username,String email) {
         this.username = username;
         this.email = email;
    }

    public Signup(Integer id) {
        this.id = id;
    }

    public Signup(Integer id, String username, String password, String email, int session) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.session = session;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSession() {
        return session;
    }

    public void setSession(int session) {
        this.session = session;
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
        if (!(object instanceof Signup)) {
            return false;
        }
        Signup other = (Signup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Signup[ id=" + id + " ]";
    }
    
}
