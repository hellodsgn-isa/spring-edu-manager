# 📘 Documentación Técnica — SpringEduManager

**Proyecto:** SpringEduManager  
**Módulo:** M6 — Desarrollo de aplicaciones JEE con Spring Framework  
**Autor:** Isabella Alarcón  
**Repositorio:** https://github.com/[TU-USUARIO]/spring-edu-manager  

---

## 1. Contexto y objetivo

La Coordinación Académica de un bootcamp de programación necesitaba una plataforma interna para que los estudiantes pudieran gestionar sus cursos, prácticas y evaluaciones en un único lugar. Antes se usaban hojas de cálculo y formularios aislados, lo que dificultaba la organización y la integración con otros sistemas del campus.

**SpringEduManager** responde a esa necesidad: una aplicación web desarrollada en Java con el ecosistema de Spring que permite registrar, listar y administrar estudiantes, y que está preparada para extenderse a cursos y evaluaciones en módulos futuros.

---

## 2. Funcionalidades implementadas

### Autenticación y seguridad
- Login personalizado con vista propia.
- Dos roles diferenciados: **ADMIN** y **USER**.
- Rutas protegidas según rol (solo ADMIN puede crear estudiantes).
- Cierre de sesión con confirmación.
- Consola H2 protegida pero accesible para inspección.

### Gestión de estudiantes
- Listado completo de estudiantes desde base de datos.
- Formulario de creación con validación de campos.
- Persistencia real en base de datos H2.
- Eliminación y consulta por ID.

### API REST
- CRUD completo expuesto en JSON.
- Manejo adecuado de códigos HTTP (200, 201, 204, 404).
- Endpoints públicos para facilitar integraciones.

### Interfaz
- Diseño moderno con paleta lila/morado.
- Dashboard con sidebar y topbar reutilizables.
- Tipografía Poppins e iconografía Bootstrap Icons.
- Diseño responsive básico.

---

## 3. Tecnologías utilizadas

| Categoría | Tecnología |
|-----------|------------|
| Lenguaje | Java 21 (LTS) |
| Framework | Spring Boot 4.1.1 |
| Gestor de dependencias | Maven |
| Persistencia | Spring Data JPA + Hibernate |
| Base de datos | H2 (en memoria) |
| Vistas | Thymeleaf |
| Seguridad | Spring Security 7 |
| API REST | Spring Web MVC |
| Estilos | CSS3 + Bootstrap Icons + Google Fonts |
| IDE | Visual Studio Code |
| Control de versiones | Git + GitHub |

---

## 4. Arquitectura

El proyecto sigue el patrón **MVC** con arquitectura por capas:

---

Cliente (Navegador / Postman)
│
├── Controllers (MVC + REST)
│
├── Service (lógica de negocio)
│
├── Repository (JPA)
│
├── Entity (modelo)
│
└── H2 Database

---


**Capas del proyecto:**
- **Model** → entidad `Estudiante` mapeada con JPA.
- **Repository** → `EstudianteRepository` extendiendo `JpaRepository`.
- **Service** → `EstudianteService` con la lógica de negocio.
- **Controller** → controladores MVC (vistas) y REST (JSON).
- **Config** → `SecurityConfig` con reglas de autorización y usuarios.
- **View** → plantillas Thymeleaf con fragmentos reutilizables.

---

## 5. Estructura del proyecto


**Capas del proyecto:**
- **Model** → entidad `Estudiante` mapeada con JPA.
- **Repository** → `EstudianteRepository` extendiendo `JpaRepository`.
- **Service** → `EstudianteService` con la lógica de negocio.
- **Controller** → controladores MVC (vistas) y REST (JSON).
- **Config** → `SecurityConfig` con reglas de autorización y usuarios.
- **View** → plantillas Thymeleaf con fragmentos reutilizables.

---

## 5. Estructura del proyecto


**Capas del proyecto:**
- **Model** → entidad `Estudiante` mapeada con JPA.
- **Repository** → `EstudianteRepository` extendiendo `JpaRepository`.
- **Service** → `EstudianteService` con la lógica de negocio.
- **Controller** → controladores MVC (vistas) y REST (JSON).
- **Config** → `SecurityConfig` con reglas de autorización y usuarios.
- **View** → plantillas Thymeleaf con fragmentos reutilizables.

---
---
```
springedumanager/
├── docs/
│ ├── DOCUMENTACION.md
│ └── screenshots/
├── src/main/java/com/bootcamp/springedumanager/
│ ├── config/SecurityConfig.java
│ ├── controller/
│ │ ├── EstudianteController.java
│ │ ├── EstudianteRestController.java
│ │ ├── HomeController.java
│ │ └── LoginController.java
│ ├── model/Estudiante.java
│ ├── repository/EstudianteRepository.java
│ ├── service/EstudianteService.java
│ └── SpringedumanagerApplication.java
├── src/main/resources/
│ ├── static/css/styles.css
│ ├── templates/
│ │ ├── fragments/layout.html
│ │ ├── formulario-estudiante.html
│ │ ├── lista-estudiantes.html
│ │ └── login.html
│ └── application.properties
├── pom.xml
├── .gitignore
└── README.md
```
---

## 6. Cómo ejecutar el proyecto

### Requisitos
- JDK 21 o superior
- Maven (o usar el wrapper incluido)

### Comandos

```
# Compilar
mvn clean package

# Ejecutar
mvn spring-boot:run
```
---

Accesos
Recurso	URL
Aplicación	http://localhost:8080
Login	http://localhost:8080/login
Estudiantes	http://localhost:8080/estudiantes
API REST	http://localhost:8080/api/estudiantes
Consola H2	http://localhost:8080/h2-console
Credenciales de prueba:

Usuario	Contraseña	Rol
admin	admin123	ADMIN, USER
user	user123	USER
Credenciales H2 Console:

JDBC URL: jdbc:h2:mem:springedu

Usuario: sa

Contraseña: (vacía)

---

7. Endpoints de la API REST
Método	Endpoint	Descripción	Código OK
GET	/api/estudiantes	Lista todos	200
GET	/api/estudiantes/{id}	Obtiene uno	200 / 404
POST	/api/estudiantes	Crea uno	201
PUT	/api/estudiantes/{id}	Actualiza	200 / 404
DELETE	/api/estudiantes/{id}	Elimina	204 / 404

---

Ejemplo de consumo:

---

curl -X POST http://localhost:8080/api/estudiantes \
  -H "Content-Type: application/json" \
  -d '{"nombre":"Ana Gómez","email":"ana@mail.com"}'

---

8. Decisiones técnicas destacadas
Arquitectura por capas: separa responsabilidades y facilita el mantenimiento y las pruebas.

H2 en memoria: agiliza el desarrollo sin necesidad de servidor externo. Migrar a MySQL/PostgreSQL solo requiere cambiar application.properties.

Spring Security basado en beans: enfoque moderno (Spring Security 6+), sin WebSecurityConfigurerAdapter.

Thymeleaf con fragmentos: reutilización de layout (sidebar, topbar, info panel) sin duplicar HTML.

REST sin JWT en la versión base: se dejó preparado el proyecto para agregarlo como mejora.

---

9. Mejoras futuras
Autenticación con JWT para la API REST.

Persistencia en MySQL o PostgreSQL.

Módulos de Cursos, Prácticas y Evaluaciones con relaciones JPA.

Tests unitarios con JUnit 5 y Mockito.

Dockerización del proyecto.

CI/CD con GitHub Actions.

---

10. Conclusión
SpringEduManager es una aplicación web completa que integra las principales capacidades del ecosistema Spring: MVC, JPA, Security y REST. El proyecto demuestra buenas prácticas de arquitectura, separación de responsabilidades, seguridad basada en roles y una interfaz de usuario moderna, dejando una base sólida para continuar creciendo en módulos posteriores.

---

