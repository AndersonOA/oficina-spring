/**
 * 
 */
package br.com.makersweb.vinhos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.makersweb.vinhos.model.Vinho;

/**
 * @author andersonorionearistides
 */
public interface IVinhosRepository extends JpaRepository<Vinho, Long> {

}
