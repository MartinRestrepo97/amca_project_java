# 🏢 Proyecto AMCA: Apoyo al Mercado Campesino Agrícola

---

## 📑 Tabla de Contenido
1. [Descripción General](#descripción-general)
2. [Requisitos del Sistema](#requisitos-del-sistema)
3. [Estructura del Proyecto](#estructura-del-proyecto)
4. [Instalación y Preparación](#instalación-y-preparación)
5. [Compilación y Ejecución](#compilación-y-ejecución)
6. [Uso del Software](#uso-del-software)
7. [Persistencia de Datos (CSV)](#persistencia-de-datos-csv)
8. [Arquitectura y Diseño](#arquitectura-y-diseño)
9. [Pruebas Funcionales y Validación](#pruebas-funcionales-y-validación)
10. [Soporte y Contacto](#soporte-y-contacto)

---

## 📋 Descripción General

**AMCA** es una aplicación de escritorio desarrollada en **Java** que simula un sistema de apoyo al mercado campesino agrícola. Permite gestionar y visualizar información sobre cultivos, animales, productos preparados y sectores productivos de manera eficiente y organizada, facilitando la toma de decisiones y la administración de recursos.

---

## 🛠️ Requisitos del Sistema

- **Java JDK:** 8 o superior
- **Sistemas Operativos Compatibles:** Windows, macOS, Linux
- **Memoria RAM:** 512 MB mínimo
- **Espacio en Disco:** 50 MB disponibles

---

## 📁 Estructura del Proyecto

```text
amca_project_java/
├── src/                  # Código fuente Java
│   ├── amca/             # Interfaces gráficas y clase principal
│   ├── modelo/           # Clases de modelo de datos
│   └── util/             # Utilidades y validaciones
├── bin/                  # Archivos .class compilados
├── *.csv                 # Archivos de datos
├── README.md             # Documentación principal
└── ...                   # Otros archivos y configuraciones
```

---

## 🏗️ Instalación y Preparación

1. Instala **Java JDK 8** o superior.
2. Descarga o clona este repositorio en tu equipo:
   ```bash
   git clone [URL_DEL_REPOSITORIO]
   ```
3. Abre una terminal y navega a la raíz del proyecto:
   ```bash
   cd amca_project_java
   ```

---

## ⚙️ Compilación y Ejecución

### Compilar el Proyecto
```bash
javac -d bin src/amca/*.java src/modelo/*.java src/util/*.java
```

### Ejecutar la Aplicación
- **Interfaz Gráfica:**
  ```bash
  java -cp bin amca.MainFrame
  ```
- **Consola:**
  ```bash
  java -cp bin amca.Main
  ```

---

## 🖥️ Uso del Software

- Navega entre los módulos usando la barra lateral (en la interfaz gráfica).
- Ingresa, consulta y edita datos de cultivos, animales, preparados y sectores productivos.
- Los datos se guardan automáticamente en archivos CSV.
- Utiliza la versión de consola para ambientes sin entorno gráfico.

---

## 📄 Persistencia de Datos (CSV)

La aplicación utiliza archivos CSV para almacenar la información:

| Archivo                | Descripción            | Estructura                       |
|------------------------|------------------------|-----------------------------------|
| `cultivos.csv`         | Datos de cultivos      | `nombre,hectareas`                |
| `animales.csv`         | Datos de animales      | `nombre,cantidad`                 |
| `preparados.csv`       | Datos de preparados    | `finca,tipo,producto,cantidad`    |
| `sectorproductivo.csv` | Datos de sectores      | `nombre,hectareas`                |

---

## 🧩 Arquitectura y Diseño

### Patrón MVC Implementado

```text
┌───────────────┐    ┌───────────────┐    ┌───────────────┐
│    VISTA      │    │ CONTROLADOR   │    │   MODELO      │
│ MainFrame     │◄──►│ Eventos       │◄──►│ Cultivos      │
│ ...           │    │ Validaciones  │    │ Animales      │
│               │    │ Lógica        │    │ Preparados    │
│               │    │ Navegación    │    │ SectorProductivo │
└───────────────┘    └───────────────┘    └───────────────┘
```

---

## 🧪 Pruebas Funcionales y Validación

### Pruebas Manuales
1. **Ingreso de datos válidos:**
   - Registra nuevos cultivos, animales, preparados y sectores productivos con datos correctos.
2. **Ingreso de datos inválidos:**
   - Intenta ingresar letras en campos numéricos (ej. hectáreas, cantidad).
   - Intenta ingresar caracteres especiales en campos de texto (ej. nombre).
   - Supera la longitud máxima permitida en los campos.
3. **Consulta y filtrado:**
   - Consulta los listados y utiliza filtros si están disponibles.
4. **Validación visual:**
   - Verifica que los mensajes de error y validación se muestren correctamente.
   - Observa el comportamiento ante datos incorrectos.

#### Documentación de Pruebas

| Módulo    | Prueba Realizada   | Resultado Esperado    | Resultado Obtenido |
-------------------------------------------------------------------------------
| Cultivos  | Ingreso de letras en hectáreas  | Mostrar mensaje de error  | [Completar] |
| Animales  | Ingreso de caracteres especiales en nombre | Mostrar mensaje de error  | [Completar] |
| Preparados| Longitud máxima en campo producto  | Mostrar mensaje de error  | [Completar] |
| Sectores  | Consulta general | Mostrar listado en tabla  | 
[Completar] |

#### Capturas de Pantalla
- Realiza capturas de pantalla de cada prueba relevante (registro exitoso, error de validación, consulta, etc.).
- Inserta las capturas en tu documento de evidencia o adjúntalas según lo requiera tu entrega.

---

## 📞 Soporte y Contacto

Para soporte técnico, dudas o sugerencias, contacta al equipo de desarrollo o al instructor responsable del proyecto.

---

> **© 2024 AMCA - Proyecto de Apoyo al Mercado Campesino Agrícola. Todos los derechos reservados.**
