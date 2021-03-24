# last-whisper-api

# Song API
#### Song model
    {
    "status": 200,
    "message": "Success",
    "data": [
        {
            "id": 1,
            "name": "song name",
            "link": "link",
            "lyric": "lyric",
            "user": {
                "id": "id",
                "username": "full user name"
            },
            "typeId": {
                "id": "id",
                "type": "type music"
            },
            "singer": {
                "id": "singerid",
                "fullName": "full name singer",
                "gender": "gender",
                "birthday": "birthday",
                "description":"description"
            }
        },
        {
            "id": 2,
            "name": "Tú",
            "link": "link",
            "lyric": "lyric",
            "user": {
                "id": "id",
                "username": "full user name"
            },
            "typeId": {
                "id": "id",
                "type": "type music"
            },
            "singer": {
                "id": "singerid",
                "fullName": "full name singer",
                "gender": "gender",
                "birthday": "birthday",
                "description":"description"
            }
        }]
    }

#### Song model POST
    {
        "name": "song Name",
        "link": "link",
        "lyric": "lyric",
        "userId": "use id",
        "typeId": "type id",
        "singerId": "singer id"
    }
    
#### Song model Getting by id
     {
    "id": 1,
    "name": "Song name",
    "link": "link firebase",
    "lyric": "lyric",
    "user": {
        "id": "id:number,
        "username": "full name"
    },
    "singer": {
        "id": "singerid",
        "fullName": "full name singer",
        "gender": "gender",
        "birthday": "birthday",
        "description":"description"
    }
    }
    
#### Update song by id
    {
        "id": "id",
        "name": "song Name",
        "link": "link",
        "lyric": "unknown",
        "userId": "use id",
        "typeId": "type id",
        "singerId": "singer id"
    }

#### Getting all songs
```GET http://localhost:8080/songs```
#### Getting all sóng contain by name
```GET GET http://localhost:8080/songs?search=name```
#### POST a songs
```POST http://localhost:8080/songs```
#### Getting by id
```GET http://localhost:8080/songs/1```
#### Putting: update song by id
```PUT http://localhost:8080/songs/1```
#### DELETE: delete song by id
```DELETE http://localhost:8080/songs/1```



# Playlist API
#### Playlist model
    {
      "id"          : 1 ;
      "name"        : "Playlist name";
      "description" : "description of description ";
      "avatar"      : "link path image";
      "userId"      : "id of user";
    }
#### PlaylistDTO model
    {
    "id"          : 1 ;
      "name"        : "Playlist name";
      "description" : "description of description ";
      "avatar"      : "link path image";
      "userFullName"      : "full name of user";
    }  
### Get all playlists(pageabel) music for customer
```Get:  http://localhost:8080/playlists```

#### Get all playlists(pageabel) music of user
```Get:  http://localhost:8080/playlists/user/{id}```

#### Get search playlists(pageabel) music of user with name of playlist
```Get: http://localhost:8080/playlists/search/{id}?search=name```

#### Get search all playlists(pageabel) music with name of playlist 
```Get: http://localhost:8080/playlists/search?search=name```

### getUserAuthor after login
``` GET: http://localhost:8080/user/username```
