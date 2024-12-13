package tin.tinproject.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tin.tinproject.Model.Bounty;

@Repository
public interface BountyRepository extends CrudRepository<Bounty, Long> {
}