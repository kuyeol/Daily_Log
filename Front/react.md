리액트(React)와 PostgreSQL을 연결하고 기본적인 GET, POST 메서드를 구현하려면, 주로 백엔드 서버(Node.js 및 Express)를 통해 클라이언트(React)와 데이터베이스(PostgreSQL)를 연결하는 방식을 사용합니다. 아래는 단계별 가이드입니다.

### 1. 프로젝트 기본 설정

1. **React 설치**:  
   ```bash
   npx create-react-app react-postgres-app
   cd react-postgres-app
   ```

2. **백엔드(Node.js/Express) 설정**:  
   React와 PostgreSQL 간의 데이터를 주고받기 위해 Express 서버를 설치합니다.
   ```bash
   mkdir backend
   cd backend
   npm init -y
   npm install express pg cors body-parser
   ```

   여기서 `pg`는 PostgreSQL 클라이언트, `cors`는 CORS 정책을 설정하는 데 사용되고, `body-parser`는 요청의 본문을 파싱하는 데 사용됩니다.

### 2. PostgreSQL 데이터베이스 설정
PostgreSQL에 필요한 데이터베이스와 테이블을 미리 만들어야 합니다.

```sql
CREATE DATABASE testdb;
\c testdb;

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    age INTEGER
);
```

### 3. 백엔드 서버 코드 작성

1. **Express 서버 구현**: `backend/server.js` 파일을 생성하고, Express와 PostgreSQL을 연결합니다.

   ```javascript
   const express = require('express');
   const cors = require('cors');
   const bodyParser = require('body-parser');
   const { Pool } = require('pg');

   const app = express();
   const PORT = 5000;

   // CORS와 body-parser 설정
   app.use(cors());
   app.use(bodyParser.json());

   // PostgreSQL 연결 설정
   const pool = new Pool({
       user: 'your_db_user',
       host: 'localhost',
       database: 'testdb',
       password: 'your_db_password',
       port: 5432,
   });

   // GET 요청 처리
   app.get('/users', async (req, res) => {
       try {
           const result = await pool.query('SELECT * FROM users');
           res.json(result.rows);
       } catch (error) {
           console.error(error);
           res.status(500).json({ error: '데이터를 가져오는 중 오류가 발생했습니다.' });
       }
   });

   // POST 요청 처리
   app.post('/users', async (req, res) => {
       const { name, age } = req.body;
       try {
           const result = await pool.query(
               'INSERT INTO users (name, age) VALUES ($1, $2) RETURNING *',
               [name, age]
           );
           res.json(result.rows[0]);
       } catch (error) {
           console.error(error);
           res.status(500).json({ error: '데이터를 추가하는 중 오류가 발생했습니다.' });
       }
   });

   // 서버 실행
   app.listen(PORT, () => {
       console.log(`서버가 포트 ${PORT}에서 실행 중입니다.`);
   });
   ```

2. **백엔드 서버 실행**:
   ```bash
   node backend/server.js
   ```

### 4. React에서 데이터 가져오기 및 보내기

1. **React 컴포넌트에서 GET 메서드 구현**:  
   `App.js` 파일에서 데이터를 가져오는 코드를 추가합니다.

   ```javascript
   import React, { useEffect, useState } from 'react';

   function App() {
       const [users, setUsers] = useState([]);

       useEffect(() => {
           fetch('http://localhost:5000/users')
               .then((response) => response.json())
               .then((data) => setUsers(data))
               .catch((error) => console.error('Error fetching users:', error));
       }, []);

       return (
           <div>
               <h1>User List</h1>
               <ul>
                   {users.map((user) => (
                       <li key={user.id}>{user.name} - {user.age} years old</li>
                   ))}
               </ul>
           </div>
       );
   }

   export default App;
   ```

2. **POST 메서드 구현**:
   새로운 사용자를 추가하는 폼을 추가하여 POST 요청을 보냅니다.

   ```javascript
   import React, { useEffect, useState } from 'react';

   function App() {
       const [users, setUsers] = useState([]);
       const [name, setName] = useState('');
       const [age, setAge] = useState('');

       useEffect(() => {
           fetch('http://localhost:5000/users')
               .then((response) => response.json())
               .then((data) => setUsers(data))
               .catch((error) => console.error('Error fetching users:', error));
       }, []);

       const handleSubmit = (e) => {
           e.preventDefault();
           fetch('http://localhost:5000/users', {
               method: 'POST',
               headers: {
                   'Content-Type': 'application/json',
               },
               body: JSON.stringify({ name, age }),
           })
               .then((response) => response.json())
               .then((newUser) => setUsers([...users, newUser]))
               .catch((error) => console.error('Error adding user:', error));
       };

       return (
           <div>
               <h1>User List</h1>
               <ul>
                   {users.map((user) => (
                       <li key={user.id}>{user.name} - {user.age} years old</li>
                   ))}
               </ul>
               <h2>Add New User</h2>
               <form onSubmit={handleSubmit}>
                   <input
                       type="text"
                       placeholder="Name"
                       value={name}
                       onChange={(e) => setName(e.target.value)}
                   />
                   <input
                       type="number"
                       placeholder="Age"
                       value={age}
                       onChange={(e) => setAge(e.target.value)}
                   />
                   <button type="submit">Add User</button>
               </form>
           </div>
       );
   }

   export default App;
   ```

### 5. CORS 이슈 해결
프론트엔드가 `localhost:3000`에서 실행되고 백엔드는 `localhost:5000`에서 실행되므로, CORS 에러가 발생할 수 있습니다. 백엔드 코드에서 `cors` 미들웨어를 추가하여 해결할 수 있습니다.

이제 이 설정을 완료하면 React 앱에서 PostgreSQL 데이터베이스로 GET, POST 요청을 보내고, 사용자 목록을 가져오거나 새로운 사용자를 추가할 수 있습니다.
