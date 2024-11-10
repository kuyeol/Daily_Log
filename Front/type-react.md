TypeScript로 Express와 PostgreSQL을 연결하는 프로젝트를 처음부터 설정하는 방법을 단계별로 설명하겠습니다.

### 1. 프로젝트 기본 설정

1. **새 디렉토리 생성 및 초기화**

   ```bash
   mkdir ts-express-postgres
   cd ts-express-postgres
   npm init -y
   ```

2. **필요한 패키지 설치**

   TypeScript, Express, PostgreSQL 클라이언트, CORS, Body-parser, Nodemon(개발 중 자동 재시작) 등을 설치합니다.

   ```bash
   npm install express pg cors body-parser
   npm install --save-dev typescript @types/node @types/express @types/cors @types/body-parser @types/pg nodemon
   ```

3. **TypeScript 설정 파일(tsconfig.json) 생성**

   ```bash
   npx tsc --init
   ```

   `tsconfig.json` 파일에서 필요한 설정을 조정합니다. 예를 들어, `strict` 모드를 `true`로 두고, `outDir`을 `dist`로 설정하는 것을 추천합니다:

   ```json
   {
     "compilerOptions": {
       "target": "es6",
       "module": "commonjs",
       "strict": true,
       "esModuleInterop": true,
       "skipLibCheck": true,
       "forceConsistentCasingInFileNames": true,
       "outDir": "./dist"
     },
     "include": ["src/**/*"]
   }
   ```

4. **프로젝트 구조 설정**

   `src` 폴더를 생성하여 모든 소스 파일을 그 안에 넣습니다.

   ```bash
   mkdir src
   ```

### 2. 데이터베이스 설정

PostgreSQL에서 사용할 데이터베이스와 테이블을 설정합니다. 예시로 `testdb`라는 데이터베이스와 `users` 테이블을 생성합니다.

```sql
CREATE DATABASE testdb;
\c testdb;

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    age INTEGER
);
```

### 3. 서버 코드 작성

1. **`src/server.ts` 파일 작성**

   이 파일에서 Express 서버를 설정하고 PostgreSQL 데이터베이스와 연결합니다.

   ```typescript
   import express, { Request, Response } from 'express';
   import cors from 'cors';
   import bodyParser from 'body-parser';
   import { Pool } from 'pg';

   // Express 앱 초기화
   const app = express();
   const PORT = 5000;

   // CORS 및 body-parser 설정
   app.use(cors());
   app.use(bodyParser.json());

   // PostgreSQL Pool 설정
   const pool = new Pool({
       user: 'your_db_user',
       host: 'localhost',
       database: 'testdb',
       password: 'your_db_password',
       port: 5432,
   });

   // User 타입 정의
   interface User {
       id: number;
       name: string;
       age: number;
   }

   // GET 요청: 모든 사용자 조회
   app.get('/users', async (req: Request, res: Response) => {
       try {
           const result = await pool.query<User>('SELECT * FROM users');
           res.json(result.rows);
       } catch (error) {
           console.error(error);
           res.status(500).json({ error: '데이터를 가져오는 중 오류가 발생했습니다.' });
       }
   });

   // POST 요청: 새로운 사용자 추가
   app.post('/users', async (req: Request, res: Response) => {
       const { name, age } = req.body;
       try {
           const result = await pool.query<User>(
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

### 4. 스크립트 설정

`package.json`에 개발 서버를 시작하는 스크립트를 추가하여 개발 중에 코드 변경 시 자동으로 서버가 재시작되도록 설정합니다.

```json
"scripts": {
  "start": "node dist/server.js",
  "build": "tsc",
  "dev": "nodemon src/server.ts"
}
```

### 5. 빌드 및 실행

1. **개발 모드로 실행 (Nodemon 사용)**

   ```bash
   npm run dev
   ```

   개발 모드로 실행하면 TypeScript 코드가 변경될 때마다 자동으로 서버가 재시작됩니다.

2. **빌드 및 배포 모드로 실행**

   TypeScript 코드를 JavaScript로 컴파일한 후, 컴파일된 코드를 실행합니다.

   ```bash
   npm run build
   npm start
   ```

이제 TypeScript로 작성된 Express 서버가 PostgreSQL과 연결되어 작동할 것입니다. `/users` 엔드포인트로 GET 요청을 보내면 모든 사용자 데이터를 가져오고, POST 요청을 보내면 새 사용자를 추가할 수 있습니다.
