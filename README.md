# SpringEduManager

Aplicación web desarrollada con **Spring Boot** que permite gestionar estudiantes de forma simple y segura. Fue creada como proyecto del **Módulo 6 — Desarrollo de aplicaciones JEE con Spring Framework**.

## ¿Qué es?

La Coordinación Académica de un bootcamp necesitaba centralizar la información de sus estudiantes (cursos, prácticas y evaluaciones) en un solo lugar, ya que antes se usaban hojas de cálculo y formularios aislados.

**SpringEduManager** responde a esa necesidad: una plataforma web interna que permite registrar y consultar estudiantes, con autenticación por roles y una API REST para integrarse con otros sistemas.

## ¿Qué incluye?

- Login con roles **ADMIN** y **USER**
- Listado y registro de estudiantes
- Persistencia en base de datos H2
- API REST con operaciones CRUD
- Interfaz moderna con dashboard

## Tecnologías

- **Java 21** + **Spring Boot 4.1.1**
- **Maven** (gestor de dependencias)
- **Spring MVC** + **Thymeleaf** (vistas)
- **Spring Data JPA** + **H2** (persistencia)
- **Spring Security** (autenticación por roles)
- **REST API** (interoperabilidad)
- **CSS3** + **Bootstrap Icons** + **Google Fonts**

## Cómo ejecutar

**Requisitos:** JDK 21 o superior.

```
# Clonar el repositorio
git clone https://github.com/hellodsgn-isa/spring-edu-manager.git
cd spring-edu-manager

# Ejecutar la aplicación
mvn spring-boot:run

```
```

Luego abre: http://localhost:8080

```
