package tin.tinproject.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tin.tinproject.Model.BountyClaim;

@Repository
public interface BountyClaimRepository extends CrudRepository<BountyClaim, Long> {
}