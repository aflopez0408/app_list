# 🎵 app_list – API de Listas de Reproducción

Este proyecto es una API RESTful desarrollada con **Spring Boot** y un frontend hecho en **Angular 19**, que permite crear, consultar, eliminar y buscar **listas de reproducción musicales**. Cada lista contiene múltiples canciones asociadas.

---

## 🚀 Características

### Backend (Spring Boot)

- Crear playlist con canciones
- Listar todas las playlists
- Buscar playlist por nombre
- Eliminar playlist por nombre
- Validaciones y manejo global de errores
- Base de datos en memoria H2
- Seguridad básica con Spring Security (HTTP Basic)
- Documentación Swagger con SpringDoc OpenAPI
- Separación en capas (`controller`, `service`, `repository`, `dto`, `exception`, `model`)
- Test unitarios con JUnit y Mockito

### Frontend (Angular 19)

- Crear lista con formulario dinámico para canciones
- Visualización de playlists
- Buscar y eliminar por nombre
- Diseño simple, moderno y responsivo
- Angular sin `app.module.ts` (estructura moderna CLI)

---

## 🧱 Estructura del proyecto
app_list/
├── backend/
│ ├── src/main/java/com/andres/app_list/
│ │ ├── controller/
│ │ ├── service/
│ │ ├── repository/
│ │ ├── model/
│ │ ├── dto/
│ │ └── exception/
│ └── application.properties
└── frontend/
├── src/app/
│ ├── components/
│ ├── services/
│ └── app.component.*


---

## ⚙️ Requisitos

- Java 17 o superior (Java 21+ recomendado)
- Maven 3.8+
- Node.js 18.x
- Angular CLI 19.x

---

## 🛠️ Instalación y ejecución

### Backend


cd app-list
mvn clean install
mvn spring-boot:run



La API se iniciará en http://localhost:8080.

Credenciales HTTP Basic (por defecto):

Usuario: admin

Contraseña: admin123


**Frontend**

ng new app_list-frontend
cd app_list-frontend
ng serve
ng generate service services/playlist
ng generate component components/playlist-create --standalone
ng generate component components/playlist-list --standalone
ng generate component components/playlist-search --standalone

App disponible en:
http://localhost:4200

🧪 Pruebas

Para ejecutar las pruebas del backend:
mvn test

📌 Endpoints principales (API)

Método	Endpoint	Descripción
POST	/lists	Crear una nueva playlist
GET	/lists	Listar todas las playlists
GET	/lists/{nombre}	Buscar playlist por nombre
DELETE	/lists/{nombre}	Eliminar playlist por nombre


✍️ Autor
Desarrollado por Andrés López
GitHub: @aflopez0408

🧾 Licencia
Este proyecto está bajo licencia MIT.
