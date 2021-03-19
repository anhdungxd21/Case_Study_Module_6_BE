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
            "lyric": "unknown",
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
        "lyric": "unknown",
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
      private Long id;
      private String name;
      private String link;
      private String lyric;
      private Long userId;
      private Long typeId;
      private Long singerId;
      }
#### PlaylistDTO model
    {
    private Long id;
    private String name;
    private String description;
    private String avatar;
    private String userFullName;
    }  

### Get all playlists(pageabel) music for customer
```Get:  http://localhost:8080/playlists```

    {
    "content": [
        {
            "id": 2,
            "name": "Do Ai",
            "description": "Ai",
            "avatar": "avatar2",
            "userFullName": "Luong Anh Tu"
        },
        {
            "id": 3,
            "name": "Do Ai do",
            "description": "Vi Sao",
            "avatar": "avatar3",
            "userFullName": "aaaaaaaa"
        }
    ],
    "pageable": {
        "sort": {
            "sorted": true,
            "unsorted": false,
            "empty": false
        },
        "offset": 0,
        "pageSize": 2,
        "pageNumber": 0,
        "unpaged": false,
        "paged": true
    },
    "last": true,
    "totalElements": 2,
    "totalPages": 1,
    "size": 2,
    "number": 0,
    "sort": {
        "sorted": true,
        "unsorted": false,
        "empty": false
    },
    "first": true,
    "numberOfElements": 2,
    "empty": false
    }
    }

#### Get all playlists(pageabel) music for user
```Get:  http://localhost:8080/playlists/user/{id}```

    {
    "content": [
        {
            "id": 3,
            "name": "Do Ai do",
            "description": "Vi Sao",
            "avatar": "avatar3",
            "userFullName": "aaaaaaaa"
        },
        {
            "id": 4,
            "name": "Do Do do",
            "description": "Vi quen",
            "avatar": "avatar4",
            "userFullName": "aaaaaaaa"
        },
        {
            "id": 7,
            "name": "Quen ai",
            "description": "Ai do ai",
            "avatar": "avatar7",
            "userFullName": "aaaaaaaa"
        },
        {
            "id": 6,
            "name": "va ai",
            "description": "Phong Bao",
            "avatar": "avatar6",
            "userFullName": "aaaaaaaa"
        },
        {
            "id": 1,
            "name": "Vi Ai",
            "description": "Loi Bai hat",
            "avatar": "avatar1",
            "userFullName": "aaaaaaaa"
        },
        {
            "id": 5,
            "name": "Xong",
            "description": "Quen",
            "avatar": "avatar5",
            "userFullName": "aaaaaaaa"
        }
    ],
    "pageable": {
        "sort": {
            "sorted": true,
            "unsorted": false,
            "empty": false
        },
        "offset": 0,
        "pageSize": 10,
        "pageNumber": 0,
        "unpaged": false,
        "paged": true
    },
    "last": true,
    "totalElements": 6,
    "totalPages": 1,
    "size": 10,
    "number": 0,
    "sort": {
        "sorted": true,
        "unsorted": false,
        "empty": false
    },
    "first": true,
    "numberOfElements": 6,
    "empty": false
    }
    cc
# Playlist API
#### Playlist model
    {
      private Long id;
      private String name;
      private String link;
      private String lyric;
      private Long userId;
      private Long typeId;
      private Long singerId;
    }
#### PlaylistDTO model
   {
     private Long id;
    private String name;
    private String description;
    private String avatar;
    private String userFullName;
   }  
### Get all playlists(pageabel) music for customer
```Get:  http://localhost:8080/playlists``
    {
    "content": [
        {
            "id": 2,
            "name": "Do Ai",
            "description": "Ai",
            "avatar": "avatar2",
            "userFullName": "Luong Anh Tu"
        },
        {
            "id": 3,
            "name": "Do Ai do",
            "description": "Vi Sao",
            "avatar": "avatar3",
            "userFullName": "aaaaaaaa"
        }
    ],
    "pageable": {
        "sort": {
            "sorted": true,
            "unsorted": false,
            "empty": false
        },
        "offset": 0,
        "pageSize": 2,
        "pageNumber": 0,
        "unpaged": false,
        "paged": true
    },
    "last": true,
    "totalElements": 2,
    "totalPages": 1,
    "size": 2,
    "number": 0,
    "sort": {
        "sorted": true,
        "unsorted": false,
        "empty": false
    },
    "first": true,
    "numberOfElements": 2,
    "empty": false
    }
}
#### Get all playlists(pageabel) music for user
```Get:  http://localhost:8080/playlists/user/{id}``
{
    "content": [
        {
            "id": 3,
            "name": "Do Ai do",
            "description": "Vi Sao",
            "avatar": "avatar3",
            "userFullName": "aaaaaaaa"
        },
        {
            "id": 4,
            "name": "Do Do do",
            "description": "Vi quen",
            "avatar": "avatar4",
            "userFullName": "aaaaaaaa"
        },
        {
            "id": 7,
            "name": "Quen ai",
            "description": "Ai do ai",
            "avatar": "avatar7",
            "userFullName": "aaaaaaaa"
        },
        {
            "id": 6,
            "name": "va ai",
            "description": "Phong Bao",
            "avatar": "avatar6",
            "userFullName": "aaaaaaaa"
        },
        {
            "id": 1,
            "name": "Vi Ai",
            "description": "Loi Bai hat",
            "avatar": "avatar1",
            "userFullName": "aaaaaaaa"
        },
        {
            "id": 5,
            "name": "Xong",
            "description": "Quen",
            "avatar": "avatar5",
            "userFullName": "aaaaaaaa"
        }
    ],
    "pageable": {
        "sort": {
            "sorted": true,
            "unsorted": false,
            "empty": false
        },
        "offset": 0,
        "pageSize": 10,
        "pageNumber": 0,
        "unpaged": false,
        "paged": true
    },
    "last": true,
    "totalElements": 6,
    "totalPages": 1,
    "size": 10,
    "number": 0,
    "sort": {
        "sorted": true,
        "unsorted": false,
        "empty": false
    },
    "first": true,
    "numberOfElements": 6,
    "empty": false
}
#### Get search playlists(pageabel) music
```http://localhost:8080/playlists/search/${id}?page=${page}&size=${size}&sort=${sort}&name=${name}```
{
    "content": [
        {
            "id": 3,
            "name": "Do Ai do",
            "description": "Vi Sao",
            "avatar": "avatar3",
            "userFullName": "aaaaaaaa"
        },
        {
            "id": 4,
            "name": "Do Do do",
            "description": "Vi quen",
            "avatar": "avatar4",
            "userFullName": "aaaaaaaa"
        },
        {
            "id": 7,
            "name": "Quen ai",
            "description": "Ai do ai",
            "avatar": "avatar7",
            "userFullName": "aaaaaaaa"
        },
        {
            "id": 6,
            "name": "va ai",
            "description": "Phong Bao",
            "avatar": "avatar6",
            "userFullName": "aaaaaaaa"
        },
        {
            "id": 1,
            "name": "Vi Ai",
            "description": "Loi Bai hat",
            "avatar": "avatar1",
            "userFullName": "aaaaaaaa"
        },
        {
            "id": 5,
            "name": "Xong",
            "description": "Quen",
            "avatar": "avatar5",
            "userFullName": "aaaaaaaa"
        }
    ],
    "pageable": {
        "sort": {
            "sorted": true,
            "unsorted": false,
            "empty": false
        },
        "pageNumber": 0,
        "pageSize": 10,
        "offset": 0,
        "paged": true,
        "unpaged": false
    },
    "last": true,
    "totalElements": 6,
    "totalPages": 1,
    "first": true,
    "numberOfElements": 6,
    "size": 10,
    "number": 0,
    "sort": {
        "sorted": true,
        "unsorted": false,
        "empty": false
    },
    "empty": false
}


### getUserAuthor after login
``` GET: http://localhost:8080/user/username```
