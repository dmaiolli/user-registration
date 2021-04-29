package br.com.fiap.bean;

import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.fiap.dao.UserDao;
import br.com.fiap.model.Usuario;

@Named
@RequestScoped
public class UserBean {

	private Usuario usuario = new Usuario();

	public void save() {
		new UserDao().save(this.usuario);

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário cadastrado com sucesso"));
	}
	
	public List<Usuario> getUsuarios() {
		return new UserDao().getAll();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
