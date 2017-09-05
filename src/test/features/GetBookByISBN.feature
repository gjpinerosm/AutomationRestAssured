Feature: Obtener el ISBN del libro
  Scenario: Consultar el web service para obtener los datos de un libro por el ISBN
	Given el libro tiene el ISBN 9781451648546
	When un usuario obtiene los datos del libro por el ISBN
	Then el codigo de estado es 200
	And la respuesta tiene los siguientes datos
	| totalItems 	 		| 1 					|
	| kind					| books#volumes			|
   And la respuesta incluye los datos siguientes en cualquier orden
	| items.volumeInfo.title 					| Steve Jobs			|
	| items.volumeInfo.publisher 				| Simon and Schuster	|   
	| items.volumeInfo.pageCount 				| 630					|

