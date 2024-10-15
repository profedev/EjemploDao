# Ejemplo de Implementación del Patrón DAO en Java

Este repositorio contiene un ejemplo de implementación del patrón Data Access Object (DAO) en Java. El ejemplo simula un almacenamiento de datos simple en memoria utilizando `ArrayList` en lugar de una base de datos tradicional. El modelo consta de varias clases relacionadas entre sí, incluyendo `Cliente`, `Pedido` y `Producto`.

## Estructura del Proyecto

- **Modelos**: El modelo de datos incluye las clases `Cliente`, `Pedido` y `Producto`, que representan clientes, pedidos y productos, respectivamente. Cada clase tiene sus propios atributos y métodos para la manipulación de datos.

- **Interfaces DAO**: Las interfaces (`ClienteDAO`, `PedidoDAO` y `ProductoDAO`) definen métodos para acceder y manipular los datos de cada entidad.

- **Implementaciones DAO**: Las implementaciones DAO (`ClienteDAOImpl`, `PedidoDAOImpl` y `ProductoDAOImpl`) proporcionan la lógica real para almacenar y recuperar datos en memoria utilizando `ArrayList`.

- **Clase Principal**: La clase `Main` demuestra cómo usar el patrón DAO para crear clientes, productos y pedidos, y luego recuperar y mostrar los datos almacenados.

## Características

- **Almacenamiento en Memoria**: Los datos se almacenan en memoria usando `ArrayList`, lo que facilita ejecutar y probar la aplicación sin necesidad de una base de datos.
- **Relaciones entre Entidades**: El ejemplo demuestra las relaciones entre diferentes entidades (`Cliente`, `Pedido` y `Producto`) y cómo interactúan a través del patrón DAO.
- **Diseño Modular**: El patrón DAO permite una mejor separación de responsabilidades y un código modular, lo que facilita el mantenimiento y la expansión.

## Uso

1. Clona el repositorio:
   ```sh
   git clone <repository_url>
   ```
2. Abre el proyecto en tu IDE preferido (por ejemplo, IntelliJ, Eclipse).
3. Ejecuta la clase `Main` para ver cómo se crean y gestionan las diferentes entidades utilizando el patrón DAO.

## Ejemplo de Salida

La salida muestra la creación de clientes, productos y pedidos, y muestra los pedidos asociados con un cliente específico.

```
Pedidos del cliente Juan Perez:
Pedido ID: 1
	Producto: Laptop, Precio: 1500.0
	Producto: Mouse, Precio: 25.0
```

## Requisitos

- Java 8 o superior
- Cualquier IDE que soporte Java

## Licencia

Este proyecto está bajo la Licencia MIT.

## Contribuciones

¡Las contribuciones son bienvenidas! No dudes en abrir un issue o enviar un pull request.

## Contacto

Si tienes alguna pregunta o sugerencia, no dudes en contactarme.
