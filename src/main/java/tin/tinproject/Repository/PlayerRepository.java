package tin.tinproject.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tin.tinproject.Model.Player;
import tin.tinproject.Model.User;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {
    Object findAll(Pageable pageable);
    Page<Player> findAllByUserName(String username, Pageable pageable);
}