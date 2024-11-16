package com.globalsolution2.fiap.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_usuario")
public class UsuarioModel {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_usuario")
	    private Long idUsuario;

	    @Column(name = "nm_usuario", nullable = false, length = 100)
	    private String nmUsuario;

	    @Column(name = "nm_login", nullable = false, length = 100)
	    private String nmLogin;

	    @Column(name = "nm_senha", nullable = false, length = 100)
	    private String nmSenha;

	    @Column(name = "nm_email", nullable = false, length = 300)
	    private String nmEmail;

	    @Column(name = "is_adm", nullable = false)
	    private boolean isAdm;


}
