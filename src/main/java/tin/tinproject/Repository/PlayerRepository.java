package tin.tinproject.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tin.tinproject.Model.Player;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {
}