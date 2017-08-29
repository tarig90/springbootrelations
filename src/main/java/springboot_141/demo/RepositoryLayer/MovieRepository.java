package springboot_141.demo.RepositoryLayer;

import springboot_141.demo.ModelLayer.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long> {
}
