Feature: Gestion de Orden PetStore

#  @crearOrden
#  Scenario: Crear Orden
#    When crear el orden con id 5, petId 5, quantity 7
#    Then el código de respuesta es 200
#    And el atributo de respuesta complete es "true"
#    And validar los datos ingresados id 5, petId 5, quantity 7 se registraron correctamente
#
#  @consultarOrden
#  Scenario: Consultar Orden
#    When consultar el orden con id "9223372036854775807"
#    Then el código de respuesta es 200
#    And imprimir orden
#    And el atributo de respuesta complete es "true"

  @crearOrdenes
  Scenario Outline: Crear Ordenes
    Given la url "https://petstore.swagger.io/v2/store/order" del servicio
    When crear el orden con id <id>, petId <petId>, quantity <quantity>
    Then el código de respuesta es 200
    And el atributo de respuesta complete es "true"
    And validar los datos ingresados id <id>, petId <petId>, quantity <quantity> se registraron correctamente

    Examples:
    |id  |  petId    | quantity  |
    |1   |  1        | 65        |
    |2   |  2        | 7         |
    |3   |  3        | 10        |
    |4   |  3        | 16        |
    |5   |  2        | 7         |
    |6   |  3        | 12        |
    |7   |  8        | 19        |
    |8   |  2        | 4         |
    |9   |  3        | 12        |
    |10  |  9        | 13        |

  @consultarOrdenes
  Scenario Outline: Consultar Orden
    Given la url "https://petstore.swagger.io/v2/store/order" del servicio
    When consultar el orden con id "<id>"
    Then el código de respuesta es 200
    And imprimir orden
    And el atributo de respuesta complete es "true"
    Examples:
      |id  |
      |1   |
      |2   |
      |3   |
      |4   |
      |5   |
      |6   |
      |7   |
      |8   |
      |9   |
      |10  |
