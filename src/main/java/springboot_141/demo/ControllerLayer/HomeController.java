package springboot_141.demo.ControllerLayer;


import org.springframework.web.bind.annotation.*;
import springboot_141.demo.ModelLayer.Director;
import springboot_141.demo.ModelLayer.Movie;
import springboot_141.demo.RepositoryLayer.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import springboot_141.demo.RepositoryLayer.MovieRepository;

import java.util.HashSet;
import java.util.Set;

    @Controller
    public class HomeController {

        @Autowired
        DirectorRepository directorRepository;

        @Autowired
        MovieRepository movieRepository;


        @RequestMapping("/")
        public String addDirector(Model model) {
            model.addAttribute("newdir", new Director());
            return "index";
        }

        @GetMapping("/addmovie")
        public String getMovie(Model model)
        {
        model.addAttribute("newmovie", new Movie());
        return "addmovie";
        }

        @PostMapping("/addmovie/{id}")
        public String addMovieMap(@PathVariable("id") long id,Model model)
        {

            Director director = directorRepository.findOne(id);
            Movie movie = new Movie();
            movie.setDirector(director);

            model.addAttribute("newmovie", movie);

         //   movieRepository.save(movie);
            return "addmovie";
        }

//        @PostMapping("/addmovie")
//        public String addMoviePost(Model model, Movie om)
//        {
//
////           movieRepository.save(om);
////          return "confirmmovie";
//
//        }
//
//        @PostMapping("/update/{id}")
//        public String updateDirector(@PathVariable("id") long id, Model model) {
//
//            Director dr = directorRepository.findOne(id);
//            Movie om = new Movie();
//            model.addAttribute("new", om);
//            om.setDirector(dr);
//            model.addAttribute("new", directorRepository.findOne(id));
//            System.out.println(id);
//            return "adirector";
//
//        }

        @RequestMapping("/adirector")
        public String addDirectorRequest(Model model) {

            model.addAttribute("newdir", new Director());
            return "adirector";
        }

        @PostMapping("/adirector")
        public String postDirector(Director dr, Model model) {
            model.addAttribute("newdir", dr);
            directorRepository.save(dr);
            return "confirmdirector";
        }

        @GetMapping("/displaymovie")
        public String displaymovie(Model model)
        {
            Iterable<Director> dir = directorRepository.findAll();
            model.addAttribute("newdir", dir);
            return "displaymovie";
        }

    }

//    @GetMapping("/adirector")
//    public String enterExperience(Model model)
//    {
//        model.addAttribute("newdir", new Director());
//
//        return "adirector";
//    }
//
//    @PostMapping("/adirector")
//    public String postDirector(@ModelAttribute("newdir") Director director)
//    {
//        directorRepository.save(director);
//        return "confirmdirector";
//    }
//






//        @RequestMapping("/")
//        public @ResponseBody String index(Model model)
//        {
//
//
//            Movie movie = new Movie();
//            movie.setTitle("title");
//
//            movieRepository.save(movie);
//
//            Director dee =  new Director();
//            dee.setName("tom tom");
//            dee.addMovie(movie);
//
//            directorRepository.save(dee);
//
//
//            return "index";
//        }

//
//    @RequestMapping("/")
//    public String index(Model model)
//    {
//        Director director = new Director();
//
//        director.setName("Stephan Bullock");
//        director.setGenre("Sci Fi");
//
//        Movie movie = new Movie();
//        movie.setTitle("Star Movie");
//        movie.setYear(2007);
//        movie.setDescription("About Stars");
//
////
//
//        Set<Movie> movies = new HashSet<Movie>();
//        movies.add(movie);
//        movie = new Movie();
//        movie.setTitle("DeathStar Ewoks");
//        movie.setYear(2011);
//        movie.setDescription("About Ewoks on the DeathStar");
////
//        movies.add(movie);
//
//        director.setMovies(movies);
//        directorRepository.save(director);
//
//        model.addAttribute("directors", directorRepository.findAll());
//        return "index";
//    }
