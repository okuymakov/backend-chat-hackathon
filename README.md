# Backend-Chat-Hackathon
API for chat application

How to use:
-----
Run docker containers with db and keycloack:

```shell
docker-compose up
```

Build project:
```shell
./gradlew bootRun
```

API:
-----
Url: [localhost:8081](http://localhost:8081/)

```http
POST /auth

GET /sessions/clients/{clientId}

GET /sessions/managers/{currentManagerId}
    
POST /sessions/create
    
PUT /sessions/update
    
POST /sessions/{sessionId}/close
```

Roles:
-----
    CLIENT, MANAGER, ADMIN
    
Websockets usage:
-----

```html
<script type="importmap">
  {
    "imports": {
      "@stomp/stompjs": "https://ga.jspm.io/npm:@stomp/stompjs@7.0.0/esm6/index.js"
    }
  }
</script>

<!-- ES Module Shims: Import maps polyfill for modules browsers without import maps support (all except Chrome 89+) -->
<script
  async
  src="https://ga.jspm.io/npm:es-module-shims@1.5.1/dist/es-module-shims.js"
  crossorigin="anonymous"
></script>

<script type="module">
  import { Client } from '@stomp/stompjs';

  const client = new Client({
    brokerURL: 'ws://localhost:8081/websocket
    onConnect: () => {
      client.subscribe('/user/{userId}', message =>
        console.log(`Received: ${message.body}`)
      );
      client.send("/app/chat", {}, JSON.stringify(${message}));
    },
  });

  client.activate();
</script>
```
    
