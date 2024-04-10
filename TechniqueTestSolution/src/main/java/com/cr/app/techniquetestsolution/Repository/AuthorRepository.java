package com.cr.app.techniquetestsolution.Repository;

import com.cr.app.techniquetestsolution.Entities.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {


    boolean existsAuthorByFirstNameAndLastName(String firstName, String lastName);
    Author getAuthorByFirstName(String firstName);
}
