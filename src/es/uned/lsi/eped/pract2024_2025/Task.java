package es.uned.lsi.eped.pract2024_2025;

public class Task implements TaskIF {

	/* Declaración de atributos para almacenar la información de una tarea */

	private String text;
	private int date;
	private boolean completed;

	public Task(String text, int date) {
		this.text = text;
		this.date = date;
		this.completed = false;
	}

	/* Marca la tarea como completada */
	public void setCompleted() {
		completed = true;
	}

	/* Devuelve el texto de la tarea */
	public String getText() {
		return text;
	}

	/* Devuelve la fecha de la tarea */
	public int getDate() {
		return date;
	}

	/* Devuelve si la tarea ha sido completada o no */
	public boolean getCompletion() {
		return completed;
	}

	/* Compara la tarea actual con una tarea llamante */
	public int compareTo(TaskIF T) {
		return Integer.compare(T.getDate(), date);
	}

}
