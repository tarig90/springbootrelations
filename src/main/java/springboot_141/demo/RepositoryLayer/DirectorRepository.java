package springboot_141.demo.RepositoryLayer;

import springboot_141.demo.ModelLayer.Director;
import org.springframework.data.repository.CrudRepository;

public interface DirectorRepository extends CrudRepository<Director, Long> {
}
