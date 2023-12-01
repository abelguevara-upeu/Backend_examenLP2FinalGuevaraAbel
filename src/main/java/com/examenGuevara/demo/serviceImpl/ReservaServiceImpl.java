package com.examenGuevara.demo.serviceImpl;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examenGuevara.demo.entity.Reserva;
import com.examenGuevara.demo.repository.ReservaRepository;
import com.examenGuevara.demo.service.ReservaService;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Service
public class ReservaServiceImpl implements ReservaService{
	
	@Autowired
	private ReservaRepository reservaRepository;
	private EntityManager entityManager;

	@Override
	public Reserva create(Reserva t) {
		return reservaRepository.save(t);
	}

	@Override
	public Reserva update(Reserva t) {
		return reservaRepository.save(t);
	}

	@Override
	public void delete(Long id) {
		reservaRepository.deleteById(id);
		
	}

	@Override
	public Reserva read(Long id) {
		return reservaRepository.findById(id).get();
	}

	@Override
	public List<Reserva> readAll() {
		List<Reserva> libros = reservaRepository.findAll();
        libros.sort(Comparator.comparing(Reserva::getId));
        return libros;
	}

	@Override
    @Transactional
    public void reiniciarSecuencia(String tabla, String secuencia, Long idABorrar) {
        entityManager.createNativeQuery(
                "BEGIN " +
                        "CONTROL.reiniciar_secuencia(:tabla, :secuencia, :idABorrar); " +
                        "END;")
                .setParameter("tabla", tabla)
                .setParameter("secuencia", secuencia)
                .setParameter("idABorrar", idABorrar)
                .executeUpdate();
    }
	
}
