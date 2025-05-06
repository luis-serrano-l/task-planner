package es.uned.lsi.eped.pract2024_2025;

public class Task implements TaskIF {

	/* Declaración de atributos para almacenar la información de una tarea */

	/* Marca la tarea como completada */
	public void setCompleted() {}
	
	/* Devuelve el texto de la tarea */
	public String getText() {}

	/* Devuelve la fecha de la tarea */
	public int getDate() {}

	/* Devuelve si la tarea ha sido completada o no */
	public boolean getCompletion() {}

	/* Compara la tarea actual con una tarea llamante */
	public int compareTo(TaskIF T) {}

}
