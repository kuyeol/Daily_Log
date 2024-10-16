

```json

{
    "modelName": "Graphs in MongoDB",
    "collections": [
        {
            "bucketId": "432b8e50-2360-11e7-b174-834c31d10a9e",
            "properties": [
                {
                    "type": "numeric",
                    "primaryKey": false,
                    "name": "_id",
                    "GUID": "4315bc61-2360-11e7-b174-834c31d10a9e",
                    "relationshipType": "",
                    "required": true,
                    "sample": 3,
                    "mode": "integer32",
                    "isActivated": true
                },
                {
                    "type": "string",
                    "primaryKey": false,
                    "name": "airport",
                    "GUID": "4315bc62-2360-11e7-b174-834c31d10a9e",
                    "relationshipType": "",
                    "childRelationships": [
                        "8bfb3c20-2360-11e7-b174-834c31d10a9e"
                    ],
                    "required": true,
                    "sample": "PWM",
                    "isActivated": true
                },
                {
                    "type": "array",
                    "primaryKey": false,
                    "name": "connects",
                    "additionalItems": true,
                    "GUID": "4315bc63-2360-11e7-b174-834c31d10a9e",
                    "relationshipType": "",
                    "properties": [
                        {
                            "type": "document",
                            "properties": [
                                {
                                    "type": "string",
                                    "primaryKey": false,
                                    "name": "to",
                                    "GUID": "4315bc67-2360-11e7-b174-834c31d10a9e",
                                    "relationshipType": "Foreign Key",
                                    "parentRelationship": "8bfb3c20-2360-11e7-b174-834c31d10a9e",
                                    "foreignCollection": "4315bc60-2360-11e7-b174-834c31d10a9e",
                                    "foreignField": [
                                        "4315bc60-2360-11e7-b174-834c31d10a9e",
                                        "4315bc62-2360-11e7-b174-834c31d10a9e"
                                    ],
                                    "required": true,
                                    "sample": "BOS",
                                    "isActivated": true
                                },
                                {
                                    "type": "array",
                                    "primaryKey": false,
                                    "name": "airlines",
                                    "additionalItems": true,
                                    "GUID": "4315bc65-2360-11e7-b174-834c31d10a9e",
                                    "relationshipType": "",
                                    "properties": [
                                        {
                                            "type": "string",
                                            "arrayItem": true,
                                            "primaryKey": false,
                                            "relationshipType": "",
                                            "GUID": "4315bc66-2360-11e7-b174-834c31d10a9e",
                                            "sample": "AA",
                                            "isActivated": true
                                        }
                                    ],
                                    "required": true,
                                    "isActivated": true
                                }
                            ],
                            "arrayItem": true,
                            "primaryKey": false,
                            "relationshipType": "",
                            "GUID": "4315bc64-2360-11e7-b174-834c31d10a9e",
                            "isActivated": true,
                            "additionalProperties": true
                        }
                    ],
                    "required": true,
                    "isActivated": true
                }
            ],
            "type": "object",
            "GUID": "4315bc60-2360-11e7-b174-834c31d10a9e",
            "definitions": {
                "GUID": "43159550-2360-11e7-b174-834c31d10a9e",
                "properties": [],
                "type": "definitions"
            },
            "collectionName": "airports",
            "indexes": [
                {
                    "key": [
                        {
                            "keyId": "4315bc61-2360-11e7-b174-834c31d10a9e",
                            "type": "ascending"
                        }
                    ],
                    "name": "_id_",
                    "GUID": "4316cdd0-2360-11e7-b174-834c31d10a9e",
                    "isActivated": true
                }
            ],
            "collation": {},
            "sharding": {
                "key": "",
                "hashed": false,
                "unique": true,
                "numInitialChunks": "",
                "collation": "null",
                "zone": "",
                "comments": ""
            },
            "isActivated": true,
            "additionalProperties": true
        },
        {
            "bucketId": "61540440-2363-11e7-b174-834c31d10a9e",
            "properties": [
                {
                    "type": "objectId",
                    "primaryKey": true,
                    "name": "_id",
                    "GUID": "61370662-2363-11e7-b174-834c31d10a9e",
                    "relationshipType": "",
                    "required": true,
                    "isActivated": true
                },
                {
                    "type": "string",
                    "primaryKey": false,
                    "name": "from",
                    "GUID": "61370663-2363-11e7-b174-834c31d10a9e",
                    "relationshipType": "Foreign Key",
                    "parentRelationship": "a7dc0c00-2363-11e7-b174-834c31d10a9e",
                    "foreignCollection": "61350a91-2363-11e7-b174-834c31d10a9e",
                    "foreignField": [
                        "61350a91-2363-11e7-b174-834c31d10a9e",
                        "61350a92-2363-11e7-b174-834c31d10a9e"
                    ],
                    "required": true,
                    "sample": "djw",
                    "isActivated": true
                },
                {
                    "type": "string",
                    "primaryKey": false,
                    "name": "to",
                    "GUID": "61370664-2363-11e7-b174-834c31d10a9e",
                    "relationshipType": "Foreign Key",
                    "parentRelationship": "ad1c0a80-2363-11e7-b174-834c31d10a9e",
                    "foreignCollection": "61350a91-2363-11e7-b174-834c31d10a9e",
                    "foreignField": [
                        "61350a91-2363-11e7-b174-834c31d10a9e",
                        "61350a92-2363-11e7-b174-834c31d10a9e"
                    ],
                    "required": true,
                    "sample": "jsr",
                    "isActivated": true
                },
                {
                    "type": "string",
                    "primaryKey": false,
                    "name": "group",
                    "GUID": "61370665-2363-11e7-b174-834c31d10a9e",
                    "relationshipType": "",
                    "required": true,
                    "sample": "work",
                    "isActivated": true
                },
                {
                    "type": "string",
                    "primaryKey": false,
                    "name": "ts",
                    "GUID": "61370666-2363-11e7-b174-834c31d10a9e",
                    "relationshipType": "",
                    "required": true,
                    "sample": "2013-07-11T03:30:20.201Z",
                    "isActivated": true
                }
            ],
            "type": "object",
            "GUID": "61370661-2363-11e7-b174-834c31d10a9e",
            "definitions": {
                "GUID": "61370660-2363-11e7-b174-834c31d10a9e",
                "properties": [],
                "type": "definitions"
            },
            "collectionName": "followers",
            "indexes": [
                {
                    "key": [
                        {
                            "keyId": "61370662-2363-11e7-b174-834c31d10a9e",
                            "type": "ascending"
                        }
                    ],
                    "name": "_id_",
                    "GUID": "61370667-2363-11e7-b174-834c31d10a9e",
                    "isActivated": true
                }
            ],
            "collation": {},
            "sharding": {
                "key": "",
                "hashed": false,
                "unique": true,
                "numInitialChunks": "",
                "collation": "null",
                "zone": "",
                "comments": ""
            },
            "isActivated": true,
            "additionalProperties": true
        },
        {
            "bucketId": "1f61bbd0-2364-11e7-b174-834c31d10a9e",
            "properties": [
                {
                    "type": "objectId",
                    "primaryKey": true,
                    "name": "_id",
                    "GUID": "1f3e7c67-2364-11e7-b174-834c31d10a9e",
                    "relationshipType": "",
                    "required": true,
                    "isActivated": true
                },
                {
                    "type": "string",
                    "primaryKey": false,
                    "name": "from",
                    "GUID": "1f3e7c68-2364-11e7-b174-834c31d10a9e",
                    "relationshipType": "Foreign Key",
                    "parentRelationship": "5c9d3d80-2364-11e7-b174-834c31d10a9e",
                    "foreignCollection": "1f3b6f21-2364-11e7-b174-834c31d10a9e",
                    "foreignField": [
                        "1f3b6f21-2364-11e7-b174-834c31d10a9e",
                        "1f3b6f22-2364-11e7-b174-834c31d10a9e"
                    ],
                    "required": true,
                    "sample": "djw",
                    "isActivated": true
                },
                {
                    "type": "string",
                    "primaryKey": false,
                    "name": "to",
                    "GUID": "1f3e7c69-2364-11e7-b174-834c31d10a9e",
                    "relationshipType": "Foreign Key",
                    "parentRelationship": "643ab400-2364-11e7-b174-834c31d10a9e",
                    "foreignCollection": "1f3b6f21-2364-11e7-b174-834c31d10a9e",
                    "foreignField": [
                        "1f3b6f21-2364-11e7-b174-834c31d10a9e",
                        "1f3b6f22-2364-11e7-b174-834c31d10a9e"
                    ],
                    "required": true,
                    "sample": "jsr",
                    "isActivated": true
                },
                {
                    "type": "string",
                    "primaryKey": false,
                    "name": "group",
                    "GUID": "1f3e7c6a-2364-11e7-b174-834c31d10a9e",
                    "relationshipType": "",
                    "required": true,
                    "sample": "work",
                    "isActivated": true
                },
                {
                    "type": "string",
                    "primaryKey": false,
                    "name": "ts",
                    "GUID": "1f3e7c6b-2364-11e7-b174-834c31d10a9e",
                    "relationshipType": "",
                    "required": true,
                    "sample": "2013-07-11T03:30:20.201Z",
                    "isActivated": true
                }
            ],
            "type": "object",
            "GUID": "1f3e7c66-2364-11e7-b174-834c31d10a9e",
            "definitions": {
                "GUID": "1f3e7c65-2364-11e7-b174-834c31d10a9e",
                "properties": [],
                "type": "definitions"
            },
            "collectionName": "followers",
            "indexes": [
                {
                    "key": [
                        {
                            "keyId": "1f3e7c67-2364-11e7-b174-834c31d10a9e",
                            "type": "ascending"
                        }
                    ],
                    "name": "_id_",
                    "GUID": "1f3e7c6c-2364-11e7-b174-834c31d10a9e",
                    "isActivated": true
                }
            ],
            "collation": {},
            "sharding": {
                "key": "",
                "hashed": false,
                "unique": true,
                "numInitialChunks": "",
                "collation": "null",
                "zone": "",
                "comments": ""
            },
            "isActivated": true,
            "additionalProperties": true
        },
        {
            "bucketId": "1f61bbd0-2364-11e7-b174-834c31d10a9e",
            "properties": [
                {
                    "type": "objectId",
                    "primaryKey": true,
                    "name": "_id",
                    "GUID": "1f407837-2364-11e7-b174-834c31d10a9e",
                    "relationshipType": "",
                    "required": true,
                    "isActivated": true
                },
                {
                    "type": "string",
                    "primaryKey": false,
                    "name": "from",
                    "GUID": "1f407838-2364-11e7-b174-834c31d10a9e",
                    "relationshipType": "Foreign Key",
                    "parentRelationship": "68f555e0-2364-11e7-b174-834c31d10a9e",
                    "foreignCollection": "1f3b6f21-2364-11e7-b174-834c31d10a9e",
                    "foreignField": [
                        "1f3b6f21-2364-11e7-b174-834c31d10a9e",
                        "1f3b6f22-2364-11e7-b174-834c31d10a9e"
                    ],
                    "required": true,
                    "sample": "jsr",
                    "isActivated": true
                },
                {
                    "type": "string",
                    "primaryKey": false,
                    "name": "to",
                    "GUID": "1f407839-2364-11e7-b174-834c31d10a9e",
                    "relationshipType": "Foreign Key",
                    "parentRelationship": "6d08e250-2364-11e7-b174-834c31d10a9e",
                    "foreignCollection": "1f3b6f21-2364-11e7-b174-834c31d10a9e",
                    "foreignField": [
                        "1f3b6f21-2364-11e7-b174-834c31d10a9e",
                        "1f3b6f22-2364-11e7-b174-834c31d10a9e"
                    ],
                    "required": true,
                    "sample": "dwj",
                    "isActivated": true
                },
                {
                    "type": "string",
                    "primaryKey": false,
                    "name": "group",
                    "GUID": "1f40783a-2364-11e7-b174-834c31d10a9e",
                    "relationshipType": "",
                    "required": true,
                    "sample": "work",
                    "isActivated": true
                },
                {
                    "type": "string",
                    "primaryKey": false,
                    "name": "ts",
                    "GUID": "1f40783b-2364-11e7-b174-834c31d10a9e",
                    "relationshipType": "",
                    "required": true,
                    "sample": "2013-07-11T03:30:20.201Z",
                    "isActivated": true
                }
            ],
            "type": "object",
            "GUID": "1f407836-2364-11e7-b174-834c31d10a9e",
            "definitions": {
                "GUID": "1f407835-2364-11e7-b174-834c31d10a9e",
                "properties": [],
                "type": "definitions"
            },
            "collectionName": "following",
            "indexes": [
                {
                    "key": [
                        {
                            "keyId": "1f407837-2364-11e7-b174-834c31d10a9e",
                            "type": "ascending"
                        }
                    ],
                    "name": "_id_",
                    "GUID": "1f40783c-2364-11e7-b174-834c31d10a9e",
                    "isActivated": true
                }
            ],
            "collation": {},
            "sharding": {
                "key": "",
                "hashed": false,
                "unique": true,
                "numInitialChunks": "",
                "collation": "null",
                "zone": "",
                "comments": ""
            },
            "isActivated": true,
            "additionalProperties": true
        },
        {
            "bucketId": "1f61bbd0-2364-11e7-b174-834c31d10a9e",
            "properties": [
                {
                    "type": "string",
                    "primaryKey": true,
                    "relationshipType": "",
                    "childRelationships": [
                        "5c9d3d80-2364-11e7-b174-834c31d10a9e",
                        "643ab400-2364-11e7-b174-834c31d10a9e",
                        "68f555e0-2364-11e7-b174-834c31d10a9e",
                        "6d08e250-2364-11e7-b174-834c31d10a9e"
                    ],
                    "sample": "djw",
                    "GUID": "1f3b6f22-2364-11e7-b174-834c31d10a9e",
                    "required": true,
                    "name": "_id",
                    "isActivated": true
                },
                {
                    "type": "string",
                    "primaryKey": false,
                    "name": "fullname",
                    "GUID": "1f3b6f23-2364-11e7-b174-834c31d10a9e",
                    "relationshipType": "",
                    "required": true,
                    "sample": "Darren Wood",
                    "isActivated": true
                },
                {
                    "type": "string",
                    "primaryKey": false,
                    "name": "country",
                    "GUID": "1f3b6f24-2364-11e7-b174-834c31d10a9e",
                    "relationshipType": "",
                    "required": true,
                    "sample": "Australia",
                    "isActivated": true
                }
            ],
            "type": "object",
            "GUID": "1f3b6f21-2364-11e7-b174-834c31d10a9e",
            "definitions": {
                "GUID": "1f3b6f20-2364-11e7-b174-834c31d10a9e",
                "properties": [],
                "type": "definitions"
            },
            "collectionName": "users",
            "indexes": [
                {
                    "key": [
                        {
                            "keyId": "1f3b6f22-2364-11e7-b174-834c31d10a9e",
                            "type": "ascending"
                        }
                    ],
                    "name": "_id_",
                    "GUID": "1f3ca7a0-2364-11e7-b174-834c31d10a9e",
                    "isActivated": true
                }
            ],
            "collation": {},
            "sharding": {
                "key": "_id_",
                "hashed": false,
                "unique": true,
                "numInitialChunks": "",
                "collation": "null",
                "zone": "",
                "comments": "",
                "error": {
                    "hashed": false
                }
            },
            "isActivated": true,
            "additionalProperties": true
        },
        {
            "bucketId": "61540440-2363-11e7-b174-834c31d10a9e",
            "properties": [
                {
                    "type": "string",
                    "primaryKey": true,
                    "relationshipType": "",
                    "childRelationships": [
                        "a7dc0c00-2363-11e7-b174-834c31d10a9e",
                        "ad1c0a80-2363-11e7-b174-834c31d10a9e"
                    ],
                    "sample": "djw",
                    "GUID": "61350a92-2363-11e7-b174-834c31d10a9e",
                    "required": true,
                    "name": "_id",
                    "isActivated": true
                },
                {
                    "type": "string",
                    "primaryKey": false,
                    "name": "fullname",
                    "GUID": "61350a93-2363-11e7-b174-834c31d10a9e",
                    "relationshipType": "",
                    "required": true,
                    "sample": "Darren Wood",
                    "isActivated": true
                },
                {
                    "type": "string",
                    "primaryKey": false,
                    "name": "country",
                    "GUID": "61350a94-2363-11e7-b174-834c31d10a9e",
                    "relationshipType": "",
                    "required": true,
                    "sample": "Australia",
                    "isActivated": true
                }
            ],
            "type": "object",
            "GUID": "61350a91-2363-11e7-b174-834c31d10a9e",
            "definitions": {
                "GUID": "61350a90-2363-11e7-b174-834c31d10a9e",
                "properties": [],
                "type": "definitions"
            },
            "collectionName": "users",
            "indexes": [
                {
                    "key": [
                        {
                            "keyId": "61350a92-2363-11e7-b174-834c31d10a9e",
                            "type": "ascending"
                        }
                    ],
                    "name": "_id_",
                    "GUID": "6135f4f0-2363-11e7-b174-834c31d10a9e",
                    "isActivated": true
                }
            ],
            "collation": {},
            "sharding": {
                "key": "",
                "hashed": false,
                "unique": true,
                "numInitialChunks": "",
                "collation": "null",
                "zone": "",
                "comments": ""
            },
            "isActivated": true,
            "additionalProperties": true
        },
        {
            "bucketId": "61f60610-2362-11e7-b174-834c31d10a9e",
            "properties": [
                {
                    "type": "string",
                    "primaryKey": true,
                    "relationshipType": "",
                    "childRelationships": [
                        "74da24f0-2362-11e7-b174-834c31d10a9e",
                        "7da482b0-2362-11e7-b174-834c31d10a9e"
                    ],
                    "sample": "djw",
                    "GUID": "61dd4df1-2362-11e7-b174-834c31d10a9e",
                    "required": true,
                    "name": "_id",
                    "isActivated": true
                },
                {
                    "type": "string",
                    "primaryKey": false,
                    "name": "fullname",
                    "GUID": "61dd4df2-2362-11e7-b174-834c31d10a9e",
                    "relationshipType": "",
                    "required": true,
                    "sample": "Darren Wood",
                    "isActivated": true
                },
                {
                    "type": "string",
                    "primaryKey": false,
                    "name": "country",
                    "GUID": "61dd4df3-2362-11e7-b174-834c31d10a9e",
                    "relationshipType": "",
                    "required": true,
                    "sample": "Australia",
                    "isActivated": true
                },
                {
                    "type": "array",
                    "primaryKey": false,
                    "name": "followers",
                    "additionalItems": true,
                    "GUID": "61dd4df4-2362-11e7-b174-834c31d10a9e",
                    "relationshipType": "",
                    "properties": [
                        {
                            "type": "string",
                            "arrayItem": true,
                            "primaryKey": false,
                            "relationshipType": "Foreign Key",
                            "parentRelationship": "74da24f0-2362-11e7-b174-834c31d10a9e",
                            "foreignCollection": "61dd4df0-2362-11e7-b174-834c31d10a9e",
                            "foreignField": [
                                "61dd4df0-2362-11e7-b174-834c31d10a9e",
                                "61dd4df1-2362-11e7-b174-834c31d10a9e"
                            ],
                            "GUID": "61dd4df5-2362-11e7-b174-834c31d10a9e",
                            "sample": "jsr",
                            "isActivated": true
                        }
                    ],
                    "required": true,
                    "isActivated": true
                },
                {
                    "type": "array",
                    "primaryKey": false,
                    "name": "following",
                    "additionalItems": true,
                    "GUID": "61dd4df6-2362-11e7-b174-834c31d10a9e",
                    "relationshipType": "",
                    "properties": [
                        {
                            "type": "string",
                            "arrayItem": true,
                            "primaryKey": false,
                            "relationshipType": "Foreign Key",
                            "parentRelationship": "7da482b0-2362-11e7-b174-834c31d10a9e",
                            "foreignCollection": "61dd4df0-2362-11e7-b174-834c31d10a9e",
                            "foreignField": [
                                "61dd4df0-2362-11e7-b174-834c31d10a9e",
                                "61dd4df1-2362-11e7-b174-834c31d10a9e"
                            ],
                            "GUID": "61dd4df7-2362-11e7-b174-834c31d10a9e",
                            "sample": "jsr",
                            "isActivated": true
                        }
                    ],
                    "required": true,
                    "isActivated": true
                },
                {
                    "type": "array",
                    "properties": [
                        {
                            "type": "string",
                            "primaryKey": false,
                            "relationshipType": "",
                            "GUID": "d65c9b90-2362-11e7-b174-834c31d10a9e",
                            "arrayItem": true,
                            "arrayParentType": "array",
                            "isActivated": true
                        }
                    ],
                    "primaryKey": false,
                    "relationshipType": "",
                    "additionalItems": true,
                    "GUID": "d22bc320-2362-11e7-b174-834c31d10a9e",
                    "required": true,
                    "name": "group",
                    "isActivated": true
                }
            ],
            "type": "object",
            "GUID": "61dd4df0-2362-11e7-b174-834c31d10a9e",
            "definitions": {
                "GUID": "61dd26e0-2362-11e7-b174-834c31d10a9e",
                "properties": [],
                "type": "definitions"
            },
            "collectionName": "users",
            "indexes": [
                {
                    "key": [
                        {
                            "keyId": "61dd4df1-2362-11e7-b174-834c31d10a9e",
                            "type": "ascending"
                        }
                    ],
                    "name": "_id_",
                    "GUID": "61ddea30-2362-11e7-b174-834c31d10a9e",
                    "isActivated": true
                }
            ],
            "collation": {},
            "sharding": {
                "key": "",
                "hashed": false,
                "unique": true,
                "numInitialChunks": "",
                "collation": "null",
                "zone": "",
                "comments": ""
            },
            "isActivated": true,
            "additionalProperties": true
        }
    ],
    "buckets": [
        {
            "GUID": "432b8e50-2360-11e7-b174-834c31d10a9e",
            "name": "graphs",
            "type": "bucket",
            "collectionIds": [
                "4315bc60-2360-11e7-b174-834c31d10a9e"
            ],
            "backgroundColor": {
                "r": 33,
                "g": 150,
                "b": 243,
                "a": 1
            },
            "show": true,
            "enableSharding": true,
            "isActivated": true
        },
        {
            "GUID": "61f60610-2362-11e7-b174-834c31d10a9e",
            "name": "graphs(1)",
            "type": "bucket",
            "description": "All documents in one single collection",
            "collectionIds": [
                "61dd4df0-2362-11e7-b174-834c31d10a9e"
            ],
            "backgroundColor": {
                "r": 0,
                "g": 188,
                "b": 213,
                "a": 1
            },
            "show": true,
            "enableSharding": true,
            "isActivated": true
        },
        {
            "GUID": "61540440-2363-11e7-b174-834c31d10a9e",
            "name": "graphs(2)",
            "type": "bucket",
            "collectionIds": [
                "61350a91-2363-11e7-b174-834c31d10a9e",
                "61370661-2363-11e7-b174-834c31d10a9e"
            ],
            "backgroundColor": {
                "r": 119,
                "g": 119,
                "b": 119,
                "a": 1
            },
            "show": true,
            "enableSharding": true,
            "isActivated": true
        },
        {
            "GUID": "1f61bbd0-2364-11e7-b174-834c31d10a9e",
            "name": "graphs(3)",
            "type": "bucket",
            "description": "May seem un-natural, but has the advantage of leeting you shard worldwide",
            "comments": "https://github.com/mongodb-labs/socialite/blob/master/docs/graph.md\n",
            "collectionIds": [
                "1f3b6f21-2364-11e7-b174-834c31d10a9e",
                "1f3e7c66-2364-11e7-b174-834c31d10a9e",
                "1f407836-2364-11e7-b174-834c31d10a9e"
            ],
            "backgroundColor": {
                "r": 164,
                "g": 196,
                "b": 0,
                "a": 1
            },
            "show": true,
            "enableSharding": true,
            "isActivated": true
        }
    ],
    "views": [],
    "relationships": [
        {
            "GUID": "8bfb3c20-2360-11e7-b174-834c31d10a9e",
            "name": "fk airports.airport to airports.connects.[0].to",
            "description": "",
            "comments": "",
            "relationshipType": "Foreign Key",
            "parentCollection": "4315bc60-2360-11e7-b174-834c31d10a9e",
            "parentField": [
                [
                    "4315bc60-2360-11e7-b174-834c31d10a9e",
                    "4315bc62-2360-11e7-b174-834c31d10a9e"
                ]
            ],
            "parentCardinality": "1",
            "childCollection": "4315bc60-2360-11e7-b174-834c31d10a9e",
            "childField": [
                [
                    "4315bc60-2360-11e7-b174-834c31d10a9e",
                    "4315bc63-2360-11e7-b174-834c31d10a9e",
                    "4315bc64-2360-11e7-b174-834c31d10a9e",
                    "4315bc67-2360-11e7-b174-834c31d10a9e"
                ]
            ],
            "childCardinality": "0..n"
        },
        {
            "GUID": "74da24f0-2362-11e7-b174-834c31d10a9e",
            "name": "New Relationship",
            "description": "",
            "comments": "",
            "relationshipType": "Foreign Key",
            "parentCollection": "61dd4df0-2362-11e7-b174-834c31d10a9e",
            "parentField": [
                [
                    "61dd4df0-2362-11e7-b174-834c31d10a9e",
                    "61dd4df1-2362-11e7-b174-834c31d10a9e"
                ]
            ],
            "parentCardinality": "1",
            "childCollection": "61dd4df0-2362-11e7-b174-834c31d10a9e",
            "childField": [
                [
                    "61dd4df0-2362-11e7-b174-834c31d10a9e",
                    "61dd4df4-2362-11e7-b174-834c31d10a9e",
                    "61dd4df5-2362-11e7-b174-834c31d10a9e"
                ]
            ],
            "childCardinality": "0..n"
        },
        {
            "GUID": "7da482b0-2362-11e7-b174-834c31d10a9e",
            "name": "fk twitEdgeArray._id to twitEdgeArray.following.[0]",
            "description": "",
            "comments": "",
            "relationshipType": "Foreign Key",
            "parentCollection": "61dd4df0-2362-11e7-b174-834c31d10a9e",
            "parentField": [
                [
                    "61dd4df0-2362-11e7-b174-834c31d10a9e",
                    "61dd4df1-2362-11e7-b174-834c31d10a9e"
                ]
            ],
            "parentCardinality": "1",
            "childCollection": "61dd4df0-2362-11e7-b174-834c31d10a9e",
            "childField": [
                [
                    "61dd4df0-2362-11e7-b174-834c31d10a9e",
                    "61dd4df6-2362-11e7-b174-834c31d10a9e",
                    "61dd4df7-2362-11e7-b174-834c31d10a9e"
                ]
            ],
            "childCardinality": "0..n"
        },
        {
            "GUID": "a7dc0c00-2363-11e7-b174-834c31d10a9e",
            "name": "fk users._id to followers.from",
            "description": "",
            "comments": "",
            "relationshipType": "Foreign Key",
            "parentCollection": "61350a91-2363-11e7-b174-834c31d10a9e",
            "parentField": [
                [
                    "61350a91-2363-11e7-b174-834c31d10a9e",
                    "61350a92-2363-11e7-b174-834c31d10a9e"
                ]
            ],
            "parentCardinality": "1",
            "childCollection": "61370661-2363-11e7-b174-834c31d10a9e",
            "childField": [
                [
                    "61370661-2363-11e7-b174-834c31d10a9e",
                    "61370663-2363-11e7-b174-834c31d10a9e"
                ]
            ],
            "childCardinality": "0..n"
        },
        {
            "GUID": "ad1c0a80-2363-11e7-b174-834c31d10a9e",
            "name": "fk users._id to followers.to",
            "description": "",
            "comments": "",
            "relationshipType": "Foreign Key",
            "parentCollection": "61350a91-2363-11e7-b174-834c31d10a9e",
            "parentField": [
                [
                    "61350a91-2363-11e7-b174-834c31d10a9e",
                    "61350a92-2363-11e7-b174-834c31d10a9e"
                ]
            ],
            "parentCardinality": "1",
            "childCollection": "61370661-2363-11e7-b174-834c31d10a9e",
            "childField": [
                [
                    "61370661-2363-11e7-b174-834c31d10a9e",
                    "61370664-2363-11e7-b174-834c31d10a9e"
                ]
            ],
            "childCardinality": "0..n"
        },
        {
            "GUID": "5c9d3d80-2364-11e7-b174-834c31d10a9e",
            "name": "fk users._id to followers.from",
            "description": "",
            "comments": "",
            "relationshipType": "Foreign Key",
            "parentCollection": "1f3b6f21-2364-11e7-b174-834c31d10a9e",
            "parentField": [
                [
                    "1f3b6f21-2364-11e7-b174-834c31d10a9e",
                    "1f3b6f22-2364-11e7-b174-834c31d10a9e"
                ]
            ],
            "parentCardinality": "1",
            "childCollection": "1f3e7c66-2364-11e7-b174-834c31d10a9e",
            "childField": [
                [
                    "1f3e7c66-2364-11e7-b174-834c31d10a9e",
                    "1f3e7c68-2364-11e7-b174-834c31d10a9e"
                ]
            ],
            "childCardinality": "0..n"
        },
        {
            "GUID": "643ab400-2364-11e7-b174-834c31d10a9e",
            "name": "fk users._id to followers.to",
            "description": "",
            "comments": "",
            "relationshipType": "Foreign Key",
            "parentCollection": "1f3b6f21-2364-11e7-b174-834c31d10a9e",
            "parentField": [
                [
                    "1f3b6f21-2364-11e7-b174-834c31d10a9e",
                    "1f3b6f22-2364-11e7-b174-834c31d10a9e"
                ]
            ],
            "parentCardinality": "1",
            "childCollection": "1f3e7c66-2364-11e7-b174-834c31d10a9e",
            "childField": [
                [
                    "1f3e7c66-2364-11e7-b174-834c31d10a9e",
                    "1f3e7c69-2364-11e7-b174-834c31d10a9e"
                ]
            ],
            "childCardinality": "0..n"
        },
        {
            "GUID": "68f555e0-2364-11e7-b174-834c31d10a9e",
            "name": "fk users._id to following.from",
            "description": "",
            "comments": "",
            "relationshipType": "Foreign Key",
            "parentCollection": "1f3b6f21-2364-11e7-b174-834c31d10a9e",
            "parentField": [
                [
                    "1f3b6f21-2364-11e7-b174-834c31d10a9e",
                    "1f3b6f22-2364-11e7-b174-834c31d10a9e"
                ]
            ],
            "parentCardinality": "1",
            "childCollection": "1f407836-2364-11e7-b174-834c31d10a9e",
            "childField": [
                [
                    "1f407836-2364-11e7-b174-834c31d10a9e",
                    "1f407838-2364-11e7-b174-834c31d10a9e"
                ]
            ],
            "childCardinality": "0..n"
        },
        {
            "GUID": "6d08e250-2364-11e7-b174-834c31d10a9e",
            "name": "fk users._id to following.to",
            "description": "",
            "comments": "",
            "relationshipType": "Foreign Key",
            "parentCollection": "1f3b6f21-2364-11e7-b174-834c31d10a9e",
            "parentField": [
                [
                    "1f3b6f21-2364-11e7-b174-834c31d10a9e",
                    "1f3b6f22-2364-11e7-b174-834c31d10a9e"
                ]
            ],
            "parentCardinality": "1",
            "childCollection": "1f407836-2364-11e7-b174-834c31d10a9e",
            "childField": [
                [
                    "1f407836-2364-11e7-b174-834c31d10a9e",
                    "1f407839-2364-11e7-b174-834c31d10a9e"
                ]
            ],
            "childCardinality": "0..n"
        }
    ],
    "users": [],
    "diagramViews": [],
    "idToNameHashTable": {
        "4315bc61-2360-11e7-b174-834c31d10a9e": "_id",
        "4315bc62-2360-11e7-b174-834c31d10a9e": "airport",
        "4315bc63-2360-11e7-b174-834c31d10a9e": "connects",
        "4315bc65-2360-11e7-b174-834c31d10a9e": "airlines",
        "4315bc67-2360-11e7-b174-834c31d10a9e": "to",
        "4315bc60-2360-11e7-b174-834c31d10a9e": "airports",
        "432b8e50-2360-11e7-b174-834c31d10a9e": "graphs",
        "61dd4df1-2362-11e7-b174-834c31d10a9e": "_id",
        "61dd4df2-2362-11e7-b174-834c31d10a9e": "fullname",
        "61dd4df3-2362-11e7-b174-834c31d10a9e": "country",
        "61dd4df4-2362-11e7-b174-834c31d10a9e": "followers",
        "61dd4df6-2362-11e7-b174-834c31d10a9e": "following",
        "61dd4df0-2362-11e7-b174-834c31d10a9e": "users",
        "61f60610-2362-11e7-b174-834c31d10a9e": "graphs(1)",
        "d22bc320-2362-11e7-b174-834c31d10a9e": "group",
        "61350a92-2363-11e7-b174-834c31d10a9e": "_id",
        "61350a93-2363-11e7-b174-834c31d10a9e": "fullname",
        "61350a94-2363-11e7-b174-834c31d10a9e": "country",
        "61350a91-2363-11e7-b174-834c31d10a9e": "users",
        "61370662-2363-11e7-b174-834c31d10a9e": "_id",
        "61370663-2363-11e7-b174-834c31d10a9e": "from",
        "61370664-2363-11e7-b174-834c31d10a9e": "to",
        "61370665-2363-11e7-b174-834c31d10a9e": "group",
        "61370666-2363-11e7-b174-834c31d10a9e": "ts",
        "61370661-2363-11e7-b174-834c31d10a9e": "followers",
        "61540440-2363-11e7-b174-834c31d10a9e": "graphs(2)",
        "1f3b6f22-2364-11e7-b174-834c31d10a9e": "_id",
        "1f3b6f23-2364-11e7-b174-834c31d10a9e": "fullname",
        "1f3b6f24-2364-11e7-b174-834c31d10a9e": "country",
        "1f3b6f21-2364-11e7-b174-834c31d10a9e": "users",
        "1f3e7c67-2364-11e7-b174-834c31d10a9e": "_id",
        "1f3e7c68-2364-11e7-b174-834c31d10a9e": "from",
        "1f3e7c69-2364-11e7-b174-834c31d10a9e": "to",
        "1f3e7c6a-2364-11e7-b174-834c31d10a9e": "group",
        "1f3e7c6b-2364-11e7-b174-834c31d10a9e": "ts",
        "1f3e7c66-2364-11e7-b174-834c31d10a9e": "followers",
        "1f407837-2364-11e7-b174-834c31d10a9e": "_id",
        "1f407838-2364-11e7-b174-834c31d10a9e": "from",
        "1f407839-2364-11e7-b174-834c31d10a9e": "to",
        "1f40783a-2364-11e7-b174-834c31d10a9e": "group",
        "1f40783b-2364-11e7-b174-834c31d10a9e": "ts",
        "1f407836-2364-11e7-b174-834c31d10a9e": "following",
        "1f61bbd0-2364-11e7-b174-834c31d10a9e": "graphs(3)",
        "8bfb3c20-2360-11e7-b174-834c31d10a9e": "fk airports.airport to airports.connects.[0].to",
        "74da24f0-2362-11e7-b174-834c31d10a9e": "New Relationship",
        "7da482b0-2362-11e7-b174-834c31d10a9e": "fk twitEdgeArray._id to twitEdgeArray.following.[0]",
        "a7dc0c00-2363-11e7-b174-834c31d10a9e": "fk users._id to followers.from",
        "ad1c0a80-2363-11e7-b174-834c31d10a9e": "fk users._id to followers.to",
        "5c9d3d80-2364-11e7-b174-834c31d10a9e": "fk users._id to followers.from",
        "643ab400-2364-11e7-b174-834c31d10a9e": "fk users._id to followers.to",
        "68f555e0-2364-11e7-b174-834c31d10a9e": "fk users._id to following.from",
        "6d08e250-2364-11e7-b174-834c31d10a9e": "fk users._id to following.to"
    },
    "definitions": {
        "type": "definitions",
        "properties": [],
        "GUID": "3a412570-2360-11e7-b174-834c31d10a9e"
    },
    "polyglotDefinitions": {
        "type": "polyglotDefinitions",
        "properties": [],
        "GUID": "531582d3-b000-11ec-ab49-f732172fe980"
    },
    "externalDefinitions": {
        "type": "externalDefinitions",
        "properties": [],
        "GUID": "dfdc2e72-5408-11e7-b1ef-ab0119d70e5d"
    },
    "sources": [],
    "decorativeSymbols": [],
    "dbVersion": "v3.4",
    "dbVendor": "MongoDB",
    "appTarget": "MONGODB",
    "creationTS": "2017-04-17T11:23:05.925Z",
    "GUID": "3a40d750-2360-11e7-b174-834c31d10a9e",
    "lastModifTS": "2022-03-30T08:07:18.356Z",
    "persistenceSchemaVersion": "6",
    "description": "Different ways to model graphs, according to article:\nhttps://www.mongodb.com/presentations/socialite-open-source-status-feed-part-2-managing-social-graph?jmp=docs&_ga=1.11176368.544578421.1459505203\n",
    "comments": "",
    "author": "Pascal",
    "version": "",
    "hackoladeMeta": {
        "customPropertiesUpdated": true
    },
    "isCreatedByPlugin": true,
    "pluginInformation": {
        "pluginEngineVersion": "1.0.0"
    },
    "applicationInformation": {
        "version": "6.0.0"
    },
    "settings": {
        "centralPane": {
            "dbLevel": {
                "erd": [
                    {
                        "GUID": "00dbed50-b8ea-11e6-8089-6f1f31218a06",
                        "x": 95,
                        "y": 80,
                        "width": 203,
                        "height": 135,
                        "color": {
                            "hsl": {
                                "h": 3.789473684210526,
                                "s": 0.904761904761905,
                                "l": 0.5882352941176471,
                                "a": 1
                            },
                            "hex": "#f54337",
                            "rgb": {
                                "r": 245,
                                "g": 67,
                                "b": 55,
                                "a": 1
                            },
                            "hsv": {
                                "h": 3.789473684210526,
                                "s": 0.7755102040816326,
                                "v": 0.9607843137254902,
                                "a": 1
                            },
                            "oldHue": 3.789473684210526,
                            "source": "hex"
                        }
                    },
                    {
                        "GUID": "158d2b10-b8ea-11e6-8089-6f1f31218a06",
                        "x": 100,
                        "y": 446,
                        "width": 193,
                        "height": 107,
                        "color": {
                            "hsl": {
                                "h": 3.789473684210526,
                                "s": 0.904761904761905,
                                "l": 0.5882352941176471,
                                "a": 1
                            },
                            "hex": "#f54337",
                            "rgb": {
                                "r": 245,
                                "g": 67,
                                "b": 55,
                                "a": 1
                            },
                            "hsv": {
                                "h": 3.789473684210526,
                                "s": 0.7755102040816326,
                                "v": 0.9607843137254902,
                                "a": 1
                            },
                            "oldHue": 3.789473684210526,
                            "source": "hex"
                        }
                    },
                    {
                        "GUID": "3e7daae0-b8ea-11e6-8089-6f1f31218a06",
                        "x": 368.00000000000006,
                        "y": 453,
                        "width": 203,
                        "height": 94,
                        "color": {
                            "hsl": {
                                "h": 339.7058823529412,
                                "s": 0.8292682926829267,
                                "l": 0.5176470588235293,
                                "a": 1
                            },
                            "hex": "#ea1e63",
                            "rgb": {
                                "r": 234,
                                "g": 30,
                                "b": 99,
                                "a": 1
                            },
                            "hsv": {
                                "h": 339.7058823529412,
                                "s": 0.8717948717948718,
                                "v": 0.9176470588235294,
                                "a": 1
                            },
                            "oldHue": 339.7058823529412,
                            "source": "hex"
                        }
                    },
                    {
                        "GUID": "24436570-b8ef-11e6-8089-6f1f31218a06",
                        "x": 100,
                        "y": 288,
                        "width": 193,
                        "height": 80,
                        "color": {
                            "hsl": {
                                "h": 206.57142857142858,
                                "s": 0.8974358974358974,
                                "l": 0.5411764705882353,
                                "a": 1
                            },
                            "hex": "#2196f3",
                            "rgb": {
                                "r": 33,
                                "g": 150,
                                "b": 243,
                                "a": 1
                            },
                            "hsv": {
                                "h": 206.57142857142858,
                                "s": 0.8641975308641976,
                                "v": 0.9529411764705882,
                                "a": 1
                            },
                            "oldHue": 206.57142857142858,
                            "source": "hex"
                        }
                    },
                    {
                        "GUID": "b4bf9770-b8e7-11e6-8089-6f1f31218a06",
                        "x": 40,
                        "y": 66.00000000000001,
                        "width": 203,
                        "height": 135,
                        "color": {
                            "hsl": {
                                "h": 3.789473684210526,
                                "s": 0.904761904761905,
                                "l": 0.5882352941176471,
                                "a": 1
                            },
                            "hex": "#f54337",
                            "rgb": {
                                "r": 245,
                                "g": 67,
                                "b": 55,
                                "a": 1
                            },
                            "hsv": {
                                "h": 3.789473684210526,
                                "s": 0.7755102040816326,
                                "v": 0.9607843137254902,
                                "a": 1
                            },
                            "oldHue": 3.789473684210526,
                            "source": "hex"
                        }
                    },
                    {
                        "GUID": "4315bc60-2360-11e7-b174-834c31d10a9e",
                        "x": 819.7982195845696,
                        "y": 424.2967359050444,
                        "width": 263,
                        "height": 159,
                        "color": {
                            "hsl": {
                                "h": 3.789473684210526,
                                "s": 0.904761904761905,
                                "l": 0.5882352941176471,
                                "a": 1
                            },
                            "hex": "#f54337",
                            "rgb": {
                                "r": 245,
                                "g": 67,
                                "b": 55,
                                "a": 1
                            },
                            "hsv": {
                                "h": 3.789473684210526,
                                "s": 0.7755102040816326,
                                "v": 0.9607843137254902,
                                "a": 1
                            },
                            "oldHue": 3.789473684210526,
                            "source": "hex"
                        }
                    },
                    {
                        "GUID": "61dd4df0-2362-11e7-b174-834c31d10a9e",
                        "x": 268,
                        "y": 150,
                        "width": 229,
                        "height": 195,
                        "color": {
                            "hsl": {
                                "h": 3.789473684210526,
                                "s": 0.904761904761905,
                                "l": 0.5882352941176471,
                                "a": 1
                            },
                            "hex": "#f54337",
                            "rgb": {
                                "r": 245,
                                "g": 67,
                                "b": 55,
                                "a": 1
                            },
                            "hsv": {
                                "h": 3.789473684210526,
                                "s": 0.7755102040816326,
                                "v": 0.9607843137254902,
                                "a": 1
                            },
                            "oldHue": 3.789473684210526,
                            "source": "hex"
                        }
                    },
                    {
                        "GUID": "61350a91-2363-11e7-b174-834c31d10a9e",
                        "x": 145.62314540059347,
                        "y": 447.92729970326394,
                        "width": 225,
                        "height": 87
                    },
                    {
                        "GUID": "61370661-2363-11e7-b174-834c31d10a9e",
                        "x": 460.7596439169135,
                        "y": 429.9925816023738,
                        "width": 211,
                        "height": 123
                    },
                    {
                        "GUID": "1f3b6f21-2364-11e7-b174-834c31d10a9e",
                        "x": 101.31157270029674,
                        "y": 743.8100890207714,
                        "width": 225,
                        "height": 87
                    },
                    {
                        "GUID": "1f3e7c66-2364-11e7-b174-834c31d10a9e",
                        "x": 419,
                        "y": 648,
                        "width": 211,
                        "height": 123
                    },
                    {
                        "GUID": "1f407836-2364-11e7-b174-834c31d10a9e",
                        "x": 418.6884272997033,
                        "y": 800.9198813056386,
                        "width": 211,
                        "height": 123
                    },
                    {
                        "GUID": "6e9a9cc0-f422-11e5-ab1e-4fda87c84016",
                        "x": 431,
                        "y": 485,
                        "width": 314,
                        "height": 204
                    },
                    {
                        "GUID": "166589b0-0440-11e6-a1a6-29098b60dd65",
                        "x": 87,
                        "y": 133,
                        "width": 234,
                        "height": 166
                    },
                    {
                        "GUID": "46aed5e0-0440-11e6-a1a6-29098b60dd65",
                        "x": 399,
                        "y": 46,
                        "width": 315,
                        "height": 277
                    },
                    {
                        "GUID": "b63dd6c0-0721-11e6-a0f3-475ccb6d8902",
                        "x": 459,
                        "y": 438,
                        "width": 200,
                        "height": 100
                    },
                    {
                        "GUID": "2a6e3ae0-1b20-11e7-a6fb-3159608222ec",
                        "x": 96,
                        "y": 121,
                        "width": 192,
                        "height": 125
                    },
                    {
                        "GUID": "9616a7a0-1b20-11e7-a6fb-3159608222ec",
                        "x": 356,
                        "y": 123,
                        "width": 192,
                        "height": 70
                    },
                    {
                        "GUID": "889580b1-00d6-11e7-94c9-270ac0401f9d",
                        "x": 80,
                        "y": 80,
                        "width": 247,
                        "height": 176
                    },
                    {
                        "GUID": "ac2700e1-2b1e-11e7-bde4-57d99ab8fafb",
                        "x": 228,
                        "y": 396,
                        "width": 193,
                        "height": 149,
                        "color": {
                            "hsl": {
                                "h": 339.7058823529412,
                                "s": 0.8292682926829267,
                                "l": 0.5176470588235293,
                                "a": 1
                            },
                            "hex": "#ea1e63",
                            "rgb": {
                                "r": 234,
                                "g": 30,
                                "b": 99,
                                "a": 1
                            },
                            "hsv": {
                                "h": 339.7058823529412,
                                "s": 0.8717948717948718,
                                "v": 0.9176470588235294,
                                "a": 1
                            },
                            "oldHue": 339.7058823529412,
                            "source": "hex"
                        }
                    },
                    {
                        "GUID": "ac277619-2b1e-11e7-bde4-57d99ab8fafb",
                        "x": 223,
                        "y": 96,
                        "width": 204,
                        "height": 231,
                        "color": {
                            "hsl": {
                                "h": 339.7058823529412,
                                "s": 0.8292682926829267,
                                "l": 0.5176470588235293,
                                "a": 1
                            },
                            "hex": "#ea1e63",
                            "rgb": {
                                "r": 234,
                                "g": 30,
                                "b": 99,
                                "a": 1
                            },
                            "hsv": {
                                "h": 339.7058823529412,
                                "s": 0.8717948717948718,
                                "v": 0.9176470588235294,
                                "a": 1
                            },
                            "oldHue": 339.7058823529412,
                            "source": "hex"
                        }
                    },
                    {
                        "GUID": "ac283961-2b1e-11e7-bde4-57d99ab8fafb",
                        "x": 875,
                        "y": 96,
                        "width": 308,
                        "height": 697
                    },
                    {
                        "GUID": "ac28aeaa-2b1e-11e7-bde4-57d99ab8fafb",
                        "x": 534,
                        "y": 396,
                        "width": 224,
                        "height": 382
                    },
                    {
                        "GUID": "ac2923c1-2b1e-11e7-bde4-57d99ab8fafb",
                        "x": 529,
                        "y": 96,
                        "width": 234,
                        "height": 245,
                        "color": {
                            "hsl": {
                                "h": 339.7058823529412,
                                "s": 0.8292682926829267,
                                "l": 0.5176470588235293,
                                "a": 1
                            },
                            "hex": "#ea1e63",
                            "rgb": {
                                "r": 234,
                                "g": 30,
                                "b": 99,
                                "a": 1
                            },
                            "hsv": {
                                "h": 339.7058823529412,
                                "s": 0.8717948717948718,
                                "v": 0.9176470588235294,
                                "a": 1
                            },
                            "oldHue": 339.7058823529412,
                            "source": "hex"
                        }
                    },
                    {
                        "GUID": "7739d5c0-5408-11e7-b1ef-ab0119d70e5d",
                        "x": 390,
                        "y": 440,
                        "width": 290,
                        "height": 1619
                    },
                    {
                        "GUID": "78789751-5408-11e7-b1ef-ab0119d70e5d",
                        "x": 90,
                        "y": 690,
                        "width": 202,
                        "height": 2387
                    },
                    {
                        "GUID": "78891214-5408-11e7-b1ef-ab0119d70e5d",
                        "x": 490,
                        "y": 290,
                        "width": 198,
                        "height": 56
                    },
                    {
                        "GUID": "78a68527-5408-11e7-b1ef-ab0119d70e5d",
                        "x": 390,
                        "y": 90,
                        "width": 197,
                        "height": 125
                    },
                    {
                        "GUID": "791e7443-5408-11e7-b1ef-ab0119d70e5d",
                        "x": 90,
                        "y": 190,
                        "width": 209,
                        "height": 413
                    },
                    {
                        "GUID": "79a7ef90-5408-11e7-b1ef-ab0119d70e5d",
                        "x": 640,
                        "y": 140,
                        "width": 198,
                        "height": 96
                    }
                ],
                "buckets": [
                    {
                        "x": 779.7982195845696,
                        "y": 384.2967359050444,
                        "GUID": "432b8e50-2360-11e7-b174-834c31d10a9e"
                    },
                    {
                        "x": 228,
                        "y": 110,
                        "GUID": "61f60610-2362-11e7-b174-834c31d10a9e"
                    },
                    {
                        "x": 105.62314540059347,
                        "y": 389.9925816023738,
                        "GUID": "61540440-2363-11e7-b174-834c31d10a9e"
                    },
                    {
                        "x": 61.311572700296736,
                        "y": 608,
                        "GUID": "1f61bbd0-2364-11e7-b174-834c31d10a9e"
                    }
                ],
                "collapsedNodes": [],
                "activeRelationship": "",
                "activeRelationshipFields": {
                    "childField": [],
                    "parentField": []
                },
                "selectedCollections": [],
                "displayColorPicker": false,
                "graphView": {
                    "erd": [],
                    "buckets": [
                        {
                            "x": 848,
                            "y": 362,
                            "GUID": "432b8e50-2360-11e7-b174-834c31d10a9e"
                        },
                        {
                            "x": 228,
                            "y": 110,
                            "GUID": "61f60610-2362-11e7-b174-834c31d10a9e"
                        },
                        {
                            "x": 103,
                            "y": 379.5,
                            "GUID": "61540440-2363-11e7-b174-834c31d10a9e"
                        },
                        {
                            "x": 60,
                            "y": 608,
                            "GUID": "1f61bbd0-2364-11e7-b174-834c31d10a9e"
                        }
                    ],
                    "decorativeSymbols": [],
                    "forceLayout": true,
                    "defaultLinkLength": 300
                },
                "diagramViews": [],
                "decorativeSymbols": [],
                "nestedCollectionsLayout": "horizontal",
                "options": []
            },
            "collectionLevel": {},
            "changed": false
        },
        "dtDiagram": {
            "collapsedNodes": [],
            "shouldDistributeCollections": false
        }
    }
}

```
