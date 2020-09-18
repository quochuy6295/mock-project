package vn.com.vti_crm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.vti_crm.domain.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

	public Optional<Team> findTeamById(int id);

	public Optional<Team> findTeamByName(String name);
}
