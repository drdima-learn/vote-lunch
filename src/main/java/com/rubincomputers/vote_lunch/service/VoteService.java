package com.rubincomputers.vote_lunch.service;

import com.rubincomputers.vote_lunch.model.Vote;
import com.rubincomputers.vote_lunch.repository.datajpa.restaurant.CrudRestaurantRepository;
import com.rubincomputers.vote_lunch.repository.datajpa.user.CrudUserRepository;
import com.rubincomputers.vote_lunch.repository.datajpa.vote.CrudVoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import static com.rubincomputers.vote_lunch.util.ValidationUtil.checkNotFoundWithId;

@Service
public class VoteService {

    @Autowired
    private CrudVoteRepository crudVoteRepository;

    @Autowired
    private CrudUserRepository userRepository;

    @Autowired
    private CrudRestaurantRepository restaurantRepository;

    public Vote get(int id) {
        return checkNotFoundWithId(crudVoteRepository.findById(id).orElse(null), id);
    }

    public Vote get(int id, int userId, int restaurantId) {
        return checkNotFoundWithId(
                crudVoteRepository.findById(id)
                        .filter(vote -> vote.getUser().getId() == userId && vote.getRestaurant().getId() == restaurantId)
                        .orElse(null), id);
    }

    public Vote create(Vote vote, int userId, int restaurantId) {
        Assert.notNull(vote, "vote must not be null");
        Assert.notNull(vote.getDate(), "vote.date must not be null");
        if (!vote.isNew() && vote.getUser().getId() == userId && vote.getRestaurant().getId() == restaurantId) {
            return null;
        }
        if (!vote.isNew() && get(vote.id(), userId, restaurantId) == null) {
            return null;
        }


        vote.setUser(userRepository.getReferenceById(userId));
        vote.setRestaurant(restaurantRepository.getReferenceById(restaurantId));
        return crudVoteRepository.save(vote);
    }

}
