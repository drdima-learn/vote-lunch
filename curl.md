## profile
    #get
    curl http://localhost:8080/vote/rest/profile | json_pp

    #put
    curl -X PUT http://localhost:8080/vote/rest/profile \
    -H 'Content-Type: application/json' \
    -d '{"id": 100000,"registered": "2022-12-11T20:39:15","email": "user@yandex.ru","enabled": true, "name": "User", "password": "passUpdated", "roles": ["USER"]}'
    

## admin
    #get
    curl http://localhost:8080/vote/rest/admin/users/100000 | json_pp

    #getbyEmail
    curl http://localhost:8080/vote/rest/admin/users/by-email?email=user@yandex.ru | json_pp


    #getAll
    curl http://localhost:8080/vote/rest/admin/users | json_pp

    #create //create user
    curl -X POST http://localhost:8080/vote/rest/admin/users \
    -H 'Content-Type: application/json' \
    -d '{"email": "newuser@newdomain.ru","name": "newUser", "password": "newpass", "roles": ["USER"]}'  | json_pp

    #put
    curl -X PUT http://localhost:8080/vote/rest/admin/users/100000 \
    -H 'Content-Type: application/json' \
    -d '{"id": 100000,"registered": "2022-12-11T20:39:15","email": "user@yandex.ru","enabled": true, "name": "User", "password": "fromAdminpassUpdated", "roles": ["USER"]}'


    #delete
    curl -X DELETE http://localhost:8080/vote/rest/admin/users/100000 


## restaurants
    #get
    curl http://localhost:8080/vote/rest/restaurants/100003 | json_pp

    #getAll
    curl http://localhost:8080/vote/rest/restaurants | json_pp


    #getAllByDateWithDishes
    curl http://localhost:8080/vote/rest/restaurants/with-dishes?date=2022-11-10 | json_pp

    
    #delete (admin only)
    curl -X DELETE http://localhost:8080/vote/rest/restaurants/100003



    #create (admin only)
    curl http://localhost:8080/vote/rest/restaurants \
    -H 'Content-Type: application/json' \
    -d '{"name": "new Restaurant"}' | json_pp


    #update (admin only)
    curl -X PUT http://localhost:8080/vote/rest/restaurants/100003 \
    -H 'Content-Type: application/json' \
    -d '{"id": 100003, "name": "updated Restaurant"}'
    