package com.rubincomputers.vote_lunch.repository.datajpa.vote;

import com.rubincomputers.vote_lunch.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
@Repository
public interface CrudVoteRepository extends JpaRepository<Vote, Integer> {

    @Query("SELECT v FROM Vote v JOIN FETCH v.user u JOIN FETCH v.restaurant r WHERE v.id=:id")
    Optional<Vote> findById(@Param("id") int id);

}
