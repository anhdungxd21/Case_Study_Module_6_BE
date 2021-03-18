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
            "link": "https://firebasestorage.googleapis.com/v0/b/lastwhisper-e6ba5.appspot.com/o/Sound%2F1616033952319?alt=media&token=abae3b48-16d0-4e33-ba1c-734e93580502",
            "lyric": "unknown",
            "userId": 1,
            "typeId": 1,
            "singerId": 1
        },
        {
            "id": 2,
            "name": "Tú",
            "link": "https://firebasestorage.googleapis.com/v0/b/lastwhisper-e6ba5.appspot.com/o/Sound%2F1616033952319?alt=media&token=abae3b48-16d0-4e33-ba1c-734e93580502",
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
        "link": "https://firebasestorage.googleapis.com/v0/b/lastwhisper-e6ba5.appspot.com/o/Sound%2F1616033952319?alt=media&token=abae3b48-16d0-4e33-ba1c-734e93580502",
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
