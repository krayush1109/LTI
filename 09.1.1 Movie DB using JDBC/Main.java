package com.wecp;

public class Main {
    static String url= "jdbc:mysql://localhost:3306/movieManagementDb_wecp";
    static String username = "root";
    static String password = "hellowecp";

    public static void main(String[] args){

    }
}

//     public static void main(String[] args) {
        
//         String url = "jdbc:mysql://localhost:3306/movieManagementDb_wecp";
//         String username = "root";
//         String password = "hellowecp";

//         try {
//             Connection connection = DriverManager.getConnection(url, username, password);
//             MovieDao movieDao = new MovieDaoImpl(connection);

//             // Insert a new movie
//             Movie newMovie = new Movie(0, "Inception", 2010, "Sci-Fi", 8.8);
//             movieDao.insertMovie(newMovie);

//             // Get a movie by ID
//             Movie movie = movieDao.getMovieById(1);
//             System.out.println("Movie: " + movie.getTitle());

//             // Get all movies with pagination
//             List<Movie> movies = movieDao.getAllMovies(10, 1);
//             for (Movie m : movies) {
//                 System.out.println(m.getTitle());
//             }

//             // Get movies by condition
//             List<Movie> sciFiMovies = movieDao.getMoviesByCondition(null, "Sci-Fi", 0);
//             for (Movie m : sciFiMovies) {
//                 System.out.println(m.getTitle());
//             }

//             // Update a movie
//             movie.setTitle("Inception Updated");
//             movieDao.updateMovie(movie);

//             // Delete a movie by ID
//             movieDao.deleteMovieById(1);

//         } catch (Exception e) {
//             e.printStackTrace();
//         }

//     }
// }
