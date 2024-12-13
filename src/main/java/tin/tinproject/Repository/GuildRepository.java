package tin.tinproject.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tin.tinproject.Model.Guild;

@Repository
public interface GuildRepository extends CrudRepository<Guild, Long> {
}