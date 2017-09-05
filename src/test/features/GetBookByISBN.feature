Feature: Obtener el ISBN del libro
  Scenario: Consultar el web service para obtener los datos de un libro por el ISBN
	Given el libro tiene el id 8U2oAAAAQBAJ
	When un usuario obtiene los datos del libro por el ISBN
	Then el codigo de estado es 200
	And la respuesta tiene los siguientes datos
	| totalItems 	 		| 2 					|
	| kind					| books#volumes			|
   And la respuesta incluye los datos siguientes en cualquier orden
	| items.volumeInfo.title 					| Steve Jobs, El libro de Steve Jobs |
	| items.0.volumeInfo.publisher 				| Simon and Schuster			 	 |
	| items.0.volumeInfo.pageCount 				| 630, 485       					 |


