# 📑 Evidencia de Producto: GA7-220501096-AA3-EV02  
## Módulos de Software Codificados y Probados

---

## Portada

**Nombre del Proyecto:** AMCA - Apoyo al Mercado Campesino Agrícola  
**Evidencia:** GA7-220501096-AA3-EV02  
**Versión:** 1.0  
**Fecha:** [Completar]  
**Autor:** [Tu Nombre]  
**Instructor:** [Nombre del Instructor]  
**Centro de Formación:** [Nombre del Centro]  

---

## Introducción

El presente documento evidencia el desarrollo, codificación y pruebas de los módulos de software del proyecto AMCA, conforme a los requerimientos establecidos en las historias de usuario y casos de uso. Se documentan las funcionalidades implementadas, las validaciones realizadas y los resultados obtenidos, incluyendo capturas de pantalla que demuestran el cumplimiento de cada requisito.

---

## Objetivo

Demostrar que los módulos desarrollados para el sistema AMCA cumplen con los requerimientos funcionales y no funcionales, mediante la ejecución de pruebas que validan la correcta operación y robustez de la aplicación, asegurando la calidad del producto entregado.

---

## Metodología

- **Desarrollo:** Codificación en Java bajo el patrón MVC, con persistencia en archivos CSV.
- **Pruebas:** Manuales, siguiendo los escenarios definidos en las historias de usuario y casos de uso.
- **Versionamiento:** Uso de Git para el control de versiones y trazabilidad de cambios.

---

## Historias de Usuario y Casos de Uso

A continuación, se describen las historias de usuario/casos de uso implementados, acompañados de la evidencia visual (pantallazos) y la documentación de pruebas de validación.

---

### Historia de Usuario 1: Registrar Cultivo

**Como** usuario, **quiero** registrar un nuevo cultivo, **para** llevar el control de los cultivos en la finca.

#### Requisito Funcional
- Permitir el ingreso de nombre y hectáreas del cultivo.
- Validar que hectáreas sea un número positivo.

#### Evidencia Visual

*Pantallazo de la interfaz de registro de cultivo exitoso*  
![Registro Cultivo Exitoso](ruta/a/captura1.png)

#### Pruebas de Validación

| Prueba                                   | Resultado Esperado           | Resultado Obtenido | Observaciones |
|-------------------------------------------|------------------------------|--------------------|--------------|
| Ingreso de letras en hectáreas            | Mensaje de error             | [Completar]        |              |
| Ingreso de número negativo en hectáreas   | Mensaje de error             | [Completar]        |              |
| Ingreso de datos válidos                  | Registro exitoso             | [Completar]        |              |

---

### Historia de Usuario 2: Registrar Animal

**Como** usuario, **quiero** registrar animales, **para** gestionar el inventario ganadero.

#### Requisito Funcional
- Permitir el ingreso de nombre y cantidad.
- Validar que cantidad sea un número entero positivo.
- Validar que el nombre no contenga caracteres especiales.

#### Evidencia Visual

*Pantallazo de la interfaz de registro de animal exitoso*  
![Registro Animal Exitoso](ruta/a/captura2.png)

#### Pruebas de Validación

| Prueba                                   | Resultado Esperado           | Resultado Obtenido | Observaciones |
|-------------------------------------------|------------------------------|--------------------|--------------|
| Ingreso de caracteres especiales en nombre| Mensaje de error             | [Completar]        |              |
| Ingreso de letras en cantidad             | Mensaje de error             | [Completar]        |              |
| Ingreso de datos válidos                  | Registro exitoso             | [Completar]        |              |

---

### Historia de Usuario 3: Registrar Producto Preparado

**Como** usuario, **quiero** registrar productos preparados, **para** llevar el control de la producción.

#### Requisito Funcional
- Permitir el ingreso de finca, tipo, producto y cantidad.
- Validar longitud máxima en el campo producto.

#### Evidencia Visual

*Pantallazo de la interfaz de registro de producto preparado*  
![Registro Preparado Exitoso](ruta/a/captura3.png)

#### Pruebas de Validación

| Prueba                                   | Resultado Esperado           | Resultado Obtenido | Observaciones |
|-------------------------------------------|------------------------------|--------------------|--------------|
| Longitud máxima en campo producto         | Mensaje de error             | [Completar]        |              |
| Ingreso de datos válidos                  | Registro exitoso             | [Completar]        |              |

---

### Historia de Usuario 4: Consultar Sectores Productivos

**Como** usuario, **quiero** consultar los sectores productivos, **para** visualizar la información registrada.

#### Requisito Funcional
- Mostrar listado de sectores en una tabla.

#### Evidencia Visual

*Pantallazo de la consulta de sectores productivos*  
![Consulta Sectores Productivos](ruta/a/captura4.png)

#### Pruebas de Validación

| Prueba                                   | Resultado Esperado           | Resultado Obtenido | Observaciones |
|-------------------------------------------|------------------------------|--------------------|--------------|
| Consulta general                          | Mostrar listado en tabla     | [Completar]        |              |

---

## Pruebas de Validaciones Generales

Se realizaron pruebas adicionales para validar la robustez de la aplicación ante entradas incorrectas:

- Fechas fuera de rango (si aplica)
- Números negativos o no numéricos
- Textos con caracteres especiales
- Longitudes máximas y mínimas en campos de texto

*Pantallazos de mensajes de error y validaciones*  
![Validación Error](ruta/a/captura5.png)

---

## Control de Versiones

El proyecto utiliza **Git** para el control de versiones.  
- Se mantiene el historial de cambios y ramas en el repositorio:  
  `[Pega aquí la URL de tu repositorio]`
- Los commits documentan avances, correcciones y pruebas realizadas.

---

## Conclusión

El sistema AMCA cumple con los requerimientos funcionales y de validación definidos en las historias de usuario y casos de uso. Las pruebas realizadas demuestran la correcta operación de los módulos desarrollados, así como la adecuada gestión de errores y validaciones, garantizando la calidad y confiabilidad del software.

---

## Recomendaciones

- Continuar con pruebas automatizadas para futuras versiones.
- Documentar nuevas historias de usuario conforme evolucione el sistema.
- Mantener el control de versiones actualizado y documentado.

---

> **© 2024 AMCA - Proyecto de Apoyo al Mercado Campesino Agrícola. Todos los derechos reservados.** 