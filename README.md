# last-whisper-api

# Song API
#### Song model
    {
    "status": 200,
    "message": "Success",
    "data": [
        {
            "id": 1,
            "name": "Dương",
            "link": "link",
            "lyric": "unknown",
            "userId": 1,
            "typeId": 1,
            "singerId": 1
        },
        {
            "id": 2,
            "name": "Tú",
            "link": "link",
            "lyric": "unknown",
            "userId": 1,
            "typeId": 1,
            "singerId": 1
        }]
    }

#### Song model POST
    {
    "status": 201,
    "message": "Create success",
    "data": {
        "id": 4,
        "name": "Dũng",
        "link": "link",
        "lyric": "unknown",
        "userId": 1,
        "typeId": 1,
        "singerId": 1
    }
    }

#### Getting all songs
```GET http://localhost:8080/songs```
#### POST a songs
```POST http://localhost:8080/songs```



# Playlist API
#### Playlist model
{
    "content": [
        {
            "id": 2,
            "name": "Do Ai",
            "description": "Ai",
            "avatar": "avatar2",
            "userId": 2
        },
        {
            "id": 3,
            "name": "Do Ai do",
            "description": "Vi Sao",
            "avatar": "avatar3",
            "userId": 1
        }
    ],
    "pageable": {
        "sort": {
            "sorted": true,
            "unsorted": false,
            "empty": false
        },
        "pageSize": 2,
        "pageNumber": 0,
        "offset": 0,
        "paged": true,
        "unpaged": false
    },
    "last": false,
    "totalElements": 7,
    "totalPages": 4,
    "first": true,
    "numberOfElements": 2,
    "size": 2,
    "number": 0,
    "sort": {
        "sorted": true,
        "unsorted": false,
        "empty": false
    },
    "empty": false
}

### Get all playlists music for customer and user
Get:  http://localhost:8080/playlists

