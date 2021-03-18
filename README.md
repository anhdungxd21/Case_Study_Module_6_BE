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
