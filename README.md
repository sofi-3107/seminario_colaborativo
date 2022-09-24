# seminario_colaborativo

Es una pequeña API rest que permite ver los productos que ofrece una cafeteria y realizar pedidos.
Almacena la información de Pedidos, Productos y Clientes en MYSQL en una tabla llamada "cafeteria"
que se crea al ejecutar la aplicación, y opera sobre la misma con JPA mediante un ORM.

ENDPOINTS

1)"/":lista los productos Tipo GET

2)"/nuevo-producto":
  tipo POST
  permite crear un nuevo prodcto
  devuelve el objeto creado con el id asignado por el servidor
  estructura:  {
        "nombre": "medialuna",
        "precioUnitario": 60.0,
        "cantidadEnStock": 12,
        "imagen": "algo"
    }
    
3) "/modificar-producto":
 Tipo PUT permite modificar el producto, no recibe el id como parametro sino en el mismo objeto, aprovechando el método save de los repositorios
 devuelve el objeto modificado
 estructura:  {
        "id":1,
        "nombre": "medialuna",
        "precioUnitario": 60.0,
        "cantidadEnStock": 12,
        "imagen": "algo"
    }
    
 4)"/eliminar-producto/id" 
 Tipo DELETE permite eliminar el producto del id que se pasa como parametro
 devuelve un mensaje de eliminacion correcta
 
 5)"/pedidos"
 Tipo GET
 Devuelve la lista de todos los pedidos del servidor.(se omite la estructura ya que en crear-pedido se vera la misma,
 y este endpoint devuelve un [] conteniendo ese tipo de objetos con sus respectivos id.
 
 6)"/nuevo-pedido"
 Tipo:POST crea un nuevo pedido
 estructura
     {       
        "detallePedido": [
            {
                
                "producto": {
                    "id": 1,
                    "nombre": "submarino",
                    "precioUnitario": 200.0,
                    "cantidadEnStock": 12,
                    "imagen": "http://localhost:8000/submarino.jpg"
                },
                "cantidad": 3
            }
        ],
        "importeTotal": 600.0,
        "cliente": {
            "id": 4,
            "apellido": "Pereyra",
            "nombre": "Alfredo",
            "telefono": "4235689",
            "documento": "4544566",
            "domicilio": "Las Heras 25"
        }
    }
 
 
