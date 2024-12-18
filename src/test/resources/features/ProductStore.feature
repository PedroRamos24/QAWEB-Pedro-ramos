Feature: Product - Store
  @ValidacionProducto
  Scenario Outline: Validacion del precio de un producto
    Given dado que estoy en la página de la tienda
    And doy click en Iniciar Sesion
    And me logueo con mi usuario "<user>" y clave "<password>"
    And verifico que salga el nombre "<nombre>"
    When navego a la categoria "<categoria>" y subcategoria "<subcategoria>"
    And agrego <numero> unidades del primer producto al carrito
    Then valido en el popup la confirmación del producto agregado
    And valido en el popup que el monto total sea calculado correctamente
    When finalizo la compra
    Then valido el titulo de la pagina del carrito
    And vuelvo a validar el calculo de precios en el carrito
    Examples:
      | user                           | password      | nombre      | categoria | subcategoria | numero |
      | pedroramosantezana24@gmail.com | contraseña123 | Pedro Ramos | Clothes   | Men          | 2      |
      | cuentanoregistrada@gmail.com   | password123   | Nombre Mal  | Clothes   | Men          | 2      |
      | pedroramosantezana24@gmail.com | contraseña123 | Pedro Ramos | Autos     | Llantas      | 2      |