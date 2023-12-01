package com.examenGuevara.demo.entity;


import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper=false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="CLIENTES")
public class Cliente {
	
	@Id
	@Column(name = "CLIENTE_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCliente")
    @SequenceGenerator(name = "seqCliente", allocationSize = 1, sequenceName = "SEQ_CLIENTE")
    @Builder.Default
    private Long id=0L;
	
	@NotNull
	@Column(name = "NIF")
    private String nif;

	@NotNull
	@Column(name = "NOMBRES")
    private String nombres;
	
	@NotNull
	@Column(name = "APELLIDOS")
    private String apellidos;
	
	@Column(name = "TELEFONO")
    private String telefono;
	
	@Column(name = "EMAIL")
    private String email;
	
    //!OneToMany's
	@OneToMany(											//*Verificado
		mappedBy = "clienteReferente",
		cascade = CascadeType.ALL,
		fetch = FetchType.LAZY
	)
	@JsonIgnore
	private Set<Reserva> reservas;
	
}
